// 
// 
// 

package mms.pojo;

public class Agency
{
    private int aid;
    private String ano;
    private String aname;
    private String asex;
    private String aphone;
    private String aremark;
    
    public int getAid() {
        return this.aid;
    }
    
    public void setAid(final int aid) {
        this.aid = aid;
    }
    
    public String getAno() {
        return this.ano;
    }
    
    public void setAno(final String ano) {
        this.ano = ano;
    }
    
    public String getAname() {
        return this.aname;
    }
    
    public void setAname(final String aname) {
        this.aname = aname;
    }
    
    public String getAsex() {
        return this.asex;
    }
    
    public void setAsex(final String asex) {
        this.asex = asex;
    }
    
    public String getAphone() {
        return this.aphone;
    }
    
    public void setAphone(final String aphone) {
        this.aphone = aphone;
    }
    
    public String getAremark() {
        return this.aremark;
    }
    
    public void setAremark(final String aremark) {
        this.aremark = aremark;
    }
    
    @Override
    public String toString() {
        return "Agency [ano=" + this.ano + ", aname=" + this.aname + ", asex=" + this.asex + ", aphone=" + this.aphone + ", aremark=" + this.aremark + "]";
    }
}
