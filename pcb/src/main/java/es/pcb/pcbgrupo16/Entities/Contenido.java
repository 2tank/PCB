package es.pcb.pcbgrupo16.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "contenido")
public class Contenido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "contenido")
    private String contenido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "atributo")
    private Atributo atributo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto")
    private es.pcb.pcbgrupo16.Entities.Producto producto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Atributo getAtributo() {
        return atributo;
    }

    public void setAtributo(Atributo atributo) {
        this.atributo = atributo;
    }

    public es.pcb.pcbgrupo16.Entities.Producto getProducto() {
        return producto;
    }

    public void setProducto(es.pcb.pcbgrupo16.Entities.Producto producto) {
        this.producto = producto;
    }

}