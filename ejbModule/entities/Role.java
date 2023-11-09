package entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;


@Entity
public class Role implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	/*
	 *  @ManyToMany
	    @JoinTable(
	        name = "user_role",
	        joinColumns = @JoinColumn(name = "role_id"),
	        inverseJoinColumns = @JoinColumn(name = "user_id")
	    )
    private List<User> users;
	 */
	
	public Role(int id, String name) {

		this.id = id;
		this.name = name;
	}
	public Role(String name) {
		this.name = name;
	}
	public Role() {
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
/*	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	*/
	
	

}
