package models;
import jakarta.persistence.*;

@Entity
@Table(name="clientes")
public class Cliente {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="cuit")
	private int cuit;
	
	@Column(name="razonSocial")
	private String razonSocial;
	
	
	public Cliente() {
		super();
	}	

	public Cliente(String nombre, String apellido, int cuit, String razonSocial) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuit = cuit;
		this.razonSocial = razonSocial;
	}

	public Cliente(int id, String nombre, String apellido, int cuit, String razonSocial) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuit = cuit;
		this.razonSocial = razonSocial;
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

	public int getCuit() {
		return cuit;
	}

	public void setCuit(int cuit) {
		this.cuit = cuit;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	
}
