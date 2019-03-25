package com.kurtas.designerkurtas.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.kurtas.designerkurtas.model.Cartdata;
import com.kurtas.designerkurtas.model.Cartitems;
import com.kurtas.designerkurtas.model.ProductDetails;

@Component
public interface Cartdao {
public boolean newCart(Cartdata cdt);
boolean deletcartdata(Cartdata cdata);
boolean updateCartdata(Cartdata ctdata);
ArrayList<Cartdata> retreiveAllCartdata();
}
