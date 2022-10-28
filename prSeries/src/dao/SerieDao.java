package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Serie;
import util.DatabaseConnection;

public class SerieDao implements Dao<Serie> {
	
	private static Connection connection;
	
	public SerieDao() {
		
		
	}

	@Override
	public ArrayList<Serie> buscarTodos() {
		
		return null;
	}

	@Override
	public Serie buscarPorId(int i) {
	
		return null;
	}

	@Override
	public void insertar(Serie t) {
	
		
	}

	@Override
	public void modificar(Serie serie) {
		
		connection = openConnection();
		String query ="insert into series (titulo, edad, plataforma)"+"values(?,?,?)";
		
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1, serie.getTitulo());
			ps.setInt(2, serie.getEdad());
			ps.setString(3, serie.getPlataforma());
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void borrar(Serie t) {
		
		
	}
	
	private static Connection openConnection() {
		DatabaseConnection dbConnection=new DatabaseConnection();
		connection =dbConnection.getConnection();
		return connection;
	}
	
	private static void closeConnection() {
		
		try {
			connection.close();
			connection=null;
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	

}
