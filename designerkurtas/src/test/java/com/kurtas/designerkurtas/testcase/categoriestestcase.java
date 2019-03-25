package com.kurtas.designerkurtas.testcase;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kurtas.designerkurtas.dao.Categoriesdao;
import com.kurtas.designerkurtas.dbconfig1.Dbconfig;
import com.kurtas.designerkurtas.model.CategoryDetails;



public class categoriestestcase {
AnnotationConfigApplicationContext context;
CategoryDetails cdt;
Categoriesdao cdo;
@Before
public void init() {
	context = new AnnotationConfigApplicationContext(Dbconfig.class);
	cdt = new CategoryDetails();
	cdo = (Categoriesdao) context.getBean("cdao");
}

	/*@Test
	public void test() {
	cdt.setCtName("AKS");
	cdt.setCtDescription("All types of fancy and formal kurtas");
	cdo.newCategoriesdata(cdt);
	
	}*/
/*@Test
public void test() {
	cdt=cdo.getctid(1);
	System.out.println("ctname=" +cdt.getCtName());
}*/
/*@Test
public void test() {
	List<CategoryDetails> cdt=cdo.retrieveAllUsers();
	for(int i=0;i<cdt.size();i++)
	{
		CategoryDetails cd=(CategoryDetails)cdt.get(i);
		System.out.println(cd.getCtName()+" "+cd.getCtDescription());
		
	}*/
/*@Test
public void test() {
	cdt=cdo.getctid(1);
	cdt.setCtName("Avasa");
	assertEquals("updatesuccessfully",true,cdo.updateCatdata(cdt));


	
}*/
@Test
public void test() {
	cdt=cdo.getctid(2);

	assertEquals("deletesuccessfully",true,cdo.deleteCdata(cdt));
}

}
