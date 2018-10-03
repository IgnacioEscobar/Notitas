package model;

import com.google.gson.annotations.SerializedName;
import org.uqbar.commons.utils.Observable;

import java.util.ArrayList;
import java.util.List;

@Observable
public class Tarea {
	@SerializedName("description")
	private String descripcion;

	@SerializedName("grades")
	private List<String> notas;
	private String notaActual;

    public Tarea() {
    }

	public Tarea(String descripcion) {
		super();
		notas = new ArrayList<String>();
		this.descripcion = descripcion;
	}

	public List<String> getNotas() {
		return notas;
	}

	public void setNotas(List<String> notas) {
		this.notas = notas;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNotaActual() {
		return notaActual;
	}

	public void setNotaActual(String notaActual) {
		this.notaActual = notaActual;
	}

	public void evaluar(String unaNota) {
		notas.add(unaNota);
		this.notaActual = unaNota;
	}

}
