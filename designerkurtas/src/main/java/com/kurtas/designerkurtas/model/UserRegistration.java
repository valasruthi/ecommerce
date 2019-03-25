package com.kurtas.designerkurtas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class UserRegistration {
	public static final String DEFAULT_ROLE = "ROLE_USER";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userid;
	@NotNull(message ="field should not be  empty")
	@NotEmpty(message = "field should not be empty ")
	//@Pattern(regexp ="[a-zA-Z] {4,15}",message= "Alphabets must be in the range of 4-15")
	private String FirstName;
	@NotNull(message ="please fill this field")
	//@Pattern(regexp ="[a-zA-Z] {4,15}",message="Alphabets must be in the range of 4-15")
	private String LastName;
	@NotNull(message="Please fill the field")
	//@Pattern(regexp = "(0-9{10,10}", message="Only 10 numbers are accepted")
	private String mobile;
	@NotNull(message = "field should not be empty")
	@NotNull(message = "field should not be empty")
	//@Pattern(regexp = "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@"
	//+ "[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$", message = "you can use @symbol , hiphen- and digits")
	@Email
	private String email;
	@NotNull(message = "field should not be empty")
	@ManyToOne
	private Cartdata cart;
	public Cartdata getCart() {
		return cart;
	}
	public void setCart(Cartdata cart) {
		this.cart = cart;
	}

	private String address;

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@NotNull(message = "Please fill this field")
	//@Pattern(regexp = "((?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*\\W).{8,12})", message = "One UpperCase, One lowercase, one number and one special character are must in 8-12 character range")
	private String password;
	@Transient
	private String confirmPassword;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
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
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public static String getDefaultRole() {
		return DEFAULT_ROLE;
	}
	private boolean is_Active;
	
	public boolean isIs_Active() {
		return is_Active;
	}
	public void setIs_Active(boolean is_Active) {
		this.is_Active = is_Active;
	}
	

public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}


	
private String role = DEFAULT_ROLE;


}
