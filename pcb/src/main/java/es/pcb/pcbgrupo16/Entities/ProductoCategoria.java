package es.pcb.pcbgrupo16.Entities;

import jakarta.persistence.*;

@Entity
public class ProductoCategoria {
    @EmbeddedId
    private ProductoCategoriaId id;

    @MapsId("idProducto")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto idProducto;

    @MapsId("idCategoria")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idCategoria", nullable = false)
    private Categoria idCategoria;

    public ProductoCategoriaId getId() {
        return id;
    }

    public void setId(ProductoCategoriaId id) {
        this.id = id;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

}