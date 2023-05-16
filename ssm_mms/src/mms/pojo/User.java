// 
// 
// 

package mms.pojo;

public class User
{
    private String uUsername;
    private String uPassword;
    private String uAccess;
    
    public String getuUsername() {
        return this.uUsername;
    }
    
    public void setuUsername(final String uUsername) {
        this.uUsername = uUsername;
    }
    
    public String getuPassword() {
        return this.uPassword;
    }
    
    public void setuPassword(final String uPassword) {
        this.uPassword = uPassword;
    }
    
    public String getuAccess() {
        return this.uAccess;
    }
    
    public void setuAccess(final String uAccess) {
        this.uAccess = uAccess;
    }
    
    @Override
    public String toString() {
        return "User [uUsername=" + this.uUsername + ", uPassword=" + this.uPassword + ", uAccess=" + this.uAccess + "]";
    }
}
