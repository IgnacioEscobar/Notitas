package model;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;

@Observable
public class Alumno {
	private static Alumno instancia = new Alumno();
	

	public static Alumno getInstance() {
		return instancia;
	}
	
	private String nombre;
	private Integer legajo;
	private String usuarioGitHub;
	private List<Tarea> tareas;

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
	
	public void asignarTarea(Tarea unaTarea) {
		tareas.add(unaTarea);
	}
}
