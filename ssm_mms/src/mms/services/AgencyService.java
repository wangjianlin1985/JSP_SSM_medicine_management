// 
// 
// 

package mms.services;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import mms.pojo.EasyUIResult;
import mms.pojo.Agency;
import org.springframework.beans.factory.annotation.Autowired;
import mms.mapper.AgencyMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AgencyService
{
    @Autowired
    private AgencyMapper agencyMapper;
    
    public Agency queryAgencyByAno(final String ano) {
        final Agency agency = this.agencyMapper.queryAgencyByAno(ano);
        return agency;
    }
    
    public EasyUIResult queryAllAgency(final Integer page, final Integer rows) {
        PageHelper.startPage((int)page, (int)rows);
        final List<Agency> agencies = this.agencyMapper.queryAllAgency();
        final PageInfo<Agency> pageInfo = (PageInfo<Agency>)new PageInfo((List)agencies);
        return new EasyUIResult(Long.valueOf(pageInfo.getTotal()), agencies);
    }
    
    public String saveAgency(final Agency agency) {
        try {
            if (this.queryAgencyByAno(agency.getAno()) != null) {
                return "\u7ecf\u529e\u4eba\u7f16\u53f7\u5df2\u7ecf\u5b58\u5728\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165\u7f16\u53f7";
            }
            this.agencyMapper.saveAgency(agency);
            return "\u4fdd\u5b58\u6210\u529f";
        }
        catch (Exception e) {
            return "\u64cd\u4f5c\u5f02\u5e38\uff0c\u8bf7\u5237\u65b0\u540e\u64cd\u4f5c";
        }
    }
    
    public String deleteAgencyByAno(final String ano) {
        try {
            this.agencyMapper.deleteAgencyByAno(ano);
        }
        catch (Exception e) {
            return "\u5220\u9664\u5931\u8d25\uff0c\u6b64\u7ecf\u529e\u4eba\u4e3a\u5ba2\u6237\u63d0\u4f9b\u8fc7\u670d\u52a1\uff0c\u65e0\u6cd5\u5220\u9664\u6b64\u7ecf\u529e\u4eba";
        }
        return "\u5220\u9664\u6210\u529f";
    }
    
    public String modifyAgency(final Agency agency) {
        final Agency queryAgencyByAno = this.queryAgencyByAno(agency.getAno());
        if (queryAgencyByAno != null && queryAgencyByAno.getAid() != agency.getAid()) {
            return "\u8fd9\u4e2a\u7ecf\u529e\u4eba\u7f16\u53f7\u5df2\u7ecf\u5b58\u5728\uff0c\u4e0d\u80fd\u4fee\u6539\u4e3a\u8fd9\u4e2a\u7f16\u53f7";
        }
        try {
            this.agencyMapper.modifyAgency(agency);
        }
        catch (Exception e) {
            return "\u4fee\u6539\u5931\u8d25\uff0c\u53ef\u80fd\u662f\u6709\u5ba2\u6237\u5728\u6b64\u7ecf\u529e\u4eba\u8d2d\u836f\uff0c\u65e0\u6cd5\u4fee\u6539\u7f16\u53f7";
        }
        return "\u4fee\u6539\u6210\u529f";
    }
    
    public List<Agency> getAllAgency() {
        final List<Agency> allAgency = this.agencyMapper.queryAllAgency();
        return allAgency;
    }
    
    public String deleteAgencyByRows(final String[] array) {
        try {
            for (final String ano : array) {
                this.agencyMapper.deleteAgencyByAno(ano);
            }
        }
        catch (Exception e) {
            throw new RuntimeException();
        }
        return "\u5220\u9664\u6210\u529f";
    }
}
