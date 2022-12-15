package pojo;

import java.util.ArrayList;

public class Sala {
	
	private int id;
	private int numero;
	private String horario;
	private int asientos;
	private ArrayList<Pelicula> peliculas;
	
	public Sala(int numero, String horario, int asientos, ArrayList<Pelicula> peliculas) {
		super();
		this.numero = numero;
		this.horario = horario;
		this.asientos = asientos;
		this.peliculas = peliculas;
	}

	public Sala(int id, int numero, String horario, int asientos, ArrayList<Pelicula> peliculas) {
		super();
		this.id = id;
		this.numero = numero;
		this.horario = horario;
		this.asientos = asientos;
		this.peliculas = peliculas;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}


	public int getAsientos() {
		return asientos;
	}

	public void setNumeroAsientos(int asientos) {
		this.asientos = asientos;
	}

	public ArrayList<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPelicula(ArrayList<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Sala [id=" + id + ", numero=" + numero + ", horario=" + horario + ", asientos=" + asientos
				+ ", peliculas=" + peliculas + "]";
	}
	

}