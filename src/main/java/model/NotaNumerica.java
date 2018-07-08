package model;

public class NotaNumerica {
	private Integer nota;

	public NotaNumerica(Integer nota) {
		super();
		this.nota = nota;
	}
	
	public Boolean aprobo() {
		return nota >= 6;
	}
}
