package tw.hibernatedemo.model;

import java.io.Serializable;

public class CompanyBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int companyId;
	private String companyName;
	
	
	public int getCompanyId() {
		return companyId;
	}


	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String cmpanyName) {
		this.companyName = cmpanyName;
	}


	public CompanyBean(int companyId, String cmpanyName) {
		super();
		this.companyId = companyId;
		this.companyName = cmpanyName;
	}


	public CompanyBean() {
	}


	@Override
	public String toString() {
		return "CompanyBean [companyId=" + companyId + ", companyName=" + companyName + "]";
	}
	
	

}
