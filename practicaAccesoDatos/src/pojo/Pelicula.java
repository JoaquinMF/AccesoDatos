package pojo;

import java.util.ArrayList;

public class Pelicula {
	
	private int id;
	private String titulo;
	private int edad;
	private String cine;
	private ArrayList<Sala> salas;
	
	public Pelicula(String titulo, int edad, String cine) {
		super();
		this.titulo = titulo;
		this.edad = edad;
		this.cine = cine;
		
	}

	public Pelicula(int id, String titulo, int edad, String cine, ArrayList<Sala> salas) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.edad = edad;
		this.cine = cine;
		this.salas = salas;
	}
	
	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCine() {
		return cine;
	}

	public void setCine(String cine) {
		this.cine = cine;
	}

	public ArrayList<Sala> getSalas() {
		return salas;
	}

	public void setSalas(ArrayList<Sala> salas) {
		this.salas = salas;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", edad=" + edad + ", cine=" + cine + ", salas=" + salas
				+ "]";
	}

	

	
}