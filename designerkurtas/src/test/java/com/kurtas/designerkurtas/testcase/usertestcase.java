package com.kurtas.designerkurtas.testcase;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kurtas.designerkurtas.dao.UserDao;
import com.kurtas.designerkurtas.dbconfig1.Dbconfig;
import com.kurtas.designerkurtas.model.UserRegistration;

public class usertestcase {
	AnnotationConfigApplicationContext context;
	UserRegistration uregister;
	UserDao udao;

	@Before
	public void init() {
		context = new AnnotationConfigApplicationContext(Dbconfig.class);
		uregister = new UserRegistration();
		udao = (UserDao) context.getBean("userdao");
	}
	@Test
	public void Test()
	{
		
	}

	/*@Test
	public void test()
	{
	uregister.setConfirmPassword("sruthi123");
	uregister.setEmail("valasruthi4@gmail.com");
	uregister.setFirstName("vala");
	uregister.setLastName("sruthi");
	uregister.setMobile("8008734058");
	uregister.setPassword("sruthi123");
	uregister.setAddress("3-1-125,kachiguda,Hyderabad");
	udao.newUserData(uregister);
	}*/
//this testcase is for retriving specific records
	/*@Test
	public void test() {
	uregister=udao.getUserid(1);
	System.out.println("firstname=" +uregister.getFirstName());
	}*/
	//re
	/*@Test
	public void test() {
		List<UserRegistration> uregister =udao.retreiveAllUsers();
		for(int i=0;i<uregister.size();i++)
		{
			UserRegistration ur=(UserRegistration)uregister.get(i);
			System.out.println(ur.getFirstName()+" "+ur.getLastName()+" "+ur.getMobile()+" "+ur.getEmail());
		}
		
	}*/
	/*@Test
	public void test()
	{
		uregister=udao.getUserid(1);
		uregister.setMobile("9346150001");
		assertEquals("updatesuccessfully",true,udao.updateUserData(uregister));
	}*/
	/*@Test
	public void test()
	{
		uregister.setUserid(2);
		assertEquals("successfullydeleted",true,udao.deleteUserData(uregister));
	
	} */
	/*@Test
	public void test()
	{
		uregister=udao.getUserMobile("8008734058");
		System.out.println("mobileno=" +uregister.getMobile());
	}*/
	 
}
