package ui.windows;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import model.Alumno;
import model.Tarea;
import ui.viewModels.PrincipalViewModel;

public class VentanaPrincipal extends SimpleWindow<PrincipalViewModel>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6180403924383779129L;

	public VentanaPrincipal(WindowOwner parent) {
		super(parent, new PrincipalViewModel());
	}

	@Override
	protected void addActions(Panel actionsPanel) {
        new Button(actionsPanel)
	        .setCaption("Actualizar datos")
	        .onClick(this::modificarAlumno);
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		new Label(mainPanel).setText("Alumno:");
		new Label(mainPanel).bindValueToProperty("alumno.nombre");
		new Label(mainPanel).bindValueToProperty("alumno.legajo");
		new Label(mainPanel).bindValueToProperty("alumno.usuarioGitHub");
		
        //  Asignacion
        Table<Tarea> tablaTareas = new Table<Tarea>(mainPanel, Tarea.class);
        tablaTareas.setNumberVisibleRows(10);
        tablaTareas.bindItemsToProperty("alumno.tareas");

        Column<Tarea> columnaDescripcion = new Column<Tarea>(tablaTareas);
        columnaDescripcion.setTitle("Descripcion");
        columnaDescripcion.bindContentsToProperty("descripcion");
        Column<Tarea> columnaNota = new Column<Tarea>(tablaTareas);
        columnaNota.setTitle("Nota");
        columnaNota.bindContentsToProperty("notaActual");

		
	}
	
	protected void modificarAlumno() {
        Dialog<PrincipalViewModel> actualizarDatos = new VentanaActualizarDatos(this);
        actualizarDatos.open();
	}
	
}
