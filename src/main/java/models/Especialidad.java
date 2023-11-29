package models;
import jakarta.persistence.*;

@Entity
@Table(name="especialidades")
public class Especialidad {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="tipoEspecialidad")
	private String tipoEspecialidad;
	
	public Especialidad() {
		super();
	}

	public Especialidad(String tipoEspecialidad) {
		super();
		this.tipoEspecialidad = tipoEspecialidad;
	}

	public Especialidad(int id, String tipoEspecialidad) {
		super();
		this.id = id;
		this.tipoEspecialidad = tipoEspecialidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipoEspecialidad;
	}

	public void setTipo(String tipoEspecialidad) {
		this.tipoEspecialidad = tipoEspecialidad;
	}
	
	
}
