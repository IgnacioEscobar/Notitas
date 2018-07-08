package model;

import java.util.List;

public class Alumno {
	private String nombre;
	private Integer legajo;
	private String usuarioGitHub;
	private List<Tarea> tareas;

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
