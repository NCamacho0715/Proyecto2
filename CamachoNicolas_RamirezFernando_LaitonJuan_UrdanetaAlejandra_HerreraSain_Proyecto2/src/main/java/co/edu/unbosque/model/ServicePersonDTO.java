package co.edu.unbosque.model;

import java.sql.Date;

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
	public ServicePersonDTO(int id, String username, String password, String name, Date birthDate, int identityDoc,
			String birthCity) {
		super(id, username, password, name, birthDate, identityDoc, birthCity);
		// TODO Auto-generated constructor stub
	}
	public ServicePersonDTO(int id, String username, String password, String name, Date birthDate, int identityDoc,
			String birthCity, int salary, int cleanedSessions) {
		super(id, username, password, name, birthDate, identityDoc, birthCity);
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
