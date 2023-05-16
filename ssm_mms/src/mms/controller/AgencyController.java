// 
// 
// 

package mms.controller;

import java.util.List;
import mms.pojo.EasyUIResult;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import mms.pojo.Agency;
import org.springframework.beans.factory.annotation.Autowired;
import mms.services.AgencyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({ "Agency" })
@Controller
public class AgencyController
{
    @Autowired
    private AgencyService agencyService;
    
    @RequestMapping({ "GetAgency" })
    @ResponseBody
    public Agency queryAgencyByAno(final String ano) {
        final Agency agency = this.agencyService.queryAgencyByAno(ano);
        return agency;
    }
    
    @RequestMapping(value = { "DeleteAgency" }, produces = { "text/html;charset=UTF-8" })
    @ResponseBody
    public String deleteAgencyByAno(final String ano) {
        return this.agencyService.deleteAgencyByAno(ano);
    }
    
    @RequestMapping(value = { "DeleteRows" }, produces = { "text/html;charset=UTF-8" })
    @ResponseBody
    public String deleteAgencyByRows(@RequestParam("array[]") final String[] array) {
        try {
            return this.agencyService.deleteAgencyByRows(array);
        }
        catch (Exception e) {
            return "\u64cd\u4f5c\u5f02\u5e38\uff0c\uff0c\u67d0\u4e9b\u7ecf\u529e\u4eba\u5904\u7406\u8fc7\u987e\u5ba2\u4fe1\u606f,\u65e0\u6cd5\u5220\u9664\u8be5\u7ecf\u529e\u4eba\uff0c\u8bf7\u91cd\u65b0\u9009\u62e9";
        }
    }
    
    @RequestMapping(value = { "ModifyAgency" }, produces = { "text/html;charset=UTF-8" })
    @ResponseBody
    public String modifyAgency(final Agency agency) {
        return this.agencyService.modifyAgency(agency);
    }
    
    @RequestMapping({ "GetMessage" })
    @ResponseBody
    public EasyUIResult queryAllAgency(@RequestParam(value = "page", defaultValue = "1") final Integer page, @RequestParam(value = "rows", defaultValue = "5") final Integer rows) {
        return this.agencyService.queryAllAgency(page, rows);
    }
    
    @RequestMapping(value = { "SaveAgency" }, produces = { "text/html;charset=UTF-8" })
    @ResponseBody
    public String saveAgency(final Agency agency) {
        return this.agencyService.saveAgency(agency);
    }
    
    @RequestMapping({ "GetAllAgency" })
    @ResponseBody
    public List<Agency> getAllAgency() {
        final List<Agency> allAgency = this.agencyService.getAllAgency();
        return allAgency;
    }
}
