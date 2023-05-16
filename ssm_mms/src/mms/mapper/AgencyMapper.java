// 
// 
// 

package mms.mapper;

import java.util.List;
import mms.pojo.Agency;

public interface AgencyMapper
{
    Agency queryAgencyByAno(String p0);
    
    void saveAgency(Agency p0);
    
    List<Agency> queryAllAgency();
    
    void deleteAgencyByAno(String p0);
    
    void modifyAgency(Agency p0);
}
