package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.CompanyBean;
import tw.hibernatedemo.service.CompanyService;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoCompanyServiceActionEx1 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			CompanyService comService = new CompanyService(session);
			
			CompanyBean comBean = comService.select(1002);
			
			if(comBean != null) {
				System.out.println("id: " + comBean.getCompanyId() + " Name: " + comBean.getCompanyName());
			}else {
				System.out.println("沒有這筆資料");
			}
			
			
			
			session.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("rollback!!");
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSessionFactory();
		}

	}

}
