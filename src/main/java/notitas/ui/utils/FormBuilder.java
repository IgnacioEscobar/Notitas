package notitas.ui.utils;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;

public class FormBuilder {
    private Panel panel;

    public FormBuilder(Panel panel) {
        this.panel = panel;
        panel.setLayout(new ColumnLayout(2));
    }

    public FormBuilder buildInput(String label, String propertyToBind) {
        new Label(panel).setText(label);
        new TextBox(panel).setWidth(150).bindValueToProperty(propertyToBind);
        return this;
    }

    public FormBuilder buildOutput(String label, String propertyToBind) {
        new Label(panel).setText(label);
        new Label(panel).bindValueToProperty(propertyToBind);
        return this;
    }
}