package com.demo.model;



import javax.persistence.*;


@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id=-1l;
    
    @Column(name="username")
    private String username;
    
    @Column(name="email")
    private String email;

    @Column(name="password")
	private String password;

	


    public User() {}


    
    public User(String username, String email, String password) { 
    	this.setUsername(username);
    	this.setEmail(email);
    	this.setPassword(password); 
    }


	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email="  + ", password=" + password + "]";
	}


	
 

}
