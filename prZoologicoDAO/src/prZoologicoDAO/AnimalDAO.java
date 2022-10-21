package prZoologicoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class AnimalDAO {
	
	private static Connection connection;
	
	public static void uptateAnimal (Animal animal) {
		connection = openConnection();
		
		
		int id = animal.getId();
		String nombre=animal.getNombre();
		String habitat=animal.getHabitat();
		double pesoAproximado=animal.getPeso_aproximado();
		String query ="update animal set nombre = ?, habitat = ?, peso_aproximado=? where id = ?";
		
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			
			ps.setString(1,nombre);
		    ps.setString(2,habitat);
		    ps.setDouble(3,pesoAproximado);
		    ps.setInt(4, id);
		    
		    ps.executeUpdate();
		    
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		closeConnection();
		
	}
	
	
	
	public static ArrayList<Animal> findAllAnimales(){
		connection = openConnection();
		
		ArrayList<Animal> animales=new ArrayList<>();
		Animal animal=null;
		String query ="select * from animales";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
			animal = new Animal(rs.getInt("id"),rs.getString("nombre"),rs.getString("habitat"),rs.getDouble("peso_aproximado"));
			
			animales.add(animal);
		}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
		
		
		return animales;
	}
	
	
	public static Animal findById(int id) {
		
		connection = openConnection();
		
		String query = "select * from animales where id = ?";
		Animal animal=null;
		
		try {
			PreparedStatement ps= connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				animal = new Animal(rs.getInt("id"),rs.getString("nombre"),rs.getString("habitat"),rs.getDouble("peso_aproximado"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		
		return animal;
		
	}
	
	public static void deleteAnimalByNombre (String nombre) {
		
		connection =openConnection();
		
		String query = "delete from animales where nombre = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, nombre);
			ps.executeUpdate();
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		closeConnection();
	
	}
		
	
	public static void deleteAllAnimales() {
		
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
