package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.CompanyBean;
import tw.hibernatedemo.model.CompanyDao;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoCompanyDAO {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			CompanyBean com1 = new CompanyBean();
			CompanyDao dao = new CompanyDao(session);
			
			com1.setCompanyId(1003);
			com1.setCompanyName("運動彩券");
			
			CompanyBean comp = dao.insertCompany(com1);
			
			System.out.println(comp.toString());
			
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			HibernateUtil.closeSessionFactory();
		}
	}

}
