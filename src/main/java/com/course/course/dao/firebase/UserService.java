package com.course.course.dao.firebase;


import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.firebase.webhooks.dominospizza.Users;

@Resource
@Component
public class UserService {
	
	
	private UsersDao dao;
	
	public UserService(@Qualifier("FakeUsersDaoImpl") UsersDao d) {
		dao = d;
	}


	public Users getUser(String number) {
		return dao.getUser(number);
	}

	public Collection<Users> getAllUsers() {
		return dao.getUser();
	}

	public String addUser(Users user) {
		return dao.addUser(user);
	}

	public String deleteUser(String number) {
		return dao.deleteUser(number);
	}
}

