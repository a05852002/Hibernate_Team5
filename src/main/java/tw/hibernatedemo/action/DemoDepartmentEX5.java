package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import tw.hibernatedemo.model.Department;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoDepartmentEX5 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			Department dept = new Department("戰鬥部門");
			
			session.save(dept);
			
			
			
			
			
			tx.commit();
			
		} catch (Exception e) {
			System.out.println("有內鬼，終止交易！");
			tx.rollback();
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSessionFactory();
		}

	}

}
