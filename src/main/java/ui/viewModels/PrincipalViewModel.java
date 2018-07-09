package ui.viewModels;

import org.uqbar.commons.utils.Observable;

import model.Alumno;

@Observable
public class PrincipalViewModel {
	private Alumno alumno;
	
	public PrincipalViewModel() {
		super();
		alumno = Alumno.getInstance();
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	
}