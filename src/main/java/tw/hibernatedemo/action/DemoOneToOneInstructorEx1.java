package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Instructor;
import tw.hibernatedemo.model.InstructorDetail;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoOneToOneInstructorEx1 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			Instructor ins1 = new Instructor();
			ins1.setName("Jerry");
			
			InstructorDetail detail1 = new InstructorDetail();
			detail1.setEmail("jerry@gmail");
			detail1.setPhone("66666");
			
			ins1.setInstructorDetail(detail1);
			
			session.beginTransaction();
			
			// 因為有做 cascade 連動，所以 detail1 也會一起轉到 Persistent 狀態
			session.save(ins1);
			
			session.getTransaction().commit();
		}catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSessionFactory();
		}

	}

}
