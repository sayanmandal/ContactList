package ContactList;


public class PersonalFriend extends Acquaintance{

	private String context;
	private String dateofmeeting;
	private String specialevents;
	public PersonalFriend(String name, String mobNumber, String emailaddress,String context,String dateofmeeting,String specialevents) {
		super(name, mobNumber, emailaddress);
		this.context = context;
		this.dateofmeeting = dateofmeeting;
		this.specialevents = specialevents;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getDateofmeeting() {
		return dateofmeeting;
	}
	public void setDateofmeeting(String dateofmeeting) {
		this.dateofmeeting = dateofmeeting;
	}
	public String getSpecialevents() {
		return specialevents;
	}
	public void setSpecialevents(String specialevents) {
		this.specialevents = specialevents;
	}
}
