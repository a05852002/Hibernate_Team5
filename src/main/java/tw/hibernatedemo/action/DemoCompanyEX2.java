package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.CompanyBean;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoCompanyEX2 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		
		try {
			session.beginTransaction();
			
			CompanyBean com1 = session.get(CompanyBean.class, 1001);
			
			System.out.println(com1.toString());
			
			com1.setCompanyName("Google");
			session.save(com1);
			
			System.out.println(com1.toString());
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("出4了阿北，緊酸！");
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSessionFactory();
		}

	}

}
