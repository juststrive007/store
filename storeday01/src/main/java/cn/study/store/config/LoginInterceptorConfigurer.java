package cn.study.store.config;

import cn.study.store.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wm
 */
@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //创建拦截器
        HandlerInterceptor interceptor = new LoginInterceptor();
        //不拦截的路径
        List<String> patterns = new ArrayList<>();
        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("/js/**");
        patterns.add("/images/**");
        patterns.add("/users/reg");
        patterns.add("/users/login");
        patterns.add("/web/register.html");
        patterns.add("/web/login.html");

        //添加拦截器
        registry.addInterceptor(interceptor).addPathPatterns("/**").
                excludePathPatterns(patterns);
    }
}
