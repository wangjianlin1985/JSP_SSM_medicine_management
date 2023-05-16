// 
// 
// 

package mms.interceptors;

import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.HandlerInterceptor;

public class MyHandlerInterceptor implements HandlerInterceptor
{
    public void afterCompletion(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final Exception ex) throws Exception {
    }
    
    public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final ModelAndView modelAndView) throws Exception {
    }
    
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {
        final HttpSession session = request.getSession();
        final Object username = session.getAttribute("user");
        final Object password = session.getAttribute("password");
        if (username == null || password == null) {
            response.sendRedirect("../login.html");
            System.out.println("##");
            return false;
        }
        return true;
    }
}
