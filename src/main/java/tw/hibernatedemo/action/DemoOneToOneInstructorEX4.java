package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Instructor;
import tw.hibernatedemo.model.InstructorDetail;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoOneToOneInstructorEX4 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();

			InstructorDetail detail = new InstructorDetail();
			
			detail.setEmail("jerry@google.com");
			detail.setPhone("0912345678");
			
			session.save(detail);
			
			Instructor ins =session.get(Instructor.class, 1);
			ins.setInstructorDetail(detail);
//			detail.setInstructor(ins);  為啥不行?
			
			
			
			session.getTransaction().commit();
		}catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSessionFactory();
		}
	}

}
