package es.pcb.pcbgrupo16;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class AtributoUsuarioId implements java.io.Serializable {
    private static final long serialVersionUID = -849185393362352217L;
    @Column(name = "nombre", nullable = false)
    private Integer nombre;

    @Column(name = "tipo", nullable = false, length = 45)
    private String tipo;

    public Integer getNombre() {
        return nombre;
    }

    public void setNombre(Integer nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AtributoUsuarioId entity = (AtributoUsuarioId) o;
        return Objects.equals(this.tipo, entity.tipo) &&
                Objects.equals(this.nombre, entity.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo, nombre);
    }

}