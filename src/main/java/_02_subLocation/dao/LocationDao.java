package _02_subLocation.dao;

import java.util.List;

import _02_subLocation.model.LocationBean;


public interface LocationDao {

	public List<LocationBean> searchAllLoc();

	public List<LocationBean> findById(Integer locno);

	public List<LocationBean> findByClass(String locclass);

	public void add(LocationBean locationBean);

	public void deleteLocfromLocno(Integer locno);

	public void updateLocFromLocno(Integer locno, String locname, String locclass);

}
