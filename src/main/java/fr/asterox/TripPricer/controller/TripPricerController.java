package fr.asterox.TripPricer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.asterox.TripPricer.service.TripPricerService;
import tripPricer.Provider;

@RestController
public class TripPricerController {
	@Autowired
	TripPricerService tripPricerService;

	@Autowired
	UserManagementController userManagementController;

	@RequestMapping("/getTripDeals")
	public List<Provider> getTripDeals(@RequestParam String userName) {
		return tripPricerService.getTripDeals(userName);
	}

}
