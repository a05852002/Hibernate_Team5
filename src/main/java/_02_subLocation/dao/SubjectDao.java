package _02_subLocation.dao;

import java.util.List;

import _02_subLocation.model.SubjectBean;

public interface SubjectDao {

	public List<SubjectBean> searchAllSub();

	public List<SubjectBean> findById(Integer subjectId);

	public List<SubjectBean> findByClass(String subjectClass);

	public void add(SubjectBean subjectBean);

	public void deleteSubfromSubno(Integer subjectId);

	public void updateSubFromSubno(Integer subjectId, String subjectName, String subjectClass);

}
