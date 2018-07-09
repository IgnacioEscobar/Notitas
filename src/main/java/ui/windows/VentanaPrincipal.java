package ui.windows;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

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
		
		Panel alumnoPanel = new Panel(mainPanel);
		alumnoPanel.setLayout(new ColumnLayout(2));
		
		new Label(alumnoPanel).setText("Alumno:");
		new Label(alumnoPanel).bindValueToProperty("alumno.nombre");
		new Label(alumnoPanel).setText("Legajo:");
		new Label(alumnoPanel).bindValueToProperty("alumno.legajo");
		new Label(alumnoPanel).setText("Usuario Github:");
		new Label(alumnoPanel).bindValueToProperty("alumno.usuarioGitHub");
		
        //  Asignacion
        Table<Tarea> tablaTareas = new Table<Tarea>(mainPanel, Tarea.class);
        tablaTareas.setNumberVisibleRows(5);
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
