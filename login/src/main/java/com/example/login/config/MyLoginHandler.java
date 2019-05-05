package com.example.login.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyLoginHandler implements AuthenticationSuccessHandler {

    Logger log = LoggerFactory.getLogger(getClass());

    // 登录成功处理
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        log.info("登录成功！");
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath().concat("/hello"));
    }
}
