package es.pcb.pcbgrupo16.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class AtributoUsuarioId implements java.io.Serializable {
    private static final long serialVersionUID = -1357415368079675380L;
    @Column(name = "idAtributo", nullable = false)
    private Integer idAtributo;

    @Column(name = "idUsuario", nullable = false)
    private Integer idUsuario;

    public Integer getIdAtributo() {
        return idAtributo;
    }

    public void setIdAtributo(Integer idAtributo) {
        this.idAtributo = idAtributo;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AtributoUsuarioId entity = (AtributoUsuarioId) o;
        return Objects.equals(this.idUsuario, entity.idUsuario) &&
                Objects.equals(this.idAtributo, entity.idAtributo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idAtributo);
    }

}