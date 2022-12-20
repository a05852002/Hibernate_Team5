package tw.hibernatedemo.model;

import java.io.Serializable;

public class myHouseBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int houseid;
	private String houseName;

	public myHouseBean(int houseid, String houseName) {
		super();
		this.houseid = houseid;
		this.houseName = houseName;
	}

	@Override
	public String toString() {
		return "myHouseBean [houseid=" + houseid + ", houseName=" + houseName + "]";
	}

	public int getHouseid() {
		return houseid;
	}

	public void setHouseid(int houseid) {
		this.houseid = houseid;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public myHouseBean() {
	}
	
	
	

}
