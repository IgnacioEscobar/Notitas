package dominio;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import dominio.dispositivo.Dispositivo;

public class Cliente {
	private String nombre;
	private String apellido;
	private TipoDeDocumento tipoDeDocumento;
	private Integer numeroDeDocumento;
	private Integer telefono;
	private LocalDate fechaDeAlta;
	private String domicilio;
	private String nombreDeUsuario;
	private String contrasena;
	private List<Dispositivo> dispositivos;
	private Categoria categoria;
	private Integer puntaje;

	public TipoDeDocumento getTipoDeDocumento() {
		return tipoDeDocumento;
	}

	public LocalDate getFechaDeAlta() {
		return fechaDeAlta;
	}

	public Categoria categoria() {
		return this.categoria;
	}

	public void agregarDispositivo(Dispositivo dispositivo) {
		this.dispositivos.add(dispositivo);
	}

	public Cliente(String nombre, String apellido, TipoDeDocumento tipoDeDocumento, Integer numeroDeDocumento,
			Integer telefono, LocalDate fechaDeAlta, String domicilio, String nombreDeUsuario, String contrasena,
			List<Dispositivo> dispositivos) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDeDocumento = tipoDeDocumento;
		this.numeroDeDocumento = numeroDeDocumento;
		this.telefono = telefono;
		this.fechaDeAlta = fechaDeAlta;
		this.domicilio = domicilio;
		this.nombreDeUsuario = nombreDeUsuario;
		this.contrasena = contrasena;
		this.dispositivos = dispositivos;
		this.puntaje = 0;

		this.recategorizar();
	}

	public Stream<Dispositivo> dispositivosQueCumplen(Predicate<Dispositivo> unaCondicion) {
		return this.dispositivos.stream().filter(unaCondicion);
	}

	public Stream<Dispositivo> dispositivosEncendidos() {
		return dispositivosQueCumplen(dispositivo -> dispositivo.estaEncendido());
	}

	public int cantidadDeDispositivos() {
		return this.dispositivos.size();
	}

	public int cantidadDeDispositivosEncendidos() {
		return (int) this.dispositivosEncendidos().count();
	}

	public int cantidadDeDispositivosApagados() {
		return this.cantidadDeDispositivos() - this.cantidadDeDispositivosEncendidos();
	}

	public Boolean hayAlgunDispositivoEncendido() {
		return this.cantidadDeDispositivosEncendidos() > 0;
	}

	public Double consumo(Period periodo) {
		return this.dispositivosEncendidos().mapToDouble((Dispositivo dispositivo) -> dispositivo.consumoEnElPeriodo(periodo)).sum();
	}

	public void recategorizar() {
	    Period ultimoMes =Period.between(LocalDate.now().plusMonths(-1) , LocalDate.now());
		RepositorioCategorias repositorio = RepositorioCategorias.getInstance();
		this.categoria = repositorio.categoriaCorrespondiente(this.consumo(ultimoMes));
	}

}
