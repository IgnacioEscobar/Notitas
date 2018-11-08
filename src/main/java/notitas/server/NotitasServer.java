package notitas.server;

import spark.Spark;

public class NotitasServer {
    public static void main(String[] args) {
        Fixture.init();
        Spark.port(9000);
        Router.route();
    }

}