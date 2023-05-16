// 
// 
// 

package mms.mapper;

import java.util.List;
import mms.pojo.Client;

public interface ClientMapper
{
    Client queryClientBycno(String p0);
    
    void saveClient(Client p0);
    
    List<Client> queryAllClient();
    
    void deleteClientBycno(String p0);
    
    void modifyClient(Client p0);
}
