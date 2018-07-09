package ui.windows;

import org.apache.commons.collections15.Transformer;

import model.Nota;

public class aprobacionNotaTransformer implements Transformer<Nota,String> {

	@Override
	public String transform(Nota nota) {
		return nota.aprobo() ? "Aprobado" : "Todavia no aprobado";
	}

}
