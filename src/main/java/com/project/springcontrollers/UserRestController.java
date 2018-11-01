package com.project.springcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//import com.exception.ResourceNotFoundException;
import com.project.entity.User;
import com.project.service.UserService;

@RestController
@RequestMapping("/user")
public class UserRestController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/addUser",
			method = RequestMethod.POST,produces = "application/json")
	 @ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public List<User> addUser(@RequestBody User user){
		return userService.addUser(user);
	}
	
	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE,produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<User> deleteUser(@PathVariable("id") long userId){
		return userService.deleteUser(userId);
	}
	
	@RequestMapping(value = "/editUser/{id}", method = RequestMethod.PUT,produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<User> editUser(@PathVariable("id") long userId,@RequestBody User user) {
		return userService.editUser(userId, user);
	}

	@RequestMapping(value = "/viewUsers",
			method = RequestMethod.GET,produces = "application/json")
	 @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<User> viewUsers() {
		return userService.viewUsers();
	}
	
	@RequestMapping(value = "/sortUsers/{sorttype}",
			method = RequestMethod.GET,produces = "application/json")
	 @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<User> sortUsers(@PathVariable("sorttype") long sortType) {
		return userService.sortUsers(sortType);
	}

}
