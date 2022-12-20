package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import tw.hibernatedemo.model.myHouseBean;


public class DemoHouse {

	public static void main(String[] args) {
		
		StandardServiceRegistry service = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		SessionFactory factory = new MetadataSources(service).buildMetadata().buildSessionFactory();
		
		myHouseBean my = new myHouseBean();
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		my.setHouseid(1001);
		my.setHouseName("信義房屋");
		
		session.save(my);
		
		session.getTransaction().commit();
		try {
			
		} catch (Exception e) {
			System.out.println("出事就縮！");
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}

}
