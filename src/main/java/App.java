import client.NotitasClient;
import model.Tarea;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import model.Alumno;
import ui.windows.VentanaPrincipal;

import java.util.List;

public class App extends Application{

    public static void main(String[] args){
        NotitasClient cliente = new NotitasClient("http://notitas.herokuapp.com/");
        Alumno alumno = cliente.getAlumno();
        Alumno.setInstance(alumno);

        List<Tarea> tareas = cliente.getTareas();
        Alumno.getInstance().setTareas(tareas);

        new App().start();
    }

    @Override
    protected Window<?> createMainWindow() {
        return new VentanaPrincipal(this, Alumno.getInstance());
    }
}
