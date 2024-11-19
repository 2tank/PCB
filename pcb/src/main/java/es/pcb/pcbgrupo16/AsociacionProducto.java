package es.pcb.pcbgrupo16;

import jakarta.persistence.*;

@Entity
@Table(name = "AsociacionProductos")
public class AsociacionProducto {
    @EmbeddedId
    private AsociacionProductoId id;

    @MapsId("idProducto1")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idProducto1", nullable = false, referencedColumnName = "SKU")
    private es.pcb.pcbgrupo16.Producto idProducto1;

    @MapsId("idProducto2")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idProducto2", nullable = false, referencedColumnName = "SKU")
    private es.pcb.pcbgrupo16.Producto idProducto2;

    @Column(name = "nombreRelacion", length = 45)
    private String nombreRelacion;

    public AsociacionProductoId getId() {
        return id;
    }

    public void setId(AsociacionProductoId id) {
        this.id = id;
    }

    public es.pcb.pcbgrupo16.Producto getIdProducto1() {
        return idProducto1;
    }

    public void setIdProducto1(es.pcb.pcbgrupo16.Producto idProducto1) {
        this.idProducto1 = idProducto1;
    }

    public es.pcb.pcbgrupo16.Producto getIdProducto2() {
        return idProducto2;
    }

    public void setIdProducto2(es.pcb.pcbgrupo16.Producto idProducto2) {
        this.idProducto2 = idProducto2;
    }

    public String getNombreRelacion() {
        return nombreRelacion;
    }

    public void setNombreRelacion(String nombreRelacion) {
        this.nombreRelacion = nombreRelacion;
    }

}