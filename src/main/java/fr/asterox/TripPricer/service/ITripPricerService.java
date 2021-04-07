package fr.asterox.TripPricer.service;

import java.util.List;

import tripPricer.Provider;

/**
 * 
 * Microservice finding deals according to the user's preferences.
 *
 */
public interface ITripPricerService {
	public List<Provider> getTripDeals(String userName);
}
