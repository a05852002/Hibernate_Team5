package _04_shoppingCart.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import _04_shoppingCart.model.OrderBean;
import tw.hibernatedemo.model.CompanyBean;
import tw.hibernatedemo.util.HibernateUtil;

public class OrderDao {

	private Session session;

	// 依賴注入 Dependency.Injextion
	public OrderDao(Session session) {
		this.session = session;
	}

//新增---------------------
//	新增一筆訂單
	public OrderBean insertOrder(String memberId, String shippingAddress) {
		OrderBean orderBean = new OrderBean();
		orderBean.setMemberId(memberId);
		orderBean.setShippingAddress(shippingAddress);
		orderBean.setOrderDate(new Date());
		orderBean.setUpOrderDate(new Date());
		
		session.save(orderBean);
		return orderBean;
	}

//刪除---------------------
	//透過orderNo刪除
	public boolean deleteOrderNo(Integer orderNo) {
		OrderBean ordBean = session.get(OrderBean.class, orderNo);

		if (ordBean != null) {
			session.delete(ordBean);
			return true;
		}
		return false;
	}
	
//修改---------------------

	
//查詢---------------------
	//搜尋全部訂單資料
	public List<OrderBean> selectAll(){
    	Query<OrderBean> query = session.createQuery("from OrderBean", OrderBean.class);
    	List<OrderBean> result = query.getResultList();
    	
    	return result;
    }
	
	//搜尋單一orderNo
	
	
	
	//模糊搜尋全部
	
	//
	
	
////	找一筆訂單
//	public OrderBean findByOrderNo(Integer orderNo) {
//
//		String hql = "from OrderBean o where o.orderNo = :orderNo";
//
//		Session session = factory.getCurrentSession();
//		
//		try {
//			OrderBean result = session.createQuery(hql, OrderBean.class)
//					.setParameter("orderNo", orderNo)
//					.getSingleResult();
//			
//			return result;
//		} catch (NoResultException|NonUniqueResultException e) {
//			return null;
//		}
//
//	}
//	
//
//	
//	//查詢-------------------------
//////	搜尋全部
//	public List<OrderBean> searchAllorders() throws SQLException {
//		String sql = "select * from orders order by orderNo";
//		List<OrderBean> list = queryRunner.query(sql, new BeanListHandler<OrderBean>(OrderBean.class));
//		for (OrderBean o : list) {
//			System.out.println(o);
//		}
//		return list;
//		
//	}
//	
//////搜尋單一orderNo
//public List<OrderBean> searchOrdersbyNo(Integer orderNo) throws SQLException {
//	String sql = "select * from orders where orderNo=? ";
//	List<OrderBean> list = queryRunner.query(sql, new BeanListHandler<OrderBean>(OrderBean.class),orderNo);
//	for (OrderBean o : list) {
//		System.out.println(o);
//	}
//	return list;
//	
//}
//
////	透過會員編號建立查詢
//	public void searchProdFromType(Integer OrderBeanClass) throws SQLException {
//		String sql = "select  * from Orders where prodClass=? order by orderNo";
//
//		List<OrderBean> list = queryRunner.query(sql, new BeanListHandler<OrderBean>(OrderBean.class), OrderBeanClass);
//		int count = queryRunner.query(sql, new ScalarHandler<Integer>(), OrderBeanClass);
//		System.out.printf("搜尋到了%d筆資料", count);
//		if (count > 0) {
//			System.out.println("查詢結果 : ");
//			for (OrderBean o : list) {
//				System.out.println(o);
//			}
//		}
//
//	}
//	
//
////	透過會員編號建立模糊查詢
//	public List<OrderBean> searchMemberIdLike(String SearchMemberId) throws SQLException {
//		String sql = "select  * from orders where memberId like ? order by orderNo";
//		String sql1 = "select * from orders where  memberId like ? order by orderNo";
//
//		List<OrderBean> list = queryRunner.query(sql, new BeanListHandler<OrderBean>(OrderBean.class),
//				"%" + SearchMemberId + "%");
//		int count = queryRunner.query(sql1, new ScalarHandler<Integer>(), "%" + SearchMemberId + "%");
//		System.out.printf("搜尋到了%d筆資料", count);
//		if (count > 0) {
//			System.out.println("查詢結果 : ");
//			for (OrderBean o : list) {
//				System.out.println(o);
//			}
//		}
//		return list;
//	}
////	透過訂單編號建立模糊查詢
//	public List<OrderBean> searchOrderNoLike(int SearchOrderNo) throws SQLException {
//		String sql = "select  * from orders where orderNo like ? order by orderNo";
//		String sql1 = "select * from orders where  orderNo like ? order by orderNo";
//
//		List<OrderBean> list = queryRunner.query(sql, new BeanListHandler<OrderBean>(OrderBean.class),
//				"%" + SearchOrderNo + "%");
//		int count = queryRunner.query(sql1, new ScalarHandler<Integer>(),  SearchOrderNo );
//		System.out.printf("搜尋到了%d筆資料", count);
//		if (count > 0) {
//			System.out.println("查詢結果 : ");
//			for (OrderBean o : list) {
//				System.out.println(o);
//			}
//		}
//		return list;
//	}
//
////	透過會員地址建立模糊查詢
//	public List<OrderBean> searchAddLike(String searchAddLike) throws SQLException {
//		String sql = "select  * from orders where shippingAddress like ? order by orderNo";
//		String sql1 = "select * from orders where  shippingAddress like ? order by orderNo";
//
//		List<OrderBean> list = queryRunner.query(sql, new BeanListHandler<OrderBean>(OrderBean.class),
//				"%" + searchAddLike + "%");
//		System.out.println(list);
//		int count = queryRunner.query(sql1, new ScalarHandler<Integer>(), "%" + searchAddLike + "%");
//		System.out.printf("搜尋到了%d筆資料", count);
//		if (count > 0) {
//			System.out.println("查詢結果 : ");
//			for (OrderBean o : list) {
//				System.out.println(o);
//			}
//		}
//		return list;
//	}
//	
//	
////	模糊查詢全部
//	public List<OrderBean> searchAllLike(String searchAllLike) throws SQLException {
//		String sql = "select  * from orders where orderNo like ? or memberId like ? or shippingAddress like ? order by orderNo,memberId,shippingAddress";
//		String sql1 = "select * from orders where orderNo like ? or memberId like ? or shippingAddress like ? order by orderNo,memberId,shippingAddress";
//
//		List<OrderBean> list = queryRunner.query(sql, new BeanListHandler<OrderBean>(OrderBean.class),"%" + searchAllLike  + "%",
//				"%" + searchAllLike + "%","%" + searchAllLike + "%");
//		System.out.println(list);
//		int count = queryRunner.query(sql1, new ScalarHandler<Integer>(),"%" + searchAllLike + "%", "%" + searchAllLike + "%","%" + searchAllLike + "%");
//		System.out.printf("搜尋到了%d筆資料", count);
//		if (count > 0) {
//			System.out.println("查詢結果 : ");
//			for (OrderBean o : list) {
//				System.out.println(o);
//			}
//		}
//		return list;
//	}
//
//	
//	
//	//刪除-------------------------
////	透過訂單編號刪除
//	public void deleteOrderNo(Integer orderNo) throws SQLException {
//		String sql = "delete from orderItem where orderNo = ?";
//		String sql1 = "delete from orders where orderNo = ?";
//		int row = queryRunner.update(sql, orderNo);
//		int row1 = queryRunner.update(sql1, orderNo);
//		if (row > 0) {
//			System.out.println("成功刪除了" + row + "筆資料");
//		} else {
//			System.out.println("刪除失敗->\"沒有對應的產品編號\"");
//		}
//		if (row1 > 0) {
//			System.out.println("成功刪除了" + row + "筆資料");
//		} else {
//			System.out.println("刪除失敗->\"沒有對應的產品編號\"");
//		}
//	}
//	
//
//	
//	//修改-------------------------
////	修改
//	public void updateOrderFromOrderNo(Integer orderNo,String memberId, Date upOrderDate,String shippingAddress, Double totalAmount) throws SQLException {
//		String sql = "update orders set memberId=?,orderDate=?,upOrderDate=?,shippingAddress=?,totalAmount=? where orderNo= ?";
//		String sql1 = "select * from orders where orderNo=?";
//		OrderBean o = queryRunner.query(sql1, new BeanHandler<OrderBean>(OrderBean.class),orderNo);
//		Date orderDate = o.getOrderDate();
//		Object[] params = { memberId,orderDate, upOrderDate, shippingAddress, totalAmount,orderNo };
//		int row = queryRunner.update(sql,params);
//		if (row > 0) {
//			System.out.println("已成功修改了" + row + "筆資料");
//			System.out.printf("產品編號 :\" %d \"的修改結果為 : %s", orderNo, o);
//		}
//
//	}


}
