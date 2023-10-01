package co.edu.unbosque.model;

import java.sql.Date;

public class PersonDTO {

	private int id;
	private String username;
	private String password;
	private String name;
	private Date birthDate;
	private int identityDoc;
	private String birthCity;

	public PersonDTO() {
		// TODO Auto-generated constructor stub
	}

	public PersonDTO(int id, String username, String password, String name, Date birthDate, int identityDoc,
			String birthCity) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.birthDate = birthDate;
		this.identityDoc = identityDoc;
		this.birthCity = birthCity;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public int getIdentityDoc() {
		return identityDoc;
	}

	public void setIdentityDoc(int identityDoc) {
		this.identityDoc = identityDoc;
	}

	public String getBirthCity() {
		return birthCity;
	}

	public void setBirthCity(String birthCity) {
		this.birthCity = birthCity;
	}

	@Override
	public String toString() {
		return "PersonDTO [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", birthDate=" + birthDate + ", identityDoc=" + identityDoc + ", birthCity=" + birthCity + "]";
	}
}
