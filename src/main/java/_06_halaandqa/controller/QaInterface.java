package _06_halaandqa.controller;

import java.util.List;

import _06_halaandqa.model.QaBean;

public interface QaInterface {

	public QaBean insertQa(String qaClassName, Integer memberId, String title, String qaContent);

	public List<QaBean> findQaAll();

	public List<QaBean> selectQa(String qaClassName);

	public boolean deleteQa(Integer qaId);

	public QaBean findQaId(Integer qaId);

	public QaBean updateQa(Integer qaId, String qaClassName, String title, String qaContent);

}
