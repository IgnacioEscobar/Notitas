package ui.windows;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import model.Alumno;
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
	}
	
	protected void modificarAlumno() {
		Alumno.getInstance().setNombre("Roque Fort");
	}
	
}
