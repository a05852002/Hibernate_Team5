package _01_member.model;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class MemberDao {
	
	private Session session;
//
	public MemberDao(Session session) {
		this.session = session;
	}
	public MemberDao() {
	}
	
//	查詢系列
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
	public List<MemberBean> searchMemByAccount(String account){
		String hql = "from MemberBean where account = :account";
		Query<MemberBean> query = session.createQuery(hql,MemberBean.class).setParameter("account", account);
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
	
//	新增
	public MemberBean add(MemberBean member) {
		
		List<MemberBean> memberCheck = searchMemByAccount(member.getAccount());
		
		if (memberCheck.size() == 0) {
			session.save(member);
			return member;
		}
		return null;
	}
//	依帳號修改
	public MemberBean updateMemFromAccount(MemberBean member) {
		List<MemberBean> list = searchMemByAccount(member.getAccount());
		
		if (list.size() != 0) {
			Iterator<MemberBean> it = list.iterator();
			MemberBean link = it.next();
			MemberBean memberCheck = session.get(MemberBean.class, link.getMemberID());
			memberCheck.setAddress(member.getAddress());
			memberCheck.seteMail(member.geteMail());
			memberCheck.setMemName(member.getMemName());
			memberCheck.setMemNickName(member.getMemNickName());
			memberCheck.setPassword(member.getPassword());
			memberCheck.setPhone(member.getPhone());
			return memberCheck;
		}else {
			return null;
		}
	}
//	依ID刪除
	public boolean deleteMemfromMemberID(int memberID) {
		MemberBean member = session.get(MemberBean.class, memberID);
		if (member !=null) {
			session.delete(member);
			return true;
		}else {
			return false;
		}
	}
	
}
