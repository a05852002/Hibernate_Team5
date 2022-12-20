package _01_member.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class MemberDao {
	
	private Session session;

	public MemberDao(Session session) {
		this.session = session;
	}
	
	
	
	public List<MemberBean> searchMemByNameLike(String name){
		String hql = "from MemberBean where memname like :name";
		Query<MemberBean> query = session.createQuery(hql,MemberBean.class).setParameter("name", "%"+name+"%");
		return query.getResultList();		
	}
	public List<MemberBean> searchMemByAccountLike(String account){
		String hql = "from MemberBean where account like :account";
		Query<MemberBean> query = session.createQuery(hql,MemberBean.class).setParameter("account", "%"+account+"%");
		return query.getResultList();		
	}
	public List<MemberBean> searchMemByID(int memID){
		String hql = "from MemberBean where memberID = :ID";
		Query<MemberBean> query = session.createQuery(hql,MemberBean.class)
				.setParameter("ID", memID);
		return query.getResultList();		
	}

	public List<MemberBean> searchAllMember(){
		Query<MemberBean> query = session.createQuery("from MemberBean", MemberBean.class);
		List<MemberBean> list = query.getResultList();
		return list;
	}
	
}
