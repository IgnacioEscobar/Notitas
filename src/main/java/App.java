import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import model.Alumno;
import ui.windows.VentanaPrincipal;

public class App extends Application{
	
    public static void main(String[] args){
        System.out.println("Lector de notas, inicializando...");
        Alumno alumno = Alumno.getInstance();
        alumno.setNombre("Pepe Argento");
        alumno.setLegajo(12312413);
        alumno.setUsuarioGitHub("pepito");
        new App().start();
    }

    @Override
    protected Window<?> createMainWindow() {
        return new VentanaPrincipal(this);
    }
}
