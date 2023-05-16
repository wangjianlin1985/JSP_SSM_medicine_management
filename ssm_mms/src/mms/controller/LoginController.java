// 
// 
// 

package mms.controller;

import java.util.Enumeration;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import mms.services.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({ "Login" })
@Controller
public class LoginController
{
    @Autowired
    private LoginService loginService;
    
    @RequestMapping(value = { "loginUser" }, produces = { "text/html;charset=UTF-8" })
    @ResponseBody
    public String login(final String username, final String password, final HttpSession session) {
        return this.loginService.login(username, password, session);
    }
    
    @RequestMapping({ "GetLoginName" })
    @ResponseBody
    public Object GetLoginName(final HttpSession session) {
        final Object username = session.getAttribute("user");
        return username;
    }
    
    @RequestMapping({ "LogOff" })
    @ResponseBody
    public void logOff(final HttpSession session) {
        final Enumeration em = session.getAttributeNames();
        while (em.hasMoreElements()) {
            session.removeAttribute(em.nextElement().toString());
        }
    }
}
