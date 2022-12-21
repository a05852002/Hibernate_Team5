package _01_member.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class MemberDao {
	
	private Session session;

	public MemberDao(Session session) {
		this.session = session;
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
		MemberBean memberCheck = session.get(MemberBean.class, member.getAccount());
		if (memberCheck == null) {
			session.save(member);
			return member;
		}
		return null;
	}
//	依帳號修改
	public MemberBean updateMemFromAccount(MemberBean member) {
		MemberBean memberCheck = session.get(MemberBean.class, member.getAccount());
		if (memberCheck != null) {
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
