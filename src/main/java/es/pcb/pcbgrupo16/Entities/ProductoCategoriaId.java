package es.pcb.pcbgrupo16.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class ProductoCategoriaId implements java.io.Serializable {
    private static final long serialVersionUID = -409812579855028315L;
    @Column(name = "idProducto", nullable = false)
    private Integer idProducto;

    @Column(name = "idCategoria", nullable = false)
    private Integer idCategoria;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductoCategoriaId entity = (ProductoCategoriaId) o;
        return Objects.equals(this.idProducto, entity.idProducto) &&
                Objects.equals(this.idCategoria, entity.idCategoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducto, idCategoria);
    }

}