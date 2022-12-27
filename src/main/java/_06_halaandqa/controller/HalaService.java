package _06_halaandqa.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import _06_halaandqa.model.HalaBean;
import _06_halaandqa.model.HalaDao;
import tw.hibernatedemo.util.HibernateUtil;

public class HalaService implements HalaInterface {
	
	private HalaDao hDao;
	
	public HalaService(Session session) {
		this.hDao = new HalaDao(session);
	}
	
	public HalaBean insertHala(String halaClassName, Integer memberId, String title, String halaContent) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		HalaBean h = hDao.addHala(halaClassName,memberId,title,halaContent);
		session.getTransaction().commit();
		return h;
	}
	
	public List<HalaBean> findHalaAll(){
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<HalaBean> h = hDao.findAllHala();
		session.getTransaction().commit();
		return h;
	}
	
	public List<HalaBean> selectHala(String halaClassName) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<HalaBean> h = hDao.findByClassName(halaClassName);
		session.getTransaction().commit();
		return h;
	}
	
	public boolean deleteHala(Integer halaId) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		boolean h = hDao.deleteHala(halaId);
		session.getTransaction().commit();
		return h;
	}
	
	public HalaBean findHalaId(Integer halaId) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		HalaBean h = hDao.findByHalaId(halaId);
		session.getTransaction().commit();
		return h;
	}
	
	public HalaBean updateHala(Integer halaId, String halaClassName, String title, String halaContent) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		HalaBean h = hDao.updatHala(halaId, halaClassName, title, halaContent);
		session.getTransaction().commit();
		return h;
		
	}

}
