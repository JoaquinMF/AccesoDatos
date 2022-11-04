package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Temporada;
import util.DatabaseConnection;

public class TemporadaDao extends ObjetoDao implements InterfazDao<Temporada> {
	
	private static Connection connection;
	
	public TemporadaDao() {
		
		
	}
	
	@Override
	public ArrayList<Temporada> buscarTodos() {
		
		return null;
	}

	@Override
	public Temporada buscarPorId(int i) {
		
		return null;
	}

	@Override
	public void insertar(Temporada temporada) {
		
		connection = openConnection();
		String query ="insert into temporadas (num_temporada, titulo, serie_id)"+"values(?,?,?)";
		
		
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, temporada.getNum_temporadas());
			ps.setString(2, temporada.getTitulo());
			ps.setInt(3, temporada.getSerie().getId());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
		
	}

	@Override
	public void modificar(Temporada t) {
		
		
	}

	@Override
	public void borrar(Temporada t) {
		
		
		
	}
	
	

}
