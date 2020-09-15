/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javainfinite.DAO;

import java.util.List;
import javainfinite.pojo.EmployeeDetails;

/**
 *
 * @author Vikram
 */
public interface EmployeeDAO {
    
    public void SaveEmployee(EmployeeDetails employeeDetails);
    public List<EmployeeDetails> getAllEmployees();
    public void Delete (EmployeeDetails employeeDetails);
    public void Update(Integer id, String ename, String enumber);
    
}
