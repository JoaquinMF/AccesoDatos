package pojo;

public class Pelicula {
	
	private int id;
	private String titulo;
	private int edad;
	private String cine;
	private Sala sala;
	
	public Pelicula(String titulo, int edad, String cine, Sala sala) {
		super();
		this.titulo = titulo;
		this.edad = edad;
		this.cine = cine;
		this.sala=sala;
		
	}

	public Pelicula(int id, String titulo, int edad, String cine, Sala sala) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.edad = edad;
		this.cine = cine;
		this.sala= sala;
	}
	
	public Pelicula (int id, String titulo, int edad, String cine) {
		this.id = id;
		this.titulo = titulo;
		this.edad = edad;
		this.cine = cine;
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", edad=" + edad + ", cine=" + cine + ", sala=" + sala
				+ "]";
	}

	
}