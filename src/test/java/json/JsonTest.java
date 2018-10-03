package json;

import model.Alumno;
import model.Tarea;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class JsonTest {
    private String testAlumnoJson = "{\"code\":\"111222333\",\"first_name\":\"Lisa\",\"last_name\":\"Simpson\",\"github_user\":\"corazonDeLeon\"}";
    private Alumno testAlumno = new Alumno("Lisa","Simpson",111222333,"corazonDeLeon");

    private String testAsignacionesGson = "{\"assignments\":[{\"id\":1,\"title\":\"TPA1\",\"description\":\"Entrega 1 del TP Anual\",\"grades\":[]},{\"id\":2,\"title\":\"TPA2\",\"description\":\"Entrega 2 del TP Anual\",\"grades\":[]}]}";

    private Boolean alumnosIguales(Alumno alumnoA, Alumno alumnoB){
        return  alumnoA.getNombre().equals(alumnoB.getNombre()) &&
                alumnoA.getApellido().equals(alumnoB.getApellido()) &&
                alumnoA.getUsuarioGitHub().equals(alumnoB.getUsuarioGitHub()) &&
                alumnoA.getLegajo().equals(alumnoB.getLegajo());
    }

    @Test
    public void parseAlumnoTest(){
        Alumno alumnoParseado = JSONParser.objetoDesdeString(testAlumnoJson, Alumno.class);
        assertTrue(alumnosIguales(alumnoParseado,testAlumno));
    }

    @Test
    public void parseAsignacionesTest(){
        Asignaciones asignacionesParseadas = JSONParser.objetoDesdeString(testAsignacionesGson, Asignaciones.class);
        System.out.println(asignacionesParseadas.getTareas());
        assertTrue("No implementado", false);
    }
}
