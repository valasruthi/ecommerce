package com.kurtas.designerkurtas.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cartdata {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int cart_id;
private int cart_quantity;
private double cart_total;
@OneToOne
private UserRegistration cart_user;
@OneToMany(mappedBy="cart",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
List<Cartitems> crt;
public int getCart_id() {
	return cart_id;
}
public void setCart_id(int cart_id) {
	this.cart_id = cart_id;
}
public List<Cartitems> getCrt() {
	return crt;
}
public void setCrt(List<Cartitems> crt) {
	this.crt = crt;
}
public int getCart_quantity() {
	return cart_quantity;
}
public void setCart_quantity(int cart_quantity) {
	this.cart_quantity = cart_quantity;
}
public double getCart_total() {
	return cart_total;
}
public void setCart_total(double cart_total) {
	this.cart_total = cart_total;
}
public UserRegistration getCart_user() {
	return cart_user;
}
public void setCart_user(UserRegistration cart_user) {
	this.cart_user = cart_user;
}



}
