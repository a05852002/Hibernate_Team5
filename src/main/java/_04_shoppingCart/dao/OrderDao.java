package _04_shoppingCart.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import _04_shoppingCart.model.OrderBean;
import tw.hibernatedemo.model.Employee;
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
		orderBean.setTotalAmount();

		session.save(orderBean);
		return orderBean;
	}

//刪除---------------------
	// 透過orderNo刪除
	public boolean deleteOrderNo(Integer orderNo) {
		OrderBean ordBean = session.get(OrderBean.class, orderNo);

		if (ordBean != null) {
			session.delete(ordBean);
			return true;
		}
		return false;
	}

//修改---------------------
	// 透過訂單編號修改訂單資料
	public OrderBean updateOrder(Integer orderNo, String memberId, String shippingAddress, String ordStstus,
			String paymentStstus, String deliveryStstus) {
		String hql = "update OrderBean set memberId = ?1 , upOrderDate =?2, shippingAddress=?3,ordStstus=?4 ,paymentStstus=?5,deliveryStstus=?6 where orderNo = ?7";

		OrderBean orderBean = session.get(OrderBean.class, orderNo);
		if (orderBean != null) {
			session.createQuery(hql) // 更新不用資料型別,select回傳才需要
					.setParameter(1, memberId).setParameter(2, new Date()).setParameter(3, shippingAddress)
					.setParameter(4, ordStstus).setParameter(5, paymentStstus).setParameter(6, deliveryStstus)
					.setParameter(7, orderNo).executeUpdate();
		}
		return orderBean;
	}

//查詢---------------------
	// 搜尋全部訂單資料
	public List<OrderBean> selectAll() {
		Query<OrderBean> query = session.createQuery("from OrderBean", OrderBean.class);
		List<OrderBean> result = query.getResultList();

		return result;
	}

	// 搜尋單一筆訂單orderNo
	public List<OrderBean> searchOrderByONo(Integer orderNo) {
		String hql = "from OrderBean o where o.orderNo = :orderNo";
		Query<OrderBean> query = session.createQuery(hql, OrderBean.class).setParameter("orderNo", orderNo);
		List<OrderBean> resultList = query.getResultList();

		if (resultList.size() > 0) {
			for (OrderBean emp : resultList) {
				System.out.println(emp);
			}
		} else {
			System.out.println("查無此資料");
		}
		return resultList;
	}

	// 模糊搜尋全部
	public List<OrderBean> searchAllorders(String searchAll) {
		String hql = "from OrderBean o where o.orderNo like '%" + searchAll + "%' or o.memberId like :memberId or o.shippingAddress like :shippingAddress";
		Query<OrderBean> query = session.createQuery(hql, OrderBean.class).setParameter("memberId",
				"%" + searchAll + "%").setParameter("shippingAddress",
						"%" + searchAll + "%");
		List<OrderBean> resultList = query.getResultList();

		if (resultList.size() > 0) {
			for (OrderBean emp : resultList) {
				System.out.println(emp);
			}
		} else {
			System.out.println("查無此資料");
		}
		return resultList;
	}

	//
	public void findEmployeeBySalsryAndVaction(Integer salary, Integer vacation) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			String hql = "from Employee where salary > :s and vacation > :v";

			Query<Employee> query = session.createQuery(hql, Employee.class).setParameter("s", salary).setParameter("v",
					vacation);

			List<Employee> resultList = query.getResultList();

			for (Employee emp : resultList) {
				System.out.println(emp);
			}

			session.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("ROOLBACK");
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}

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
