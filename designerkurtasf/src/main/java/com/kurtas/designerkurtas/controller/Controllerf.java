package com.kurtas.designerkurtas.controller;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kurtas.designerkurtas.dao.Cartdao;
import com.kurtas.designerkurtas.dao.Categoriesdao;
import com.kurtas.designerkurtas.dao.ProductDao;
import com.kurtas.designerkurtas.dao.UserDao;
import com.kurtas.designerkurtas.model.Cartdata;
import com.kurtas.designerkurtas.model.CategoryDetails;
import com.kurtas.designerkurtas.model.ProductDetails;
import com.kurtas.designerkurtas.model.UserRegistration;

@Controller
public class Controllerf {
	@Autowired
	UserDao userdao;
	@Autowired
	Categoriesdao ctdao;
	@Autowired
	ProductDao ptdao;
     @Autowired
     Cartdao cdao;
     
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public ModelAndView HomePage(Model m, Principal p) 
	{

		if (p != null) {
			UserRegistration userreg = userdao.getUserMobile(p.getName());
			System.out.println(userreg.getMobile());
			System.out.println(userreg.getRole());
			
			if (!userreg.getRole().equals("ROLE_ADMIN")) {
				Cartdata cart=new Cartdata();
				m.addAttribute("cart",cart);
				m.addAttribute("userregt", userreg);
				System.out.println(userreg.getRole());
				return new ModelAndView("UserPage");
			} else {
				return new ModelAndView("AdminPage");
			}
		}

		return new ModelAndView("index");
	}

	@RequestMapping("/login")
	public String loginpage(Model m) {
		List<ProductDetails> listproduct = ptdao.retrieveAllProducts(); 
		m.addAttribute("productlist",listproduct);
		List<CategoryDetails> listcategories = ctdao.retrieveAllUsers();

		m.addAttribute("catlist", listcategories);
		return "Login";
	}

	
	@RequestMapping("/reg")
	public ModelAndView regpage(Model m)
	{
		UserRegistration userreg = new UserRegistration();
		m.addAttribute("userregt", userreg);
		return new ModelAndView("Signup");
	}
	
	
	@RequestMapping("/submitForm")
	public String createUser(@Valid @ModelAttribute("userregt") UserRegistration userreg, BindingResult result , Model m)
	{
		if(result.hasErrors())
		{
			System.out.println("error");
			m.addAttribute("userregt", userreg);
			return "Signup";
		}
		else
		{
			if(!(userreg.getPassword().equals(userreg.getConfirmPassword())))
			{
				System.out.println("error due to password mismatch");
				m.addAttribute(userreg);
				m.addAttribute("errorpassword", "password should match");
				return "Signup";
			}
			else
			{
				Cartdata cart=new Cartdata();
				userreg.setCart(cart);
				cart.setCart_user(userreg);
				
				userdao.newUserData(userreg);
				cdao.newCart(cart);
				List<CategoryDetails> listcategories =ctdao.retrieveAllUsers();
				m.addAttribute("catlist",listcategories);
				return "redirect:/";
			}
		}
	}
	@RequestMapping("/products")
	 public ModelAndView product(Model m, Principal principal) {
	  if (principal != null) {
		  UserRegistration usrg = userdao.getUserMobile(principal.getName());
	   m.addAttribute(usrg);
	  }
	  ProductDetails prod = new ProductDetails();
	  m.addAttribute(prod);
	  List<ProductDetails> listproducts = ptdao.retrieveAllProducts();
	  m.addAttribute("productlist", listproducts);
	  List<CategoryDetails> listcategories = ctdao.retrieveAllUsers();
	  m.addAttribute("catlist", listcategories);
	  return new ModelAndView("products");
	 }
	 @RequestMapping(value = "/productDisplay/{pid}", method = RequestMethod.GET)
	 public ModelAndView prodDisplay(@PathVariable("pid") int pid, Model m, Principal principal) {
	  if (principal != null) {
	   UserRegistration usrg = userdao.getUserMobile(principal.getName());
	   m.addAttribute(usrg);
	  }
	  List<CategoryDetails> listcategories = ctdao.retrieveAllUsers();
	  m.addAttribute("catlist", listcategories);
	  ProductDetails product = ptdao.getPtid(pid);
	  m.addAttribute("product",product);
	  return new ModelAndView("productDisplay");
	 }
	 @RequestMapping(value="/CategorizedProducts/{ctid}", method = RequestMethod.GET)
	 public ModelAndView catproducts(@PathVariable("ctid") int ctid, Model m, Principal principal) {
	  if (principal != null) {
	   UserRegistration usrg = userdao.getUserMobile(principal.getName());
	 //  Cart cart = createuser.getCart();
	  // m.addAttribute(cart);
	   m.addAttribute(usrg);
	  }
	  List<CategoryDetails> listcategories = ctdao.retrieveAllUsers();
	  m.addAttribute("catlist", listcategories);
	  CategoryDetails cat = ctdao.getctid(ctid);
	  Collection<ProductDetails> products = cat.getPdt();
	  m.addAttribute("catprodlist", products);
	  return new ModelAndView("CategorizedProducts");
	 }


}