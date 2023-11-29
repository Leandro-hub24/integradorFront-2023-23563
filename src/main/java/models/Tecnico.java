package models;
import jakarta.persistence.*;

@Entity
@Table(name="tecnicos")
public class Tecnico {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="incidentesResueltos")
	private int incidentesResueltos;
	
	public Tecnico() {
		super();
	}
	
	
	
	public Tecnico(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}



	public Tecnico(String nombre, String apellido, int incidentesResueltos) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.incidentesResueltos = incidentesResueltos;
	}

	public Tecnico(int id, String nombre, String apellido, int incidentesResueltos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.incidentesResueltos = incidentesResueltos;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getIncidentesResueltos() {
		return incidentesResueltos;
	}

	public void setIncidentesResueltos(int incidentesResueltos) {
		this.incidentesResueltos = incidentesResueltos;
	}
	
}