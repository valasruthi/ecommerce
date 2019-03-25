package com.kurtas.designerkurtas.testcase;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kurtas.designerkurtas.dao.Cartdao;
import com.kurtas.designerkurtas.dao.ProductDao;
import com.kurtas.designerkurtas.dao.UserDao;
import com.kurtas.designerkurtas.dbconfig1.Dbconfig;
import com.kurtas.designerkurtas.model.Cartdata;
import com.kurtas.designerkurtas.model.Cartitems;
import com.kurtas.designerkurtas.model.ProductDetails;

public class Carttestcase {
AnnotationConfigApplicationContext context;
Cartdata cdata;
Cartdao cdao;
ProductDao pdo;
UserDao udo;
List<Cartitems> crts;
@Before
public void init()
{
	context=new AnnotationConfigApplicationContext(Dbconfig.class);
	cdata=new Cartdata();
	cdao=(Cartdao)context.getBean("cidao");
	pdo=(ProductDao)context.getBean("pdao");
	udo=(UserDao)context.getBean("userdao");
	cdata.setCart_user(udo.getUserid(11));
	Cartitems ct =new Cartitems();
	ct.setCart(cdata);
	ProductDetails product=pdo.getPtid(1);
	ct.setPdtl(product);
	ct.setCaprice(product.getPprice());
	ct.setCaquantity(15);
	crts=new ArrayList<Cartitems>();
	crts.add(ct);
	cdata.setCart_quantity(ct.getCaquantity());
	cdata.setCart_total(ct.getCaprice());
    cdata.setCrt(crts);
	
	}

	@Test
	public void test() {
		assertEquals(true,cdao.newCart(cdata));
	}

}
