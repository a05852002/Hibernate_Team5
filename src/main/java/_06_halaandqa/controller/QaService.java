package _06_halaandqa.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import _06_halaandqa.model.QaBean;
import _06_halaandqa.model.QaDao;
import tw.hibernatedemo.util.HibernateUtil;

public class QaService implements QaInterface {
	
	private QaDao qDao;
	
	public QaService(Session session) {
		this.qDao = new QaDao(session);
	}
	
	public QaBean insertQa(String qaClassName, Integer memberId, String title, String qaContent) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		QaBean h = qDao.addQa(qaClassName,memberId,title,qaContent);
		session.getTransaction().commit();
		return h;
	}
	
	public List<QaBean> findQaAll(){
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<QaBean> h = qDao.findAllQa();
		session.getTransaction().commit();
		return h;
	}
	
	public List<QaBean> selectQa(String qaClassName) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<QaBean> h = qDao.findByQaClassName(qaClassName);
		session.getTransaction().commit();
		return h;
	}
	
	public boolean deleteQa(Integer qaId) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		boolean h = qDao.deleteQa(qaId);
		session.getTransaction().commit();
		return h;
	}
	
	public QaBean findQaId(Integer qaId) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		QaBean h = qDao.findByQaId(qaId);
		session.getTransaction().commit();
		return h;
	}
	
	public QaBean updateQa(Integer qaId, String qaClassName, String title, String qaContent) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		QaBean h = qDao.updatQa(qaId, qaClassName, title, qaContent);
		session.getTransaction().commit();
		return h;
		
	}

}



