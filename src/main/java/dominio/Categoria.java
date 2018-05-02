package dominio;

public class Categoria {
	private String nombre;
	private Integer limiteInferiorDeConsumo;
	private Integer limiteSuperiorDeConsumo;
	private Double valorFijo;
	private Double valorVariable;

	public Categoria(String nombre, Integer limiteInferiorDeConsumo, Integer limiteSuperiorDeConsumo,
			Double valorFijo, Double valorVariable) {
		this.nombre = nombre;
		this.limiteInferiorDeConsumo = limiteInferiorDeConsumo;
		this.limiteSuperiorDeConsumo = limiteSuperiorDeConsumo;
		this.valorFijo = valorFijo;
		this.valorVariable = valorVariable;
	}

	public String getNombre() {
		return this.nombre;
	}

	public double cargoFijo(Integer meses) {
		return this.valorFijo * meses;
	}

	public double cargoVariable(Double kWh) {
		return this.valorVariable * kWh;
	}

	public boolean correspondeCategoria(Double consumo) {
		return (this.limiteInferiorDeConsumo < consumo) && (consumo <= this.limiteSuperiorDeConsumo);
	}
}