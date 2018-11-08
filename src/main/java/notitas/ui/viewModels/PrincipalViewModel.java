package notitas.ui.viewModels;

import notitas.model.Alumno;
import org.uqbar.commons.utils.Observable;

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