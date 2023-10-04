package co.edu.unbosque.model.persistence;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.unbosque.controller.DBconnection;
import co.edu.unbosque.model.AdministratorDTO;
import co.edu.unbosque.model.AlcoholicDTO;
import co.edu.unbosque.util.AdministratorCRUD;

public class AdministratorDAO implements AdministratorCRUD {

	private ArrayList<AdministratorDTO> administratorList;
	private DBconnection dbcon;

	public AdministratorDAO() {
		administratorList = new ArrayList();
		dbcon = new DBconnection();
		read();
	}

	@Override
	public void create(Object o) {
		// OBJECTS SE PUEDE GUARDAR CUALQUIER TIPO DE CLASE
		AdministratorDTO temporal = (AdministratorDTO) o;
		dbcon.initConnection();
		try {
			dbcon.setPreparedStatement(dbcon.getConnect().prepareStatement("INSERT INTO administrador VALUES(?,?,?,?,?,?,?);"));
			// SIGNOS DE PREGUNTA COMODINES, SE PUEDE PONER DATOS.
			dbcon.getPreparedStatement().setInt(1, temporal.getId());
			dbcon.getPreparedStatement().setString(2, temporal.getUsername());
			dbcon.getPreparedStatement().setString(3, temporal.getPassword());
			dbcon.getPreparedStatement().setString(4, temporal.getName());
			dbcon.getPreparedStatement().setDate(5, temporal.getBirthDate());
			dbcon.getPreparedStatement().setInt(6, temporal.getIdentityDoc());
			dbcon.getPreparedStatement().setString(7, temporal.getBirthCity());



			dbcon.getPreparedStatement().executeUpdate();
			dbcon.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		administratorList.add((AdministratorDTO) o);


	}

	@Override
	public void create(String... args) {

		AdministratorDTO newUser = new AdministratorDTO(Integer.parseInt(args[0]), args[1], args[2], args[3], 
				Date.valueOf(args[4]), Integer.parseInt(args[5]), args[6]);
		dbcon.initConnection();
		administratorList.add(newUser);

	}

	@Override
	public String readAll() {
		String salida = "";
		administratorList.clear();
		dbcon.initConnection();
		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultSet(dbcon.getStatement().executeQuery("SELECT * FROM administrador;"));
			while (dbcon.getResultSet().next()) {
				int id = dbcon.getResultSet().getInt("id");
				String username = dbcon.getResultSet().getString("username");
				String password = dbcon.getResultSet().getString("password");
				String name = dbcon.getResultSet().getString("name");
				Date birthDate = dbcon.getResultSet().getDate("fechanacimiento");
				int doc = dbcon.getResultSet().getInt("cedula");
				String birthCity = dbcon.getResultSet().getString("ciudadnacimiento");
				
				administratorList.add(new AdministratorDTO(id, username, password, name, birthDate, doc, birthCity));

			}
			dbcon.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (AdministratorDTO user : administratorList) {
			salida += user.toString();

		}
		return salida;
	}

	@Override
	public String readByName(String name) {
		String salida = "";
		for (AdministratorDTO user : administratorList) {
			if (user.getName().equals(name)) {
				salida += user.toString();
			}
		}
		return salida;

	}

	@Override
	public int updateById(int id, String... args) {
		dbcon.initConnection();
		try {
			dbcon.setPreparedStatement(dbcon.getConnect().prepareStatement(
					"UPDATE administrador SET id =?,username = ?, password = ?, name = ?, fechanacimiento = ?, cedula = ?, ciudadnacimiento = ? WHERE id=?;"));
			// SIGNOS DE PREGUNTA COMODINES, SE PUEDE PONER DATOS.
			dbcon.getPreparedStatement().setInt(1, id);
			dbcon.getPreparedStatement().setString(2, args[0]);
			dbcon.getPreparedStatement().setString(3, args[1]);
			dbcon.getPreparedStatement().setString(4, args[2]);
			dbcon.getPreparedStatement().setDate(5,Date.valueOf(args[3]));
			dbcon.getPreparedStatement().setInt(6,Integer.parseInt( args[4]));
			dbcon.getPreparedStatement().setString(7, args[5]);
			dbcon.getPreparedStatement().executeUpdate();
			dbcon.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < administratorList.size(); i++) {
			if (administratorList.get(i).getId() == id) {
				administratorList.get(i).setUsername(args[0]);
				administratorList.get(i).setPassword(args[1]);
				administratorList.get(i).setName(args[2]);
				administratorList.get(i).setBirthDate(Date.valueOf(args[3]));
				administratorList.get(i).setIdentityDoc(Integer.parseInt( args[4]));
				administratorList.get(i).setBirthCity(args[5]);

				return 0;
			}
		}

		return 1;

	}

	@Override
	public int deleteById(int id) {
		dbcon.initConnection();
		try {
			dbcon.setPreparedStatement(dbcon.getConnect().prepareStatement("DELETE FROM administrador WHERE id =?;"));
			// SIGNOS DE PREGUNTA COMODINES, SE PUEDE PONER DATOS.
			dbcon.getPreparedStatement().setInt(1, id);
			dbcon.getPreparedStatement().executeUpdate();
			dbcon.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < administratorList.size(); i++) {
			if (administratorList.get(i).getId() == id) {
				administratorList.remove(i);
				return 0;
			}
		}
		return 1;
	}
	
	public boolean validate(String username, String password) {
		for (AdministratorDTO a : administratorList) {
			if (a.getUsername().equals(username)) {
				if (a.getPassword().equals(password)) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}
	
	public void read() {
		administratorList.clear();
		dbcon.initConnection();
		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultSet(dbcon.getStatement().executeQuery("SELECT * FROM administrador"));
			while (dbcon.getResultSet().next()) {
				int id = dbcon.getResultSet().getInt("id");
				String username = dbcon.getResultSet().getString("username");
				String password = dbcon.getResultSet().getString("password");
				String name = dbcon.getResultSet().getString("name");
				Date birthDate = dbcon.getResultSet().getDate("fechanacimiento");
				int doc = dbcon.getResultSet().getInt("cedula");
				String birthCity = dbcon.getResultSet().getString("ciudadnacimiento");
				
				administratorList.add(new AdministratorDTO(id, username, password, name, birthDate, doc, birthCity));

			}
			dbcon.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public ArrayList<AdministratorDTO> getAdministratorList() {
		return administratorList;
	}

	public void setAdministratorList(ArrayList<AdministratorDTO> administratorList) {
		this.administratorList = administratorList;
	}

	public DBconnection getDbcon() {
		return dbcon;
	}

	public void setDbcon(DBconnection dbcon) {
		this.dbcon = dbcon;
	}
	
}