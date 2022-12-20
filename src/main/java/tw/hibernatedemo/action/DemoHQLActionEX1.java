package tw.hibernatedemo.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import tw.hibernatedemo.model.Employee;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoHQLActionEX1 {
	

	public static void main(String[] args) {
		DemoHQLActionEX1 demoHql = new DemoHQLActionEX1();
//		demoHql.hqlDemo1();
//		demoHql.findEmployeeBySalaryAndVacation(30000, 10);
//		demoHql.findByName("o");
		demoHql.updateByName(42000, "Tom");

	}

	public void hqlDemo1() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			String hql = "from Employee";
			
			Query<Employee> query = session.createQuery(hql, Employee.class);
			List<Employee> list = query.getResultList();
			
			for (Employee employee : list) {
				System.out.println(employee.toString());
			}
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("有錯ㄟ");
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSessionFactory();
		}
	}
	
	public void findEmployeeBySalaryAndVacation(Integer salary, Integer vacation) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			String hql = "from Employee where salary > :s and vacation > :v";
			Query<Employee> query = session.createQuery(hql, Employee.class)
					.setParameter("s", salary)
					.setParameter("v", vacation);
			
			List<Employee> list = query.getResultList();
			
			for (Employee employee : list) {
				System.out.println(employee.toString());
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("有錯ㄟ");
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSessionFactory();
		}
	}
	
	public void findByName(String name) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			String hql = "from Employee where empName like :name";
			Query<Employee> query = session.createQuery(hql, Employee.class)
					.setParameter("name","%"+name+"%");
			
			List<Employee> list = query.getResultList();
			
			for (Employee employee : list) {
				System.out.println(employee.toString());
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("有錯ㄟ");
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSessionFactory();
		}
	}
	
	public void updateByName(Integer salary, String name) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			String hql = "Update Employee Set salary = :s where empName = :name";
			int rowData = session.createQuery(hql)
					.setParameter("s",salary)
					.setParameter("name", name)
					.executeUpdate();
			
			System.out.println("修改了"+rowData+"筆資料。");
			
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("有錯ㄟ");
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSessionFactory();
		}
	}
	
}
