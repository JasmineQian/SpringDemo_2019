package com.example.demo.interceptor;

import com.example.demo.common.CONST;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class AppendApiNameToResponseHeaderInterceptor implements HandlerInterceptor {
    private static Logger logger = LoggerFactory.getLogger(AppendApiNameToResponseHeaderInterceptor.class);

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //@ApiOperation
        if (handler instanceof HandlerMethod){
            String clssName = ((HandlerMethod)handler).getBeanType().getCanonicalName();
            Method method = ((HandlerMethod)handler).getMethod();
            ApiOperation apiOperation = ((HandlerMethod)handler).getMethod().getAnnotation(ApiOperation.class);
            if (!ObjectUtils.isEmpty(apiOperation)) {
                response.setHeader(CONST.RESPONS_API_NAME_KEY,apiOperation.value());
            }else {
                response.setHeader(CONST.RESPONS_API_NAME_KEY,"Please add @ApiOperation on target method");
                logger.error("{}.{} not define @ApiOperation",clssName, method);
            }

        }
    }
}