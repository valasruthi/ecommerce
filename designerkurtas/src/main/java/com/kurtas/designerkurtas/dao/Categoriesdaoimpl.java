package com.kurtas.designerkurtas.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kurtas.designerkurtas.model.CategoryDetails;

@Transactional
@Repository("cdao")
public class Categoriesdaoimpl  implements Categoriesdao{
	
	@Autowired
	SessionFactory sessionFactory;

	public boolean newCategoriesdata(CategoryDetails cdt) {
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

	public CategoryDetails getctid(int id) {
		try {
			return sessionFactory.getCurrentSession().get(CategoryDetails.class,id);
			}
		catch(Exception ae)
		{
			System.out.println(ae);
		}
		return null;
	}

	public List<CategoryDetails> retrieveAllUsers() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from CategoryDetails",CategoryDetails.class).getResultList();
		}
		catch(Exception ae)
		{
			System.out.println(ae);
		}
		return null;
	}

	public boolean updateCatdata(CategoryDetails cdet) {
	try {
		sessionFactory.getCurrentSession().update(cdet);
		return true;
	}
	catch(Exception ae) {
		System.out.println(ae);
	}
		return false;
	}

	public boolean deleteCdata(CategoryDetails cdet) {
	try {
		sessionFactory.getCurrentSession().delete(cdet);
		return true;
	}
	catch(Exception ae) {
		System.out.println(ae);
	}
		return false;
	}

}
