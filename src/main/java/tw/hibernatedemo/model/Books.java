package tw.hibernatedemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "books")

public class Books {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "booktitle")
	private String booktitle;
	
	@Column(name = "publicyear")
	private String publicYear;
	
	@ManyToOne
	@JoinColumn(name = "fk_user_id")
	private BookUsers bookUsers = new BookUsers();
	
	@Override
	public String toString() {
		return "Books [id=" + id + ", booktitle=" + booktitle + ", publicYear=" + publicYear + ", bookUsers="
				+ bookUsers + "]";
	}

	public BookUsers getBookUsers() {
		return bookUsers;
	}

	public void setBookUsers(BookUsers bookUsers) {
		this.bookUsers = bookUsers;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBooktitle() {
		return booktitle;
	}

	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}

	public String getPublicYear() {
		return publicYear;
	}

	public void setPublicYear(String publicYear) {
		this.publicYear = publicYear;
	}

	public Books() {
	}

}
