package com.rabbiter.tourism.config;

import com.rabbiter.tourism.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * springMvc web配置
 *
 * @author: 
 * 
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private TokenInterceptor tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)
                //拦截所有请求
                .addPathPatterns("/**")
                //排除请求
                .excludePathPatterns("/file/**","/video/**","/img/**","/login","/common/**","/user/setUserAvatar/**"
                        ,"/user/getEmailReg/**","/user/forgetPassword/**","/user/saveUser/**");
    }
}
