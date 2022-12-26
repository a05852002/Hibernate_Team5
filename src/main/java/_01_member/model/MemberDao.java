package _01_member.model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
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
		String hql = "from MemberBean where memberID like :ID";
		Query<MemberBean> query = session.createQuery(hql,MemberBean.class)
				.setParameter("ID",memID);
		return query.getResultList();		
	}
	public List<MemberBean> searchAllMember(){
		Query<MemberBean> query = session.createQuery("from MemberBean", MemberBean.class);
		List<MemberBean> list = query.getResultList();
		return list;
	}
	
//	新增
	public MemberBean add(String account,String password,String idNumber,
			String memName, String memNickName, int memOld, String memBirth, String memGender,
			String eMail, int phone, String address) {
		MemberBean member = new MemberBean();
		member.setAccount(account);
		member.setAddress(address);
		member.seteMail(eMail);
		member.setIdNumber(idNumber);
		member.setMemBirth(memBirth);
		member.setMemGender(memGender);
		member.setMemName(memName);
		member.setMemNickName(memNickName);
		member.setMemOld(memOld);
		member.setPassword(password);
		member.setPhone(phone);
		member.setRegistime(new Date());
		session.save(member);
		return member;
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
	
	public void updatePhotoFromAccount(String account, InputStream is) throws SQLException, IOException {
//		String hql = "update MemberBean set photo = :photo where account= :account ";
		List<MemberBean> list = searchMemByAccount(account);
		System.out.println(is);
		if (list.size() != 0) {
//			Query query = session.createQuery(hql)
//					.setParameter("photo", is)
//					.setParameter("account", account);
//			query.executeUpdate();
			Iterator<MemberBean> it = list.iterator();
			MemberBean link = it.next();
			MemberBean memberCheck = session.get(MemberBean.class, link.getMemberID());
			System.out.println(is);
			memberCheck.setPhoto(Hibernate.getLobCreator(session).createBlob(is,is.available()));
		}
			
	}
//	透過ID輸出大頭照
	public Blob ShowPhoto(String account) throws SQLException {
//		Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Team5DB;TrustServerCertificate=True", "sa", "sa123456");
//		String sql = "select photo from Member where account = ?";
//		PreparedStatement pre = conn.prepareStatement(sql);
//		pre.setString(1, ID);
//		ResultSet rs = pre.executeQuery();
//		rs.next();
//		Blob blob = rs.getBlob(1);
		List<MemberBean> member = searchMemByAccount(account);
		Iterator<MemberBean> it = member.iterator();
		Blob image = null;
		while (it.hasNext()) {
			MemberBean memberBean = (MemberBean) it.next();
			image = memberBean.getPhoto();
		}
		
		return image;
	}
	
}
