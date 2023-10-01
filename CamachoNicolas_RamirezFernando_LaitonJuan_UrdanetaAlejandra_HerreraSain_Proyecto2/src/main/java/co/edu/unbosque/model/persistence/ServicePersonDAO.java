package co.edu.unbosque.model.persistence;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.unbosque.controller.DBconnection;
import co.edu.unbosque.model.ServicePersonDTO;
import co.edu.unbosque.model.ServicePersonDTO;
import co.edu.unbosque.util.ServicePersonCRUD;

public class ServicePersonDAO implements ServicePersonCRUD{

	private ArrayList<ServicePersonDTO> servicePersonList;
	private DBconnection dbcon;
	
	public ServicePersonDAO() {
		servicePersonList = new ArrayList();
		dbcon = new DBconnection();
	}

	@Override
	public void create(Object o) {
		// OBJECTS SE PUEDE GUARDAR CUALQUIER TIPO DE CLASE
		ServicePersonDTO temporal = (ServicePersonDTO) o;
		dbcon.initConnection();
		try {
			dbcon.setPreparedStatement(dbcon.getConnect().prepareStatement("INSERT INTO usuario VALUES(?,?,?,?);"));
			// SIGNOS DE PREGUNTA COMODINES, SE PUEDE PONER DATOS.
			dbcon.getPreparedStatement().setInt(1, temporal.getId());
			dbcon.getPreparedStatement().setString(2, temporal.getUsername());
			dbcon.getPreparedStatement().setString(3, temporal.getPassword());
			dbcon.getPreparedStatement().setString(4, temporal.getName());
			dbcon.getPreparedStatement().setDate(5, temporal.getBirthDate());
			dbcon.getPreparedStatement().setInt(6, temporal.getIdentityDoc());
			dbcon.getPreparedStatement().setString(7, temporal.getBirthCity());
			dbcon.getPreparedStatement().setInt(8, temporal.getSalary());
			dbcon.getPreparedStatement().setInt(9, temporal.getCleanedSessions());




			dbcon.getPreparedStatement().executeUpdate();
			dbcon.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		servicePersonList.add((ServicePersonDTO) o);

	}

	@Override
	public void create(String... args) {

		ServicePersonDTO newUser = new ServicePersonDTO(Integer.parseInt(args[0]), args[1], args[2], args[3], 
				Date.valueOf(args[4]), Integer.parseInt(args[5]), args[6], Integer.parseInt(args[7]), Integer.parseInt(args[8]));
		dbcon.initConnection();
		servicePersonList.add(newUser);
	}

	@Override
	public String readAll() {
		String salida = "";
		servicePersonList.clear();
		dbcon.initConnection();
		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultSet(dbcon.getStatement().executeQuery("SELECT * FROM usuario;"));
			while (dbcon.getResultSet().next()) {
				int id = dbcon.getResultSet().getInt("id");
				String username = dbcon.getResultSet().getString("nombreUsuario");
				String password = dbcon.getResultSet().getString("contrasena");
				String name = dbcon.getResultSet().getString("nombre");
				Date birthDate = dbcon.getResultSet().getDate("fechaNacimiento");
				int doc = dbcon.getResultSet().getInt("documentoIdentidad");
				String birthCity = dbcon.getResultSet().getString("ciudadNacimiento");
				int salary = dbcon.getResultSet().getInt("salario");
				int cleanedSessions = dbcon.getResultSet().getInt("sesionesLimpiadas");

				
				servicePersonList.add(new ServicePersonDTO(id, username, password, name, birthDate, doc, birthCity, salary, cleanedSessions));

			}
			dbcon.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (ServicePersonDTO user : servicePersonList) {
			salida += user.toString();

		}
		return salida;
	}

	@Override
	public String readByName(String name) {
		String salida = "";
		for (ServicePersonDTO user : servicePersonList) {
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
					"UPDATE usuario SET id =?,username = ?, password = ?, name = ?, birthDate = ?, identityDoc = ?, birthCity = ?, salary = ?, cleanedSessions = ? WHERE id=?;"));
			// SIGNOS DE PREGUNTA COMODINES, SE PUEDE PONER DATOS.
			dbcon.getPreparedStatement().setInt(1, id);
			dbcon.getPreparedStatement().setString(2, args[0]);
			dbcon.getPreparedStatement().setString(3, args[1]);
			dbcon.getPreparedStatement().setString(4, args[2]);
			dbcon.getPreparedStatement().setDate(5,Date.valueOf(args[3]));
			dbcon.getPreparedStatement().setInt(6,Integer.parseInt( args[4]));
			dbcon.getPreparedStatement().setString(7, args[5]);
			dbcon.getPreparedStatement().setInt(8,Integer.parseInt(args[6]));
			dbcon.getPreparedStatement().setInt(9,Integer.parseInt(args[7]));

			dbcon.getPreparedStatement().executeUpdate();
			dbcon.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < servicePersonList.size(); i++) {
			if (servicePersonList.get(i).getId() == id) {
				servicePersonList.get(i).setUsername(args[0]);
				servicePersonList.get(i).setPassword(args[1]);
				servicePersonList.get(i).setName(args[2]);
				servicePersonList.get(i).setBirthDate(Date.valueOf(args[3]));
				servicePersonList.get(i).setIdentityDoc(Integer.parseInt( args[4]));
				servicePersonList.get(i).setBirthCity(args[5]);
				servicePersonList.get(i).setSalary(Integer.parseInt( args[6]));
				servicePersonList.get(i).setCleanedSessions(Integer.parseInt( args[7]));
				return 0;
			}
		}

		return 1;

	}

	@Override
	public int deleteById(int id) {
		dbcon.initConnection();
		try {
			dbcon.setPreparedStatement(dbcon.getConnect().prepareStatement("DELETE FROM usuario WHERE id =?;"));
			// SIGNOS DE PREGUNTA COMODINES, SE PUEDE PONER DATOS.
			dbcon.getPreparedStatement().setInt(1, id);
			dbcon.getPreparedStatement().executeUpdate();
			dbcon.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < servicePersonList.size(); i++) {
			if (servicePersonList.get(i).getId() == id) {
				servicePersonList.remove(i);
				return 0;
			}
		}
		return 1;
	}

	public DBconnection getDbcon() {
		return dbcon;
	}

	public void setDbcon(DBconnection dbcon) {
		this.dbcon = dbcon;
	}

	public ArrayList<ServicePersonDTO> getServicePersonList() {
		return servicePersonList;
	}

	public void setServicePersonList(ArrayList<ServicePersonDTO> servicePersonList) {
		this.servicePersonList = servicePersonList;
	}
}
