package prZoologicoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AnimalDAO {
	
	private static Connection connection;
	
	
	public static void deleteAnimal() {
		
		connection =openConnection();
		
		String query = "delete from animales";
		
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
		}catch (SQLException e){
			
			e.printStackTrace();
			
		}
		
		closeConnection();
		
	}
	
	public static void insertAnimal(Animal animal) {
		
		connection=openConnection();
		
		String query =("insert into animales (nombre, habitat, peso_aproximado) values (?,?,?)");
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1,animal.getNombre());
			preparedStatement.setString(2, animal.getHabitat());
			preparedStatement.setDouble(3, animal.getPeso_aproximado());
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		closeConnection();
		
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
