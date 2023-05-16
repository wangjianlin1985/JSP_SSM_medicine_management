// 
// 
// 

package mms.pojo;

import java.util.List;

public class EasyUIResult
{
    private Integer total;
    private List<?> rows;
    
    public EasyUIResult() {
    }
    
    public EasyUIResult(final Integer total, final List<?> rows) {
        this.total = total;
        this.rows = rows;
    }
    
    public EasyUIResult(final Long total, final List<?> rows) {
        this.total = total.intValue();
        this.rows = rows;
    }
    
    public Integer getTotal() {
        return this.total;
    }
    
    public void setTotal(final Integer total) {
        this.total = total;
    }
    
    public List<?> getRows() {
        return this.rows;
    }
    
    public void setRows(final List<?> rows) {
        this.rows = rows;
    }
    
    @Override
    public String toString() {
        return "EasyUIResult [total=" + this.total + ", rows=" + this.rows + "]";
    }
}
