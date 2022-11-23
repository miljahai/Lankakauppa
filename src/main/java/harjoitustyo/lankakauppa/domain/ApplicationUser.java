package harjoitustyo.lankakauppa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ApplicationUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
		
	public ApplicationUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Column(name = "firstname")
	private String firstName;
	@Column(name = "lastname")
	private String lastName;
	private String role;
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	@Column(name = "password", nullable = false)
	private String passwordHash;
	
	public ApplicationUser(String firstName, String lastName, String role, String username, String passwordHash) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.role = role;
	this.username = username;
	this.passwordHash = passwordHash;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	@Override
	public String toString() {
		return "ApplicationUser [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", role=" + role
				+ ", username=" + username + ", passwordHash=" + passwordHash + "]";
	}
	
	
}