package _06_halaandqa.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.util.HibernateUtil;

public class RunDaoHala {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			HalaDao hd = new HalaDao(session);
			//新增
     //		hd.addHala("公告", 5998, "標題4", "內容4" );
			
			//修改
			//hd.updatHala(1,"心得","標題1" ,"內容1");
			
			//查詢全部
//			 List<HalaBean> result =hd.findAllHala();
//			for(HalaBean hb:result) {
//				System.out.println(hb);
//			}
			
		    //分類查詢
			hd.findByClassName("公告");
			
			//刪除
//			hd.deleteHala(6);
			//id查詢
//			HalaBean hb= hd.findByHalaId(1);

//			System.out.println(hb.getHalaId()+hb.getHalaClassName()+hb.getTitle());
			

				
				
				
				
			session.getTransaction().commit();
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			
		}


	}


}
