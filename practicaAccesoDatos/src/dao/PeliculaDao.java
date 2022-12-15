package dao;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pojo.Pelicula;
import pojo.Sala;

public class PeliculaDao extends ObjetoDao implements InterfazDao<Pelicula> {

	public static Connection connection;
	
	public PeliculaDao() {
		
	}
	
	@Override
	public ArrayList<Pelicula> buscarTodos() {
		
		connection = openConnection();
		
		ArrayList<Pelicula> peliculas=new ArrayList<>();
		Pelicula pelicula=null;
		String query ="select * from peliculas";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				pelicula = new Pelicula(rs.getInt("id"),rs.getString("titulo"),rs.getInt("edad"),rs.getString("cine"),null);
			
				peliculas.add(pelicula);
		}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		closeConnection();
		
		
		return peliculas;
	}

	@Override
	public Pelicula buscarPorId(int i) {
		
		connection = openConnection();
		
		Pelicula pelicula=null;
		
		String query = "select * from peliculas where id = ?";
		
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, i);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				pelicula = new Pelicula(rs.getInt("id"),rs.getString("titulo"),rs.getInt("edad"),rs.getString("cine"),null);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		closeConnection();
		return pelicula;
	}

	@Override
	public void insertar(Pelicula pelicula) {
		
		connection = openConnection();
		String query ="insert into series (titulo, edad, cine, sala_id)"+"values(?,?,?,?)";
		
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1, pelicula.getTitulo());
			ps.setInt(2, pelicula.getEdad());
			ps.setString(3, pelicula.getCine());
			ps.setInt(4,pelicula.getSala().getId());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		closeConnection();
		
		
	}

	@Override
	public void modificar(Pelicula pelicula) {
		
		connection = openConnection();
		
		
		int id = pelicula.getId();
		String titulo=pelicula.getTitulo();
		int edad=pelicula.getEdad();
		String cine=pelicula.getCine();
		Sala sala=pelicula.getSala();
		String query ="update series set titulo = ?, edad = ?, cine = ?, sala_id where id = ?";
		
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			
			ps.setInt(1,numero);
		    ps.setString(2,horario);
		    ps.setInt(3,asientos);
		    ps.setInt(5, id);
		    
		    ps.executeUpdate();
		    
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		closeConnection();
		
		
		
	}

	@Override
	public void borrar(Pelicula t) {
		
		
	}

	
	
	
}