package _04_shoppingCart.dao;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;

import _04_shoppingCart.model.OrderBean;
import _04_shoppingCart.model.OrderItemBean;

public class OrderItemDao {

	private Session session;

	// 依賴注入 Dependency.Injextion
	public OrderItemDao(Session session) {
		this.session = session;
	}

// 新增------------------
	// 新增一筆訂單 沒有折扣
	public OrderItemBean insertOrder(String prodId, String prodName, int qty, Integer prodPrice, Double discount,
			String remark) {
		OrderItemBean orderItemBean = new OrderItemBean();
		orderItemBean.setProdId(prodId);
		orderItemBean.setProdName(prodName);
		orderItemBean.setQty(qty);
		orderItemBean.setDiscount(discount);
		orderItemBean.setProdPrice(prodPrice);
		orderItemBean.setItemTotal(Integer.parseInt(String.valueOf(Math.round(qty * prodPrice * discount))));
		orderItemBean.setRemark(remark);

		return orderItemBean;
	}

//刪除---------------------
	// 透過orderNo刪除
	public boolean deleteOrderItem(Integer orderNo, Integer seqno) {

		OrderBean orderBean = session.get(OrderBean.class, orderNo);
		Set<OrderItemBean> items = orderBean.getItems();

		Iterator<OrderItemBean> it = items.iterator();
		while (it.hasNext()) {
			OrderItemBean ordItem = it.next();
			if (ordItem.getSeqno() == seqno) {
				items.remove(ordItem);
				session.delete(ordItem);
				return true;
			}
		}
		return false;
	}

//修改---------------------
	// 修改---------------------
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
	// 搜尋全部訂單明細資料
	public Set<OrderItemBean> selectAllOrdItem(Integer orderNo) {
		OrderBean orderBean = session.get(OrderBean.class, orderNo);
		Set<OrderItemBean> items = orderBean.getItems();
		return items;
	}

	public List<OrderItemBean> searchOrderItemByOrderNo(Integer orderNo) {

		String hql = "from OrderItemBean o where o.orderbean = :orderNo";
		Query<OrderItemBean> query = session.createQuery(hql, OrderItemBean.class).setParameter("orderNo", orderNo);
		List<OrderItemBean> resultList = query.getResultList();

		return resultList;

	}

	// 搜尋全部訂單明細資料
	public List<OrderItemBean> selectOrdbySeq(Integer seqno) {
		String hql = "From OrberItemBean where o.seqno = :seqno";
		Query<OrderItemBean> query = session.createQuery(hql, OrderItemBean.class).setParameter("seqno", seqno);
		List<OrderItemBean> resultList = query.getResultList();

		if (resultList.size() > 0) {
			for (OrderItemBean emp : resultList) {
				System.out.println(emp);
			}
		} else {
			System.out.println("查無此資料");
		}
		return resultList;
	}

	

	// 搜尋orderNo
	public OrderItemBean selectOneOrdItem(Integer orderNo) {
		OrderBean orderBean = session.get(OrderBean.class, orderNo);
		Set<OrderItemBean> items = orderBean.getItems();
		Iterator<OrderItemBean> it = items.iterator();
		OrderItemBean order = it.next();
		return order;
	}

	// 搜尋訂單的某個Item

	//

////	新增一筆訂單
//	public void insertItem(int orderNo, String productId, String productName, String description, int qty,
//			Double unitPrice) throws SQLException {
//
//		String sql = "insert into orderItem values(?,?,?,?,?,?,?,?)";
//		String sql1 = "select count(*) from orderItem where orderNo=? ";
//		int row1 = queryRunner.query(sql1, new ScalarHandler<Integer>(), orderNo);
//		System.out.println(row1);
//		if (row1 > 0) {
//			String sql2 = "select Top 1 seqNo from orderItem where orderNo=? order by seqNo DESC";
//			int row2 = queryRunner.query(sql2, new ScalarHandler<Integer>(), orderNo);
//			Object[] params = { orderNo, row2 + 1, productId, productName, description, qty, unitPrice,
//					Double.valueOf(qty * unitPrice) };
//			int row = queryRunner.update(sql, params);
//			System.out.println("新增了" + row + "筆資料");
//
//			// 更新order金額
//			String sqlTotal = "select totalAmount from orders where orderNo=?";
//			OrderBean o = queryRunner.query(sqlTotal, new BeanHandler<OrderBean>(OrderBean.class), orderNo);
//			Double totalAmount = o.getTotalAmount();
//			System.out.println(totalAmount);
//			String sqlOrder = "update orders set totalAmount=? where orderNo=?";
//			Object[] paramsOrder = { totalAmount + Double.valueOf(qty * unitPrice), orderNo };
//			queryRunner.update(sqlOrder, paramsOrder);
//			// 更新訂單的修改日期
//			Date dt = new Date();
//			String sqlOrder1 = "update orders set upOrderDate=? where orderNo=?";
//			Object[] paramsOrder1 = { dt, orderNo };
//			queryRunner.update(sqlOrder1, paramsOrder1);
//
//		} else {
//			Object[] params = { orderNo, row1 + 1, productId, productName, description, qty, unitPrice,
//					Double.valueOf(qty * unitPrice) };
//
//			int row = queryRunner.update(sql, params);
//			System.out.println("新增了" + row + "筆資料");
//
//			// 更新order金額
//			String sqlTotal = "select totalAmount from orders where orderNo=?";
//			OrderBean o = queryRunner.query(sqlTotal, new BeanHandler<OrderBean>(OrderBean.class), orderNo);
//			Double totalAmount = o.getTotalAmount();
//			System.out.println(totalAmount);
//			String sqlOrder = "update orders set totalAmount=? where orderNo=?";
//			Object[] paramsOrder = { totalAmount + Double.valueOf(qty * unitPrice), orderNo };
//			queryRunner.update(sqlOrder, paramsOrder);
//			// 更新訂單的修改日期
//			Date dt = new Date();
//			String sqlOrder1 = "update orders set upOrderDate=? where orderNo=?";
//			Object[] paramsOrder1 = { dt, orderNo };
//			queryRunner.update(sqlOrder1, paramsOrder1);
//
//		}
//		// 或是直接 queryRunner.update(sql,params); 就好
//	}
//
////	Double.valueOf(qty*unitPrice)
//
//	// 搜尋------------------
////	搜尋某訂單全部Item
//	public List<OrderItemBean> searchOrderItemByOrderNo(int orderNo) throws SQLException {
//		String sql = "select * from orderItem where orderNo=? Order BY seqNo";
//		List<OrderItemBean> list = queryRunner.query(sql, new BeanListHandler<OrderItemBean>(OrderItemBean.class),
//				orderNo);
//		for (OrderItemBean o : list) {
//			System.out.println(o);
//		}
//		return list;
//
//	}
//	
////	搜尋某訂單的OrderNo
//
//	public List<OrderItemBean> searchOrderNoByOrderNo(int orderNo) throws SQLException {
//		String sql = "select TOP 1 * from orderItem where orderNo=? Order BY seqNo";
//		List<OrderItemBean> list = queryRunner.query(sql, new BeanListHandler<OrderItemBean>(OrderItemBean.class),
//				orderNo);
//		for (OrderItemBean o : list) {
//			System.out.println(o);
//		}
//		return list;
//	}
//
////	搜尋某訂單的Seqno 的OrderNo
//	public List<OrderItemBean> searchSeqnoByOrderNo(int seqno) throws SQLException {
//		String sql = "select * from orderItem where seqno=?";
//		List<OrderItemBean> list = queryRunner.query(sql, new BeanListHandler<OrderItemBean>(OrderItemBean.class),
//				seqno);
//		for (OrderItemBean o : list) {
//			System.out.println("搜尋某訂單的Seqno "+o);
//		}
//		return list;
//	}
////	搜尋某訂單項目的資料
//	public List<OrderItemBean> searchItem(int orderNo,int seqno) throws SQLException {
//		String sql = "select * from orderItem where orderNo=? and seqno=?";
//		List<OrderItemBean> list = queryRunner.query(sql, new BeanListHandler<OrderItemBean>(OrderItemBean.class),orderNo,
//				seqno);
//		for (OrderItemBean o : list) {
//			System.out.println("搜尋某訂單的Seqno "+o);
//		}
//		return list;
//	}
//	
////	透過會員編號建立明確查詢
//	public void searchOrderItemByMemberId(String memberId) throws SQLException {
//		String sql = "select * from orderItem join orders ON orderItem.orderNo=orders.orderNo where memberId ? Order BY orderNo,seqNo";
//
//		List<OrderItemBean> list = queryRunner.query(sql, new BeanListHandler<OrderItemBean>(OrderItemBean.class),
//				memberId);
//		int count = queryRunner.query(sql, new ScalarHandler<Integer>(), memberId);
//		System.out.printf("搜尋到了%d筆資料", count);
//		if (count > 0) {
//			System.out.println("查詢結果 : ");
//			for (OrderItemBean o : list) {
//				System.out.println(o);
//			}
//		}
//
//	}
//
////	透過產品編號建立查詢
//	public List<OrderItemBean> searchOrderItemByProductId(String productId) throws SQLException {
//		String sql = "select * from orderItem where productId=? Order BY orderNo";
//		String sql1 = "select count(*) from orderItem where productId=? Order BY orderNo";
//
//		List<OrderItemBean> list = queryRunner.query(sql, new BeanListHandler<OrderItemBean>(OrderItemBean.class),
//				"%" + productId + "%");
//		int count = queryRunner.query(sql1, new ScalarHandler<Integer>(), "%" + productId + "%");
//		System.out.printf("搜尋到了%d筆資料", count);
//		if (count > 0) {
//			System.out.println("查詢結果 : ");
//			for (OrderItemBean o : list) {
//				System.out.println(o);
//			}
//		}
//		return list;
//	}
//
////	找尋單價區間的item
//	public List<OrderItemBean> searchOrderItemByunitPrice(Double Price1, Double Price2) throws SQLException {
//		String sql = "select  * from orderItem where unitPrice BETWEEN ? AND ? Order BY seqno";
//		String sql1 = "select  * from orderItem where unitPrice BETWEEN ? AND ? Order BY seqno";
//
//		List<OrderItemBean> list = queryRunner.query(sql, new BeanListHandler<OrderItemBean>(OrderItemBean.class),
//				Price1, Price2);
//		int count = queryRunner.query(sql1, new ScalarHandler<Integer>(), Price1, Price2);
//		System.out.printf("搜尋到了%d筆資料", count);
//		if (count > 0) {
//			System.out.println("查詢結果 : ");
//			for (OrderItemBean o : list) {
//				System.out.println(o);
//			}
//		}
//		return list;
//	}
//
//	// private Integer seqNo; //序號
//	// private Integer orderNo; //訂單編號
//	// private Integer productId; //商品編號
//	// private String productName; //商品名稱
//	// private String description; //描述
//	// private Integer qty; //數量
//	// private Double unitPrice; //單價
//	// private Double itemTotal; //總金額
//	//
//
////	找尋商品編號 商品 描述的模糊搜尋
//	public List<OrderItemBean> searchOrderItemLike(String search) throws SQLException {
//		String sql = "select  * from orderItem where productId=? or productName=? or description=? ";
//		String sql1 = "select  * from orderItem where productId=? or productName=? or description=? ";
//
//		List<OrderItemBean> list = queryRunner.query(sql, new BeanListHandler<OrderItemBean>(OrderItemBean.class),
//				search);
//		int count = queryRunner.query(sql1, new ScalarHandler<Integer>(), search);
//		System.out.printf("搜尋到了%d筆資料", count);
//		if (count > 0) {
//			System.out.println("查詢結果 : ");
//			for (OrderItemBean o : list) {
//				System.out.println(o);
//			}
//		}
//		return list;
//	}
//
//	// 刪除------------------
////	透過訂單項目編號刪除
//	public void deleteOrderItemNo(int orderNo, int seqNo) throws SQLException {
//		// 找出原本的品項的總金額
//		String sqlItemtotal = "select itemTotal from orderItem where orderNo=? and seqno=?";
//		OrderItemBean order = queryRunner.query(sqlItemtotal, new BeanHandler<OrderItemBean>(OrderItemBean.class),
//				orderNo,seqNo);
//		Double itemTotal = order.getItemTotal();
//		
//		//刪除訂單項目
//		String sql = "delete from orderItem where orderNo = ? and seqNo = ? ";
//		int row = queryRunner.update(sql, orderNo, seqNo);
//		
//		// 更新order金額
//		String sqlTotal = "select totalAmount from orders where orderNo=?";
//		OrderBean order1 = queryRunner.query(sqlTotal, new BeanHandler<OrderBean>(OrderBean.class), orderNo);
//		Double totalAmount = order1.getTotalAmount();
//		System.out.println(totalAmount);
//		String sqlOrder = "update orders set totalAmount=? where orderNo=?";
//		Object[] paramsOrder = { totalAmount - itemTotal, orderNo };
//		queryRunner.update(sqlOrder, paramsOrder);
//
//		// 更新訂單的修改日期
//		Date dt = new Date();
//		String sqlOrder1 = "update orders set upOrderDate=? where orderNo=?";
//		Object[] paramsOrder1 = { dt, orderNo };
//		queryRunner.update(sqlOrder1, paramsOrder1);
//		if (row > 0) {
//			System.out.println("成功刪除了" + row + "筆資料");
//		} else {
//			System.out.println("刪除失敗->\"沒有對應的產品編號\"");
//		}
//	}
//
//
////	修改
//	public void updateOrderFromOrderNo( Integer seqno, String description, Integer qty,
//			Double unitPrice) throws SQLException {
//		//找出orderNo
//		String sqlOrderNo = "select TOP 1 * from orderItem where seqno=?";
//		List<OrderItemBean> classList = queryRunner.query(sqlOrderNo, new BeanListHandler<OrderItemBean>(OrderItemBean.class),
//				seqno);
//		Integer orderNo = classList.get(0).getOrderNo();
//		
//		// 找出原本的品項的總金額
//		String sqlItemtotal = "select itemTotal from orderItem where orderNo=? and seqno=?";
//		OrderItemBean order = queryRunner.query(sqlItemtotal, new BeanHandler<OrderItemBean>(OrderItemBean.class),
//				orderNo,seqno);
//		Double itemTotal = order.getItemTotal();
//
//		// 更新價格
//		String sql = "update orderItem set description=?, qty=?,unitPrice=?,itemtotal=? where orderNo= ? and seqno= ?";
//		Object[] params = { description, qty, unitPrice, Double.valueOf(qty * unitPrice), orderNo, seqno };
//		int row = queryRunner.update(sql, params);
//		String sql1 = "select * from orderItem where orderNo=? and seqno= ?";
//		OrderItemBean o = queryRunner.query(sql1, new BeanHandler<OrderItemBean>(OrderItemBean.class), orderNo, seqno);
//		Double itemTotal2 = o.getItemTotal();
//
//		// 更新order金額
//		String sqlTotal = "select totalAmount from orders where orderNo=?";
//		OrderBean order1 = queryRunner.query(sqlTotal, new BeanHandler<OrderBean>(OrderBean.class), orderNo);
//		Double totalAmount = order1.getTotalAmount();
//		System.out.println(totalAmount);
//		String sqlOrder = "update orders set totalAmount=? where orderNo=?";
//		Object[] paramsOrder = { totalAmount - itemTotal + itemTotal2, orderNo };
//		queryRunner.update(sqlOrder, paramsOrder);
//
//		// 更新訂單的修改日期
//		Date dt = new Date();
//		String sqlOrder1 = "update orders set upOrderDate=? where orderNo=?";
//		Object[] paramsOrder1 = { dt, orderNo };
//		queryRunner.update(sqlOrder1, paramsOrder1);
//		if (row > 0) {
//			System.out.println("已成功修改了" + row + "筆資料");
//			System.out.printf("產品編號 :\" %d \"的修改結果為 : %s", orderNo, o);
//		}
//	}

}
