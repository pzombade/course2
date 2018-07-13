package com.course.course.dao.firebase;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.firebase.webhooks.dominospizza.Users;

@Component
@Repository("FakeUsersDaoImpl")
public class FakeUsersDaoImpl implements UsersDao {
	
	private static final Map<String,Users> users;
	
	static {
		users = new HashMap<String,Users>();
		users.put("111", new Users("111","Narendra","Modi"));
		users.put("222", new Users("222","Donald","Trump"));
	}
	

	@Override
	public Users getUser(String number) {
		return users.get(number);
	}

	@Override
	public Collection<Users> getUser() {
		return users.values();
	}

	@Override
	public String addUser(Users user) {
		users.put(user.getId(), user);
		return user.getId();
	}

	@Override
	public String deleteUser(String number) {
		users.remove(number);
		return number;
	}
}
