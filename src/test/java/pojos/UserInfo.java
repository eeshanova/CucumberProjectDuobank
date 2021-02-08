package pojos;

public class UserInfo {
	
	
	private String first;
	private String last;
	private String email;
	private String dateOfBirth;
	private String sSN;
	private String cellPhone;
	
	
	
	
	
	public UserInfo(String first, String last, String email, String dateOfBirth, String sSN, String cellPhone) {
		super();
		this.first = first;
		this.last = last;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.sSN = sSN;
		this.cellPhone = cellPhone;
	}





	public String getFirst() {
		return first;
	}





	public void setFirst(String first) {
		this.first = first;
	}





	public String getLast() {
		return last;
	}





	public void setLast(String last) {
		this.last = last;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public String getDateOfBirth() {
		return dateOfBirth;
	}





	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}





	public String getsSN() {
		return sSN;
	}





	public void setsSN(String sSN) {
		this.sSN = sSN;
	}





	public String getCellPhone() {
		return cellPhone;
	}





	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}





	@Override
	public String toString() {
		return "UserInfo [first=" + first + ", last=" + last + ", email=" + email + ", dateOfBirth=" + dateOfBirth
				+ ", sSN=" + sSN + ", cellPhone=" + cellPhone + "]";
	}
	

	
	
	
	
}


