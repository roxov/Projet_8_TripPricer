package fr.asterox.TripPricer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("fr.asterox")
public class TripPricerApplication {
	private static final Logger LOGGER = LogManager.getLogger(TripPricerApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Initializing TripPricer");
		SpringApplication.run(TripPricerApplication.class, args);
	}

}
