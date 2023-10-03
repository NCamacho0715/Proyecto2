package co.edu.unbosque.model;

import java.sql.Date;

public class AdministratorDTO extends PersonDTO{

	public AdministratorDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public AdministratorDTO(int id, String username, String password, String name, Date birthDate, int identityDoc,
			String birthCity) {
		super(id, username, password, name, birthDate, identityDoc, birthCity);
		// TODO Auto-generated constructor stub
	}

}