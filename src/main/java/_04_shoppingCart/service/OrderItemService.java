package _04_shoppingCart.service;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import _04_shoppingCart.dao.OrderItemDao;
import _04_shoppingCart.model.OrderItemBean;

public class OrderItemService {

	private OrderItemDao orderItemDao;

	public OrderItemService(Session session) {
		this.orderItemDao = new OrderItemDao(session);
	}

//	新增一筆訂單 沒有折扣
	public OrderItemBean insertOrder(String prodId, String prodName, int qty, Integer prodPrice, Double discount,
			String remark) {
		return orderItemDao.insertOrder(prodId, prodName, qty, prodPrice, discount, remark);
	}

//刪除---------------------
	// 透過orderNo刪除
	public boolean deleteOrderNo(Integer orderNo, Integer seqno) {
		return orderItemDao.deleteOrderNo(orderNo, seqno);
	}

//查詢---------------------
	// 搜尋全部訂單明細資料
	public Set<OrderItemBean> selectAllOrdItem(Integer orderNo) {
		return orderItemDao.selectAllOrdItem(orderNo);
	}
	
	public List<OrderItemBean> searchOrderItemByOrderNo(Integer orderNo) {
		return orderItemDao.searchOrderItemByOrderNo(orderNo);
	}
}
