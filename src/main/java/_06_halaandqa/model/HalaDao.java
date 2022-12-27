package _06_halaandqa.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;


public class HalaDao {

	private Session session;

	public HalaDao(Session session) {
		this.session = session;
	}

	public String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		return sdf.format(date);
	}

	// 新增
	public HalaBean addHala(String halaClassName, Integer memberId, String title, String halaContent) {

		HalaBean hb = new HalaBean();
		hb.setHalaClassName(halaClassName);
		hb.setMemberId(memberId);
		hb.setTitle(title);
		hb.setPostDate(getCurrentDate());
		hb.setHalaContent(halaContent);
		session.save(hb);
		return hb;
	}

	// 修改
	public HalaBean updatHala(Integer halaId, String halaClassName, String title, String halaContent) {
		HalaBean hb = session.get(HalaBean.class, halaId);
		if (hb != null) {
			hb.setHalaClassName(halaClassName);
			hb.setTitle(title);
			hb.setPostDate(getCurrentDate());
			hb.setHalaContent(halaContent);
		}
		return hb;
	}

	// 查詢全部
	public List<HalaBean> findAllHala() {
		Query<HalaBean> query = session.createQuery("from HalaBean", HalaBean.class);
		List<HalaBean> result = query.getResultList();
		return result;
	}

	// 分類查詢
	public List<HalaBean> findByClassName(String halaClassName) {
		Query<HalaBean> query = session.createQuery("from HalaBean where HalaClassName = ?1", HalaBean.class)
				.setParameter(1, halaClassName);
		List<HalaBean> result = query.getResultList();
		for (HalaBean hb : result) {
			System.out.println(hb);
		}
		return result;
	}
	
	//刪除
	public boolean deleteHala(Integer halaId) {
		HalaBean hb =session.get(HalaBean.class, halaId);
		if(hb != null) {
			session.delete(hb);
			return true;
		}
		return false;
		
	}
	
	public HalaBean findByHalaId(Integer id) {
		return session.get(HalaBean.class,id);
	}
}
