package com.kurtas.designerkurtas.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.kurtas.designerkurtas.model.UserRegistration;
@Transactional
@Repository("userdao")

public class UserDaoImpl implements UserDao
{
	@Autowired
	SessionFactory sessionFactory;

	public boolean newUserData(UserRegistration user) 
	{
	sessionFactory.getCurrentSession().persist(user);
	return true;

}

	public UserRegistration getUserid(Integer id) {
	try {
		return sessionFactory.getCurrentSession().get(UserRegistration.class,id);
	}
	catch(Exception ae)
	{
		System.out.println(ae);
		
	}
		return null;
	}

	public List<UserRegistration> retreiveAllUsers() {
      try {
    	  return sessionFactory.getCurrentSession().createQuery("from UserRegistration",UserRegistration.class).getResultList();
    	  }
      catch(Exception ae)
      {
    	  System.out.println(ae);
      }
		return null;
	}

	public boolean updateUserData(UserRegistration ureg) {
	  try {
		  sessionFactory.getCurrentSession().update(ureg);
		  return true;
	  }
	  catch(Exception ae)
	  {
		  System.out.println(ae);
	  }
		return false;
	}

	public boolean deleteUserData(UserRegistration ure) {
			try
			{
				sessionFactory.getCurrentSession().remove(ure);
				return true;
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		return false;
	}

	public UserRegistration getUserMobile(String mobile) {
		try {
			System.out.println("i am in user mobiel "+mobile);
			return sessionFactory.getCurrentSession().createQuery("from UserRegistration where mobile= :mobile",UserRegistration.class).setParameter("mobile",mobile).getSingleResult();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}

	
}