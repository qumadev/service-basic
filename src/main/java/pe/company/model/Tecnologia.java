package pe.company.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="tecnologias")
public class Tecnologia implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tecnologiaId;
	
	@Column
	private String nombre;
	
	@Temporal(TemporalType.DATE)
	private Date fregistro;
	
	@ManyToMany(mappedBy="itemsTecnologia", cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	private Set<Instructor> itemsInstructor = new HashSet<>();
	
	public Tecnologia() {}

	public Tecnologia(Tecnologia tecnologia) {
		this(tecnologia.getTecnologiaId(), tecnologia.getNombre(), tecnologia.getFregistro());
	}
	
	public Tecnologia(Integer tecnologiaId, String nombre, Date fregistro)
	{
		this.tecnologiaId = tecnologiaId;
		this.nombre = nombre;
		this.fregistro = fregistro;
	}

	@PrePersist
	public void prePersist() {
		fregistro=new Date();
	}

	public Integer getTecnologiaId() {
		return tecnologiaId;
	}

	public void setTecnologiaId(Integer tecnologiaId) {
		this.tecnologiaId = tecnologiaId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFregistro() {
		return fregistro;
	}

	public void setFregistro(Date fregistro) {
		this.fregistro = fregistro;
	}

	public Set<Instructor> getItemsInstructor() {
		return itemsInstructor;
	}

	public void setItemsInstructor(Set<Instructor> itemsInstructor) {
		this.itemsInstructor = itemsInstructor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
