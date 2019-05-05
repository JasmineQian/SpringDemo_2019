package com.example.demo.filter;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.po.WebserviceLog;
import com.example.demo.common.CONST;
import com.example.demo.common.ResponseBean;
import com.example.demo.common.UUID16;
import com.example.demo.mapper.WebserviceLogMapper;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Pattern;

public class LogFilter implements Filter {


    static InetAddress ia = null;

    static {
        try {
            ia = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private static final Logger logger = LoggerFactory.getLogger(LogFilter.class);
    private static final String NOTLOGIN = "NOT LOGIN";
    private static final String LOGIN_PATH = "/account";

    @Autowired
    private WebserviceLogMapper webLogMapper;

    @Value("${sys.name}")
    private String sysName;

    private Pattern ignore = Pattern.compile(".*/webjars/.*$|.*/v2/.*$|.*/swagger.*$|.*/configuration/.*$|.*/images/.*|.*/farvirate.ico");

    static final Pattern BLANK = Pattern.compile("\\t|\r|\n");

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        long startTime = System.currentTimeMillis();

        /* 判断如果是swagger界面请求的一些资源就不会走日志 */
        HttpServletRequest request = (HttpServletRequest) req;


        HttpServletResponse response = (HttpServletResponse) res;
        String requestId = null;

        if (StringUtils.isEmpty(request.getHeader("sid"))) {
            requestId = UUID.randomUUID().toString().replace("-", "");
            request.setAttribute("sid", requestId);
        } else {
            requestId = request.getHeader("sid");
            request.setAttribute("sid", request.getHeader("sid"));
        }
        response.addHeader("sid", requestId);


        String requestURL = request.getRequestURI();
        if (ignore.matcher(requestURL).matches()) {
            chain.doFilter(req, res);
            return;
        }

//        System.out.println(request.getRequestURI());

        // 2、RequestBody读取
        // 创建包装对象
        LoggerHttpServletRequest wrappedRequest = new LoggerHttpServletRequest(request);
        // 读取参数
        String content = IOUtils.toString(wrappedRequest.getInputStream());
        // 重设参数
        wrappedRequest.resetServletInputStream();
        // 返回输出值
        wrappedRequest.setAttribute("sid", requestId);
        OutputStream outputStream = res.getOutputStream();

        LoggerHttpServletResponse wrapperResponse = new LoggerHttpServletResponse(response);

        chain.doFilter(wrappedRequest, wrapperResponse);

        long endTime = System.currentTimeMillis();
        byte[] responseContent = wrapperResponse.getData();
        String responseContext = null;
        String responseContentType = wrapperResponse.getContentType();
        if (!StringUtils.isEmpty(responseContentType) && responseContentType.contains("image")) {
            responseContext = "[image]";
        } else {
            responseContext = new String(wrapperResponse.getData(), "UTF-8");
        }

        outputStream.write(responseContent);

        /* 插入接口参数捕获日志 */
        try {
            insertWebServiceInvokeLog(wrappedRequest, wrapperResponse, responseContext, content, startTime, endTime, requestId);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    private void insertWebServiceInvokeLog(LoggerHttpServletRequest wrappedRequest, LoggerHttpServletResponse wrapperResponse, String responseBody, String requestBody, long beginTime,
                                           long endTime, String requestId) {
        String httpMethod = wrappedRequest.getMethod();
        String remoteHost = wrappedRequest.getRemoteHost();
        String params = wrappedRequest.getQueryString();
        String userAgent = wrappedRequest.getHeader("user-agent");
        String requestPath = wrappedRequest.getServletPath();
        String responseContentType = wrapperResponse.getContentType();
        String apiName =wrapperResponse.getHeader(CONST.RESPONS_API_NAME_KEY);


        // 创建系统日志实体
        WebserviceLog webLog = new WebserviceLog();

        webLog.setWlgId(UUID16.uuid());
        webLog.setWlgCreationuid(sysName);
        webLog.setWlgCreationDt(new Date());
        webLog.setWlgUpdateDt(new Date());
        webLog.setWlgUpdateuid(sysName);
        webLog.setWlgRemoteipaddr(remoteHost);
        webLog.setWlgRequesturl(requestPath);

        webLog.setWlgStartDt(new Date(beginTime));
        webLog.setWlgEndDt(new Date(endTime));
        webLog.setWlgMethod(httpMethod);
        webLog.setWlgName(apiName);
        webLog.setWlgParams(params);
        webLog.setWlgParamsvalue(requestBody);

        webLog.setWlgReturnMsg(responseBody);

        try {
            if (!StringUtils.isEmpty(responseContentType) && !responseContentType.contains("image")) {
                ResponseBean responseBean = JSONObject.parseObject(responseBody, ResponseBean.class);
                webLog.setWlgReturnMessage(responseBean.getMessage());
                webLog.setWlgReturnCode(responseBean.getCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        webLog.setWlgUseragent(userAgent);
        webLog.setWlgClienthost(String.format("%s:%s", ia.getHostName(), ia.getHostAddress()));
        webLog.setWlgSessionid(requestId);
        webLog.setWlgSource(sysName);

        try {
            webLogMapper.insertSelective(webLog);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("requestId:[{}] Save log to db with some error",requestId);
            logger.error("requestId:[{}] Save log to file, Log Data: ",requestId, JSONObject.toJSONString(webLog));
        }


    }


    /**
     * 包装HttpServletRequest
     */
    private static class LoggerHttpServletRequest extends HttpServletRequestWrapper {

        private byte[] data;
        private HttpServletRequest request;
        private LoggerServletInputStream servletInputStream;

        public LoggerHttpServletRequest(HttpServletRequest request) {
            super(request);
            this.request = request;
            servletInputStream = new LoggerServletInputStream();
        }

        public void resetServletInputStream() {
            try {
                servletInputStream.inputStream = new ByteArrayInputStream(new String(data).getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {

                logger.error(e.getMessage());

            }
        }

        @Override
        public ServletInputStream getInputStream() throws IOException {
            if (data == null) {
                data = IOUtils.toByteArray(this.request.getReader());
                servletInputStream.inputStream = new ByteArrayInputStream(data);
            }
            return servletInputStream;
        }

        private class LoggerServletInputStream extends ServletInputStream {

            private InputStream inputStream;

            @Override
            public int read() throws IOException {
                return inputStream.read();
            }

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener listener) {

            }

        }
    }

    /**
     * 包装的HttpServletResponse类
     *
     */
    private static class LoggerHttpServletResponse extends HttpServletResponseWrapper {

        private ByteArrayOutputStream byteStream;

        public LoggerHttpServletResponse(HttpServletResponse response) {
            super(response);
            byteStream = new ByteArrayOutputStream();
        }

        @Override
        public ServletOutputStream getOutputStream() {
            return new LoggerServletOutputStream(byteStream);
        }

        @Override
        public PrintWriter getWriter() throws IOException {
            return new PrintWriter(getOutputStream(), false);
        }

        public byte[] getData() {
            return byteStream.toByteArray();
        }

        public class LoggerServletOutputStream extends ServletOutputStream {

            private DataOutputStream dataOutputStream;

            public LoggerServletOutputStream(OutputStream output) {
                dataOutputStream = new DataOutputStream(output);
            }

            @Override
            public void write(int b) throws IOException {
                dataOutputStream.write(b);
            }

            @Override
            public void write(byte[] b) throws IOException {
                dataOutputStream.write(b);
            }

            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                dataOutputStream.write(b, off, len);
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setWriteListener(WriteListener listener) {

            }
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
