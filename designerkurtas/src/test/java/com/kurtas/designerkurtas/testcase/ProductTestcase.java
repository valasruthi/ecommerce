package com.kurtas.designerkurtas.testcase;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kurtas.designerkurtas.dao.Categoriesdao;
import com.kurtas.designerkurtas.dao.ProductDao;
import com.kurtas.designerkurtas.dbconfig1.Dbconfig;
import com.kurtas.designerkurtas.model.CategoryDetails;
import com.kurtas.designerkurtas.model.ProductDetails;

public class ProductTestcase {
	AnnotationConfigApplicationContext context;
	ProductDetails prod;
	ProductDao pdao;
	CategoryDetails cd;
	Categoriesdao ctdao;
	
@Before
public void init() {
	context = new AnnotationConfigApplicationContext(Dbconfig.class);
	prod=new ProductDetails();
	pdao=(ProductDao)context.getBean("pdao");
	cd=new CategoryDetails();
	ctdao=(Categoriesdao)context.getBean("cdao");
}
	/*@Test
	public void test() {
		cd.setCtName("Anarkali kurtas");
        cd.setCtDescription("All types of partyware anarkalis");
        prod.setPname("Designer Anarkali");
        prod.setPprice(2000);
        prod.setPdescription("Salwar Soul Pink Net Anarkali Semi-Stitched Suit");
        prod.setStock(15);
        prod.setCategorydetails(cd);
        Assert.assertEquals("successfully updated",true,ctdao.newCategoriesdata(cd));
        Assert.assertEquals("successfully updated",true,pdao.newProductData(prod));
	}*/
/*@Test
public void Test() {
	prod=pdao.getPtid(1);
	System.out.println("pname=" +prod.getPname());
	
}*/
/*@Test
public void Test() {
	prod=pdao.getPtid(1);
	prod.setPprice(1700);
	Assert.assertEquals("successfully updated",true,pdao.updateProdData(prod));
}*/
/*@Test
public void Test() {
	prod=pdao.getPtid(2);
	Assert.assertEquals("successfully deleted",true,pdao.deleteProducts(prod));
	}*/
@Test
public void test() {
	List<ProductDetails> pdt=pdao.retrieveAllProducts();
	for(int i=0;i<pdt.size();i++)
	{
		ProductDetails pdts=(ProductDetails)pdt.get(i);
		System.out.println(pdts.getPname()+" "+pdts.getPdescription());
		
	}
}
}
