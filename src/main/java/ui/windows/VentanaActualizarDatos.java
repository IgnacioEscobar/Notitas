package ui.windows;

import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.WindowOwner;

import model.Alumno;

public class VentanaActualizarDatos extends TransactionalDialog<Alumno>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 351936031159955597L;

	public VentanaActualizarDatos(WindowOwner owner, Alumno model) {
		super(owner, model);
	}
	
	@Override
	protected void addActions(Panel actionsPanel) {
        new Button(actionsPanel)
	        .setCaption("Aplicar")
	        .onClick(this::accept);
        new Button(actionsPanel)
	        .setCaption("Cancelar")
	        .onClick(this::cancel);
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel nuevoPanel = new Panel(mainPanel);
		nuevoPanel.setLayout(new ColumnLayout(2));
		new Label(nuevoPanel).setText("Alumno:");
		new TextBox(nuevoPanel).setWidth(150).bindValueToProperty("nombre");
		new Label(nuevoPanel).setText("Legajo:");
		new TextBox(nuevoPanel).setWidth(150).bindValueToProperty("legajo");
		new Label(nuevoPanel).setText("Usuario GitHub:");
		new TextBox(nuevoPanel).setWidth(150).bindValueToProperty("usuarioGitHub");
	}
	
}
