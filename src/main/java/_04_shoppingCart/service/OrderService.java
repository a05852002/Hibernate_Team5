package _04_shoppingCart.service;

import java.util.List;

import org.hibernate.Session;

import _04_shoppingCart.dao.OrderDao;
import _04_shoppingCart.model.OrderBean;

public class OrderService {
	
	private OrderDao orderDao;

	public OrderService(Session session) {
		this.orderDao = new OrderDao(session);
	}

	public OrderBean insertOrder(String memberId, String shippingAddress) {
		return orderDao.insertOrder(memberId, shippingAddress);
	}
	
	
	
	
	public boolean deleteOrderNo(Integer orderNo) {
		return orderDao.deleteOrderNo(orderNo);
	}
	
	public List<OrderBean> selectAll() {
		return orderDao.selectAll();
	}
	
}
