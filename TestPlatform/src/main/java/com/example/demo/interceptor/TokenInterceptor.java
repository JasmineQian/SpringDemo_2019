package com.example.demo.interceptor;

import com.example.demo.common.CONST;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenInterceptor implements HandlerInterceptor {


    @Value("${auth.token.expire}")
    private Integer expire;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String requestToken = httpServletRequest.getHeader(CONST.TOKEN_KEY);
        // http header "token" 不能为空
        if (StringUtils.isEmpty(requestToken)) {
            throw new TokenException();
        }

        String decode = null;
        // base64 解码
        try {
            decode = decodeToken(requestToken);
        } catch (Exception e) {
            e.printStackTrace();
            throw new TokenException();
        }

        // 是否是时间戳开头\d{10}
        if (!vaildToken(decode)) {
            throw new TokenException();
        }

        // 提取时间戳
        long timestemp = findTimestemp(decode);

        // 验证时间戳是否过期 expire = true 为过期
        boolean expire = isExpire(timestemp);
        if (expire) {
            throw new TokenExpireException();
        }

        // 提取 code 对应 SSOCIALPROVIDER -> SOP_CODE
        String code = decode.substring(10);

        // 判断 SOP_CODE 是否存在
        RDataSource dataSource = dataSourceService.findDataSourceByCode(code);
        if (dataSource == null) {
            throw new TokenException();
        }

        httpServletRequest.setAttribute(CONST.DATASOURCE_KEY, dataSource);
        return true;
    }


    /**
     * Base64 解码
     *
     * @param token
     * @return
     */
    private String decodeToken(String token) {
        return new String(Base64.decode(token));
    }

    /**
     * 判断是不是时间戳开头
     *
     * @param token
     * @return Boolean
     */
    private boolean vaildToken(String token) {
        return token.matches("\\d{10}.*");
    }

    /**
     * 提取明文token的时间戳部分
     *
     * @param decodeToken
     * @return
     */
    private long findTimestemp(String decodeToken) {
        return new Long(decodeToken.substring(0, 10));
    }


    /**
     * 判断是否过期 如果 auth.token.expire = 0 不过期
     *
     * @param timestemp
     * @return
     */
    private boolean isExpire(long timestemp) {
        if (expire == 0) {
            return false;
        }
        long deff = ((System.currentTimeMillis() - timestemp * 1000) / 1000);
        return deff > expire;
    }
}
