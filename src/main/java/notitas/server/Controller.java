package notitas.server;

import notitas.json.JSONParser;
import notitas.model.Alumno;
import spark.Request;
import spark.Response;

public class Controller {
    private static Repositorio repo = Repositorio.getInstance();

    private static String getAsJSON(Object object) {
        return JSONParser.stringDesdeObjeto(object);
    }

    public static String getAsignacionesAsJSON(Request req, Response res) {
        return getAsJSON(repo.getAsignaciones(getUserId(req)));
    }

    private static Long getUserId(Request req) {
        return req.session().attribute("userId");
    }

    public static String getAlumnoAsJSON(Request req, Response res) {
        return getAsJSON(repo.getAlumno(getUserId(req)));
    }

    public static String setAlumno(Request req, Response res) {
        Alumno nuevoAlumno = JSONParser.objetoDesdeString(req.body(), Alumno.class);
        repo.actualizarAlumno(getUserId(req), nuevoAlumno);
        return "done";
    }
}
