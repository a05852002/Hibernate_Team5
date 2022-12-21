package _04_shoppingCart.model;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

public class OrderBean {
	
	private Integer orderNo; //訂單編號
	private String 	memberId; //會員編號
	private Date  orderDate; //訂單日期
	private Date  upOrderDate; //更新日期
	private String	shippingAddress; //收件地址
	private String ordStstus; //訂單狀態
	private String paymentStstus; //付款狀態
	private String deliveryStstus; //送貨狀態
	private Double	totalAmount; //總金額
	private String	cancelTag; //取消
	private Set<OrderItemBean> items = new LinkedHashSet<OrderItemBean>(); //itemsList

	
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



	public String getOrdStstus() {
		return ordStstus;
	}


	public void setOrdStstus(String ordStstus) {
		this.ordStstus = ordStstus;
	}


	public String getPaymentStstus() {
		return paymentStstus;
	}


	public void setPaymentStstus(String paymentStstus) {
		this.paymentStstus = paymentStstus;
	}


	public String getDeliveryStstus() {
		return deliveryStstus;
	}


	public void setDeliveryStstus(String deliveryStstus) {
		this.deliveryStstus = deliveryStstus;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderBean [orderNo=");
		builder.append(orderNo);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", orderDate=");
		builder.append(orderDate);
		builder.append(", upOrderDate=");
		builder.append(upOrderDate);
		builder.append(", shippingAddress=");
		builder.append(shippingAddress);
		builder.append(", ordStstus=");
		builder.append(ordStstus);
		builder.append(", paymentStstus=");
		builder.append(paymentStstus);
		builder.append(", deliveryStstus=");
		builder.append(deliveryStstus);
		builder.append(", totalAmount=");
		builder.append(totalAmount);
		builder.append(", cancelTag=");
		builder.append(cancelTag);
		builder.append(", items=");
		builder.append(items);
		builder.append("]");
		return builder.toString();
	}

}
