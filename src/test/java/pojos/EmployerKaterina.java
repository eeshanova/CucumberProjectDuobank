package pojos;

public class EmployerKaterina {
	
	private String employer;
	private String position;
	private String city;
	private String state;
	private String startDate;
	private String monthlyIncome;
	
	public EmployerKaterina(String employer, String position, String city, String state, String startDate,
			String monthlyIncome) {
		super();
		this.employer = employer;
		this.position = position;
		this.city = city;
		this.state = state;
		this.startDate = startDate;
		this.monthlyIncome = monthlyIncome;
	}
	
	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(String monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	@Override
	public String toString() {
		return "EmployerKaterina [employer=" + employer + ", position=" + position + ", city=" + city + ", state="
				+ state + ", startDate=" + startDate + ", monthlyIncome=" + monthlyIncome + "]";
	}
	
	
	
	
}
