package com.project.test;

import java.util.ArrayList;
import java.util.List;

import com.project.entity.User;

public class TestDataUser {
	
	public static Object[] provideUsers() {
		User user1 = new User();
		user1.setUserId(1);
		user1.setFirstName("cyril");
		user1.setLastName("kumar");
		user1.setEmployeeId(357494);

		User user2 = new User();
		user2.setUserId(2);
		user2.setFirstName("cyril2");
		user2.setLastName("kumar2");
		user2.setEmployeeId(3574942);

		List<User> userList = new ArrayList<>();
		userList.add(user1);
		userList.add(user2);
		return (new Object[]{
				userList
		}
				);
	}
	
	public static Object[] provideAddUsers() {
		User user1 = new User();
		user1.setUserId(1);
		user1.setFirstName("cyril23");
		user1.setLastName("kumar23");
		user1.setEmployeeId(35749411);

		User user2 = new User();
		user2.setUserId(2);
		user2.setFirstName("cyril25");
		user2.setLastName("kumar25");
		user2.setEmployeeId(35749421);

		return (new Object[]{
				user1,user2
		}
				);
	}
	
	
	public static Object[] provideDelUsers() {
		

		return (new Object[]{
				1,2
		}
				);
	}

	
	public static Object[] provideEditUsers() {
		User user1 = new User();
		user1.setUserId(1);
		user1.setFirstName("cyril23");
		user1.setLastName("kumar23");
		user1.setEmployeeId(35749411);

		User user2 = new User();
		user2.setUserId(2);
		user2.setFirstName("cyril23");
		user2.setLastName("kumar25");
		user2.setEmployeeId(35749421);

		return (new Object[][]{
				{user1,user1.getFirstName()},{user2,user2.getFirstName()}
		}
				);
	}
	
	
	public static Object[] provideUsersForSort() {
		User user1 = new User();
		user1.setUserId(1);
		user1.setFirstName("cyril");
		user1.setLastName("kumar");
		user1.setEmployeeId(357494);

		User user2 = new User();
		user2.setUserId(2);
		user2.setFirstName("cyril2");
		user2.setLastName("kumar2");
		user2.setEmployeeId(3574942);

		List<User> userList = new ArrayList<>();
		userList.add(user1);
		userList.add(user2);
		return (new Object[][]{
				{userList,1},{userList,2},{userList,3}
		}
				);
	}


}
