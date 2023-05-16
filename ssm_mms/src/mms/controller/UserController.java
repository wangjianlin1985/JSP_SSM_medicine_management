// 
// 
// 

package mms.controller;

import mms.pojo.EasyUIResult;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import mms.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import mms.services.UserServies;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({ "User" })
@Controller
public class UserController
{
    @Autowired
    private UserServies userServies;
    
    @RequestMapping({ "AddUser" })
    @ResponseBody
    public String addUser(final User user) {
        this.userServies.addUser(user);
        return "success";
    }
    
    @RequestMapping({ "UpdateUser" })
    @ResponseBody
    public void updateUser(final User user) {
        this.userServies.updateUser(user);
    }
    
    @RequestMapping({ "DeleteUser" })
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(final String uUsername) {
        this.userServies.deleteUser(uUsername);
    }
    
    @RequestMapping({ "queryAllUser" })
    @ResponseBody
    public EasyUIResult queryAllUser(@RequestParam(value = "page", defaultValue = "1") final Integer page, @RequestParam(value = "rows", defaultValue = "5") final Integer rows) {
        final EasyUIResult queryAllUser = this.userServies.queryAllUser(page, rows);
        return queryAllUser;
    }
    
    @RequestMapping(value = { "GetUUsername" }, produces = { "text/html;charset=UTF-8" })
    @ResponseBody
    public String queryUserByName(final String uUsername) {
        return this.userServies.queryUserByName(uUsername);
    }
    
    @RequestMapping(value = { "GetUpassword" }, produces = { "text/html;charset=UTF-8" })
    @ResponseBody
    public String queryPasswordByName(final String uUsername) {
        return this.userServies.queryPasswordByName(uUsername);
    }
}
