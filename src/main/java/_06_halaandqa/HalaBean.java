package _06_halaandqa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HALA")
public class HalaBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="HALAID")
	private Integer halaId;
	
	@Column(name = "HALACLASSNAME")
	private String halaClassName;
	
	@Column(name = "MEMBERID")
	private Integer memberId;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "POSTDATE")
	private String postDate;
	
	@Column(name = "HALACONTENT")
	private String halaContent;
	

	public HalaBean() {
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HalaBean [halaId=");
		builder.append(halaId);
		builder.append(", halaClassName=");
		builder.append(halaClassName);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", title=");
		builder.append(title);
		builder.append(", postDate=");
		builder.append(postDate);
		builder.append(", halaContent=");
		builder.append(halaContent);
		builder.append("]");
		return builder.toString();
	}


	public Integer getHalaId() {
		return halaId;
	}


	public void setHalaId(Integer halaId) {
		this.halaId = halaId;
	}


	public String getHalaClassName() {
		return halaClassName;
	}


	public void setHalaClassName(String halaClassName) {
		this.halaClassName = halaClassName;
	}


	public Integer getMemberId() {
		return memberId;
	}


	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getPostDate() {
		return postDate;
	}


	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}


	public String getHalaContent() {
		return halaContent;
	}


	public void setHalaContent(String halaContent) {
		this.halaContent = halaContent;
	}

}
