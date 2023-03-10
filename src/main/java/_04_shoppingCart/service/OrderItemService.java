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
	public OrderItemBean insertOrder(Integer orderNo, String prodId, String prodName, Integer qty, Integer prodPrice,
			Double discount, String remark) {
		return orderItemDao.insertOrder(orderNo, prodId, prodName, qty, prodPrice, discount, remark);
	}

//刪除---------------------
	// 透過orderNo刪除
	public boolean deleteOrderItem(Integer orderNo, Integer seqno) {
		return orderItemDao.deleteOrderItem(orderNo, seqno);
	}

//修改---------------------
	// 透過訂單編號修改訂單資料
	public OrderItemBean updateOrder(Integer orderNo, Integer seqno, Integer qty, Integer prodPrice, Double discount,
			String remark) {
		return orderItemDao.updateOrder(orderNo, seqno, qty, prodPrice, discount, remark);
	}

//查詢---------------------
	// 搜尋全部訂單明細資料
	public Set<OrderItemBean> selectAllOrdItem(Integer orderNo) {
		return orderItemDao.selectAllOrdItem(orderNo);
	}

	public List<OrderItemBean> searchOrderItemByOrderNo(Integer orderNo) {
		return orderItemDao.searchOrderItemByOrderNo(orderNo);
	}

	// 搜尋orderNo
	public OrderItemBean selectOneOrdItem(Integer orderNo) {
		return orderItemDao.selectOneOrdItem(orderNo);
	}

	// 搜尋單一明細資料
	public List<OrderItemBean> searchOrderItemBySeq(Integer seqno) {
		return orderItemDao.searchOrderItemBySeq(seqno);
	}

	public List<OrderItemBean> selectOneOrdItem(Integer orderNo, Integer seqno) {
		return orderItemDao.selectOneOrdItem(orderNo, seqno);
	}
}
