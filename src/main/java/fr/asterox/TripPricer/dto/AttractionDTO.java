package fr.asterox.TripPricer.dto;

import java.util.UUID;

public class AttractionDTO extends LocationDTO {
	public String attractionName;
	public String city;
	public String state;
	public UUID attractionId;

	public AttractionDTO(String attractionName, String city, String state, double latitude, double longitude) {
		super(latitude, longitude);
		this.attractionName = attractionName;
		this.city = city;
		this.state = state;
		this.attractionId = UUID.randomUUID();
	}
}
