package _06_halaandqa.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class QaDao {
	private Session session;

	public QaDao(Session session) {
		this.session = session;
	}

	public String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		return sdf.format(date);
	}

	// 新增
	public QaBean addQa(String qaClassName, Integer memberId, String title, String qaContent) {

		QaBean qb = new QaBean();
		qb.setQaClassName(qaClassName);
		qb.setMemberId(memberId);
		qb.setTitle(title);
		qb.setPostDate(getCurrentDate());
		qb.setQaContent(qaContent);
		session.save(qb);
		return qb;
	}

	// 修改
	public QaBean updatQa(Integer qaId, String qaClassName, String title, String qaContent) {
		QaBean qb = session.get(QaBean.class, qaId);
		if (qb != null) {
			qb.setQaClassName(qaClassName);
			qb.setTitle(title);
			qb.setPostDate(getCurrentDate());
			qb.setQaContent(qaContent);
		}
		return qb;
	}

	// 查詢全部
	public List<QaBean> findAllQa() {
		Query<QaBean> query = session.createQuery("from QaBean", QaBean.class);
		List<QaBean> result = query.getResultList();
		return result;
	}

	// 分類查詢
	public List<QaBean> findByQaClassName(String qaClassName) {
		Query<QaBean> query = session.createQuery("from QaBean where qaClassName = ?1", QaBean.class)
				.setParameter(1, qaClassName);
		List<QaBean> result = query.getResultList();
		for (QaBean qb : result) {
			System.out.println(qb);
		}
		return result;
	}
	
	//刪除
	public boolean deleteQa(Integer qaId) {
		QaBean qb =session.get(QaBean.class, qaId);
		if(qb != null) {
			session.delete(qb);
			return true;
		}
		return false;
		
	}
	public QaBean findByQaId(Integer id) {
		return session.get(QaBean.class,id);
	}

}

