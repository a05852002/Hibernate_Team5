package _06_halaandqa.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.util.HibernateUtil;

public class RunQaDao {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
//			session.beginTransaction();
//			QaDao qd = new QaDao(session);
			//新增
//     		qd.addQa("QQQ", 5998, "標題6", "內容6" );
			
			//修改
//			qd.updatQa(1,"HTML","標題6" ,"內容6");
			
			//查詢全部
//			 List<QaBean> result =qd.findAllQa();
//			for(QaBean qb:result) {
//				System.out.println(qb);
//			}
			
		    //分類查詢
//			qd.findByQaClassName("java");
			
			//刪除
//			qd.deleteQa(6);
			
			

				
				
				
				
			session.getTransaction().commit();
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			
		}


	}


}
