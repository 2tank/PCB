package es.pcb.pcbgrupo16;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class AsociacionProductoId implements java.io.Serializable {
    private static final long serialVersionUID = -577132602378675790L;
    @Column(name = "idProducto1", nullable = false)
    private Integer idProducto1;

    @Column(name = "idProducto2", nullable = false)
    private Integer idProducto2;

    public Integer getIdProducto1() {
        return idProducto1;
    }

    public void setIdProducto1(Integer idProducto1) {
        this.idProducto1 = idProducto1;
    }

    public Integer getIdProducto2() {
        return idProducto2;
    }

    public void setIdProducto2(Integer idProducto2) {
        this.idProducto2 = idProducto2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AsociacionProductoId entity = (AsociacionProductoId) o;
        return Objects.equals(this.idProducto2, entity.idProducto2) &&
                Objects.equals(this.idProducto1, entity.idProducto1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducto2, idProducto1);
    }

}