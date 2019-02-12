package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@EnableWebSecurity
public class HTMLSecurityConfig extends WebSecurityConfigurerAdapter {

    private AnyUserDetailsService anyUserDetailsService;


    @Autowired
    public void setAnyUserDetailsService(AnyUserDetailsService anyUserDetailsService) {
        this.anyUserDetailsService = anyUserDetailsService;
    }

    /**
     * 匹配 "/" 路径，不需要权限即可访问
     * 匹配 "/user" 及其以下所有路径，都需要 "USER" 权限
     * 登录地址为 "/login"，登录成功默认跳转到页面 "/user"
     * 退出登录的地址为 "/logout"，退出成功后跳转到页面 "/login"
     * 默认启用 CSRF
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {


        //允许访问静态资源
        http.authorizeRequests()
                .antMatchers("/upload", "/css/**", "/js/**", "/images/**",
                        "/resources/**", "/lib/**", "/skin/**", "/template/**")
                .permitAll();
        //所有的访问都需要权限验证
        http.authorizeRequests().anyRequest().authenticated();
        //访问失败页url
        http.formLogin().failureUrl("/login?error").
                /*    //登录信息保存
                            successHandler(loginSuccessHandler()).*/
                //访问成功页url
                        defaultSuccessUrl("/login")
                //默认访问页
                .loginPage("/login")
                .permitAll().and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                //注销失败跳转到登录页面
                .logoutSuccessUrl("/login").permitAll();
/*
        // 允许iframe 嵌套
        http.headers().frameOptions().disable();
        //关闭csrf 防止循环定向
        http.csrf().disable();*/
    }

    /**
     * 添加 UserDetailsService， 实现自定义登录校验
     */
    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(anyUserDetailsService);
    }
}
