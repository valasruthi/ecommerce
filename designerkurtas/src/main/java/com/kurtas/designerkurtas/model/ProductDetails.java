package com.kurtas.designerkurtas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class ProductDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	@NotEmpty(message = "It should not be empty")
	private String pname;
	//@Pattern(regexp = "[a-zA-Z] {4,15}", message = "Alphabets must be in the range of 4-15")
	private String pdescription;
	@Min(value=500, message="must be equal or greater than 18")  
	@Max(value=20000, message="must be equal or less than 45")  
	private int pprice;
	@OneToOne
	private CategoryDetails categorydetails;
	@Transient
	private MultipartFile pimage;
	private int stock;
	
	
	public int getPid() {
		return pid;
	}
	
	public MultipartFile getPimage() {
		return pimage;
	}

	public void setPimage(MultipartFile pimage) {
		this.pimage = pimage;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdescription() {
		return pdescription;
	}
	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public CategoryDetails getCategorydetails() {
		return categorydetails;
	}
	public void setCategorydetails(CategoryDetails categorydetails) {
		this.categorydetails = categorydetails;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	
	
	
	
	
}
