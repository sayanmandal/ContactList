package ContactList;


public class ProfessionalFriend extends Acquaintance{
	
	private String CommonInterest;

	public ProfessionalFriend(String name, String mobNumber, String emailaddress,String CommonInterest) {
		super(name, mobNumber, emailaddress);
		this.CommonInterest = CommonInterest;
	}

	public String getCommonInterest() {
		return CommonInterest;
	}

	public void setCommonInterest(String commonInterest) {
		CommonInterest = commonInterest;
	}

	
}
