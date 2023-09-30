package co.edu.unbosque.model;

public class ServicePersonDTO extends PersonDTO {

	private int salary;
	private int cleanedSessions;

	public ServicePersonDTO() {
		// TODO Auto-generated constructor stub
	}

	public ServicePersonDTO(int salary, int cleanedSessions) {
		super();
		this.salary = salary;
		this.cleanedSessions = cleanedSessions;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getCleanedSessions() {
		return cleanedSessions;
	}

	public void setCleanedSessions(int cleanedSessions) {
		this.cleanedSessions = cleanedSessions;
	}

	@Override
	public String toString() {
		return "ServicePerson [salary=" + salary + ", cleanedSessions=" + cleanedSessions + "]";
	}
}
