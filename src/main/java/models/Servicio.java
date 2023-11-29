package models;
import jakarta.persistence.*;

@Entity
@Table(name="servicios")
public class Servicio {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombreServicio")
	private String nombreServicio;
	
	public Servicio() {
		super();
	}

	public Servicio(String nombreServicio) {
		super();
		this.nombreServicio = nombreServicio;
	}

	public Servicio(int id, String nombreServicio) {
		super();
		this.id = id;
		this.nombreServicio = nombreServicio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}
	
	
}

