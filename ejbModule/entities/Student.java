package entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;


@Entity
public class Student extends User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String firstname;
	private String lastname;
	private String tell;
	
	@ManyToOne
	private Filiere filiere;
	

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String password, String login,String firstname, String lastname, String tell) {
		super(password, login);
		this.firstname = firstname;
		this.lastname = lastname;
		this.tell = tell;
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getTell() {
		return tell;
	}
	public void setTell(String tell) {
		this.tell = tell;
	}

	
	public Filiere getFiliere() {
		return filiere;
	}
	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}
	
}
