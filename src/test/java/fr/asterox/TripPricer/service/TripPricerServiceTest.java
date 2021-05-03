package fr.asterox.TripPricer.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.asterox.TripPricer.dto.AttractionDTO;
import fr.asterox.TripPricer.dto.UserPreferencesDTO;
import fr.asterox.TripPricer.dto.UserRewardDTO;
import fr.asterox.TripPricer.dto.VisitedLocationDTO;
import fr.asterox.TripPricer.proxy.UserManagementProxy;
import tripPricer.Provider;
import tripPricer.TripPricer;

@ExtendWith(MockitoExtension.class)
public class TripPricerServiceTest {

	@Mock
	UserManagementProxy userManagementProxy;

	@Mock
	TripPricer tripPricer;

	@InjectMocks
	TripPricerService tripPricerService;

	@Test
	public void givenAUser_whenGetTripDeals_thenReturnAListOfFiveProviders() {
		// GIVEN
		UUID userId = UUID.fromString("329e4bf3-ee62-4a67-b7d7-b0dc06989c6e");
		UserPreferencesDTO userPreferences = new UserPreferencesDTO();

		AttractionDTO attraction = new AttractionDTO("name", "city", "state", 144, 155);
		when(tripPricer.getPrice(anyString(), any(UUID.class), anyInt(), anyInt(), anyInt(), anyInt()))
				.thenReturn(new TripPricer().getPrice("riendutout", userId, 1, 0, 1, 1000));
		when(userManagementProxy.getUserRewards("jon")).thenReturn(
				List.of(new UserRewardDTO(new VisitedLocationDTO(userId, attraction, new Date()), attraction)));
		when(userManagementProxy.getUserId("jon")).thenReturn(userId);
		when(userManagementProxy.getUserPreferences("jon")).thenReturn(userPreferences);
		doNothing().when(userManagementProxy).setTripDeals(eq("jon"), anyList());

		// WHEN
		List<Provider> providers = tripPricerService.getTripDeals("jon");

		// THEN
		verify(userManagementProxy, Mockito.times(1)).getUserId(anyString());
		verify(userManagementProxy, Mockito.times(3)).getUserPreferences(anyString());
		verify(userManagementProxy, Mockito.times(1)).setTripDeals(anyString(), anyList());
		assertEquals(5, providers.size());
	}
}
