package dao;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pojo.Pelicula;
import pojo.Sala;


public class SalaDao extends ObjetoDao implements InterfazDao<Sala>{
	
	public static Connection connection;
	
	public SalaDao() {
		
	}
	
	
	@Override
	public Sala buscarPorId(int i) {
		connection = openConnection();
		
		Sala sala=null;
		
		String query = "select * from salas where id = ?";
		
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, i);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				sala = new Sala(rs.getInt("id"),rs.getInt("numero"),rs.getString("horario"),rs.getInt("asientos"),null);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		closeConnection();
		return sala;
	}
	
	@Override
	public void insertar(Sala sala) {
		
		connection = openConnection();
		String query ="insert into series (numero, horario, asientos)"+"values(?,?,?)";
		
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, sala.getNumero());
			ps.setString(2, sala.getHorario());
			ps.setInt(3, sala.getAsientos());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		closeConnection();
		
		
	}

	@Override
	public ArrayList<Sala> buscarTodos() {
		connection = openConnection();
		
		ArrayList<Sala> salas=new ArrayList<>();
		Sala sala=null;
		String query ="select * from salas";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				sala = new Sala(rs.getInt("id"),rs.getInt("numero"),rs.getString("horario"),rs.getInt("asientos"),null);
			
				salas.add(sala);
		}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		closeConnection();
		
		
		return salas;
	}


	
	@Override
	public void modificar(Sala sala) {
		connection = openConnection();
		
		
		int id = sala.getId();
		int numero=sala.getNumero();
		String horario=sala.getHorario();
		int asientos=sala.getAsientos();
		String query ="update series set numero = ?, horario = ?, asientos = ? where id = ?";
		
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			
			ps.setInt(1,numero);
		    ps.setString(2,horario);
		    ps.setInt(3,asientos);
		    ps.setInt(4,id);
		    
		    ps.executeUpdate();
		    
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		closeConnection();
		
	}
	
	public ArrayList<Pelicula> obtenerPeliculas(Sala sala){
		
		ArrayList<Pelicula> peliculas = new ArrayList<>();
		
		connection = openConnection();
		
		String query ="SELECT * FROM peliculas WHERE sala_id = ?";
		
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1,sala.getId());
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Pelicula pelicula =new Pelicula(rs.getInt("id"),rs.getString("titulo"),rs.getInt("edad"),rs.getString("cine"),sala);				
				
				peliculas.add(pelicula);
				
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeConnection();
		
		return peliculas;
		
	}

	@Override
	public void borrar(Sala sala) {
		
		int sala_id=sala.getId();
		
		PeliculaDao peliculaDao=new PeliculaDao();
		peliculaDao.borrarPorSala(sala_id);
		
		connection = openConnection();
		
		String query ="DELETE FROM series WHERE id = ?";
		
	
		try {
			
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, sala_id);
			ps.executeUpdate();
		}catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		closeConnection();
		
		
	}

}
