package com.kurtas.designerkurtas.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kurtas.designerkurtas.model.CategoryDetails;
import com.kurtas.designerkurtas.model.ProductDetails;
@Transactional
@Repository("pdao")

public class ProductDaoimpl implements ProductDao{
@Autowired
SessionFactory sessionFactory;
	public boolean newProductData(ProductDetails pdt) {
	try {
		sessionFactory.getCurrentSession().persist(pdt);
		return true;
	}
	catch(Exception ae)
	{
		System.out.println(ae);
	}
	
		
		return false;
	}
	public ProductDetails getPtid(int id) {
		try {
			return sessionFactory.getCurrentSession().get(ProductDetails.class,id);
			}
		catch(Exception ae) {
			System.out.println(ae);
		}
		return null;
	}
	public boolean updateProdData(ProductDetails pdts) {
		try {
			sessionFactory.getCurrentSession().update(pdts);
			return true;
		}
		catch(Exception ae) {
			System.out.println(ae);
		}
		return false;
	}
	public boolean deleteProducts(ProductDetails pd) {
		try {
			sessionFactory.getCurrentSession().delete(pd);
			return true;
		}
		catch(Exception ae) {
			System.out.println(ae);
		}
		return false;
	}
	public List<ProductDetails> retrieveAllProducts() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from ProductDetails",ProductDetails.class).getResultList();
		}
		catch(Exception ae)
		{
			System.out.println(ae);
		}
		return null;
	}
	
}
