package tw.hibernatedemo.model;

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
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "bookusers")
public class BookUsers {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "username")
	private String user;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "bookUsers",cascade = CascadeType.ALL)
	@OrderBy("publicYear desc")  //訂單
	private Set<Books> books = new LinkedHashSet<Books>();
	
	@Override
	public String toString() {
		return "BookUsers [id=" + id + ", user=" + user + ", books=" + books + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public BookUsers() {
	}

	public Set<Books> getBooks() {
		return books;
	}

	public void setBooks(Set<Books> books) {
		this.books = books;
	}
	
	

}
