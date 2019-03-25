package com.kurtas.designerkurtas.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Cartitems {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int caid;
	private int caquantity;
	private int caprice;
	@OneToOne(fetch = FetchType.EAGER)
	private ProductDetails pdtl;
	@ManyToOne
	private Cartdata cart;
	public int getCaid() {
		return caid;
	}
	public void setCaid(int caid) {
		this.caid = caid;
	}
	public int getCaquantity() {
		return caquantity;
	}
	public void setCaquantity(int caquantity) {
		this.caquantity = caquantity;
	}
	public int getCaprice() {
		return caprice;
	}
	public void setCaprice(int caprice) {
		this.caprice = caprice;
	}
	public ProductDetails getPdtl() {
		return pdtl;
	}
	public void setPdtl(ProductDetails pdtl) {
		this.pdtl = pdtl;
	}
	public Cartdata getCart() {
		return cart;
	}
	public void setCart(Cartdata cart) {
		this.cart = cart;
	}
	
	
	
	

}
