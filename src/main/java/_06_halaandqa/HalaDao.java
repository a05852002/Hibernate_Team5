package _06_halaandqa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.util.HibernateUtil;

public class HalaDao {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
	
		
	

}
