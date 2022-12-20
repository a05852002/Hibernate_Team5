package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import tw.hibernatedemo.model.Department;

public class DemoDepartmentEX1 {

	public static void main(String[] args) {
		
		StandardServiceRegistry service = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory factory = new MetadataSources(service).buildMetadata().buildSessionFactory();
		
		Session session = factory.openSession();
		
		session.beginTransaction();
		
		Department dept1 = new Department();
		
		dept1.setName("人資部門");
		
		session.save(dept1);
		
		session.getTransaction().commit();
		
		session.close();
		factory.close();

	}

}
