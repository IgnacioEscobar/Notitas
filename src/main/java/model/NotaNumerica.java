package model;

public class NotaNumerica implements Nota{
	private Integer nota;

	public NotaNumerica(Integer nota) {
		super();
		this.nota = nota;
	}
	
	public Boolean aprobo() {
		return nota >= 6;
	}
}
