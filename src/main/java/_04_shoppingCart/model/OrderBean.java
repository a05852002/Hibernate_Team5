package _04_ShoppingCart.model;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

public class OrderBean {
	
	private Integer orderNo; //訂單編號
	private String 	memberId; //會員編號
	private Date  orderDate; //訂單日期
	private Date  upOrderDate; //更新日期
	private String	shippingAddress; //收件地址
	private Double	totalAmount; //總金額
	private String	cancelTag; //取消
	private Set<OrderItemBean> items = new LinkedHashSet<>(); //itemsList

	public OrderBean(){
		
	}
	

	public Date getUpOrderDate() {
		return upOrderDate;
	}


	public void setUpOrderDate(Date upOrderDate) {
		this.upOrderDate = upOrderDate;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public Set<OrderItemBean> getItems() {
		return items;
	}

	public void setItems(Set<OrderItemBean> items) {
		this.items = items;
	}
	
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	public String getCancelTag() {
		return cancelTag;
	}

	public void setCancelTag(String cancelTag) {
		this.cancelTag = cancelTag;
	}



	@Override
	public String toString() {
		return "OrderBean [orderNo=" + orderNo + ", memberId=" + memberId + ", orderDate=" + orderDate + ", upDate="
				+ upOrderDate + ", shippingAddress=" + shippingAddress + ", totalAmount=" + totalAmount + ", cancelTag="
				+ cancelTag + ", items=" + items + "]";
	}


	
	
	
	
}
