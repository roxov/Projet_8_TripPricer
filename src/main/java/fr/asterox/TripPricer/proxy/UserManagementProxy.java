package fr.asterox.TripPricer.proxy;

import java.util.List;
import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import fr.asterox.TripPricer.dto.UserPreferencesDTO;
import fr.asterox.TripPricer.dto.UserRewardDTO;
import tripPricer.Provider;

@FeignClient(name = "UserManagement", url = "localhost:9001")
public interface UserManagementProxy {

	@GetMapping("/getUserId")
	public UUID getUserId(@RequestParam String userName);

	@GetMapping("/getUserPreferences")
	public UserPreferencesDTO getUserPreferences(@RequestParam String userName);

	@GetMapping("/getUserRewards")
	public List<UserRewardDTO> getUserRewards(@RequestParam String userName);

	@PostMapping("/setTripDeals")
	public void setTripDeals(@RequestParam String userName, @RequestBody List<Provider> providers);
}
