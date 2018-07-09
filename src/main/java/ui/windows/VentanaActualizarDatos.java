package ui.windows;

import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;

import ui.viewModels.PrincipalViewModel;

public class VentanaActualizarDatos extends TransactionalDialog<PrincipalViewModel>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 351936031159955597L;

	public VentanaActualizarDatos(WindowOwner owner) {
		super(owner, new PrincipalViewModel());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		new Label(mainPanel).setText("Alumno:");
		new Label(mainPanel).bindValueToProperty("alumno.nombre");
		new Label(mainPanel).bindValueToProperty("alumno.legajo");
		new Label(mainPanel).bindValueToProperty("alumno.usuarioGitHub");
	}
	
}
