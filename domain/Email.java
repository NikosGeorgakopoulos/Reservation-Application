package domain;
public class Email {
	private String FullMail;
	private String Domain;
	private String Address;
	
	String[] parts;
	
	public Email(String mail){
		setFullMail(mail);
		Breakparts();
		setDomain(parts[1]);
		setAddress(parts[0]);
	}
	
	public void Breakparts(){
		parts = FullMail.split("@");
	}
	
	public String getDomain() {
		return Domain;
	}
	public void setDomain(String domain) {
		Domain = domain;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getFullMail() {
		return FullMail;
	}
	public void setFullMail(String fullMail) {
		FullMail = fullMail;
	}
	
	
}
