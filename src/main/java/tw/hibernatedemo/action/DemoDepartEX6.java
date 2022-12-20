package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Department;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoDepartEX6 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		
		
		try {
			session.beginTransaction();
			
			Department dept = session.get(Department.class, 4);
			
			System.out.println(dept.toString());
			
			session.delete(dept);
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("出錯拜天恩！");
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSessionFactory();
		}
		
		
	}

}
