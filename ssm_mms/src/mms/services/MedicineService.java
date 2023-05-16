// 
// 
// 

package mms.services;

import javax.servlet.http.HttpSession;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import mms.pojo.EasyUIResult;
import mms.pojo.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import mms.mapper.MedicineMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MedicineService
{
    @Autowired
    private MedicineMapper medicineMapper;
    
    public Medicine queryMedicineByMno(final String mno) {
        final Medicine medicine = this.medicineMapper.queryMedicineByMno(mno);
        return medicine;
    }
    
    public EasyUIResult queryAllMedicine(final Integer page, final Integer rows) {
        PageHelper.startPage((int)page, (int)rows);
        final List<Medicine> medicines = this.medicineMapper.queryAllMedicine();
        final PageInfo<Medicine> pageInfo = (PageInfo<Medicine>)new PageInfo((List)medicines);
        return new EasyUIResult(Long.valueOf(pageInfo.getTotal()), medicines);
    }
    
    public String saveMedicine(final Medicine medicine) {
        if (this.queryMedicineByMno(medicine.getMno()) != null) {
            return "\u836f\u54c1\u7f16\u53f7\u5df2\u7ecf\u5b58\u5728\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165\u7f16\u53f7";
        }
        this.medicineMapper.saveMedicine(medicine);
        return "\u4fdd\u5b58\u6210\u529f";
    }
    
    public String deleteMedicineByMno(final String mno) {
        try {
            this.medicineMapper.deleteMedicineByMno(mno);
        }
        catch (Exception e) {
            return "\u5220\u9664\u5931\u8d25\uff0c\u53ef\u80fd\u662f\u6709\u5ba2\u6237\u8d2d\u4e70\u6b64\u836f\uff0c\u65e0\u6cd5\u5220\u9664\u6b64\u836f\u54c1";
        }
        return "\u5220\u9664\u6210\u529f";
    }
    
    public String modifyMedicine(final Medicine medicine) {
        final Medicine queryMedicineByMno = this.queryMedicineByMno(medicine.getMno());
        if (queryMedicineByMno != null && queryMedicineByMno.getMid() != medicine.getMid()) {
            return "\u8fd9\u4e2a\u836f\u54c1\u7f16\u53f7\u5df2\u7ecf\u5b58\u5728\uff0c\u4e0d\u80fd\u4fee\u6539\u4e3a\u8fd9\u4e2a\u7f16\u53f7";
        }
        try {
            this.medicineMapper.modifyMedicine(medicine);
        }
        catch (Exception e) {
            return "\u4fee\u6539\u5931\u8d25\uff0c\u53ef\u80fd\u662f\u6709\u5ba2\u6237\u8d2d\u4e70\u6b64\u836f\uff0c\u65e0\u6cd5\u4fee\u6539\u7f16\u53f7";
        }
        return "\u4fee\u6539\u6210\u529f";
    }
    
    public List<Medicine> getAllMedicine() {
        final List<Medicine> queryAllMedicine = this.medicineMapper.queryAllMedicine();
        return queryAllMedicine;
    }
    
    public String deleteMedicineByRows(final String[] array) {
        try {
            for (final String mno : array) {
                this.medicineMapper.deleteMedicineByMno(mno);
            }
        }
        catch (Exception e) {
            throw new RuntimeException();
        }
        return "\u5220\u9664\u6210\u529f";
    }
    
    public String queryMultiMedicine(final Medicine medicine, final HttpSession session) {
        try {
            final List<Medicine> medicines = this.medicineMapper.queryMultiMedicine(medicine);
            session.setAttribute("medicines", (Object)medicines);
            System.out.println(medicines);
            System.out.println("@@@@@");
            return "";
        }
        catch (Exception e) {
            return "\u64cd\u4f5c\u5f02\u5e38\uff0c\u8bf7\u5237\u65b0\u540e\u64cd\u4f5c";
        }
    }
    
    public EasyUIResult getMultiMedicine(final Integer page, final Integer rows, final HttpSession session) {
        PageHelper.startPage((int)page, (int)rows);
        final List<Medicine> medicines = (List<Medicine>)session.getAttribute("medicines");
        System.out.println(medicines);
        final PageInfo<Medicine> pageInfo = (PageInfo<Medicine>)new PageInfo((List)medicines);
        return new EasyUIResult(Long.valueOf(pageInfo.getTotal()), medicines);
    }
}
