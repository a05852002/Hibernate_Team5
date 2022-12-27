package _04_shoppingCart.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
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
	public OrderItemBean insertOrder(Integer orderNo, String prodId, String prodName, Integer qty, Integer prodPrice,
			Double discount, String remark) {
		OrderBean orderBean = session.get(OrderBean.class, orderNo);
		OrderItemBean orderItemBean = new OrderItemBean();
		orderItemBean.setOrderNo(orderNo);
		orderItemBean.setProdId(prodId);
		orderItemBean.setProdName(prodName);
		orderItemBean.setQty(qty);
		orderItemBean.setDiscount(discount);
		orderItemBean.setProdPrice(prodPrice);
		orderItemBean.setItemTotal(Integer.parseInt(String.valueOf(Math.round(qty * prodPrice * discount))));
		orderItemBean.setRemark(remark);
		orderItemBean.setOrderbean(orderBean);
		System.out.println("test2" + orderItemBean.getOrderbean().getOrderNo());

		Set<OrderItemBean> orderItemBeanSet = new LinkedHashSet<OrderItemBean>();
		orderItemBeanSet.add(orderItemBean);
		orderBean.setItems(orderItemBeanSet);
		
		// 更新訂單的總金額與時間
		Integer totalAmount = orderBean.getTotalAmount();
		orderBean.setTotalAmount(Integer
				.parseInt(String.valueOf(Math.round(totalAmount+ (qty * prodPrice * discount)))));
		orderBean.setUpOrderDate(new Date());

		session.save(orderBean);
		
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
				// 更新資料
				// 原本的資料金額
				Integer itemTotal = ordItem.getItemTotal();
				Integer totalAmount = orderBean.getTotalAmount();
				
				//移除Item
				items.remove(ordItem);
				session.delete(ordItem);
				
				// 更新訂單的總金額與時間
				orderBean.setTotalAmount(totalAmount-itemTotal);
				orderBean.setUpOrderDate(new Date());
				session.save(orderBean);
				return true;
			}
		}
		return false;
	}

//修改---------------------
	// 修改---------------------
	// 透過訂單編號修改訂單資料
	public OrderItemBean updateOrder(Integer orderNo, Integer seqno, Integer qty, Integer prodPrice, Double discount,
			String remark) {
		String hql = "update OrderItemBean set qty=?1,prodPrice=?2 ,discount=?3,itemTotal=?4, remark=?5 where orderNo = ?6 and seqno=?7";

		OrderBean orderBean = session.get(OrderBean.class, orderNo);
		Set<OrderItemBean> items = orderBean.getItems();

		Iterator<OrderItemBean> it = items.iterator();
		OrderItemBean ordItem = new OrderItemBean();
		System.out.println("seqno: " + seqno);
		while (it.hasNext()) {
			ordItem = it.next();
			System.out.println(ordItem.getSeqno());
			if (ordItem.getSeqno() == seqno) {
				// 原本的資料金額
				Integer itemTotal = ordItem.getItemTotal();
				Integer totalAmount = orderBean.getTotalAmount();
				Integer itemTotal2 =  Integer
						.parseInt(String.valueOf(Math.round(qty*prodPrice*discount)));

				// 更新資料
				session.createQuery(hql) // 更新不用資料型別,select回傳才需要
						.setParameter(1, qty).setParameter(2, prodPrice).setParameter(3, discount).setParameter(4, itemTotal2)
						.setParameter(5, remark).setParameter(6, orderNo).setParameter(7, seqno).executeUpdate();

				// 更新訂單的總金額與時間
				orderBean.setTotalAmount(Integer
						.parseInt(String.valueOf(Math.round(totalAmount - itemTotal + (qty * prodPrice * discount)))));
				orderBean.setUpOrderDate(new Date());
				session.save(orderBean);
			}
		}
		return ordItem;

	}

//查詢---------------------
	// 搜尋全部訂單明細資料
	public Set<OrderItemBean> selectAllOrdItem(Integer orderNo) {
		OrderBean orderBean = session.get(OrderBean.class, orderNo);
		Set<OrderItemBean> items = orderBean.getItems();
		return items;
	}

	public List<OrderItemBean> searchOrderItemByOrderNo(Integer orderNo) {

		String hql = "from OrderItemBean o where o.orderNo = :orderNo";
		Query<OrderItemBean> query = session.createQuery(hql, OrderItemBean.class).setParameter("orderNo", orderNo);
		List<OrderItemBean> resultList = query.getResultList();
		List<OrderItemBean> list = new ArrayList<OrderItemBean>();
		OrderItemBean index0 = resultList.get(0);
		list.add(index0);
		return list;

	}

	// 搜尋單一明細資料
	public List<OrderItemBean> searchOrderItemBySeq(Integer seqno) {

		String hql = "from OrderItemBean o where o.seqno = :seqno";
		Query<OrderItemBean> query = session.createQuery(hql, OrderItemBean.class).setParameter("seqno", seqno);
		List<OrderItemBean> resultList = query.getResultList();
		List<OrderItemBean> list = new ArrayList<OrderItemBean>();
		OrderItemBean index0 = resultList.get(0);
		list.add(index0);
		return list;

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
	public List<OrderItemBean> selectOneOrdItem(Integer orderNo, Integer seqno) {

		String hql = "from OrderItemBean o where o.orderNo=:orderNo and o.seqno = :seqno";
		Query<OrderItemBean> query = session.createQuery(hql, OrderItemBean.class).setParameter("orderNo", orderNo)
				.setParameter("seqno", seqno);
		List<OrderItemBean> resultList = query.getResultList();
		List<OrderItemBean> list = new ArrayList<OrderItemBean>();
		OrderItemBean index0 = resultList.get(0);
		list.add(index0);
		return list;

	}

}
