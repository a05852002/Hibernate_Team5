package tw.hibernatedemo.action;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.BookUsers;
import tw.hibernatedemo.model.Books;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoOneToManyBookUsersEX2 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			//bookuser id=1 ,想知道他借了哪些書
			BookUsers users = session.get(BookUsers.class, 3);
			
			Set<Books> userBooks = users.getBooks();
			
			for (Books books : userBooks) {
				System.out.println(books.toString());
			}
			
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("苗頭不對酸喔");
			e.printStackTrace();
		}finally {
			session.close();
		}

	}

}
