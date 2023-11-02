package pe.company.model;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;


@Entity
@Table(name="instructores")
public class Instructor implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int instructorID;
	@Column
	private String nombre;
	@Column
	private String apellidos;
	@Column
	private String password;
	@Column(unique = true,nullable = false)
	private String email;
	@Temporal(TemporalType.DATE)
	private Date fregistro;

	@OneToOne(mappedBy = "instructor")
	private Conyuge conyuge;

	@OneToMany(mappedBy = "instructor")
	private Collection<Taller> itemsTaller = new ArrayList<>();

	@ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "instructores_tecnologias",
	joinColumns = @JoinColumn(name = "instructor_id",nullable = false,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(instructor_id) references instructores(instructor_id)")),
	inverseJoinColumns = @JoinColumn(name = "tecnologia_id",nullable = false,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(tecnologia_id) references tecnologias(tecnologia_id)")))
	private Set<Tecnologia> itemsTecnologia = new HashSet<>();
	
	public Instructor() {
		super();
	}

	public Instructor(Instructor instructor) {
		this(instructor.getInstructorID(),instructor.getNombre(),instructor.getApellidos()
				,instructor.getPassword(),instructor.getEmail(),instructor.getFregistro());
	}
	
	public Instructor(int instructorID, String nombre, String apellidos, String password, String email,
			Date fregistro) {
		super();
		this.instructorID = instructorID;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.password = password;
		this.email = email;
		this.fregistro = fregistro;
	}

	@PrePersist
	public void prePersist() {
		this.fregistro=new Date();
	}

	public int getInstructorID() {
		return instructorID;
	}

	public void setInstructorID(int instructorID) {
		this.instructorID = instructorID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFregistro() {
		return fregistro;
	}

	public void setFregistro(Date fregistro) {
		this.fregistro = fregistro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
