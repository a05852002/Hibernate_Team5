package tw.hibernatedemo.action;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.CompanyBean;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoDepartmentEX4 {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			CompanyBean com1 = new CompanyBean();
			com1.setCompanyId(1002);
			com1.setCompanyName("FTX");

			Serializable id = session.save(com1);

			System.out.println("ID:" + id);

			session.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("老大，出事了！先撤退RollBack！");
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSessionFactory();
		}

	}

}
