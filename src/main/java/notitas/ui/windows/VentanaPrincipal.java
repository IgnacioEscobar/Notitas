package notitas.ui.windows;

import notitas.model.Alumno;
import notitas.model.Tarea;
import notitas.ui.utils.FormBuilder;
import notitas.ui.utils.TableBuilder;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

public class VentanaPrincipal extends SimpleWindow<Alumno>{

    /**
     *
     */
    private static final long serialVersionUID = 6180403924383779129L;

    public VentanaPrincipal(WindowOwner parent, Alumno model) {
        super(parent, model);
    }

    @Override
    protected void addActions(Panel actionsPanel) {
        new Button(actionsPanel)
                .setCaption("Actualizar datos")
                .onClick(this::modificarAlumno);
    }

    @Override
    protected void createFormPanel(Panel mainPanel) {

        Panel alumnoPanel = new Panel(mainPanel);

        new FormBuilder(alumnoPanel)
                .buildOutput("Alumno:", "nombre")
                .buildOutput("Legajo:", "legajo")
                .buildOutput("Usuario GitHub:", "usuarioGitHub");

        new TableBuilder(mainPanel,Tarea.class,"tareas")
                .setNumberVisibleRows(5)
                .buildColumn("Descripcion","descripcion",200)
                .buildColumn("Nota","notaActual",50)
                .buildColumn("Estado",200)
                    .bindToPropertyWithTransformer("notaActual",new aprobacionNotaTransformer());

    }

    private void modificarAlumno() {
        Dialog<Alumno> actualizarDatos = new VentanaActualizarDatos(this,this.getModelObject());
        actualizarDatos.open();
    }

}
