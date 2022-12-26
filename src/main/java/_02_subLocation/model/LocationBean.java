package _02_subLocation.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "location")
public class LocationBean implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "locno")
	private Integer locno;

	@Column(name = "locname")
	private String locname;

	@Column(name = "locclass")
	private String locclass;


	public Integer getLocno() {
		return locno;
	}


	public void setLocno(Integer locno) {
		this.locno = locno;
	}


	public String getLocname() {
		return locname;
	}


	public void setLocname(String locname) {
		this.locname = locname;
	}


	public String getLocclass() {
		return locclass;
	}


	public void setLocclass(String locclass) {
		this.locclass = locclass;
	}


	public LocationBean(Integer locno, String locname, String locclass) {
		super();
		this.locno = locno;
		this.locname = locname;
		this.locclass = locclass;
	}


	public LocationBean() {
	}



}
