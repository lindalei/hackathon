package com.demo.hackthon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //配置PasswordEncoder,BCryptPasswordEncoder是security提供的PasswordEncorder的一个实现类
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()   //使用表单登录页面
                .loginPage("/login")    //登录url
                .loginProcessingUrl("/doLogin")
//                .httpBasic()
                .and()
                .authorizeRequests()    //认证请求
                .antMatchers("/register", "/hackathon/doRegister", "/login", "/doLogin").permitAll()     //除了***能够无认证访问
                .anyRequest().authenticated()    //任何请求都需要认证
                .and()
                .csrf().disable();     //CSRF跨站请求伪造直接关闭
    }
}