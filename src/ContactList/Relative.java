package ContactList;

public class Relative extends Acquaintance {
	private String birthday;
	private String dateoflastmeeting;
	
	public Relative(String name, String mobNumber, String emailaddress,String birthday,String dateoflastmeeting) {
		super(name, mobNumber, emailaddress);
		this.birthday = birthday;
		this.dateoflastmeeting = dateoflastmeeting;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getDateoflastmeeting() {
		return dateoflastmeeting;
	}

	public void setDateoflastmeeting(String dateoflastmeeting) {
		this.dateoflastmeeting = dateoflastmeeting;
	}
	
	
	
}
