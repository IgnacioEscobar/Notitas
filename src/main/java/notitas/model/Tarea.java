package notitas.model;

import com.google.gson.annotations.SerializedName;
import org.uqbar.commons.utils.Observable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;

@Observable
@Entity
@Table(name = "Tarea")
public class Tarea extends PersistentObject {
    @SerializedName("description")
    private String descripcion;

    @SerializedName("grades")
    @ElementCollection
    private List<String> notas;
    private String notaActual = "-1";

    public Tarea() {
    }

    public Tarea(String descripcion) {
        super();
        notas = new ArrayList<String>();
        this.descripcion = descripcion;
    }

    public Tarea(String descripcion, List<String> notas) {
        this.descripcion = descripcion;
        this.notas = notas;
    }

    public List<String> getNotas() {
        return notas;
    }

    public void setNotas(List<String> notas) {
        this.notas = notas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNotaActual() {
        if (notas.size() == 0) {
            notaActual = "-1";
        }
        return notaActual;
    }

    public void setNotaActual(String notaActual) {
        this.notaActual = notaActual;
    }

    public void evaluar(String unaNota) {
        notas.add(unaNota);
        this.notaActual = unaNota;
    }

}
