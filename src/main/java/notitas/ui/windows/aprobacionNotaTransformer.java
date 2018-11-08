package notitas.ui.windows;

import org.apache.commons.collections15.Transformer;

public class aprobacionNotaTransformer implements Transformer<String, String> {

    @Override
    public String transform(String nota) {
        try {
            if (Integer.parseInt(nota) > 6) {
                return "Aprobado";
            } else if (Integer.parseInt(nota) == -1) {
                return "No hay notas cargadas";
            } else {
                return "No Aprobado";
            }
        } catch (NumberFormatException e) {
            if (nota.contains("B") || nota.contains("R")) {
                return "Aprobado";
            } else {
                return "No Aprobado";
            }
        }
    }

}
