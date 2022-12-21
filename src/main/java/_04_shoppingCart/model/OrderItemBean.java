package _04_shoppingCart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderitem")
public class OrderItemBean {
	
	
	
	@ManyToOne
	@JoinColumn(name = "orderNo_fk")
	private OrderBean orderbean; // 訂單編號
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seqno")
	private Integer seqno; // 序號
	@Column(name = "prodId")
	private String prodId; // 商品編號
	@Column(name = "prodName")
	private String prodName; // 商品名稱
	@Column(name = "qty")
	private Integer qty; // 數量
	@Column(name = "prodPrice")
	private Integer prodPrice; // 單價
	@Column(name = "discount")
	private Double discount = 1.0; // 折扣
	@Column(name = "itemTotal")
	private Integer itemTotal; // 總金額
	@Column(name = "remark")
	private String remark; // 備註


	public OrderItemBean(OrderBean orderbean, Integer seqno, String prodId, String prodName, Integer qty,
			Integer prodPrice, Double discount, Integer itemTotal, String remark) {
		super();
		this.orderbean = orderbean;
		this.seqno = seqno;
		this.prodId = prodId;
		this.prodName = prodName;
		this.qty = qty;
		this.prodPrice = prodPrice;
		this.discount = discount;
		this.itemTotal = itemTotal;
		this.remark = remark;
	}




	public OrderItemBean() {

	}




	public OrderBean getOrderbean() {
		return orderbean;
	}


	public void setOrderbean(OrderBean orderbean) {
		this.orderbean = orderbean;
	}


	public Integer getSeqno() {
		return seqno;
	}


	public void setSeqno(Integer seqno) {
		this.seqno = seqno;
	}


	public String getProdId() {
		return prodId;
	}


	public void setProdId(String prodId) {
		this.prodId = prodId;
	}


	public String getProdName() {
		return prodName;
	}


	public void setProdName(String prodName) {
		this.prodName = prodName;
	}


	public Integer getQty() {
		return qty;
	}


	public void setQty(Integer qty) {
		this.qty = qty;
	}


	public Integer getProdPrice() {
		return prodPrice;
	}


	public void setProdPrice(Integer prodPrice) {
		this.prodPrice = prodPrice;
	}


	public Double getDiscount() {
		return discount;
	}


	public void setDiscount(Double discount) {
		this.discount = discount;
	}


	public Integer getItemTotal() {
		return itemTotal;
	}


	public void setItemTotal(Integer itemTotal) {
		this.itemTotal = itemTotal;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderItemBean [orderNo=");
		builder.append(orderbean);
		builder.append(", seqno=");
		builder.append(seqno);
		builder.append(", prodId=");
		builder.append(prodId);
		builder.append(", prodName=");
		builder.append(prodName);
		builder.append(", qty=");
		builder.append(qty);
		builder.append(", prodPrice=");
		builder.append(prodPrice);
		builder.append(", discount=");
		builder.append(discount);
		builder.append(", itemTotal=");
		builder.append(itemTotal);
		builder.append(", remark=");
		builder.append(remark);
		builder.append("]");
		return builder.toString();
	}

}
