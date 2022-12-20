package tw.hibernatedemo.action;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Department;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoDepartmentEX3 {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();	
		Session session = factory.openSession();
		
		session.beginTransaction();
		
		Department dept3 = new Department("Sells");
		
		Serializable id = session.save(dept3);
		
		System.out.println(id);
		
		session.getTransaction().commit();
		
		session.close();
		
		HibernateUtil.closeSessionFactory();
		
		
		
	}

}
