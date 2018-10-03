import json.JSONParser;
import model.Alumno;
import model.Concepto;
import model.NotaConceptual;
import model.NotaNumerica;
import model.Tarea;
import rest.client.RestClient;

public class Fixture {
	
	public static void init() {
		/*Alumno alumno = Alumno.getInstance();
        alumno.setNombre("Roque Fort");
        alumno.setLegajo(12312413);
        alumno.setUsuarioGitHub("maiameee666");
        
        Tarea tarea = new Tarea("1 Parcial");
        tarea.evaluar(new NotaNumerica(7));
        alumno.asignarTarea(tarea);
        
        Tarea tarea2 = new Tarea("2 Parcial");
        tarea2.evaluar(new NotaNumerica(7));
        alumno.asignarTarea(tarea2);
        
        Tarea tarea4 = new Tarea("Trabajo practico");
        tarea4.evaluar(new NotaConceptual(Concepto.B));
        alumno.asignarTarea(tarea4);
        
        Tarea tarea3 = new Tarea("Final");
        tarea3.evaluar(new NotaNumerica(9));
        alumno.asignarTarea(tarea3);*/
        
        RestClient cliente = new RestClient("http://notitas.herokuapp.com/");
        JSONParser parser = new JSONParser();
        Alumno alumno = parser.objetoDesdeString(cliente.getResource("student"), Alumno.class);
        Alumno.setInstance(alumno);
        Tarea tarea = new Tarea("1 Parcial");
        tarea.evaluar(new NotaNumerica(7));
        alumno.asignarTarea(tarea);
        
	}

}
