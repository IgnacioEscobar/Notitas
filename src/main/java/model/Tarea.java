package model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import org.uqbar.commons.utils.Observable;

@Observable
public class Tarea {
	@SerializedName("description")
	private String descripcion;
	private List<Nota> notas;
	private Nota notaActual;

    public Tarea() {
    }

    public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public Tarea(String descripcion) {
		super();
		notas = new ArrayList<Nota>();
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
