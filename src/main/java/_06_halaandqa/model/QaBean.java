package _06_halaandqa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="QA")
public class QaBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="QAID")
	private Integer qaId;
	
	@Column(name = "QACLASSNAME")
	private String qaClassName;
	
	@Column(name = "MEMBERID")
	private Integer memberId;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "POSTDATE")
	private String postDate;
	
	@Column(name = "QACONTENT")
	private String qaContent;

	public QaBean() {
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QaBean [qaId=");
		builder.append(qaId);
		builder.append(", qaClassName=");
		builder.append(qaClassName);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", title=");
		builder.append(title);
		builder.append(", postDate=");
		builder.append(postDate);
		builder.append(", qaContent=");
		builder.append(qaContent);
		builder.append("]");
		return builder.toString();
	}

	public Integer getQaId() {
		return qaId;
	}

	public void setQaId(Integer qaId) {
		this.qaId = qaId;
	}

	public String getQaClassName() {
		return qaClassName;
	}

	public void setQaClassName(String qaClassName) {
		this.qaClassName = qaClassName;
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

	public String getQaContent() {
		return qaContent;
	}

	public void setQaContent(String qaContent) {
		this.qaContent = qaContent;
	}

}
