package _01_member.action;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import _01_member.model.MemberBean;
import _01_member.model.MemberDao;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoSearchAction {
	

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();//開啟交易
			MemberDao md = new MemberDao(session);
			MemberBean member = new MemberBean();
			
			List<MemberBean> sID = md.searchMemByID(5);
			Iterator<MemberBean> it = sID.iterator();
			while (it.hasNext()) {
				MemberBean memberBean = (MemberBean) it.next();
				System.out.println(memberBean.toString());
			}
			
//			member.setAccount("");
//			member.setPassword("123456789");
//			MemberBean mfa = md.updateMemFromAccount(member);
//			System.out.println(mfa.toString());
			
//			MemberBean add = md.add(memberBean);
//			System.out.println(add.toString());
			
//			List<MemberBean> list = md.searchMemByAccountLike("5");
//			Iterator<MemberBean> iterator = list.iterator();
//			while (iterator.hasNext()) {
//				MemberBean memberBean = (MemberBean) iterator.next();
//				System.out.println(memberBean.toString());
//			}
			
			session.getTransaction().commit();//確認交易
		} catch (Exception e) {
			System.out.println("Something Wrong!");
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSessionFactory();
		}
		
		
	}

}
