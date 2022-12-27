package _02_subLocation.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import _02_subLocation.dao.SubjectDao;
import _02_subLocation.model.SubjectBean;
import _02_subLocation.service.SubjectService;
import tw.hibernatedemo.util.HibernateUtil;

public class SubjectServiceImpl implements SubjectService{
	
	private SessionFactory factory;
	private Session session;
	private SubjectDao sDao;

	public SubjectServiceImpl() {
		factory = HibernateUtil.getSessionFactory();
	}
	
	@Override
	public List<SubjectBean> searchAllSub(){
		return sDao.searchAllSub();
	}

	@Override
	public List<SubjectBean> findById(Integer subjectId){
		return sDao.findById(subjectId);
	}

	@Override
	public List<SubjectBean> findByClass(String subjectClass){
		return findByClass(subjectClass);
	}

	@Override
	public void add(SubjectBean subjectBean) {
		sDao.add(subjectBean);
	}

	@Override
	public void deleteSubfromSubno(Integer subjectId) {
		sDao.deleteSubfromSubno(subjectId);

	}
	
	@Override
	public void updateSubFromSubno(Integer subjectId, String subjectName, String subjectClass) {
		sDao.updateSubFromSubno(subjectId,subjectName,subjectClass);

	}

}
