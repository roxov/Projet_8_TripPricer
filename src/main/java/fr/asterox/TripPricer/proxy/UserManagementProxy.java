package fr.asterox.TripPricer.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.asterox.TripPricer.DTO.User;

@FeignClient(name = "UserManagement", url = "localhost:9001")
public interface UserManagementProxy {

	@RequestMapping("/getUser")
	public User getUser(@RequestParam String userName);
}
