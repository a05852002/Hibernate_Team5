package _02_product.model;

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
import javax.persistence.Table;

@Entity
@Table(name="PRODTYPE")
public class ProdType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="prodClass")
	private Integer prodClass;
	
	@Column(name="prodClassName")
	private String prodClassName;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "prodtype",cascade = CascadeType.ALL)
	private Set<Product> product = new LinkedHashSet<Product>();
	
	public ProdType() {
	}

	public Integer getProdClass() {
		return prodClass;
	}

	public void setProdClass(Integer prodClass) {
		this.prodClass = prodClass;
	}

	public String getProdClassName() {
		return prodClassName;
	}

	public void setProdClassName(String prodClassName) {
		this.prodClassName = prodClassName;
	}

	public Set<Product> getProduct() {
		return product;
	}

	public ProdType(Integer prodClass, String prodClassName, Set<Product> product) {
		super();
		this.prodClass = prodClass;
		this.prodClassName = prodClassName;
		this.product = product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}

}
