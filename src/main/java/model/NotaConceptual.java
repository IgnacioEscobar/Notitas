package model;

public class NotaConceptual implements Nota{
	private Concepto nota;

	public NotaConceptual(Concepto nota) {
		super();
		this.nota = nota;
	}
	
	public Boolean aprobo() {
		return nota != Concepto.M;
	}
}
