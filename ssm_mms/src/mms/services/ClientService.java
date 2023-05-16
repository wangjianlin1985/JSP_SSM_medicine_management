// 
// 
// 

package mms.services;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import mms.pojo.EasyUIResult;
import mms.pojo.Client;
import org.springframework.beans.factory.annotation.Autowired;
import mms.mapper.ClientMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ClientService
{
    @Autowired
    private ClientMapper clientMapper;
    
    public Client queryClientBycno(final String cno) {
        final Client client = this.clientMapper.queryClientBycno(cno);
        return client;
    }
    
    public String saveClient(final Client client) {
        try {
            if (this.queryClientBycno(client.getCno()) != null) {
                return "\u5ba2\u6237\u7f16\u53f7\u5df2\u7ecf\u5b58\u5728\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165\u7f16\u53f7";
            }
            System.out.println(client);
            this.clientMapper.saveClient(client);
            return "\u4fdd\u5b58\u6210\u529f";
        }
        catch (Exception e) {
            return "\u64cd\u4f5c\u5f02\u5e38\uff0c\u8bf7\u91cd\u65b0\u64cd\u4f5c";
        }
    }
    
    public EasyUIResult queryAllClient(final Integer page, final Integer rows) {
        PageHelper.startPage((int)page, (int)rows);
        final List<Client> clients = this.clientMapper.queryAllClient();
        final PageInfo<Client> pageInfo = (PageInfo<Client>)new PageInfo((List)clients);
        return new EasyUIResult(Long.valueOf(pageInfo.getTotal()), clients);
    }
    
    public void deleteClientBycno(final String cno) {
        this.clientMapper.deleteClientBycno(cno);
    }
    
    public String modifyClient(final Client client) {
        final Client queryClientBycno = this.queryClientBycno(client.getCno());
        if (queryClientBycno != null && queryClientBycno.getCid() != client.getCid()) {
            return "\u8fd9\u4e2a\u5ba2\u6237\u7f16\u53f7\u5df2\u7ecf\u5b58\u5728\uff0c\u4e0d\u80fd\u4fee\u6539\u4e3a\u8fd9\u4e2a\u7f16\u53f7";
        }
        this.clientMapper.modifyClient(client);
        return "\u4fee\u6539\u6210\u529f";
    }
    
    public String deleteClientByRows(final String[] array) {
        try {
            for (final String cno : array) {
                System.out.println(cno);
                this.deleteClientBycno(cno);
            }
        }
        catch (Exception e) {
            return "\u64cd\u4f5c\u5f02\u5e38\uff0c\u8bf7\u5237\u65b0\u540e\u64cd\u4f5c";
        }
        return "\u5220\u9664\u6210\u529f";
    }
}
