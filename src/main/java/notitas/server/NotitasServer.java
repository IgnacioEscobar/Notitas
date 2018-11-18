package notitas.server;

import notitas.server.cargaInicial.AlumnoBase;
import notitas.server.cargaInicial.TareasBase;
import spark.Spark;

public class NotitasServer {
    public static void main(String[] args) {
        //Fixture.init();
    	AlumnoBase.init();
    	TareasBase.init();
        Spark.port(9000);
        Router.route();
    }

}