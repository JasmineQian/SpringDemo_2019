package com.example.demo.interceptor;

import com.alibaba.fastjson.JSON;
import com.example.demo.common.CONST;
import com.example.demo.common.SignUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Component
//sign check
public class SignInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object o) throws Exception {

        RequestWrapper requestWrapper = new RequestWrapper(httpServletRequest);
        String body = requestWrapper.getBody();
        Map<String, Object> map = new HashMap<String, Object>();
        Map maps = (Map) JSON.parse(body);
        for (Object ob : maps.keySet()) {
            map.put(ob.toString(), maps.get(ob.toString()));
            System.out.println(ob.toString() + "=" + maps.get(ob.toString()));
        }
        Exception e = null;

        System.out.println(requestWrapper.getRequestURI());
        if (map.get(CONST.SIGN) == null)
            throw e;
        String sign = map.get(CONST.SIGN).toString();
        String signCal = SignUtil.signTopRequest(map, CONST.SECRET);
        if (!sign.equals(signCal)) {
            System.out.println(body);
            throw e;
        }

        return true;
    }

}
