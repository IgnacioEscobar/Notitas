package notitas.server;

import notitas.json.JSONParser;
import notitas.model.Alumno;
import notitas.server.security.SecurityService;
import spark.Request;
import spark.Response;
import spark.Spark;

public class Controller {
    private static Repositorio repo = Repositorio.getInstance();

    private static Long verify(Request req, Response res){
        SecurityService securityService = new SecurityService("3l_4leph");
        Long userId = null;
        try {
            userId = securityService.user(req.headers("Authorization").replace("Bearer ", ""));
        } catch (Exception e) {
            Spark.halt(401, "<h1><a href='https://www.youtube.com/watch?v=0Jx8Eay5fWQ'>Hack me </a></h1><br/><br/><br/><a href='https://www.youtube.com/watch?v=PtLmEARfStE'> El aleph </a>");
        }
        return userId;
    }

    private static String getAsJSON(Object object) {
        return JSONParser.stringDesdeObjeto(object);
    }

    public static String getAsignacionesAsJSON(Request req, Response res){
        Long id = verify(req, res);
        return getAsJSON(repo.getAsignaciones(id));
    }

    public static String getAlumnoAsJSON(Request req, Response res){
        Long id = verify(req, res);
        return getAsJSON(repo.getAlumno(id));
    }

    public static String setAlumno(Request req, Response res) {
        Long id = verify(req, res);
        Alumno nuevoAlumno = JSONParser.objetoDesdeString(req.body(), Alumno.class);
        repo.actualizarAlumno(id, nuevoAlumno);
        return "done";
    }
}
