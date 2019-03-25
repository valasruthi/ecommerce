package com.kurtas.designerkurtas.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kurtas.designerkurtas.dao.Cartdao;
import com.kurtas.designerkurtas.dao.Cartitemsdao;
import com.kurtas.designerkurtas.dao.ProductDao;
import com.kurtas.designerkurtas.dao.UserDao;
import com.kurtas.designerkurtas.model.Cartdata;
import com.kurtas.designerkurtas.model.Cartitems;
import com.kurtas.designerkurtas.model.ProductDetails;
import com.kurtas.designerkurtas.model.UserRegistration;

@Controller
@RequestMapping("/customer")
public class CartdataController {
	@Autowired
	 ProductDao ptdao;
	 @Autowired
	 UserDao udao;
	  @Autowired
	 Cartdao cartdao;
	 
	 @Autowired
	 Cartitemsdao cartItemDao;
	 @RequestMapping("/addToCart/{pid}")
	 public String addToCart(@PathVariable("pid") int pid, Model m, @RequestParam(value ="quantity") int quantity, Principal principal)
	 {
	   
	  
	  System.out.println(principal);
	  
	  ProductDetails product = ptdao.getPtid(pid);
	  UserRegistration ureg = udao.getUserMobile(principal.getName());
	  Cartdata cart=ureg.getCart();
      /* if(cart == null) 
	{
	   cart=new Cartdata();
	  }*/
	
	  
	  
	  
	  Cartitems citems =  cartItemDao.getProduct(pid, cart.getCart_id());
	  
	  if(citems==null)
	  {
	   citems = new Cartitems();
	   citems.setPdtl(product);;
	   citems.setCaquantity(quantity);;
	   citems.setCart(cart);;
	   citems.setCaprice(citems.getCaquantity() * product.getPprice());
	   ArrayList<Cartitems> itemsList=new ArrayList<Cartitems>();
	   itemsList.add(citems);
	   cart.setCart_quantity(cart.getCart_quantity()+citems.getCaprice());
	   cart.setCart_total(cart.getCart_total()+citems.getCaprice());
	   cart.setCrt(itemsList);
	   m.addAttribute("citems",itemsList);
	   cartItemDao.addCitems(citems);
	  }
	  else
	  {
	   citems.setPdtl(product);;
	   citems.setCaprice(citems.getCaprice()+(quantity*product.getPprice()));
	   citems.setCaquantity(citems.getCaquantity()+quantity);
	   ArrayList<Cartitems> itemsList=new ArrayList<Cartitems>();
	   itemsList.add(citems);
	   cart.setCart_quantity(cart.getCart_quantity()+citems.getCaquantity());
	   cart.setCart_total(cart.getCart_total()+(quantity*product.getPprice()));
	   cart.setCrt(itemsList);
	   m.addAttribute("citems",itemsList);
	   cartItemDao.updateCartItems(citems);
	  }
	  
	  cartdao.updateCartdata(cart);
	  m.addAttribute(product);
	  m.addAttribute(cart);
	  return "redirect:/customer/myCart";
	 }
	 @RequestMapping("/myCart")
	 public String myCart(Model m, Principal principal)
	 {
	  System.out.println(principal);
	  UserRegistration ureg=udao.getUserMobile(principal.getName());
	  Cartdata cart = ureg.getCart();
	  List<Cartitems> cartitems = cart.getCrt();
	  m.addAttribute("cartItems",cartitems);
	 m.addAttribute(cart);
	  return "mycart";
	 }
	 
	 @RequestMapping(value="/editCartItems/{caid}")
	 public String editcartItem(@PathVariable(value="caid")int caid, Model m, @RequestParam(value ="quantity") int quantity, Principal p)
	 {

	  Cartitems cartItem = cartItemDao.get(caid);
	  UserRegistration ureg = udao.getUserMobile(p.getName());
	  Cartdata cart = ureg.getCart();
	  cart.setCart_quantity(cart.getCart_quantity()-cartItem.getCaquantity());
	  cart.setCart_total(cart.getCart_total()-cartItem.getCaprice());
	  ProductDetails product = cartItem.getPdtl();
	  cartItem.setCaquantity(quantity);
	  cartItem.setCaprice(quantity*product.getPprice());
	  cart.setCart_id(cartItem.getCart().getCart_id());
	  cart.setCart_quantity(cart.getCart_quantity()+cartItem.getCaquantity());
	  cart.setCart_total(cart.getCart_total()+cartItem.getCaprice());
	  cartItemDao.updateCartItems(cartItem);
	  ureg.setCart(cart);;
	  cartdao.updateCartdata(cart);
	  return "redirect:/customer/myCart";
	  
	 }
	 
	 
	 @RequestMapping(value="deleteCartItems/{caid}/cartItem")
	 public String deleteCartItem(@PathVariable("caid")int caid,Model m, Principal p)
	 {
	  Cartitems cartItem = cartItemDao.get(caid);
	  UserRegistration ureg = udao.getUserMobile(p.getName());
	  Cartdata cart = ureg.getCart();
	  cart.setCart_id(cartItem.getCart().getCart_id());
	     cart.setCart_quantity(cart.getCart_quantity()-cartItem.getCaquantity());
	     cart.setCart_total(cart.getCart_total()-cartItem.getCaprice());
	      ureg.setCart(cart);
	   cartdao.updateCartdata(cart);
	  cartItemDao.deletCartItems(cartItem);
	  
	  return "redirect:/customer/myCart";
	 }
	 
}
