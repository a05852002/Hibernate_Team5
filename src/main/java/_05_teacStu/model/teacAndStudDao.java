package _05_teacStu.model;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class teacAndStudDao {

	private Session session;

	// 依賴注入，Dependency Injection
	public teacAndStudDao(Session session) {
		this.session = session;
	}
	
	//	模糊查詢教師全部
	public List<tableForTeac> searchAllLike(String searchAllLike) {
		String hql = "from tableForTeac where memberId like :m or title like :t or detail like :d or subjectItem like :s";
//		String hql = "from tableForTeac where memberId like :m or title like :t or detail like :d or price like :p or subjectItem like :s";
		Query<tableForTeac> query = session.createQuery(hql, tableForTeac.class)
				.setParameter("m","%"+searchAllLike+"%")
				.setParameter("t","%"+searchAllLike+"%")
				.setParameter("d","%"+searchAllLike+"%")
//				.setParameter("p","%"+searchAllLike+"%")
				.setParameter("s","%"+searchAllLike+"%");
		List<tableForTeac> list = query.getResultList();
		return list;
	}
	
//	模糊查詢教師全部
	public List<tableForTeac> searchAllLike(Integer searchAllLike) {
		String hql = "from tableForTeac where memberId like :m";
//		String hql = "from tableForTeac where memberId like :m or title like :t or detail like :d or price like :p or subjectItem like :s";
		Query<tableForTeac> query = session.createQuery(hql, tableForTeac.class)
				.setParameter("m","%"+searchAllLike+"%");
//				.setParameter("t","%"+searchAllLike+"%")
//				.setParameter("d","%"+searchAllLike+"%")
//				.setParameter("p","%"+searchAllLike+"%")
//				.setParameter("s","%"+searchAllLike+"%");
		List<tableForTeac> list = query.getResultList();
		return list;
	}
	
	//	模糊查詢學生全部
	public List<tableForStud> searchAllLikeStud(String searchAllLike) {
		String hql = "from tableForStud where memberId like :m or title like :t or detail like :d or price like :p or subjectItem like :s or learnLoc like :l";
		Query<tableForStud> query = session.createQuery(hql, tableForStud.class)
				.setParameter("m","%"+searchAllLike+"%")
				.setParameter("t","%"+searchAllLike+"%")
				.setParameter("d","%"+searchAllLike+"%")
				.setParameter("p","%"+searchAllLike+"%")
				.setParameter("s","%"+searchAllLike+"%")
				.setParameter("l","%"+searchAllLike+"%");
		List<tableForStud> list = query.getResultList();
		return list;
	}
	
	// 透過時薪區間建立教師貼文查詢
	public List<tableForTeac> searchTeacByPrice(Integer low, Integer high) {
		boolean wrongside = (low > high);
		boolean lowisnull = (low == null);
		boolean highisnull = (high == null);
		String price = "";
		if (lowisnull && highisnull) {
			price = "";
		} else if (wrongside) {
			price = "";
		} else if (lowisnull) {
			price = " where price <= " + high;
		}else if (highisnull) {
			price = " where price >= " + low;
		}else if (!(lowisnull && highisnull)) {
			price = " where price >= " + low + "and price <=" + high + "";
		}
		String hql = "from tableForTeac" + price;
		Query<tableForTeac> query = session.createQuery(hql, tableForTeac.class);
		List<tableForTeac> list = query.getResultList();
		return list;
	}
	
	// 透過時薪區間建立學生貼文查詢
		public List<tableForStud> searchStudByPrice(Integer low, Integer high) {
			boolean wrongside = (low > high);
			boolean lowisnull = (low == null);
			boolean highisnull = (high == null);
			String price = "";
			if (lowisnull && highisnull) {
				price = "";
			} else if (wrongside) {
				price = "";
			} else if (lowisnull) {
				price = " where price <= " + high;
			}else if (highisnull) {
				price = " where price >= " + low;
			}else if (!(lowisnull && highisnull)) {
				price = " where price >= " + low + "and price <=" + high + "";
			}
			String hql = "from tableForStud" + price;
			Query<tableForStud> query = session.createQuery(hql, tableForStud.class);
			List<tableForStud> list = query.getResultList();
			return list;
		}
	
	//	搜尋全部教師貼文依時薪降序排序
	public List<tableForTeac> searchAllTeacOBprice() {
		Query<tableForTeac> query = session.createQuery("from tableForTeac order by price desc", tableForTeac.class);
		List<tableForTeac> list = query.getResultList();
		return list;
	}
	
	//	搜尋全部學生貼文依時薪降序排序
	public List<tableForStud> searchAllStudOBprice() {
		Query<tableForStud> query = session.createQuery("from tableForStud order by price desc", tableForStud.class);
		List<tableForStud> list = query.getResultList();
		return list;
	}
	
	//	搜尋全部教師貼文依日期降序排序
	public List<tableForTeac> searchAllTeacOBpDate() {
		Query<tableForTeac> query = session.createQuery("from tableForTeac order by postDate desc", tableForTeac.class);
		List<tableForTeac> list = query.getResultList();
		return list;
	}
	
	//	搜尋全部學生貼文依日期降序排序
	public List<tableForStud> searchAllStudOBpDate() {
		Query<tableForStud> query = session.createQuery("from tableForStud order by postDate desc", tableForStud.class);
		List<tableForStud> list = query.getResultList();
		return list;
	}
	
	//	搜尋全部教師貼文依會員編號排序
	public List<tableForTeac> searchAllTeacOBmId() {
		Query<tableForTeac> query = session.createQuery("from tableForTeac order by memberId", tableForTeac.class);
		List<tableForTeac> list = query.getResultList();
		return list;
	}
	
	//	搜尋全部學生貼文依會員編號排序
	public List<tableForStud> searchAllStudOBmId() {
		Query<tableForStud> query = session.createQuery("from tableForStud order by memberId", tableForStud.class);
		List<tableForStud> list = query.getResultList();
		return list;
	}
	
	// 透過貼文編號建立教師貼文查詢
	public tableForTeac searchTeacFromTeacno(Integer teacno) {
		String hql = "from tableForTeac where teacno = :t ";
		Query<tableForTeac> query = session.createQuery(hql, tableForTeac.class).setParameter("t", teacno);
		tableForTeac t = query.getSingleResult();
		return t;
	}

	// 透過貼文編號建立學生貼文查詢
	public tableForStud searchStudFromStudno(Integer studno) {
		String hql = "from tableForStud where studno = :s ";
		Query<tableForStud> query = session.createQuery(hql, tableForStud.class).setParameter("s", studno);
		tableForStud list = query.getSingleResult();
		return list;
	}

	//	搜尋全部教師貼文done
	public List<tableForTeac> searchAllTeac() {
		Query<tableForTeac> query = session.createQuery("from tableForTeac", tableForTeac.class);
		List<tableForTeac> list = query.getResultList();
		return list;
	}

	//  搜尋全部學生貼文
	public List<tableForStud> searchAllStud() {
		Query<tableForStud> query = session.createQuery("from tableForStud", tableForStud.class);
		List<tableForStud> list = query.getResultList();
		return list;
	}

	//	新增教師貼文
	public void addTeac(tableForTeac tableForTeac) {
			session.save(tableForTeac);
	}

	//	新增學生貼文
	public void addStud(tableForStud tableForStud) {
			session.save(tableForStud);
	}

	//	透過ID刪除教師貼文
	public void deleteTeacfromTeacno(Integer teacno) {
		tableForTeac teac = session.get(tableForTeac.class, teacno);
		if (teac != null) {
			session.delete(teac);
		}
	}

	//	透過ID刪除學生貼文
	public void deleteStudfromStudno(Integer studno) {
		tableForStud stud = session.get(tableForStud.class, studno);
		if (stud != null) {
			session.delete(stud);
		}
	}

	//	透過ID修改教師貼文
	public tableForTeac updateTeacFromTeacno(Integer teacno, Integer memberId, String title, Date postDate,
			String detail, Double price, String subjectItem, Blob ClassPicture) {
		tableForTeac teac = session.get(tableForTeac.class, teacno);
		if (teac != null) {
			teac.setMemberId(memberId);
			teac.setTitle(title);
			teac.setPostDate(postDate);
			teac.setDetail(detail);
			teac.setPrice(price);
			teac.setSubjectItem(subjectItem);
			teac.setClassPicture(ClassPicture);
		}
		return teac;
	}

	//	透過ID修改學生貼文
	public tableForStud updateStudFromStudno(Integer studno, Integer memberId, String title, Date postDate,
			String detail, Double price, String subjectItem, String learnLoc, Blob ClassPicture) {
		tableForStud stud = session.get(tableForStud.class, studno);
		if (stud != null) {
			stud.setMemberId(memberId);
			stud.setTitle(title);
			stud.setPostDate(postDate);
			stud.setDetail(detail);
			stud.setPrice(price);
			stud.setSubjectItem(subjectItem);
			stud.setLearnLoc(learnLoc);
			stud.setClassPicture(ClassPicture);
		}
		return stud;
	}
}
