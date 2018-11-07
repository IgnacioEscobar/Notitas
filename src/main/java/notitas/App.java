package notitas;

import notitas.client.NotitasClient;
import notitas.model.Tarea;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import notitas.model.Alumno;
import notitas.ui.windows.VentanaPrincipal;

import java.util.List;

public class App extends Application{

    public static void main(String[] args){
        NotitasClient cliente = new NotitasClient("localhost:9000");
        Configuracion.cliente = cliente;

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
