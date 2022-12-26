package _02_subLocation.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "subject")
public class SubjectBean implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "subjectId")
	private Integer subjectId;

	@Column(name = "subjectName")
	private String subjectName;
	
	@Column(name = "subjectClass")
	private String subjectClass;

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectClass() {
		return subjectClass;
	}

	public void setSubjectClass(String subjectClass) {
		this.subjectClass = subjectClass;
	}
	
	

	

	public SubjectBean(Integer subjectId, String subjectName, String subjectClass) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.subjectClass = subjectClass;
	}

	public SubjectBean() {
	}

	@Override
	public String toString() {
		return "subjectBean [subjectId=" + subjectId + ", subjectName=" + subjectName + ", subjectClass=" + subjectClass
				+ "]";
	}
}
