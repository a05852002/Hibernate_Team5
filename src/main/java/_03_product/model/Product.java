package _03_product.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "PRODUCT")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prodID")
	private int prodID;

	@Column(name = "prodName")
	private String prodName;

	@Column(name = "prodPrice")
	private int prodPrice;

	@Column(name = "memberID")
	private int memberID;

	@Column(name = "inventory")
	private int inventory;

	@Column(name = "prodPost")
	private String prodPost;

	@Column(name = "prodUpdate")
	private String prodUpdate;
	
	@Column(name="prodImg")
	private Blob prodImg;

	@Column(name = "prodClass")
	@Transient
	private int prodClass;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "prodClass")
	private ProdType prodtype;

	@Override
	public String toString() {
		return "Product [prodID=" + prodID + ", prodName=" + prodName + ", prodPrice=" + prodPrice + ", memberID="
				+ memberID + ", inventory=" + inventory + ", prodPost=" + prodPost + ", prodUpdate=" + prodUpdate
				+ ", prodImg=" + prodImg + ", prodClass=" + prodClass + ", prodtype=" + prodtype + "]";
	}

	public Product() {
	}

	public Product(int prodID, String prodName, int prodPrice, int memberID, int inventory, String prodPost,
			String prodUpdate, Blob prodImg, int prodClass, ProdType prodtype) {
		super();
		this.prodID = prodID;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.memberID = memberID;
		this.inventory = inventory;
		this.prodPost = prodPost;
		this.prodUpdate = prodUpdate;
		this.prodImg = prodImg;
		this.prodClass = prodClass;
		this.prodtype = prodtype;
	}

	public int getProdID() {
		return prodID;
	}

	public void setProdID(int prodID) {
		this.prodID = prodID;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}

	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public String getProdPost() {
		return prodPost;
	}

	public void setProdPost(String prodPost) {
		this.prodPost = prodPost;
	}

	public String getProdUpdate() {
		return prodUpdate;
	}

	public void setProdUpdate(String prodUpdate) {
		this.prodUpdate = prodUpdate;
	}

	public int getProdClass() {
		return prodClass;
	}

	public void setProdClass(int prodClass) {
		this.prodClass = prodClass;
	}

	public ProdType getProdtype() {
		return prodtype;
	}

	public void setProdtype(ProdType prodtype) {
		this.prodtype = prodtype;
	}
	
	public Blob getProdImg() {
		return prodImg;
	}
	
	public void setProdImg(Blob prodImg) {
		this.prodImg = prodImg;
	}

}
