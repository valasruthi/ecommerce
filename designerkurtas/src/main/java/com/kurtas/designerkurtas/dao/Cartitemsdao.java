package com.kurtas.designerkurtas.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.kurtas.designerkurtas.model.Cartitems;

@Component
public interface Cartitemsdao {
	boolean addCitems(Cartitems citems);
	boolean deletCartItems(Cartitems ctitems);
	boolean updateCartItems(Cartitems citems);
	ArrayList<Cartitems> retreiveAllCartItems();
	Cartitems getProduct(int pid, int cart_id);
    public Cartitems get(int caid);
}
