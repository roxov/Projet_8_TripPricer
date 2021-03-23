package fr.asterox.TripPricer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.asterox.TripPricer.DTO.User;
import fr.asterox.TripPricer.proxy.UserManagementProxy;

@RestController
public class UserManagementController {
	@Autowired
	UserManagementProxy userManagementProxy;

	@RequestMapping("/getUser")
	public User getUser(@RequestParam String userName) {
		return userManagementProxy.getUser(userName);
	}
}
