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
		
		String query ="select * from peliculas";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
			Pelicula pelicula = new Pelicula(rs.getInt("id"),rs.getString("titulo"),rs.getInt("edad"),rs.getString("cine"),null);
			
			
			String query_sala = "select * from salas where id = ?";
            PreparedStatement ps_sala = connection.prepareStatement(query_sala);
            ps_sala.setInt(1, rs.getInt("id")); 
            ResultSet rs_sala = ps_sala.executeQuery();
            
            while(rs_sala.next()) {

                Sala sala = new Sala(rs_sala.getInt("id"),rs_sala.getInt("numero"),rs_sala.getString("horario"),rs_sala.getInt("asientos"),peliculas);

                 if(rs_sala.getInt("id") == rs.getInt("id")) {
                     pelicula.setSala(sala); 
                 }
             }
            peliculas.add(pelicula);
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		closeConnection();
		
		return peliculas;
	}

	@Override
	public Pelicula buscarPorId(int id) {
		
		connection = openConnection();
		String query = "select * from peliculas where id = ?";
		Pelicula pelicula=null;
		
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				int sala_id = rs.getInt("salas_id");
                Sala sala = null;
                
                String query_sala = "select * from salas where id = ?";
                PreparedStatement ps_sala= connection.prepareStatement(query_sala);
                ps_sala.setInt(1, sala_id); 
                ResultSet rs_sala = ps_sala.executeQuery();
                
                while(rs_sala.next()) {
                	sala = new Sala(
                			rs_sala.getInt("id"), 
                			rs_sala.getInt("numero"), 
                			rs_sala.getString("horario"),
                			rs_sala.getInt("asientos"),
                			null
                	);
                }
                pelicula = new Pelicula(
                		rs.getInt("id"), 
                		rs.getString("titulo"),
                		rs.getInt("edad"),
                		rs.getString("cine"), 
                		sala
                );
                
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
		String query ="insert into peliculas (titulo, edad, cine, salas_id) values (?,?,?,?)";
		
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
		String tituloNuevo=pelicula.getTitulo();
		int edadNueva=pelicula.getEdad();
		String cineNuevo=pelicula.getCine();
		Sala sala=pelicula.getSala();
		String query ="update peliculas set titulo = ?, edad = ?, cine = ?, salas_id = ? where id = ?";
		
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			
			ps.setString(1,tituloNuevo);
		    ps.setInt(2,edadNueva);
		    ps.setString(3,cineNuevo);
		    ps.setInt(4,sala.getId());
		    ps.setInt(5, id);
		    ps.executeUpdate();
		    
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		closeConnection();
		
		
		
	}

	@Override
	public void borrar(Pelicula peliculas) {
		
		connection=openConnection();
		
		int id=peliculas.getId();
		
		String query="DELETE FROM peliculas WHERE id = ?";
		
		try {
			PreparedStatement ps= connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
				
		closeConnection();	
		
		
	}

	
	public void borrarPorSala (int sala_id) {
		
		connection=openConnection();
		
		String query = "DELETE FROM peliculas WHERE salas_id=?";
		
		try {
			
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, sala_id);
			ps.executeUpdate();
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		closeConnection();
		
		
		
	}
	
	
	
}