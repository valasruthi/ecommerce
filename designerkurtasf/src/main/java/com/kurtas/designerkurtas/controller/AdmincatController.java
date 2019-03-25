package com.kurtas.designerkurtas.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kurtas.designerkurtas.dao.Categoriesdao;
import com.kurtas.designerkurtas.dao.ProductDao;
import com.kurtas.designerkurtas.model.CategoryDetails;
import com.kurtas.designerkurtas.model.ProductDetails;

@Controller
@RequestMapping("/admin")
public class AdmincatController {
	@Autowired
	Categoriesdao ctdao;
	@Autowired
	ProductDao ptdao;
	@RequestMapping("/category")
	public ModelAndView categorieslist(Model m)
	 {
	  CategoryDetails category=new CategoryDetails();
	  m.addAttribute(category);
	  
	  
	  List<CategoryDetails> listcat = ctdao.retrieveAllUsers();
	  m.addAttribute("catlist", listcat);
	  return new ModelAndView("category");
	  
	 }
	@RequestMapping(value="/catprocess", method= RequestMethod.POST)
	public String addCategory(@ModelAttribute("categoryDetails") CategoryDetails categoryDetails , Model m)
	{
			System.out.println("cat id ="+categoryDetails.getCtid());
			if (categoryDetails.getCtid() != 0) {

				ctdao.updateCatdata(categoryDetails);

			} else 
					ctdao.newCategoriesdata(categoryDetails);
			@SuppressWarnings("unused")
			List< CategoryDetails> listcategories = ctdao.retrieveAllUsers();
			
			return "redirect:/admin/category";
		
			
	}
	@RequestMapping(value = "deleteCat/{ctid}")

	public String deleteCategory(@PathVariable("ctid") int ctid, Model m) {

		CategoryDetails cdtls = ctdao.getctid(ctid);

		ctdao.deleteCdata(cdtls);

		CategoryDetails category = new CategoryDetails();

		m.addAttribute(category);

		List<CategoryDetails> listcategories = ctdao.retrieveAllUsers();

		m.addAttribute("catlist", listcategories);

		return "redirect:/admin/category";

	}
	@RequestMapping(value = "updateCat/{ctid}")
	public String updateCategory(@PathVariable("ctid")int ctid, Model m)
	{
		CategoryDetails category = ctdao.getctid(ctid);
		m.addAttribute("category",category);
		System.out.println("it is in update category"+category.getCtid());
		ctdao.updateCatdata(category);
		
		m.addAttribute(category);
		System.out.println("after process "+category.getCtid());
		List<CategoryDetails> listcategories =ctdao.retrieveAllUsers();
		m.addAttribute("catlist", listcategories);
		return "category";
		
	}
	@RequestMapping("/product")
	public ModelAndView product(Model m)
	{
		ProductDetails product = new ProductDetails();
		m.addAttribute(product);
		List<ProductDetails> listproduct = ptdao.retrieveAllProducts(); 
		m.addAttribute("productlist",listproduct);
		List<CategoryDetails> listcategories = ctdao.retrieveAllUsers();

		m.addAttribute("catlist", listcategories);
        return  new ModelAndView("product");
	}
	@RequestMapping(value = "/productprocess", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("productDetails") ProductDetails productDetails,@RequestParam("pimage") MultipartFile mfile,Model m,BindingResult result,HttpServletRequest request) {
		System.out.println("p id =" + productDetails.getPid());
		if (productDetails.getPid() != 0) {
			ptdao.updateProdData(productDetails);
		} else
			ptdao.newProductData(productDetails);
		//multipart code to insert an image
		String path = request.getServletContext().getRealPath("/resources/");
		  String totalFilewithPath = path + String.valueOf(productDetails.getPid()) + ".jpg";
		  File productImage = new File(totalFilewithPath);
		  if (!mfile.isEmpty()) {
		   try {
		    byte fileBuffer[] = mfile.getBytes();
		    FileOutputStream fos = new FileOutputStream(productImage);
		    BufferedOutputStream bs = new BufferedOutputStream(fos);
		    bs.write(fileBuffer);
		    bs.close();
		   } catch (Exception e) {
		    m.addAttribute("File Exception", e);
		   }
		  }
		  else {
		   m.addAttribute("error", "problem in uploading image");
		  }
		  @SuppressWarnings("unused")
		List<ProductDetails> listproducts = ptdao.retrieveAllProducts();
		  m.addAttribute("productlist", listproducts);
		 List<CategoryDetails> listcategories = ctdao.retrieveAllUsers();
		  m.addAttribute("catlist", listcategories);
		  return "redirect:/admin/product";
		 }
		
	@RequestMapping(value = "updateProductData/{pid}")
	public String updateProdData(@PathVariable("pid")int pid, Model m)
	{
		ProductDetails productDetails = ptdao.getPtid(pid);
		m.addAttribute("productDetails",productDetails);
		System.out.println("it is in update products"+productDetails.getPid());
		ptdao.updateProdData(productDetails);
		m.addAttribute(productDetails);
		System.out.println("after process "+productDetails.getPid());
		List<ProductDetails> listproducts =ptdao.retrieveAllProducts();
		m.addAttribute("productlist", listproducts);
		return "product";
		
	}
	@RequestMapping(value = "deletepro/{pid}")
	public String deleteproduct(@PathVariable("pid") int pid, Model m) {
		ProductDetails pdt = ptdao.getPtid(pid);
		ptdao.deleteProducts(pdt);
		 ProductDetails prod = new  ProductDetails();
		m.addAttribute(prod);
		List< ProductDetails> listproducts = ptdao.retrieveAllProducts();
		m.addAttribute("productlist", listproducts);
		return "redirect:/admin/product";
	}
	
	}

