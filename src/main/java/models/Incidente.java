package models;
import jakarta.persistence.*;

@Entity
@Table(name="incidentes")
public class Incidente {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="tipoIncidente")
	private String tipoIncidente;
	
	@Column(name="descripcionIncidente")
	private String descripcionIncidente;
	
	@Column(name="idCliente")
	private int idCliente;
	
	@Column(name="idTecnico")
	private int idTecnico;
	
	public Incidente() {
		super();
	}

	public Incidente(String tipoIncidente, String descripciónIncidente) {
		super();
		this.tipoIncidente = tipoIncidente;
		this.descripcionIncidente = descripciónIncidente;
	}

	public Incidente(String tipoIncidente, String descripcionIncidente, int idCliente, int idTecnico) {
		super();
		this.tipoIncidente = tipoIncidente;
		this.descripcionIncidente = descripcionIncidente;
		this.idCliente = idCliente;
		this.idTecnico = idTecnico;
	}

	public Incidente(int id, String tipoIncidente, String descripcionIncidente, int idCliente, int idTecnico) {
		super();
		this.id = id;
		this.tipoIncidente = tipoIncidente;
		this.descripcionIncidente = descripcionIncidente;
		this.idCliente = idCliente;
		this.idTecnico = idTecnico;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoIncidente() {
		return tipoIncidente;
	}

	public void setTipoIncidente(String tipoIncidente) {
		this.tipoIncidente = tipoIncidente;
	}

	public String getDescripcionIncidente() {
		return descripcionIncidente;
	}

	public void setDescripcionIncidente(String descripcionIncidente) {
		this.descripcionIncidente = descripcionIncidente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdTecnico() {
		return idTecnico;
	}

	public void setIdTecnico(int idTecnico) {
		this.idTecnico = idTecnico;
	}
	
	
		
}