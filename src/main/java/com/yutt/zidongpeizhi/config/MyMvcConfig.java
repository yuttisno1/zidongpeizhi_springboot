package com.yutt.zidongpeizhi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//@EnableWebMvc
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter{
    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/yutt").setViewName("success");
    }


    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter()
    {
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/login").setViewName("login");
                registry.addViewController("/").setViewName("login");
        //        registry.addViewController("/user/login.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("success");
            }
            //注册拦截器
            @Override
            public  void  addInterceptors(InterceptorRegistry registration)
            {
                registration.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login");
            }


        };
        return adapter;
    }

}
