package notitas.ui.windows;

import notitas.Configuracion;
import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.WindowOwner;

import notitas.model.Alumno;

public class VentanaActualizarDatos extends TransactionalDialog<Alumno>{

    /**
     *
     */
    private static final long serialVersionUID = 351936031159955597L;
    private Alumno model;

    public VentanaActualizarDatos(WindowOwner owner, Alumno model) {
        super(owner, model);
        this.model = model;
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

    public void accept() {
        super.accept();
        Configuracion.cliente.putAlumno(this.model);
    }

    @Override
    protected void createFormPanel(Panel mainPanel) {
        Panel nuevoPanel = new Panel(mainPanel);
        new FormBuilder(nuevoPanel)
                .buildInput("Alumno:", "nombre")
                .buildInput("Legajo:", "legajo")
                .buildInput("Usuario GitHub:", "usuarioGitHub");
    }

    class FormBuilder{
        private Panel panel;
        public FormBuilder(Panel panel) {
            this.panel = panel;
            panel.setLayout(new ColumnLayout(2));
        }
        public FormBuilder buildInput(String label, String propertyToBind){
            new Label(panel).setText(label);
            new TextBox(panel).setWidth(150).bindValueToProperty(propertyToBind);
            return this;
        }
    }

}
