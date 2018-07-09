package ui.windows;

import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
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
	protected void addActions(Panel actionsPanel) {
        new Button(actionsPanel)
	        .setCaption("Aplicar")
	        .onClick(this::actualizar);
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel nuevoPanel = new Panel(mainPanel);
		nuevoPanel.setLayout(new ColumnLayout(2));
		new Label(nuevoPanel).setText("Alumno:");
		new TextBox(nuevoPanel).bindValueToProperty("alumno.nombre");
		new Label(nuevoPanel).setText("Legajo:");
		new TextBox(nuevoPanel).bindValueToProperty("alumno.legajo");
		new Label(nuevoPanel).setText("Usuario GitHub:");
		new TextBox(nuevoPanel).bindValueToProperty("alumno.usuarioGitHub");
	}
	
	public void actualizar() {
		this.accept();
	}
	
}
