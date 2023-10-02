package co.edu.unbosque.model.persistence;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.unbosque.controller.DBconnection;
import co.edu.unbosque.model.PsychologistDTO;
import co.edu.unbosque.model.PsychologistDTO;
import co.edu.unbosque.util.PsychologistCRUD;

public class PsychologistDAO implements PsychologistCRUD{

	private ArrayList<PsychologistDTO> psychologistList;
	private DBconnection dbcon;
	
	public PsychologistDAO() {
		psychologistList = new ArrayList();
		dbcon = new DBconnection();
	}

	@Override
	public void create(Object o) {
		// OBJECTS SE PUEDE GUARDAR CUALQUIER TIPO DE CLASE
		PsychologistDTO temporal = (PsychologistDTO) o;
		dbcon.initConnection();
		try {
			dbcon.setPreparedStatement(dbcon.getConnect().prepareStatement("INSERT INTO psicologo VALUES(?,?,?,?,?,?,?,?,?,?,?);"));
			// SIGNOS DE PREGUNTA COMODINES, SE PUEDE PONER DATOS.
			dbcon.getPreparedStatement().setInt(1, temporal.getId());
			dbcon.getPreparedStatement().setString(2, temporal.getUsername());
			dbcon.getPreparedStatement().setString(3, temporal.getPassword());
			dbcon.getPreparedStatement().setString(4, temporal.getName());
			dbcon.getPreparedStatement().setDate(5, temporal.getBirthDate());
			dbcon.getPreparedStatement().setInt(6, temporal.getIdentityDoc());
			dbcon.getPreparedStatement().setString(7, temporal.getBirthCity());
			
			dbcon.getPreparedStatement().setDate(8, temporal.getGraduationDate());

			dbcon.getPreparedStatement().setInt(9, temporal.getServiceDays());
			dbcon.getPreparedStatement().setInt(10, temporal.getSupportedSessions());
			dbcon.getPreparedStatement().setInt(11, temporal.getSalary());


			dbcon.getPreparedStatement().executeUpdate();
			dbcon.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		psychologistList.add((PsychologistDTO) o);

	}

	@Override
	public void create(String... args) {

		PsychologistDTO newUser = new PsychologistDTO(Integer.parseInt(args[0]), args[1], args[2], args[3], 
				Date.valueOf(args[4]), Integer.parseInt(args[5]), args[6],Date.valueOf(args[7]), Integer.parseInt(args[8]), Integer.parseInt(args[9]), Integer.parseInt(args[10]));
		dbcon.initConnection();
		psychologistList.add(newUser);
	}

	@Override
	public String readAll() {
		String salida = "";
		psychologistList.clear();
		dbcon.initConnection();
		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultSet(dbcon.getStatement().executeQuery("SELECT * FROM psicologo;"));
			while (dbcon.getResultSet().next()) {
				int id = dbcon.getResultSet().getInt("id");
				String username = dbcon.getResultSet().getString("username");
				String password = dbcon.getResultSet().getString("password");
				String name = dbcon.getResultSet().getString("name");
				Date birthDate = dbcon.getResultSet().getDate("fechanacimiento");
				int doc = dbcon.getResultSet().getInt("cedula");
				String birthCity = dbcon.getResultSet().getString("ciudadnacimiento");
				Date fechagraduacion = dbcon.getResultSet().getDate("fechagraduacion");
				int diasservicio  = dbcon.getResultSet().getInt("diasservicio");
				int sesionesapoyadas = dbcon.getResultSet().getInt("sesionesapoyadas");
				int salario = dbcon.getResultSet().getInt("salario");


				psychologistList.add(new PsychologistDTO(id, username, password, name, birthDate, doc, birthCity, fechagraduacion, diasservicio, sesionesapoyadas, salario));

			}
			dbcon.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (PsychologistDTO user : psychologistList) {
			salida += user.toString();

		}
		return salida;
	}

	@Override
	public String readByName(String name) {
		String salida = "";
		for (PsychologistDTO user : psychologistList) {
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
					"UPDATE alcoholico SET id =?,username = ?, password = ?, name = ?, fechanacimiento = ?, cedula = ?, ciudadnacimiento = ?, fechagraduacion = ?, diasservicio = ?, sesionesapoyadas = ?, salario = ? WHERE id=?;"));
			// SIGNOS DE PREGUNTA COMODINES, SE PUEDE PONER DATOS.
			dbcon.getPreparedStatement().setInt(1, id);
			dbcon.getPreparedStatement().setString(2, args[0]);
			dbcon.getPreparedStatement().setString(3, args[1]);
			dbcon.getPreparedStatement().setString(4, args[2]);
			dbcon.getPreparedStatement().setDate(5,Date.valueOf(args[3]));
			dbcon.getPreparedStatement().setInt(6,Integer.parseInt( args[4]));
			dbcon.getPreparedStatement().setString(7, args[5]);
			dbcon.getPreparedStatement().setDate(8,Date.valueOf(args[6]));
			dbcon.getPreparedStatement().setInt(9,Integer.parseInt( args[7]));
			dbcon.getPreparedStatement().setInt(10,Integer.parseInt( args[8]));
			dbcon.getPreparedStatement().setInt(11,Integer.parseInt( args[9]));



			dbcon.getPreparedStatement().executeUpdate();
			dbcon.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < psychologistList.size(); i++) {
			if (psychologistList.get(i).getId() == id) {
				psychologistList.get(i).setUsername(args[0]);
				psychologistList.get(i).setPassword(args[1]);
				psychologistList.get(i).setName(args[2]);
				psychologistList.get(i).setBirthDate(Date.valueOf(args[3]));
				psychologistList.get(i).setIdentityDoc(Integer.parseInt( args[4]));
				psychologistList.get(i).setBirthCity(args[5]);
				psychologistList.get(i).setGraduationDate(Date.valueOf(args[6]));
				psychologistList.get(i).setServiceDays(Integer.parseInt( args[7]));
				psychologistList.get(i).setSupportedSessions(Integer.parseInt( args[8]));
				psychologistList.get(i).setSalary(Integer.parseInt( args[9]));



				return 0;
			}
		}

		return 1;

	}

	@Override
	public int deleteById(int id) {
		dbcon.initConnection();
		try {
			dbcon.setPreparedStatement(dbcon.getConnect().prepareStatement("DELETE FROM psicologo WHERE id =?;"));
			// SIGNOS DE PREGUNTA COMODINES, SE PUEDE PONER DATOS.
			dbcon.getPreparedStatement().setInt(1, id);
			dbcon.getPreparedStatement().executeUpdate();
			dbcon.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < psychologistList.size(); i++) {
			if (psychologistList.get(i).getId() == id) {
				psychologistList.remove(i);
				return 0;
			}
		}
		return 1;
	}

	public ArrayList<PsychologistDTO> getPsychologistList() {
		return psychologistList;
	}

	public void setPsychologistList(ArrayList<PsychologistDTO> psychologistList) {
		this.psychologistList = psychologistList;
	}

	public DBconnection getDbcon() {
		return dbcon;
	}

	public void setDbcon(DBconnection dbcon) {
		this.dbcon = dbcon;
	}


}
