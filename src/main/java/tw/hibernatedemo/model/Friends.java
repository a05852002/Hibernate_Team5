package tw.hibernatedemo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "friends")
public class Friends {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "friends_id")
	private Integer id;
	
	@Column(name = "friendName")
	private String name;
	
	@ManyToMany(mappedBy = "friends")
	private Set<MyGroup> groups = new HashSet<MyGroup>();
	
	public Friends() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<MyGroup> getGroups() {
		return groups;
	}

	public void setGroups(Set<MyGroup> groups) {
		this.groups = groups;
	}

	@Override
	public String toString() {
		return "Friends [id=" + id + ", name=" + name + "]";
	}

}
