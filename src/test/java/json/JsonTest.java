package json;

import model.Alumno;
import net.sf.oval.constraint.AssertTrue;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class JsonTest {
    private String testJson = "{\"code\":\"111222333\",\"first_name\":\"Lisa\",\"last_name\":\"Simpson\",\"github_user\":\"corazonDeLeon\"}";
    private Alumno testAlumno = new Alumno("Lisa","Simpson",111222333,"corazonDeLeon");

    private Boolean alumnosIguales(Alumno alumnoA, Alumno alumnoB){
        return  alumnoA.getNombre().equals(alumnoB.getNombre()) &&
                alumnoA.getApellido().equals(alumnoB.getApellido()) &&
                alumnoA.getUsuarioGitHub().equals(alumnoB.getUsuarioGitHub()) &&
                alumnoA.getLegajo().equals(alumnoB.getLegajo());
    }

    @Test
    public void parseAlumnoTest(){
        Alumno alumnoParseado = JSONParser.objetoDesdeString(testJson, Alumno.class);
        assertTrue(alumnosIguales(alumnoParseado,testAlumno));
    }

    @Test
    public void parseAsignacionesTest(){
        assertTrue("No implementado", false);
    }
}
