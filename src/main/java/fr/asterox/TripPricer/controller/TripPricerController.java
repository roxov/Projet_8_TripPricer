package fr.asterox.TripPricer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsoniter.output.JsonStream;

import fr.asterox.TripPricer.service.TripPricerService;
import tripPricer.Provider;

@RestController
public class TripPricerController {
	@Autowired
	TripPricerService tripPricerService;

	@Autowired
	UserManagementController userManagementController;

	@RequestMapping("/getTripDeals")
	public String getTripDeals(@RequestParam String userName) {
		List<Provider> providers = tripPricerService.getTripDeals(userManagementController.getUser(userName));
		return JsonStream.serialize(providers);
	}

//	@RequestMapping("/getRewards")
//	public String getRewards(@RequestParam String userName) {
//		return usersManagementProxy.getRewards(userName);
//	}
}
