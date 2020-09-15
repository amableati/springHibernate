/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javainfinite.execution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javainfinite.DAO.EmployeeDAO;
import javainfinite.pojo.EmployeeDetails;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Vikram
 */
public class execute {
    
    public static void main(String args[]){
        int updateId = 0;
        
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeDAO eDao = (EmployeeDAO) ac.getBean("EmployeeDAO");
        EmployeeDetails employeeDetails1 =(EmployeeDetails) ac.getBean("employeeDetails");
        EmployeeDetails employeeDetails2 =(EmployeeDetails) ac.getBean("employeeDetails");
        EmployeeDetails employeeDetails3 =(EmployeeDetails) ac.getBean("employeeDetails");

        // Inserting Employee - Create
        System.out.println("----------CREATE--------");
        employeeDetails1.setEname("Alpha");
        employeeDetails1.setEnumber("A0121");
        eDao.SaveEmployee(employeeDetails1);
        
        employeeDetails2.setEname("Beta");
        employeeDetails2.setEnumber("B2321");
        eDao.SaveEmployee(employeeDetails2);
        
        employeeDetails3.setEname("Charlie");
        employeeDetails3.setEnumber("C2345");
        eDao.SaveEmployee(employeeDetails3);
        
         System.out.println("-------------------------------------------------------------");
        
        //Listing All Employees
        System.out.println("----------READ--------");
        List<EmployeeDetails> employeeDetailsList = new ArrayList();
        employeeDetailsList = eDao.getAllEmployees();
        
        for(EmployeeDetails eList: employeeDetailsList){
            System.out.println("Employee ID: "+eList.getId());
            System.out.println("Employee Name: "+eList.getEname());
            System.out.println("Employee Number: "+eList.getEnumber());
        }
        
         System.out.println("-------------------------------------------------------------");
        //Deleting Employee
        
        System.out.println("----------DELETE--------");
        Scanner input = new Scanner(System.in);
        int id = 0;
        System.out.println("Enter the ID to Delete: ");
        id = input.nextInt();
        EmployeeDetails employeeDetailsDelete =(EmployeeDetails) ac.getBean("employeeDetails");
        
        employeeDetailsDelete.setId(id);
        eDao.Delete(employeeDetailsDelete);
        System.out.println("Record with ID: "+id+" Deleted");
        
         System.out.println("-------------------------------------------------------------");
        
        //Listing All Employees
        System.out.println("----------READ--------");
        List<EmployeeDetails> employeeDetailsList1 = new ArrayList();
        employeeDetailsList1 = eDao.getAllEmployees();
        
        for(EmployeeDetails eList: employeeDetailsList1){
            System.out.println("Employee ID: "+eList.getId());
            System.out.println("Employee Name: "+eList.getEname());
            System.out.println("Employee Number: "+eList.getEnumber());
        }
        
         System.out.println("-------------------------------------------------------------");
        
        //Update
        System.out.println("----------Update--------");
        System.out.println("Enter the ID to be Updated: ");
        Scanner update = new Scanner(System.in);
        updateId = update.nextInt();
        String ename = "";
        String enumber = "";
        
        System.out.println("Name to be Updated: ");
        ename = update.next();
        System.out.println("Number to be Updated: ");
        enumber = update.next();
        eDao.Update(updateId, ename, enumber );
        System.out.println("Updated");
        
         System.out.println("-------------------------------------------------------------");
        
         //Listing All Employees
        System.out.println("----------READ--------");
        List<EmployeeDetails> employeeDetailsList2 = new ArrayList();
        employeeDetailsList2 = eDao.getAllEmployees();
        
        for(EmployeeDetails eList: employeeDetailsList2){
            System.out.println("Employee ID: "+eList.getId());
            System.out.println("Employee Name: "+eList.getEname());
            System.out.println("Employee Number: "+eList.getEnumber());
        }
        
        System.out.println("-------------------------------------------------------------");
    }
    
}
