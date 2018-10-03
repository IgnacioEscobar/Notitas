package ui.windows;

import model.Alumno;
import model.Tarea;
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
        alumnoPanel.setLayout(new ColumnLayout(2));

        new Label(alumnoPanel).setText("Alumno:");
        new Label(alumnoPanel).bindValueToProperty("nombre");
        new Label(alumnoPanel).setText("Legajo:");
        new Label(alumnoPanel).bindValueToProperty("legajo");
        new Label(alumnoPanel).setText("Usuario Github:");
        new Label(alumnoPanel).bindValueToProperty("usuarioGitHub");

        //  Tareas
        Table<Tarea> tablaTareas = new Table<Tarea>(mainPanel, Tarea.class);
        tablaTareas.setNumberVisibleRows(5);
        tablaTareas.bindItemsToProperty("tareas");

        Column<Tarea> columnaDescripcion = new Column<Tarea>(tablaTareas);
        columnaDescripcion.setTitle("Descripcion");
        columnaDescripcion.setFixedSize(200);
        columnaDescripcion.bindContentsToProperty("descripcion");

        Column<Tarea> columnaNota = new Column<Tarea>(tablaTareas);
        columnaNota.setTitle("Nota");
        columnaNota.setFixedSize(50);
        columnaNota.bindContentsToProperty("notaActual");

        Column<Tarea> columnaAprobado = new Column<Tarea>(tablaTareas);
        columnaAprobado.setTitle("Estado");
        columnaAprobado.setFixedSize(200);
        columnaAprobado.bindContentsToProperty("notaActual").setTransformer(new aprobacionNotaTransformer());


    }

    protected void modificarAlumno() {
        Dialog<Alumno> actualizarDatos = new VentanaActualizarDatos(this,this.getModelObject());
        actualizarDatos.open();
    }

}
