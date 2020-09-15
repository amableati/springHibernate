package springHibernate.services;

import springHibernate.model.Student;

public interface IStudentService {

	void add(Student student);
	
	void update(Student student);
	
	void delete(Student student);

	void view();
	
	Student findStudentById(Long id);
}
