package pojo;

public class Sala {
	
	private int id;
	private int numero;
	private String horario;
	private String vose;
	private int numeroAsientos;
	private Pelicula pelicula;
	
	public Sala(int numero, String horario, String vose, int numeroAsientos, Pelicula pelicula) {
		super();
		this.numero = numero;
		this.horario = horario;
		this.vose = vose;
		this.numeroAsientos = numeroAsientos;
		this.pelicula = pelicula;
	}

	public Sala(int id, int numero, String horario, String vose, int numeroAsientos, Pelicula pelicula) {
		super();
		this.id = id;
		this.numero = numero;
		this.horario = horario;
		this.vose = vose;
		this.numeroAsientos = numeroAsientos;
		this.pelicula = pelicula;
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

	public String getVose() {
		return vose;
	}

	public void setVose(String vose) {
		this.vose = vose;
	}

	public int getNumeroAsientos() {
		return numeroAsientos;
	}

	public void setNumeroAsientos(int numeroAsientos) {
		this.numeroAsientos = numeroAsientos;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Sala [id=" + id + ", numero=" + numero + ", horario=" + horario + ", vose=" + vose + ", numeroAsientos="
				+ numeroAsientos + ", pelicula=" + pelicula + "]";
	}
	
	
	
	
	

}
