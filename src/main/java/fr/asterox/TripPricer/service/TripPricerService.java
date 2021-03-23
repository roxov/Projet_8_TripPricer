package fr.asterox.TripPricer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.asterox.TripPricer.DTO.User;
import tripPricer.Provider;
import tripPricer.TripPricer;

@Service
public class TripPricerService {
	private final TripPricer tripPricer = new TripPricer();

	public List<Provider> getTripDeals(User user) {
		int cumulatativeRewardPoints = user.getUserRewards().stream().mapToInt(i -> i.getRewardPoints()).sum();
		List<Provider> providers = tripPricer.getPrice(tripPricerApiKey, user.getUserId(),
				user.getUserPreferences().getNumberOfAdults(), user.getUserPreferences().getNumberOfChildren(),
				user.getUserPreferences().getTripDuration(), cumulatativeRewardPoints);
		user.setTripDeals(providers);
		return providers;
	}

	private static final String tripPricerApiKey = "test-server-api-key";
}
