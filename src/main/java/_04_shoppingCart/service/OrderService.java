package _04_shoppingCart.service;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import _04_shoppingCart.dao.OrderDao;
import _04_shoppingCart.model.OrderBean;

public class OrderService {
	
	private OrderDao orderDao;

	public OrderService(Session session) {
		this.orderDao = new OrderDao(session);
	}

	//新增一筆訂單
	public OrderBean insertOrder(String memberId, String shippingAddress) {
		return orderDao.insertOrder(memberId, shippingAddress);
	}
	
	//刪除一筆訂單-透過orderNo
	public boolean deleteOrderNo(Integer orderNo) {
		return orderDao.deleteOrderNo(orderNo);
	}
	
	//查詢全部訂單
	public List<OrderBean> selectAll() {
		return orderDao.selectAll();
	}
	
	//修改一筆訂單
	public OrderBean updateOrder(Integer orderNo, String memberId, Date upOrderDate, String shippingAddress,
			String ordStstus,String paymentStstus,String deliveryStstus) {
		return orderDao.updateOrder(orderNo, memberId, upOrderDate, shippingAddress, ordStstus, paymentStstus, deliveryStstus);
	}
}
