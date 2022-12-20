package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import tw.hibernatedemo.model.CompanyBean;

public class DemoCompanyBeanEx1 {

	public static void main(String[] args) {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		SessionFactory factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();

		Session session = factory.openSession();
		session.beginTransaction();
		
		CompanyBean comBean = new CompanyBean();
		
		comBean.setCompanyId(1001);
		comBean.setCompanyName("Google");
		
		session.save(comBean);
		
		session.getTransaction().commit();
		session.close();
		factory.close();
		
		
	}

}
