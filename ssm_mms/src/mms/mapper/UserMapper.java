// 
// 
// 

package mms.mapper;

import java.util.List;
import mms.pojo.User;

public interface UserMapper
{
    void addUser(User p0);
    
    List<User> queryAllUser();
    
    void deleteUser(String p0);
    
    void updateUser(User p0);
    
    User queryUserByName(String p0);
}
