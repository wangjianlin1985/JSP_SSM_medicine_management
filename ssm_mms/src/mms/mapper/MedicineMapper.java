// 
// 
// 

package mms.mapper;

import java.util.List;
import mms.pojo.Medicine;

public interface MedicineMapper
{
    Medicine queryMedicineByMno(String p0);
    
    List<Medicine> queryAllMedicine();
    
    void saveMedicine(Medicine p0);
    
    void deleteMedicineByMno(String p0);
    
    void modifyMedicine(Medicine p0);
    
    List<Medicine> queryMultiMedicine(Medicine p0);
}
