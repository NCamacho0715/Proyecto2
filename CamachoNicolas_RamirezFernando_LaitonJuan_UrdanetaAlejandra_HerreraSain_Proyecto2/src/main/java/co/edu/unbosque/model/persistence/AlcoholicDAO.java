package co.edu.unbosque.model.persistence;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.unbosque.controller.DBconnection;
import co.edu.unbosque.model.AlcoholicDTO;
import co.edu.unbosque.util.AlcoholicCRUD;

public class AlcoholicDAO implements AlcoholicCRUD {

	private ArrayList<AlcoholicDTO> alcoholicList;
	private DBconnection dbcon;

	public AlcoholicDAO() {
		alcoholicList = new ArrayList();
		dbcon = new DBconnection();
	}

	@Override
	public void create(Object o) {
		// OBJECTS SE PUEDE GUARDAR CUALQUIER TIPO DE CLASE
		AlcoholicDTO temporal = (AlcoholicDTO) o;
		dbcon.initConnection();
		try {
			dbcon.setPreparedStatement(dbcon.getConnect().prepareStatement("INSERT INTO alcoholico VALUES(?,?,?,?,?,?,?,?,?);"));
			// SIGNOS DE PREGUNTA COMODINES, SE PUEDE PONER DATOS.
			dbcon.getPreparedStatement().setInt(1, temporal.getId());
			dbcon.getPreparedStatement().setString(2, temporal.getUsername());
			dbcon.getPreparedStatement().setString(3, temporal.getPassword());
			dbcon.getPreparedStatement().setString(4, temporal.getName());
			dbcon.getPreparedStatement().setDate(5, temporal.getBirthDate());
			dbcon.getPreparedStatement().setInt(6, temporal.getIdentityDoc());
			dbcon.getPreparedStatement().setString(7, temporal.getBirthCity());
			dbcon.getPreparedStatement().setInt(8, temporal.getParticipatedSessions());
			dbcon.getPreparedStatement().setString(9, temporal.getNickname());


			dbcon.getPreparedStatement().executeUpdate();
			dbcon.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		alcoholicList.add((AlcoholicDTO) o);

	}

	@Override
	public void create(String... args) {

		AlcoholicDTO newUser = new AlcoholicDTO(Integer.parseInt(args[0]), args[1], args[2], args[3], 
				Date.valueOf(args[4]), Integer.parseInt(args[5]), args[6], Integer.parseInt(args[7]), args[8]);
		dbcon.initConnection();
		alcoholicList.add(newUser);
	}

	@Override
	public String readAll() {
		String salida = "";
		alcoholicList.clear();
		dbcon.initConnection();
		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultSet(dbcon.getStatement().executeQuery("SELECT * FROM alcoholico;"));
			while (dbcon.getResultSet().next()) {
				int id = dbcon.getResultSet().getInt("id");
				String username = dbcon.getResultSet().getString("username");
				String password = dbcon.getResultSet().getString("password");
				String name = dbcon.getResultSet().getString("name");
				Date birthDate = dbcon.getResultSet().getDate("fechanacimiento");
				int doc = dbcon.getResultSet().getInt("cedula");
				String birthCity = dbcon.getResultSet().getString("ciudadnacimiento");
				int participatedSessions = dbcon.getResultSet().getInt("sesionesparticipadas");
				String nickname = dbcon.getResultSet().getString("apodo");
				
				alcoholicList.add(new AlcoholicDTO(id, username, password, name, birthDate, doc, birthCity, participatedSessions, nickname));

			}
			dbcon.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (AlcoholicDTO user : alcoholicList) {
			salida += user.toString();

		}
		return salida;
	}

	@Override
	public String readByName(String name) {
		String salida = "";
		for (AlcoholicDTO user : alcoholicList) {
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
					"UPDATE alcoholico SET id =?,username = ?, password = ?, name = ?, fechanacimiento = ?, cedula = ?, ciudadnacimiento = ?, sesionesparticipadas = ?, apodo = ? WHERE id=?;"));
			// SIGNOS DE PREGUNTA COMODINES, SE PUEDE PONER DATOS.
			dbcon.getPreparedStatement().setInt(1, id);
			dbcon.getPreparedStatement().setString(2, args[0]);
			dbcon.getPreparedStatement().setString(3, args[1]);
			dbcon.getPreparedStatement().setString(4, args[2]);
			dbcon.getPreparedStatement().setDate(5,Date.valueOf(args[3]));
			dbcon.getPreparedStatement().setInt(6,Integer.parseInt( args[4]));
			dbcon.getPreparedStatement().setString(7, args[5]);
			dbcon.getPreparedStatement().setInt(8,Integer.parseInt(args[6]));
			dbcon.getPreparedStatement().setString(9, args[7]);
			dbcon.getPreparedStatement().executeUpdate();
			dbcon.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < alcoholicList.size(); i++) {
			if (alcoholicList.get(i).getId() == id) {
				alcoholicList.get(i).setUsername(args[0]);
				alcoholicList.get(i).setPassword(args[1]);
				alcoholicList.get(i).setName(args[2]);
				alcoholicList.get(i).setBirthDate(Date.valueOf(args[3]));
				alcoholicList.get(i).setIdentityDoc(Integer.parseInt( args[4]));
				alcoholicList.get(i).setBirthCity(args[5]);
				alcoholicList.get(i).setParticipatedSessions(Integer.parseInt( args[6]));
				alcoholicList.get(i).setNickname(args[7]);
				return 0;
			}
		}

		return 1;

	}

	@Override
	public int deleteById(int id) {
		dbcon.initConnection();
		try {
			dbcon.setPreparedStatement(dbcon.getConnect().prepareStatement("DELETE FROM alcoholico WHERE id =?;"));
			// SIGNOS DE PREGUNTA COMODINES, SE PUEDE PONER DATOS.
			dbcon.getPreparedStatement().setInt(1, id);
			dbcon.getPreparedStatement().executeUpdate();
			dbcon.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < alcoholicList.size(); i++) {
			if (alcoholicList.get(i).getId() == id) {
				alcoholicList.remove(i);
				return 0;
			}
		}
		return 1;
	}

	public ArrayList<AlcoholicDTO> getAlcoholicList() {
		return alcoholicList;
	}

	public void setAlcoholicList(ArrayList<AlcoholicDTO> alcoholicList) {
		this.alcoholicList = alcoholicList;
	}

	public DBconnection getDbcon() {
		return dbcon;
	}

	public void setDbcon(DBconnection dbcon) {
		this.dbcon = dbcon;
	}
	
}
