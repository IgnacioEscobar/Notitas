package notitas.model;

import com.google.gson.annotations.SerializedName;
import org.uqbar.commons.utils.Observable;
import org.uqbar.commons.utils.Transactional;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Observable
@Transactional
@Entity
@Table(name = "Alumno")
public class Alumno extends PersistentObject {
	@Transient
    private static Alumno instancia = new Alumno();
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
    public Alumno(String nombre, Integer legajo, String usuarioGitHub, List<Tarea> tareas) {
        super();
        this.nombre = nombre;
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
