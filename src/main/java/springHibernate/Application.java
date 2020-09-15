package springHibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springHibernate.model.Student;
import springHibernate.services.IStudentService;

public class Application {

	public static void main(String[] args) {

//		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Student student = new Student("Atindra", 28, 78F);
		IStudentService studentService = context.getBean(IStudentService.class);
		

		studentService.add(student);
		
		studentService.view();
		Student std1 = studentService.findStudentById(1L);
		if(null!=std1){
			System.out.println("---------Student "+std1.getId()+" Found------");
			std1.setMarks(65F);
			std1.setName("Arindam");
			std1.setAge(21);
			System.out.println("---------After Updation------");
			studentService.update(std1);
			studentService.view();
		}else{
			System.out.println("---------Student NOT Found------");
		}
		Student std2 = studentService.findStudentById(1L);
		if(null!=std2){
			System.out.println("---------Student "+std2.getId()+" Found------");
			studentService.delete(std2);
			System.out.println("---------After Deletion------");
			studentService.view();
		}else{
			System.out.println("---------Student NOT Found------");
		}
		
		((AbstractApplicationContext) context).close();
	}
}
