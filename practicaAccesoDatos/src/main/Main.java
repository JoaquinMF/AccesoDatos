package main;

import java.util.ArrayList;
import dao.PeliculaDao;
import dao.SalaDao;
import pojo.Pelicula;
import pojo.Sala;



public class Main {
	
	public static void main(String[] args) {
		
	SalaDao salaDao = new SalaDao();
	
	PeliculaDao peliculaDao = new PeliculaDao();
	
	//INSERCION
	System.out.println("INSERCION DE DATOS");
    
	Sala azul = new Sala(2, "11:00 - 20:00", 300);
	
	salaDao.insertar(azul);
	
	azul = salaDao.buscarPorId(1);
	
	Pelicula theAvengers = new Pelicula(1, "The Avengers", 13, "YELMO CINES", azul);
	
	Pelicula theEternals = new Pelicula(2,"The Eternals", 13, "YELMO CINES",azul);
	
	Pelicula suicideSquad = new Pelicula(3,"Suicide Squad",18, "YELMO CINES",azul);
	
	peliculaDao.insertar(theAvengers);
	
	peliculaDao.insertar(theEternals);
	
	peliculaDao.insertar(suicideSquad);
	
	Sala verde =new Sala(3,"15:00 - 02:00",300);
	
	salaDao.insertar(verde);
	
	verde = salaDao.buscarPorId(2);
	
	Pelicula imLegend = new Pelicula(4,"Im Legend",18, "La Cañada", verde);
	
	Pelicula valerianMilPlanetas = new Pelicula(5,"Valerian y la Ciudad de los Mil Planetas",16,"La Cañada",verde);
	
	Pelicula rogueOne = new Pelicula(6,"Starwars: Rogue One",13,"La Cañada",verde);
	
	peliculaDao.insertar(imLegend);
	
	peliculaDao.insertar(valerianMilPlanetas);
	
	peliculaDao.insertar(rogueOne);
	
	System.out.println("Datos insertados");
	
	//Se consultan los datos
    System.out.println("CONSULTA DE DATOS: ");
    
    System.out.println("Salas en la base de datos y sus peliculas: ");
    
    ArrayList<Sala> salas = salaDao.buscarTodos();
    
    for (Sala sala : salas) {
    	
        System.out.println("Sala: "+sala.getNumero());
        
        for (Pelicula pelicula : sala.getPeliculas()) {
        	
            System.out.println("Pelicula: "+pelicula.getTitulo());
        }
    }
    
	//Se modifican los datos
    System.out.println("MODIFICACION DE DATOS:");
    
    theAvengers.setTitulo("The Avengers: Endgame");
    
    peliculaDao.modificar(theAvengers);
    
    Pelicula theAvengersEndGame = peliculaDao.buscarPorId(theAvengers.getId());
    
    System.out.println("Titulo modificado: " + theAvengersEndGame.getTitulo());
    
    azul.setNumero(5);
    
    salaDao.modificar(azul);
    
    System.out.println("Numero modificado: " + azul.getNumero());

	//Se Eliminan datos
    System.out.println("ELIMINACION DE DATOS:");
    
   peliculaDao.borrar(valerianMilPlanetas);
   
   Pelicula valerianMilPlanetasBorrado = peliculaDao.buscarPorId(valerianMilPlanetas.getId());
   
   
    if (valerianMilPlanetasBorrado == null) {
    	
        System.out.println("Pelicula borrada");
        
    } else {
    	
        System.err.println("No se borro la pelicula");
    }
    
    salaDao.borrar(verde);
    
    Sala verdeBorrada = salaDao.buscarPorId(verde.getId());
    
    if (verdeBorrada == null) {
    	
        System.out.println("Se borro la sala");
        
    } else {
    	
        System.err.println("No se borro la sala");
    }
	
	

	}
}