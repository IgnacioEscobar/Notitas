package notitas.server;

import spark.Spark;
import spark.debug.DebugScreen;

public class NotitasServer {
    public static void main(String[] args) {
        Spark.port(9000);
        DebugScreen.enableDebugScreen();
        Router.route();
    }
}