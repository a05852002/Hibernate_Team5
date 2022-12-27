package _06_halaandqa.controller;

import java.util.List;

import _06_halaandqa.model.HalaBean;

public interface HalaInterface {
	
	public HalaBean insertHala(String halaClassName, Integer memberId, String title, String halaContent);
	
	public List<HalaBean> findHalaAll();
	
	public List<HalaBean> selectHala(String halaClassName) ;
	
	public boolean deleteHala(Integer halaId) ;
	
	public HalaBean findHalaId(Integer halaId);
	
	public HalaBean updateHala(Integer halaId, String halaClassName, String title, String halaContent) ;

}
