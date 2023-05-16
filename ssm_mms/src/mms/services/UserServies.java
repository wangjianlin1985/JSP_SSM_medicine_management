// 
// 
// 

package mms.services;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import mms.pojo.EasyUIResult;
import mms.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import mms.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServies
{
    @Autowired
    private UserMapper userMapper;
    
    public void addUser(final User user) {
        this.userMapper.addUser(user);
    }
    
    public EasyUIResult queryAllUser(final Integer page, final Integer rows) {
        PageHelper.startPage((int)page, (int)rows);
        final List<User> users = this.userMapper.queryAllUser();
        final PageInfo<User> pageInfo = (PageInfo<User>)new PageInfo((List)users);
        return new EasyUIResult(Long.valueOf(pageInfo.getTotal()), users);
    }
    
    public void deleteUser(final String uUsername) {
        this.userMapper.deleteUser(uUsername);
    }
    
    public void updateUser(final User user) {
        this.userMapper.updateUser(user);
    }
    
    public String queryUserByName(final String uUsername) {
        final User user = this.userMapper.queryUserByName(uUsername);
        if (user != null) {
            return "\u7528\u6237\u5df2\u5b58\u5728";
        }
        return "";
    }
    
    public String queryPasswordByName(final String uUsername) {
        final User user = this.userMapper.queryUserByName(uUsername);
        if (user == null) {
            return "\u7528\u6237\u4e0d\u5b58\u5728";
        }
        return user.getuPassword();
    }
}
