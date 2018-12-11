package notitas.server;

import notitas.json.Asignaciones;
import notitas.json.JSONParser;
import notitas.model.Alumno;
import spark.Request;
import spark.Response;

public class Controller {
    private static Repositorio repo = Repositorio.getInstance();
    
    private static Long getUserId(Request req) {
        return req.session().attribute("userId");
    }

    public static String setAlumno(Request req, Response res) {
        Alumno nuevoAlumno = JSONParser.objetoDesdeString(req.body(), Alumno.class);
        repo.actualizarAlumno(getUserId(req), nuevoAlumno);
        return "done";
    }

    public static Alumno getAlumno(Request req, Response res) {
        return repo.getAlumno(getUserId(req));
    }

    public static Asignaciones getAsignaciones(Request req, Response res) {
        return repo.getAsignaciones(getUserId(req));
    }
}
