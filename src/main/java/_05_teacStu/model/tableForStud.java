package _05_teacStu.model;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class tableForStud {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "studno")
	private Integer studno;
	@Column(name = "memberId")
	private Integer memberId;
	@Column(name = "title")
	private String title;
	@Column(name = "postDate")
	private Date postDate;
	@Column(name = "detail")
	private String detail;
	@Column(name = "price")
	private Double price;
	@Column(name = "subjectItem")
	private String subjectItem;
	@Column(name = "learnLoc")
	private String learnLoc;
	@Column(name = "ClassPicture")
	private Blob ClassPicture;

	public tableForStud(Integer studno, Integer memberId, String title, Date postDate, String detail, Double price,
			String subjectItem, String learnLoc, Blob classPicture) {
		super();
		this.studno = studno;
		this.memberId = memberId;
		this.title = title;
		this.postDate = postDate;
		this.detail = detail;
		this.price = price;
		this.subjectItem = subjectItem;
		this.learnLoc = learnLoc;
		ClassPicture = classPicture;
	}

	public tableForStud() {
		super();
	}

	public Blob getClassPicture() {
		return ClassPicture;
	}

	public void setClassPicture(Blob classPicture) {
		ClassPicture = classPicture;
	}

	public Integer getStudno() {
		return studno;
	}

	public void setStudno(Integer studno) {
		this.studno = studno;
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

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getSubjectItem() {
		return subjectItem;
	}

	public void setSubjectItem(String subjectItem) {
		this.subjectItem = subjectItem;
	}

	public String getLearnLoc() {
		return learnLoc;
	}

	public void setLearnLoc(String learnLoc) {
		this.learnLoc = learnLoc;
	}

	@Override
	public String toString() {
		return String.format(
				"tableForStud [studno=%s, memberId=%s, title=%s, postDate=%s, detail=%s, price=%s, subjectItem=%s, learnLoc=%s]",
				studno, memberId, title, postDate, detail, price, subjectItem, learnLoc);
	}

}
