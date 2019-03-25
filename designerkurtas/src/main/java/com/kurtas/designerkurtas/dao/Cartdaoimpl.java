package com.kurtas.designerkurtas.dao;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kurtas.designerkurtas.model.Cartdata;
import com.kurtas.designerkurtas.model.Cartitems;
@Transactional
@Repository("cidao")
public class Cartdaoimpl implements Cartdao {
@Autowired
SessionFactory sessionFactory;
	public boolean newCart(Cartdata cdt) {
		try {
			sessionFactory.getCurrentSession().persist(cdt);
			return true;
		}
		catch(Exception ae)
		{
			System.out.println(ae);
		}
		return false;
	}
	public boolean deletcartdata(Cartdata cdata) {
		try {
			sessionFactory.getCurrentSession().persist(cdata);
			return true;
		}
		catch(Exception ae) {
			System.out.println(ae);
		}
		return false;
	}
	public boolean updateCartdata(Cartdata ctdata) {
		try {
			sessionFactory.getCurrentSession().update(ctdata);
			return true;
		}
		catch(Exception ae) {
			System.out.println(ae);
		}
		return false;
	}
	public ArrayList<Cartdata> retreiveAllCartdata() {
		try {
			   return (ArrayList<Cartdata>) sessionFactory.getCurrentSession().createQuery("from Cartdata", Cartdata.class).getResultList();
	}
		catch(Exception ae) {
			System.out.println(ae);
		}
		return null;
	}
	
}
