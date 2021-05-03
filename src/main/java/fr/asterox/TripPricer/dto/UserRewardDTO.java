package fr.asterox.TripPricer.dto;

public class UserRewardDTO {

	public VisitedLocationDTO visitedLocation;
	public AttractionDTO attraction;
	private int rewardPoints;

	public UserRewardDTO() {
		super();
	}

	public UserRewardDTO(VisitedLocationDTO visitedLocation, AttractionDTO attraction, int rewardPoints) {
		this.visitedLocation = visitedLocation;
		this.attraction = attraction;
		this.rewardPoints = rewardPoints;
	}

	public UserRewardDTO(VisitedLocationDTO visitedLocation, AttractionDTO attraction) {
		this.visitedLocation = visitedLocation;
		this.attraction = attraction;
	}

	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	public int getRewardPoints() {
		return rewardPoints;
	}

}
