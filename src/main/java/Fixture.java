import model.Alumno;
import model.NotaNumerica;
import model.Tarea;

public class Fixture {
	
	public static void init() {
		Alumno alumno = Alumno.getInstance();
        alumno.setNombre("Pepe Argento");
        alumno.setLegajo(12312413);
        alumno.setUsuarioGitHub("pepito");
        Tarea tarea = new Tarea("1 Parcial");
        tarea.evaluar(new NotaNumerica(8));
        alumno.asignarTarea(tarea);
	}

}
