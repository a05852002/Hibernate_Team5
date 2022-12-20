package tw.hibernatedemo.action;

import java.awt.print.Book;
import java.util.LinkedHashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.BookUsers;
import tw.hibernatedemo.model.Books;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoOneToManyBookUsers {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			//new users
			BookUsers users = new BookUsers();
			users.setUser("阿館");
			
			//new book1
			Books book1 = new Books();
			book1.setBooktitle("JAVA王者歸來");
			book1.setPublicYear("2018-8");
			
			//new book2
			Books book2 = new Books();
			book2.setBooktitle("SQL的一百種解法");
			book2.setPublicYear("2022-2");
			
			book1.setBookUsers(users);
			book2.setBookUsers(users);
			//user set book
			Set<Books> bookSet = new LinkedHashSet<Books>();
			bookSet.add(book1);
			bookSet.add(book2);
			
			users.setBooks(bookSet);
			session.save(users);
			
			
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
