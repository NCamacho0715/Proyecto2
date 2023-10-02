package co.edu.unbosque.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnection {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private final String IP = "35.239.57.35";
	private final String PORT = "3306";
	private final String DATABASE = "ramirezFernando";
	private final String USERNAME = "programacion2diegorodriguezcloud";
	private final String PASSWORD = "progaramacion2";

	public DBconnection() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Connection getConnect() {
		return connect;
	}



	public void setConnect(Connection connect) {
		this.connect = connect;
	}



	public Statement getStatement() {
		return statement;
	}



	public void setStatement(Statement statement) {
		this.statement = statement;
	}



	public PreparedStatement getPreparedStatement() {
		return preparedStatement;
	}



	public void setPreparedStatement(PreparedStatement preparedStatement) {
		this.preparedStatement = preparedStatement;
	}



	public ResultSet getResultSet() {
		return resultSet;
	}



	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}



	public String getIP() {
		return IP;
	}



	public String getPORT() {
		return PORT;
	}



	public String getDATABASE() {
		return DATABASE;
	}



	public String getUSERNAME() {
		return USERNAME;
	}



	public String getPASSWORD() {
		return PASSWORD;
	}



	public void initConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connect = DriverManager.getConnection("jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE, USERNAME,
					PASSWORD);
			System.out.println("Conexion realizada con exito.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void close() {
		try {

			if (resultSet != null) {
				resultSet.close();
				;
			}
			if (statement != null) {
				statement.close();
			}
			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
