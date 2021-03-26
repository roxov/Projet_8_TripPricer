package fr.asterox.TripPricer.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.asterox.TripPricer.controller.UserManagementController;
import tripPricer.Provider;
import tripPricer.TripPricer;

@Service
public class TripPricerService {
	@Autowired
	private TripPricer tripPricer;
	@Autowired
	UserManagementController userManagementController;

	private Logger logger = LoggerFactory.getLogger(TripPricerService.class);

	public TripPricerService() {
		super();
	}

	public TripPricerService(TripPricer tripPricer) {
		this.tripPricer = tripPricer;
	}

	public List<Provider> getTripDeals(String userName) {
		int cumulatativeRewardPoints = userManagementController.getUserRewards(userName).stream()
				.mapToInt(i -> i.getRewardPoints()).sum();
		List<Provider> providers = tripPricer.getPrice(tripPricerApiKey, userManagementController.getUserId(userName),
				userManagementController.getUserPreferences(userName).getNumberOfAdults(),
				userManagementController.getUserPreferences(userName).getNumberOfChildren(),
				userManagementController.getUserPreferences(userName).getTripDuration(), cumulatativeRewardPoints);
		userManagementController.setTripDeals(userName, providers);
		return providers;
	}

	private static final String tripPricerApiKey = "test-server-api-key";
}
