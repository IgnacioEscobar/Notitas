package model;

import java.util.List;

public class Tarea {
	private String descripcion;
	private List<Nota> notas;
	private Nota notaActual;
	
	public Tarea(String descripcion) {
		super();
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setNotaActual(Nota notaActual) {
		this.notaActual = notaActual;
	}

	public Nota getNotaActual() {
		return notaActual;
	}

	public void evaluar(Nota unaNota) {
		notas.add(unaNota);
		this.notaActual = unaNota;
	}

}
