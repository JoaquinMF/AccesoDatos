package main;

import java.util.ArrayList;

import dao.SerieDao;
import dao.TemporadaDao;
import pojo.Serie;
import pojo.Temporada;

public class Main {

	public static void main(String[] args) {
		
		//Serie serie =new Serie("Los Simpsons",7,"Disney Plus");
		
		SerieDao serieDao=new SerieDao();
		
		//serieDao.insertar(serie);
		
		//System.out.println(serieDao.buscarPorId(1));
		
		//Serie serie=serieDao.buscarPorId(1);
		//System.out.println(serie);
		//Temporada t1=new Temporada(1,"Temporada 1",serie);
		//Temporada t2=new Temporada(2,"Temporada 2",serie);
		
		//TemporadaDao temporadaDao =new TemporadaDao();
		//temporadaDao.insertar(t1);
		//temporadaDao.insertar(t2);
		
		ArrayList<Serie> series= serieDao.buscarTodos();
		
		Serie los_simpson=serieDao.buscarPorId(1);
		los_simpson.setPlataforma("Netflix");
		serieDao.modificar(los_simpson);
		
		for(Serie serie : series) {
		System.out.println(series);
		}
		
		
		
		
	}

}
