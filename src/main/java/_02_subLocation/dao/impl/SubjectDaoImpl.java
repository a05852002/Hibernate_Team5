package _02_subLocation.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import _02_subLocation.dao.SubjectDao;
import _02_subLocation.model.SubjectBean;


public class SubjectDaoImpl implements SubjectDao {

	private Session session;

	public SubjectDaoImpl(Session session) {
		this.session = session;
	}
	
	@Override
	public List<SubjectBean> searchAllSub(){
		Query<SubjectBean> query = session.createQuery("from SubjectBean", SubjectBean.class);
		List<SubjectBean> list = query.getResultList();
		return list;
	}

	@Override
	public List<SubjectBean> findById(Integer subjectId){
		String hql = "from SubjectBean where subjectId = :s ";
		Query<SubjectBean> query = session.createQuery(hql, SubjectBean.class).setParameter("s", subjectId);
		List<SubjectBean> s = query.getResultList();
		return s;
	}

	@Override
	public List<SubjectBean> findByClass(String searchAll){
		String hql = "from SubjectBean where subjectId like '%"+searchAll+"%' or subjectname like :m or subjectclass like :t";
		Query<SubjectBean> query = session.createQuery(hql, SubjectBean.class)
				.setParameter("m","%"+searchAll+"%")
				.setParameter("t","%"+searchAll+"%");
		List<SubjectBean> list = query.getResultList();
		return list;
	}

	@Override
	public void add(SubjectBean subjectBean) {
		session.save(subjectBean);
	}

	@Override
	public void deleteSubfromSubno(Integer subjectId) {
		SubjectBean subjectBean = session.get(SubjectBean.class, subjectId);
		if (subjectBean != null) {
			session.delete(subjectBean);
		}
	}

	@Override
	public void updateSubFromSubno(Integer subjectId, String subjectName, String subjectClass) {
		SubjectBean subjectBean = session.get(SubjectBean.class, subjectId);
			if (subjectBean != null) {
				subjectBean.setSubjectId(subjectId);
				subjectBean.setSubjectName(subjectName);
				subjectBean.setSubjectClass(subjectClass);
			}
	}
}
