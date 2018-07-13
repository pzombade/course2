package com.course.course.dao.firebase;

import java.util.Collection;

import com.firebase.webhooks.dominospizza.Users;


public interface UsersDao {
	public Users getUser(String number);
	public Collection<Users> getUser();
	public String addUser(Users user);
	public String deleteUser(String number);
}
