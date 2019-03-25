package com.kurtas.designerkurtas.dao;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kurtas.designerkurtas.model.UserRegistration;



@Component
public interface UserDao {
	public boolean newUserData(UserRegistration  user); 
public UserRegistration getUserid(Integer id);
public UserRegistration getUserMobile(String mobile);
public List<UserRegistration> retreiveAllUsers();
public boolean updateUserData(UserRegistration ureg);
public boolean deleteUserData(UserRegistration ure);

	}


