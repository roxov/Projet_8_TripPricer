package fr.asterox.TripPricer.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.asterox.TripPricer.proxy.UserManagementProxy;
import tripPricer.Provider;
import tripPricer.TripPricer;

@Service
public class TripPricerService implements ITripPricerService {
	@Autowired
	private TripPricer tripPricer;

	@Autowired
	UserManagementProxy userManagementProxy;

	private Logger logger = LoggerFactory.getLogger(TripPricerService.class);

	public TripPricerService() {
		super();
	}

	@Override
	public List<Provider> getTripDeals(String userName) {
		int cumulatativeRewardPoints = userManagementProxy.getUserRewards(userName).stream()
				.mapToInt(i -> i.getRewardPoints()).sum();

		logger.debug("getting providers from tripPricer for the preferences of user :" + userName);

		List<Provider> providers = tripPricer.getPrice(tripPricerApiKey, userManagementProxy.getUserId(userName),
				userManagementProxy.getUserPreferences(userName).getNumberOfAdults(),
				userManagementProxy.getUserPreferences(userName).getNumberOfChildren(),
				userManagementProxy.getUserPreferences(userName).getTripDuration(), cumulatativeRewardPoints);

		userManagementProxy.setTripDeals(userName, providers);

		return providers;
	}

	private static final String tripPricerApiKey = "test-server-api-key";
}
