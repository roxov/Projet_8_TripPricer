package fr.asterox.TripPricer.service;

import java.util.Locale;

import org.junit.jupiter.api.BeforeEach;

import tripPricer.TripPricer;

public class TripPricerServiceTest {
	TripPricerService tripPricerService;

	@BeforeEach
	public void setUp() {
		Locale.setDefault(Locale.US);
		TripPricer tripPricer = new TripPricer();
		tripPricerService = new TripPricerService(tripPricer);
	}

//	public void givenAUser_whenGetTripDeals_thenReturnAListOfTenProviders() {
//		// GIVEN
//		User user = new User(UUID.randomUUID(), "jon", "000", "jon@tourGuide.com");
//
//		// WHEN
//		List<Provider> providers = tripPricerService.getTripDeals(userName);
//
//		userManagementService.tracker.stopTracking();
//
//		// THEN
//		assertEquals(10, providers.size());
//	}

}
