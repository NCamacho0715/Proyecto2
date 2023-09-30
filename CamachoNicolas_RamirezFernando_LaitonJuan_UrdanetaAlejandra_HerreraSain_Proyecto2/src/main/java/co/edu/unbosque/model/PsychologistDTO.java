package co.edu.unbosque.model;

import java.sql.Date;

public class PsychologistDTO extends PersonDTO {

	private Date graduationDate;
	private int serviceDays;
	private int supportedSessions;
	private int salary;

	public PsychologistDTO() {
		// TODO Auto-generated constructor stub
	}

	public PsychologistDTO(Date graduationDate, int serviceDays, int supportedSessions, int salary) {
		super();
		this.graduationDate = graduationDate;
		this.serviceDays = serviceDays;
		this.supportedSessions = supportedSessions;
		this.salary = salary;
	}

	public Date getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(Date graduationDate) {
		this.graduationDate = graduationDate;
	}

	public int getServiceDays() {
		return serviceDays;
	}

	public void setServiceDays(int serviceDays) {
		this.serviceDays = serviceDays;
	}

	public int getSupportedSessions() {
		return supportedSessions;
	}

	public void setSupportedSessions(int supportedSessions) {
		this.supportedSessions = supportedSessions;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Psychologist [graduationDate=" + graduationDate + ", serviceDays=" + serviceDays
				+ ", supportedSessions=" + supportedSessions + ", salary=" + salary + "]";
	}
}
