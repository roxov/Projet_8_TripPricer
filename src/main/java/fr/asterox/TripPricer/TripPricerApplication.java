package fr.asterox.TripPricer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("fr.asterox")
public class TripPricerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripPricerApplication.class, args);
	}

}
