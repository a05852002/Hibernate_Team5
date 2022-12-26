package _02_subLocation.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import _02_subLocation.dao.LocationDao;
import _02_subLocation.model.LocationBean;



public class LocationDaoImpl implements LocationDao {

	private Session session;

	public LocationDaoImpl(Session session) {
		this.session = session;
	}
	
	@Override
	public List<LocationBean> searchAllLoc(){
		Query<LocationBean> query = session.createQuery("from LocationBean", LocationBean.class);
		List<LocationBean> list = query.getResultList();
		return list;
	}

	@Override
	public List<LocationBean> findById(Integer locno){
		String hql = "from LocationBean where locno = :s";
		Query<LocationBean> query = session.createQuery(hql, LocationBean.class).setParameter("s", locno);
		List<LocationBean> s = query.getResultList();
		return s;
	}

	@Override
	public List<LocationBean> findByClass(String searchAll){
		String hql = "from LocationBean where locno like '%"+searchAll+"%' or locname like :m or locclass like :t";
		Query<LocationBean> query = session.createQuery(hql, LocationBean.class)
				.setParameter("m","%"+searchAll+"%")
				.setParameter("t","%"+searchAll+"%");
		List<LocationBean> list = query.getResultList();
		return list;
	}

	@Override
	public void add(LocationBean locationBean) {
		session.save(locationBean);
	}

	@Override
	public void deleteLocfromLocno(Integer locno) {
		LocationBean locationBean = session.get(LocationBean.class, locno);
		if (locationBean != null) {
			session.delete(locationBean);
		}
	}

	@Override
	public void updateLocFromLocno(Integer subjectId, String subjectName, String subjectClass) {
		LocationBean subjectBean = session.get(LocationBean.class, subjectId);
			if (subjectBean != null) {
				subjectBean.setLocno(subjectId);
				subjectBean.setLocname(subjectName);
				subjectBean.setLocclass(subjectClass);
			}
	}

	
}
