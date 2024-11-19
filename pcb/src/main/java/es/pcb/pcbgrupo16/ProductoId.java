package es.pcb.pcbgrupo16;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class ProductoId implements java.io.Serializable {
    private static final long serialVersionUID = 1000323303028752228L;
    @Column(name = "SKU", nullable = false)
    private Integer sku;

    @Column(name = "GTIN", nullable = false)
    private Integer gtin;

    public Integer getSku() {
        return sku;
    }

    public void setSku(Integer sku) {
        this.sku = sku;
    }

    public Integer getGtin() {
        return gtin;
    }

    public void setGtin(Integer gtin) {
        this.gtin = gtin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductoId entity = (ProductoId) o;
        return Objects.equals(this.gtin, entity.gtin) &&
                Objects.equals(this.sku, entity.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gtin, sku);
    }

}