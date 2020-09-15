package springHibernate.dao;

import java.util.ArrayList;

import springHibernate.model.Student;

public interface IStudentDAO {

	void update(Student student);

	void delete(Student student);

	ArrayList<Student> view();

	void add(Student student);

	Student findStudentById(Long id);
	
}
