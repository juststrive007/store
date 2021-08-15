package cn.study.store.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author wm
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //从request获取session
        HttpSession session = request.getSession();
        //判断Session中是否不包含登录信息
        if(session.getAttribute("uid") == null){
            //重定向
            response.sendRedirect("/web/login.html");
            return false;
        }
        //有登录信息
        return true;
    }
}
