package fr.asterox.TripPricer.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.asterox.TripPricer.dto.UserPreferences;
import fr.asterox.TripPricer.dto.UserReward;
import fr.asterox.TripPricer.proxy.UserManagementProxy;
import tripPricer.Provider;

@RestController
public class UserManagementController {
	@Autowired
	UserManagementProxy userManagementProxy;

	@RequestMapping("/getUserId")
	public UUID getUserId(@RequestParam String userName) {
		return userManagementProxy.getUserId(userName);
	}

	@RequestMapping("/getUserPreferences")
	public UserPreferences getUserPreferences(@RequestParam String userName) {
		return userManagementProxy.getUserPreferences(userName);
	}

	@RequestMapping("/getUserRewards")
	public List<UserReward> getUserRewards(@RequestParam String userName) {
		return userManagementProxy.getUserRewards(userName);
	}

	@RequestMapping("/setTripDeals")
	public void setTripDeals(@RequestParam String userName, @RequestBody List<Provider> providers) {
		userManagementProxy.setTripDeals(userName, providers);
	}
}
