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

public class teacAndStudService {
	
	private teacAndStudDao tsDao;
	
	public teacAndStudService(Session session) {
		this.tsDao = new teacAndStudDao(session);
	}
	
//	模糊查詢教師全部
	public List<tableForTeac> searchAllLike(String searchAllLike) {
		return tsDao.searchAllLike(searchAllLike);
	}
	
//	模糊查詢學生全部
	public List<tableForStud> searchAllLikeStud(String searchAllLike) {
		return tsDao.searchAllLikeStud(searchAllLike);
	}
	
//  透過時薪區間建立教師貼文查詢
	public List<tableForTeac> searchTeacByPrice(Integer low, Integer high) {
		return tsDao.searchTeacByPrice(low, high);
	}
	
//  透過時薪區間建立學生貼文查詢
	public List<tableForStud> searchStudByPrice(Integer low, Integer high) {
		return tsDao.searchStudByPrice(low, high);
	}
	
//	搜尋全部教師貼文依時薪降序排序
	public List<tableForTeac> searchAllTeacOBprice() {
		return tsDao.searchAllTeacOBprice();
	}
	
//	搜尋全部學生貼文依時薪降序排序
	public List<tableForStud> searchAllStudOBprice() {
		return tsDao.searchAllStudOBprice();
	}
	
//	搜尋全部教師貼文依日期降序排序
	public List<tableForTeac> searchAllTeacOBpDate() {
		return tsDao.searchAllTeacOBpDate();
	}
	
//	搜尋全部學生貼文依日期降序排序
	public List<tableForStud> searchAllStudOBpDate() {
		return tsDao.searchAllStudOBpDate();
	}
	
//	搜尋全部教師貼文依會員編號排序
	public List<tableForTeac> searchAllTeacOBmId() {
		return tsDao.searchAllTeacOBmId();
	}
	
//	搜尋全部學生貼文依會員編號排序
	public List<tableForStud> searchAllStudOBmId() {
		return tsDao.searchAllStudOBmId();
	}
	
//	透過貼文編號建立教師貼文查詢
	public tableForTeac searchTeacFromTeacno(Integer teacno) {
		return tsDao.searchTeacFromTeacno(teacno);
	}
	
//	透過貼文編號建立學生貼文查詢
	public tableForStud searchStudFromStudno(Integer studno) {
		return tsDao.searchStudFromStudno(studno);
	}
	
//	搜尋全部教師貼文
	public List<tableForTeac> searchAllTeac() {
		return tsDao.searchAllTeac();
	}
	
//	搜尋全部學生貼文
	public List<tableForStud> searchAllStud() {
		return tsDao.searchAllStud();
	}
	
//	新增教師貼文
	public void addTeac(tableForTeac tableForTeac) {
		tsDao.addTeac(tableForTeac);
	}
	
//	新增學生貼文
	public void addStud(tableForStud tableForStud) {
		tsDao.addStud(tableForStud);
	}
	
//	透過ID刪除教師貼文
	public void deleteTeacfromTeacno(Integer teacno) {
		tsDao.deleteTeacfromTeacno(teacno);
	}
	
//	透過ID刪除學生貼文
	public void deleteStudfromStudno(Integer studno) {
		tsDao.deleteStudfromStudno(studno);
	}
	
//	透過ID修改教師貼文
	public tableForTeac updateTeacFromTeacno(Integer teacno, Integer memberId, String title, Date postDate,
			String detail, Double price, String subjectItem, Blob ClassPicture) {
		return tsDao.updateTeacFromTeacno(teacno, memberId, title, postDate, detail, price, subjectItem, ClassPicture);
	}
	
//	透過ID修改學生貼文
	public tableForStud updateStudFromStudno(Integer studno, Integer memberId, String title, Date postDate,
			String detail, Double price, String subjectItem, String learnLoc, Blob ClassPicture) {
		return tsDao.updateStudFromStudno(studno, memberId, title, postDate, detail, price, subjectItem, learnLoc, ClassPicture);
	}
	
}
