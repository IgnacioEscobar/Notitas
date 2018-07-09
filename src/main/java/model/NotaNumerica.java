package model;

public class NotaNumerica implements Nota{
	private Integer valor;

	public NotaNumerica(Integer nota) {
		super();
		this.valor = nota;
	}
	
	public Boolean aprobo() {
		return valor >= 6;
	}
	
	public String valorEnTexto() {
		return valor.toString();
	}
}
