package _04_shoppingCart.model;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "memberorder")

public class OrderBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderNo")
	private Integer orderNo; // 訂單編號
	@Column(name = "memberId")
	private String memberId; // 會員編號
	@Column(name = "orderDate")
	private Date orderDate; // 訂單日期
	@Column(name = "upOrderDate")
	private Date upOrderDate; // 更新日期
	@Column(name = "shippingAddress")
	private String shippingAddress; // 收件地址
	@Column(name = "ordStstus")
	private String ordStstus ="處理中"; // 訂單狀態 處理中(預設)/備貨中
	@Column(name = "paymentStstus")
	private String paymentStstus = "未付款"; // 付款狀態 未付款(預設)/已付款/退款中/已退款
	@Column(name = "deliveryStstus")
	private String deliveryStstus ="無"; // 送貨狀態 無/備貨中/已發貨/已取貨/退貨中/已退貨
	@Column(name = "totalAmount")
	private Double totalAmount = 0.0; // 總金額 0處理中(預設)
//	private String cancelTag; // 取消
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orderbean",cascade = CascadeType.ALL)
	@OrderBy("seqno desc") //拿資料的順序自己決定用,增加下一個排序
	private Set<OrderItemBean> items = new LinkedHashSet<OrderItemBean>(); // itemsList

	public OrderBean(Integer orderNo, String memberId, Date orderDate, Date upOrderDate, String shippingAddress,
			String ordStstus, String paymentStstus, String deliveryStstus, Double totalAmount, String cancelTag,
			Set<OrderItemBean> items) {
		super();
		this.orderNo = orderNo;
		this.memberId = memberId;
		this.orderDate = orderDate;
		this.upOrderDate = upOrderDate;
		this.shippingAddress = shippingAddress;
		this.ordStstus = ordStstus;
		this.paymentStstus = paymentStstus;
		this.deliveryStstus = deliveryStstus;
		this.totalAmount = totalAmount;
//		this.cancelTag = cancelTag;
		this.items = items;
	}

	public OrderBean() {

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
	
	public void setTotalAmount() {
		this.totalAmount = 0.0;
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

//	public String getCancelTag() {
//		return cancelTag;
//	}
//
//	public void setCancelTag(String cancelTag) {
//		this.cancelTag = cancelTag;
//	}

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
		builder.append("]");
		return builder.toString();
	}
	


}
