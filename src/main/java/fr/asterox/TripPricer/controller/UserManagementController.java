package fr.asterox.TripPricer.controller;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.asterox.TripPricer.dto.UserPreferencesDTO;
import fr.asterox.TripPricer.dto.UserRewardDTO;
import fr.asterox.TripPricer.proxy.UserManagementProxy;
import tripPricer.Provider;

@RestController
public class UserManagementController {
	@Autowired
	UserManagementProxy userManagementProxy;

	private Logger logger = LoggerFactory.getLogger(UserManagementController.class);

	@RequestMapping("/getUserId")
	public UUID getUserId(@RequestParam String userName) {
		logger.debug("sending request to UserManagement microservice to get userId of user :" + userName);
		return userManagementProxy.getUserId(userName);
	}

	@RequestMapping("/getUserPreferences")
	public UserPreferencesDTO getUserPreferences(@RequestParam String userName) {
		logger.debug("sending request to UserManagement microservice to get user preferences of user :" + userName);
		return userManagementProxy.getUserPreferences(userName);
	}

	@RequestMapping("/getUserRewards")
	public List<UserRewardDTO> getUserRewards(@RequestParam String userName) {
		logger.debug("sending request to UserManagement microservice to get user rewards of user :" + userName);
		return userManagementProxy.getUserRewards(userName);
	}

	@RequestMapping("/setTripDeals")
	public void setTripDeals(@RequestParam String userName, @RequestBody List<Provider> providers) {
		logger.debug("sending request to UserManagement microservice to set Trip Deals of user :" + userName);
		userManagementProxy.setTripDeals(userName, providers);
	}
}
