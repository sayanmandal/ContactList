package ContactList;



public class CasualFriend extends Acquaintance{
	
	private String timeofmeeting;
	private String placeofmeeting;
	private String circumstanceofmeeting;

	public CasualFriend(String name, String mobNumber, String emailaddress,String timeofmeeting,String placeofmeeting,String circumstanceofmeeting) {
		super(name, mobNumber, emailaddress);
		this.timeofmeeting = timeofmeeting;
		this.placeofmeeting = placeofmeeting;
		this.circumstanceofmeeting = circumstanceofmeeting;
	}

	public String getTimeofmeeting() {
		return timeofmeeting;
	}

	public void setTimeofmeeting(String timeofmeeting) {
		this.timeofmeeting = timeofmeeting;
	}

	public String getPlaceofmeeting() {
		return placeofmeeting;
	}

	public void setPlaceofmeeting(String placeofmeeting) {
		this.placeofmeeting = placeofmeeting;
	}

	public String getCircumstanceofmeeting() {
		return circumstanceofmeeting;
	}

	public void setCircumstanceofmeeting(String circumstanceofmeeting) {
		this.circumstanceofmeeting = circumstanceofmeeting;
	}

	
	
}
