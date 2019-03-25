package com.kurtas.designerkurtas.dao;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kurtas.designerkurtas.model.Cartitems;

@Transactional
@Repository("cartitemdao")
public class Cartitemsdaoimpl implements Cartitemsdao {
	 @Autowired
	 SessionFactory sessionFactory;
	public boolean addCitems(Cartitems citems) {
		try {
			 sessionFactory.getCurrentSession().save(citems);
			   return true;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	public boolean deletCartItems(Cartitems ctitems) {
		try {
			sessionFactory.getCurrentSession().remove(ctitems);
			   return true;
           }
		catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	public boolean updateCartItems(Cartitems citems) {
		try {
			sessionFactory.getCurrentSession().update(citems);
			   return true;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public ArrayList<Cartitems> retreiveAllCartItems() {
		try {
			   return (ArrayList<Cartitems>) sessionFactory.getCurrentSession().createQuery("from Cartitems", Cartitems.class).getResultList();
	}
catch(HibernateException e )
		{
	   e.printStackTrace();
	   return null;
		}
	}
	public Cartitems getProduct(int pid, int cart_id) {
		 try {
			   return sessionFactory.getCurrentSession()
			     .createQuery("from Cartitems where cart_cartId = :cart_id and product_productId= :pid",
			       Cartitems.class)
			     .setParameter("cartId",cart_id).setParameter("productId", pid).getSingleResult();
	}
		 catch (Exception e) {
			   System.out.println(e);
			   return null;
			  }
}
	public Cartitems get(int caid) {
		try {
			return sessionFactory.getCurrentSession().get(Cartitems.class,caid);
		}
		catch(Exception ae) {
			System.out.println(ae);
		}
		return null;
	}
}
