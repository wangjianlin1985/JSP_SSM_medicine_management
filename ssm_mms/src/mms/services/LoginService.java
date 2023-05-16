// 
// 
// 

package mms.services;

import mms.pojo.User;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import mms.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class LoginService
{
    @Autowired
    private UserMapper userMapper;
    
    public String login(final String username, final String password, final HttpSession session) {
        final User user = this.userMapper.queryUserByName(username);
        if (user == null) {
            return "\u6ca1\u6709\u6b64\u7528\u6237";
        }
        if (!user.getuPassword().equals(password)) {
            return "\u5bc6\u7801\u9519\u8bef";
        }
        session.setAttribute("user", (Object)user);
        session.setAttribute("password", (Object)password);
        return "";
    }
}
