package notitas.server;

import spark.Spark;
import spark.debug.DebugScreen;

import static spark.Spark.before;

public class NotitasServer {
	public static void main(String[] args) {
		Fixture.init();
		Spark.port(9000);
		Router.route();
	}

}