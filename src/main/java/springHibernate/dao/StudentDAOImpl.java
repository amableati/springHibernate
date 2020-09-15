package springHibernate.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import springHibernate.common.ApplicationException;
import springHibernate.common.SessionFactoryConnection;
import springHibernate.model.Student;

@Repository
@SuppressWarnings("unchecked")
public class StudentDAOImpl extends SessionFactoryConnection implements IStudentDAO {

	
	@Override
	public void update(Student student) {
		try {
			getSession().update(student);
		} catch (HibernateException e) {
			throw new ApplicationException(e);
		}
	}

	@Override
	public void delete(Student student) {
		try {
			getSession().delete(student);
		} catch (HibernateException e) {
			throw new ApplicationException(e);
		}
	}

	@Override
	public ArrayList<Student> view() {
		Query query = getSession().createQuery("FROM Student");
		try {
			return (ArrayList<Student>) query.list();
		} catch (HibernateException e) {
			throw new ApplicationException(e);
		}
	}

	@Override
	public void add(Student student) {
		try {
			getSession().save(student);
		} catch (HibernateException e) {
			throw new ApplicationException(e);
		}
	}

	@Override
	public Student findStudentById(Long id) {
		Query query = getSession().createQuery("FROM Student where id=:id");
		query.setLong("id", id);
		try {
			return (Student) query.uniqueResult();
		} catch (HibernateException e) {
			throw new ApplicationException(e);
		}
	}

}
