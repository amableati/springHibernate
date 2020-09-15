package springHibernate.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springHibernate.common.ApplicationException;
import springHibernate.dao.IStudentDAO;
import springHibernate.model.Student;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentDAO iStudentDAO;
	
	@Override
	public void add(Student student) {
		try {
			iStudentDAO.add(student);
		} catch (Exception e) {
			throw new ApplicationException(e);
		}
	}

	@Override
	public void view() {
		try {
			ArrayList<Student> studentList = iStudentDAO.view();
			if(studentList.size()<1){
				System.out.println("No Student Record Found");
			}
			for(Student s : studentList){
				System.out.println("Student ID "+s.getId());
				System.out.println("Name: "+s.getName());
				System.out.println("Age: "+s.getAge());
				System.out.println("Marks: "+s.getMarks());
				System.out.println("--------------");
			}
		} catch (Exception e) {
			throw new ApplicationException(e);
		}
	}

	@Override
	public void update(Student student) {
		try {
			iStudentDAO.update(student);
		} catch (Exception e) {
			throw new ApplicationException(e);
		}
	}

	@Override
	public void delete(Student student) {
		try {
			iStudentDAO.delete(student);
		} catch (Exception e) {
			throw new ApplicationException(e);
		}
	}

	@Override
	public Student findStudentById(Long id) {
		try {
			if(id!=null){
				return iStudentDAO.findStudentById(id);
			}
			return null;
		} catch (Exception e) {
			throw new ApplicationException(e);
		}
	}
}
