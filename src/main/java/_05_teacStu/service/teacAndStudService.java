package _05_teacStu.service;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import _05_teacStu.model.tableForStud;
import _05_teacStu.model.tableForTeac;
import _05_teacStu.model.teacAndStudDao;
import tw.hibernatedemo.util.HibernateUtil;

public class teacAndStudService implements teacAndStudServiceInterface {
	
	private teacAndStudDao tsDao;
	
	public teacAndStudService(Session session) {
		this.tsDao = new teacAndStudDao(session);
	}
	
//	模糊查詢教師全部
	@Override
	public List<tableForTeac> searchAllLike(String searchAllLike) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<tableForTeac> ts = tsDao.searchAllLike(searchAllLike);
		session.getTransaction().commit();
		return ts;
	}
	
//	模糊查詢學生全部
	@Override
	public List<tableForStud> searchAllLikeStud(String searchAllLike) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<tableForStud> ts = tsDao.searchAllLikeStud(searchAllLike);
		session.getTransaction().commit();
		return ts;
	}
	
//  透過時薪區間建立教師貼文查詢
	@Override
	public List<tableForTeac> searchTeacByPrice(Integer low, Integer high) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<tableForTeac> ts = tsDao.searchTeacByPrice(low, high);
		session.getTransaction().commit();
		return ts;
	}
	
//  透過時薪區間建立學生貼文查詢
	@Override
	public List<tableForStud> searchStudByPrice(Integer low, Integer high) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<tableForStud> ts = tsDao.searchStudByPrice(low, high);
		session.getTransaction().commit();
		return ts;
	}
	
//	搜尋全部教師貼文依時薪降序排序
	@Override
	public List<tableForTeac> searchAllTeacOBprice() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<tableForTeac> ts = tsDao.searchAllTeacOBprice();
		session.getTransaction().commit();
		return ts;
	}
	
//	搜尋全部學生貼文依時薪降序排序
	@Override
	public List<tableForStud> searchAllStudOBprice() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<tableForStud> ts = tsDao.searchAllStudOBprice();
		session.getTransaction().commit();
		return ts;
	}
	
//	搜尋全部教師貼文依日期降序排序
	@Override
	public List<tableForTeac> searchAllTeacOBpDate() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<tableForTeac> ts = tsDao.searchAllTeacOBpDate();
		session.getTransaction().commit();
		return ts;
	}
	
//	搜尋全部學生貼文依日期降序排序
	@Override
	public List<tableForStud> searchAllStudOBpDate() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<tableForStud> ts = tsDao.searchAllStudOBpDate();
		session.getTransaction().commit();
		return ts;
	}
	
//	搜尋全部教師貼文依會員編號排序
	@Override
	public List<tableForTeac> searchAllTeacOBmId() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<tableForTeac> ts = tsDao.searchAllTeacOBmId();
		session.getTransaction().commit();
		return ts;
	}
	
//	搜尋全部學生貼文依會員編號排序
	@Override
	public List<tableForStud> searchAllStudOBmId() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<tableForStud> ts = tsDao.searchAllStudOBmId();
		session.getTransaction().commit();
		return ts;
	}
	
//	透過貼文編號建立教師貼文查詢
	@Override
	public tableForTeac searchTeacFromTeacno(Integer teacno) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		tableForTeac ts = tsDao.searchTeacFromTeacno(teacno);
		session.getTransaction().commit();
		return ts;
	}
	
//	透過貼文編號建立學生貼文查詢
	@Override
	public tableForStud searchStudFromStudno(Integer studno) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		tableForStud ts = tsDao.searchStudFromStudno(studno);
		session.getTransaction().commit();
		return ts;
	}
	
//	搜尋全部教師貼文
	@Override
	public List<tableForTeac> searchAllTeac() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<tableForTeac> ts = tsDao.searchAllTeac();
		session.getTransaction().commit();
		return ts;
	}
	
//	搜尋全部學生貼文
	@Override
	public List<tableForStud> searchAllStud() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<tableForStud> ts = tsDao.searchAllStud();
		session.getTransaction().commit();
		return ts;
	}
	
//	新增教師貼文
	@Override
	public void addTeac(tableForTeac tableForTeac) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		tsDao.addTeac(tableForTeac);
		session.getTransaction().commit();
	}
	
//	新增學生貼文
	@Override
	public void addStud(tableForStud tableForStud) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		tsDao.addStud(tableForStud);
		session.getTransaction().commit();
	}
	
//	透過ID刪除教師貼文
	@Override
	public void deleteTeacfromTeacno(Integer teacno) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		tsDao.deleteTeacfromTeacno(teacno);
		session.getTransaction().commit();
	}
	
//	透過ID刪除學生貼文
	@Override
	public void deleteStudfromStudno(Integer studno) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		tsDao.deleteStudfromStudno(studno);
		session.getTransaction().commit();
	}
	
//	透過ID修改教師貼文
	@Override
	public tableForTeac updateTeacFromTeacno(Integer teacno, Integer memberId, String title, Date postDate,
			String detail, Double price, String subjectItem, Blob ClassPicture) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		tableForTeac ts = tsDao.updateTeacFromTeacno(teacno, memberId, title, postDate, detail, price, subjectItem, ClassPicture);
		session.getTransaction().commit();
		return ts;
	}
	
//	透過ID修改學生貼文
	@Override
	public tableForStud updateStudFromStudno(Integer studno, Integer memberId, String title, Date postDate,
			String detail, Double price, String subjectItem, String learnLoc, Blob ClassPicture) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		tableForStud ts = tsDao.updateStudFromStudno(studno, memberId, title, postDate, detail, price, subjectItem, learnLoc, ClassPicture);
		session.getTransaction().commit();
		return ts;
	}
	
}
