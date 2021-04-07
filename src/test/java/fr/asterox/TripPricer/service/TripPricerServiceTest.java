package fr.asterox.TripPricer.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.asterox.TripPricer.controller.UserManagementController;
import fr.asterox.TripPricer.dto.UserRewardDTO;
import gpsUtil.GpsUtil;
import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;
import tripPricer.Provider;
import tripPricer.TripPricer;

@ExtendWith(MockitoExtension.class)
public class TripPricerServiceTest {

	@Mock
	UserManagementController userManagementController;

	TripPricerService tripPricerService;
	GpsUtil gpsUtil;

	@BeforeEach
	public void setUp() {
		Locale.setDefault(Locale.US);
		gpsUtil = new GpsUtil();
		TripPricer tripPricer = new TripPricer();
		tripPricerService = new TripPricerService(tripPricer);
	}

//TODO
	@Test
	public void givenAUser_whenGetTripDeals_thenReturnAListOfFiveProviders() {
		// GIVEN
		UUID userId = UUID.randomUUID();
		Attraction attraction = gpsUtil.getAttractions().get(0);

		when(userManagementController.getUserRewards("jon")).thenReturn(
				List.of(new UserRewardDTO(new VisitedLocation(userId, attraction, new Date()), attraction)));
		when(userManagementController.getUserId("jon")).thenReturn(userId);
		when(userManagementController.getUserPreferences("jon").getNumberOfAdults()).thenReturn(1);
		when(userManagementController.getUserPreferences("jon").getNumberOfChildren()).thenReturn(0);
		when(userManagementController.getUserPreferences("jon").getTripDuration()).thenReturn(1);
		doNothing().when(userManagementController).setTripDeals("jon", anyList());

		// WHEN
		List<Provider> providers = tripPricerService.getTripDeals("jon");

		// THEN
		verify(userManagementController, Mockito.times(1)).getUserId(anyString());
		verify(userManagementController, Mockito.times(3)).getUserPreferences(anyString());
		verify(userManagementController, Mockito.times(1)).setTripDeals(anyString(), anyList());
		assertEquals(5, providers.size());
	}

}
