package model;

import java.util.List;

public class Tarea {
	private List<Nota> notas;
	private Nota notaActual;
	
	public Nota getNotaActual() {
		return notaActual;
	}

	public void evaluar(Nota unaNota) {
		notas.add(unaNota);
		this.notaActual = unaNota;
	}

}
