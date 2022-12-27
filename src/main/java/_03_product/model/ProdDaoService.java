package _03_product.model;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.util.HibernateUtil;

public class ProdDaoService {

	private ProdDao pDao;
	private SessionFactory factory;

	public ProdDaoService() {
		this.factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		this.pDao = new ProdDao(session);
	}

//	搜尋全部商品
	public List<Product> searchAllProduct() throws SQLException {
		this.factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		List<Product> list = null;
		try {
			list = pDao.searchAllProduct();

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return list;
	}

//	透過商品編號(prodID)來做單一個商品資訊搜尋 會回傳一個 Product
	public Product searchSingleProductFromProdID(Integer prodID) throws SQLException {
		this.factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Product prod = null;
		try {
			prod = pDao.searchSingleProductFromProdID(prodID);
//		System.out.println("DaoSingleSearch-tryBody");

			session.getTransaction().commit();
		} catch (Exception e) {
//			System.out.println("DaoSingleSearch-catch");
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return prod;
	}

	public void addNewProduct(int prodClass, String prodName, int prodPrice, int memberID, int inventory,
			Blob prodImg) {
		this.factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
//		System.out.println("service-addNew-head");

		try {
//			System.out.println("service-addNew-Body");
			pDao.addNewProduct(prodClass, prodName, prodPrice, memberID, inventory, prodImg);
			session.getTransaction().commit();
		} catch (Exception e) {
//			System.out.println("service-addNew-catch");
			session.getTransaction().rollback();
			e.printStackTrace();
		}

	}

//	透過prodID刪除整筆資料
	public void deleteProdFromProdID(Integer prodID) {
		this.factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
//		System.out.println("service-deleteProd-head");

		try {
//			System.out.println("service-deleteProd-Body");
			pDao.deleteProdFromProdID(prodID);
			session.getTransaction().commit();
		} catch (Exception e) {
//			System.out.println("service-deleteProd-catch");
			session.getTransaction().rollback();
			e.printStackTrace();
		}

	}

//	透過prodID修改product的資料 -- update including photo as well
	public void updateProdWithPhotoFromProdID(int oldProdClass,int NewProdClass, String prodName, int prodPrice, int memberID,
			int inventory, Blob prodImg, int prodID) {

		this.factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		System.out.println("service-UpdateProd-head");

		try {
			System.out.println("service-UpdateProd-Body");
			
			pDao.updateProdWithPhotoFromProdID(oldProdClass,NewProdClass, prodName, prodPrice, memberID, inventory, prodImg, prodID);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("service-UpdateProd-catch");
			session.getTransaction().rollback();
			e.printStackTrace();
		}

	}
//	透過prodID修改product的資料 -- update without updating photo
	public void updateProdWithoutPhotoFromProdID(int oldProdClass,int NewProdClass, String prodName, int prodPrice, int memberID, int inventory,int prodID) {
		
		this.factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		System.out.println("service-UpdateProd-head");

		try {
			System.out.println("service-UpdateProd-Body");
			
			pDao.updateProdWithoutPhotoFromProdID(oldProdClass,NewProdClass, prodName, prodPrice, memberID, inventory, prodID);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("service-UpdateProd-catch");
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	public List<Product> searchShit(String type, Integer low, Integer high, String name, Integer order) {
		this.factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		System.out.println("service-UpdateProd-head");
		
		List<Product> list = null;

		try {
			System.out.println("service-UpdateProd-Body");
			
			list = pDao.searchShit(type, low, high, name, order);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("service-UpdateProd-catch");
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return list;
	}

}
