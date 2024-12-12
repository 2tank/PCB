package es.pcb.pcbgrupo16.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class RelacionId implements java.io.Serializable {
    private static final long serialVersionUID = 2987562155659672934L;
    @Column(name = "prod1", nullable = false)
    private Integer prod1;

    @Column(name = "prod2", nullable = false)
    private Integer prod2;

    public Integer getProd1() {
        return prod1;
    }

    public void setProd1(Integer prod1) {
        this.prod1 = prod1;
    }

    public Integer getProd2() {
        return prod2;
    }

    public void setProd2(Integer prod2) {
        this.prod2 = prod2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RelacionId entity = (RelacionId) o;
        return Objects.equals(this.prod2, entity.prod2) &&
                Objects.equals(this.prod1, entity.prod1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prod2, prod1);
    }

}