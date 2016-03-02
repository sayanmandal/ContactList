package ContactList;

import java.io.Serializable;

public class Acquaintance implements Serializable{
	
	private String name;
	private String mobnumber;
	private String email;
	public Acquaintance(String name, String mobnumber, String email) {
		super();
		this.name = name;
		this.mobnumber = mobnumber;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobNumber() {
		return mobnumber;
	}
	public void setMobnumber(String mobnumber) {
		this.mobnumber = mobnumber;
	}
	public String getEmailaddress() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Acquaintance [name=" + name + ", mobnumber=" + mobnumber + ", email=" + email + "]";
	}
	

}
