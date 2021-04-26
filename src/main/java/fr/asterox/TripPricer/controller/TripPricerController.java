package fr.asterox.TripPricer.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.asterox.TripPricer.service.TripPricerService;
import tripPricer.Provider;

@RestController
public class TripPricerController {
	@Autowired
	TripPricerService tripPricerService;

	private Logger logger = LoggerFactory.getLogger(TripPricerController.class);

	@GetMapping("/getTripDeals")
	public List<Provider> getTripDeals(@RequestParam @NotNull(message = "username is compulsory") String userName) {
		logger.debug("getting trip deals for user :" + userName);
		return tripPricerService.getTripDeals(userName);
	}

}
