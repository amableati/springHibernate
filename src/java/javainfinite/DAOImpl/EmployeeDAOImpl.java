/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javainfinite.DAOImpl;

import java.util.ArrayList;
import java.util.List;
import javainfinite.DAO.EmployeeDAO;
import javainfinite.pojo.EmployeeDetails;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;


/**
 *
 * @author Admin
 */
public class EmployeeDAOImpl implements EmployeeDAO {
    

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void SaveEmployee(EmployeeDetails employeeDetails) {
        Session session = this.sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        session.save(employeeDetails);
        trans.commit();
        session.close();
    }


    public List<EmployeeDetails> getAllEmployees() {
         Session session = this.sessionFactory.openSession();
        List<EmployeeDetails> employeeList = new ArrayList();
        Query query = session.createQuery("From EmployeeDetails");
        employeeList = query.list();
        session.close();
        return employeeList;    
    }


    public void Delete(EmployeeDetails employeeDetails) {
         Session session = this.sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        session.delete(employeeDetails);
        trans.commit();
        session.close();
    }
    
     public void Update(Integer id, String ename, String enumber) {
        Session session = this.sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        EmployeeDetails employeeDetails =(EmployeeDetails) session.load(EmployeeDetails.class,id);
        employeeDetails.setEname(ename);
        employeeDetails.setEnumber(enumber);
        session.update(employeeDetails);
        trans.commit();
        session.close();
    }
    
}
