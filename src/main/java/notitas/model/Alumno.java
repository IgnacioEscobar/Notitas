package notitas.model;

import com.google.gson.annotations.SerializedName;
import org.uqbar.commons.utils.Observable;
import org.uqbar.commons.utils.Transactional;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.Transient;

@Observable
@Transactional
@Entity
@Table(name = "Alumno")
public class Alumno {
	@Transient
    private static Alumno instancia = new Alumno();
	@Id
	private Long userID;
	@SerializedName("first_name")
    private String nombre;
    @SerializedName("last_name")
    private String apellido;
    @SerializedName("code")
    private Integer legajo;
    @SerializedName("github_user")
    private String usuarioGitHub;
    
    @OneToMany
    @JoinColumn(name = "alumno_id")
    private List<Tarea> tareas;

    public Alumno() {
        tareas = new ArrayList<Tarea>();
    }
    public Alumno(String nombre, String apellido, Integer legajo, String usuarioGitHub, List<Tarea> tareas) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.usuarioGitHub = usuarioGitHub;
        this.tareas = tareas;
    }

    public Alumno(String nombre, String apellido, Integer legajo, String usuarioGitHub) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.usuarioGitHub = usuarioGitHub;
    }

    public static Alumno getInstance() {
        return instancia;
    }

    public static void setInstance(Alumno alumno) {
        instancia = alumno;
    }
    
    public void setUserID(Long userID) {
		this.userID = userID;
	}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getLegajo() {
        return legajo;
    }

    public void setLegajo(Integer legajo) {
        this.legajo = legajo;
    }

    public String getUsuarioGitHub() {
        return usuarioGitHub;
    }

    public void setUsuarioGitHub(String usuarioGitHub) {
        this.usuarioGitHub = usuarioGitHub;
    }

    public List<Tarea> getTareas() {
    	/*
    	EntityManager manager =  PerThreadEntityManagers.getEntityManager();
    	Query query= manager.createNativeQuery("select *\r\n" + 
		 		"from tarea T join alumno A on T.alumno_id = A.id\r\n" + 
		 		"where A.legajo = ?1");	      
		query.setParameter(1, legajo);		 
		List<Tarea> tareas =  query.getResultList();
		*/
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void asignarTarea(Tarea unaTarea) {
        tareas.add(unaTarea);
    }
}
