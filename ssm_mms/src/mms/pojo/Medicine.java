// 
// 
// 

package mms.pojo;

public class Medicine
{
    private int mid;
    private String mno;
    private String mname;
    private String mmode;
    private String mefficacy;
    
    public int getMid() {
        return this.mid;
    }
    
    public void setMid(final int mid) {
        this.mid = mid;
    }
    
    public String getMno() {
        return this.mno;
    }
    
    public void setMno(final String mno) {
        this.mno = mno;
    }
    
    public String getMname() {
        return this.mname;
    }
    
    public void setMname(final String mname) {
        this.mname = mname;
    }
    
    public String getMmode() {
        return this.mmode;
    }
    
    public void setMmode(final String mmode) {
        this.mmode = mmode;
    }
    
    public String getMefficacy() {
        return this.mefficacy;
    }
    
    public void setMefficacy(final String mefficacy) {
        this.mefficacy = mefficacy;
    }
    
    @Override
    public String toString() {
        return "Medicine [mno=" + this.mno + ", mname=" + this.mname + ", mmode=" + this.mmode + ", mefficacy=" + this.mefficacy + "]";
    }
}
