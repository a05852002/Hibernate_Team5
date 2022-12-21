package _04_shoppingCart.model;

public class OrderItemBean {
	private Integer seqno; //序號
	private Integer orderNo; //訂單編號
	private String productId; //商品編號
	private String productName; //商品名稱
	private String description; //描述
	private Integer qty; //數量
	private Double unitPrice; //單價
	private Double itemTotal; //總金額

	public OrderItemBean( Integer orderNo,Integer seqno, String productId,String productName,
			String description, Integer qty, Double unitPrice, Double itemTotal) {
		this.orderNo = orderNo;
		this.seqno = seqno;
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.qty = qty;
		this.unitPrice = unitPrice;
		this.itemTotal = itemTotal;
	
	}


	@Override
	public String toString() {
		return "OrderItemBean [seqno=" + seqno + ", orderNo=" + orderNo + ", productId=" + productId + ", productName="
				+ productName + ", description=" + description + ", qty=" + qty + ", unitPrice=" + unitPrice
				+ ", itemTotal=" + itemTotal + "]";
	}


	public OrderItemBean() {
		
	}
	
	public Integer getSeqno() {
		return seqno;
	}

	public void setSeqno(Integer seqno) {
		this.seqno = seqno;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Double getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(Double itemTotal) {
		this.itemTotal = itemTotal;
	}

}
