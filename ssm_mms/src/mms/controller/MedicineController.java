// 
// 
// 

package mms.controller;

import java.util.List;
import mms.pojo.EasyUIResult;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import mms.pojo.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import mms.services.MedicineService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({ "Medicine" })
@Controller
public class MedicineController
{
    @Autowired
    private MedicineService medicineService;
    
    @RequestMapping({ "QueryMedicineByMno" })
    @ResponseBody
    public Medicine queryMedicineByMno(final String mno) {
        final Medicine medicine = this.medicineService.queryMedicineByMno(mno);
        return medicine;
    }
    
    @RequestMapping(value = { "DeleteRows" }, produces = { "text/html;charset=UTF-8" })
    @ResponseBody
    public String deleteMedicineByRows(@RequestParam("array[]") final String[] array) {
        try {
            return this.medicineService.deleteMedicineByRows(array);
        }
        catch (Exception e) {
            return "\u64cd\u4f5c\u5f02\u5e38\uff0c\u53ef\u80fd\u67d0\u4e9b\u836f\u54c1\u88ab\u987e\u5ba2\u8d2d\u4e70\u8fc7\uff0c\u65e0\u6cd5\u5220\u8be5\u836f\u54c1\uff0c\u8bf7\u91cd\u65b0\u9009\u62e9";
        }
    }
    
    @RequestMapping(value = { "SaveMedicine" }, produces = { "text/html;charset=UTF-8" })
    @ResponseBody
    public String saveMedicine(final Medicine medicine) {
        return this.medicineService.saveMedicine(medicine);
    }
    
    @RequestMapping(value = { "ModifyMedicine" }, produces = { "text/html;charset=UTF-8" })
    @ResponseBody
    public String modifyMedicine(final Medicine medicine) {
        return this.medicineService.modifyMedicine(medicine);
    }
    
    @RequestMapping({ "GetMessage" })
    @ResponseBody
    public EasyUIResult queryAllMedicine(@RequestParam(value = "page", defaultValue = "1") final Integer page, @RequestParam(value = "rows", defaultValue = "5") final Integer rows) {
        return this.medicineService.queryAllMedicine(page, rows);
    }
    
    @RequestMapping({ "GetAllMedicine" })
    @ResponseBody
    public List<Medicine> getAllMedicine() {
        final List<Medicine> allMedicine = this.medicineService.getAllMedicine();
        return allMedicine;
    }
}
