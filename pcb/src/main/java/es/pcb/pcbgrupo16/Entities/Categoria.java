package es.pcb.pcbgrupo16.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 45)
    private String nombre;

    @Column(name = "num_productos")
    private Integer numProductos;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cuenta", nullable = false)
    private es.pcb.pcbgrupo16.Entities.Cuenta cuenta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumProductos() {
        return numProductos;
    }

    public void setNumProductos(Integer numProductos) {
        this.numProductos = numProductos;
    }

    public es.pcb.pcbgrupo16.Entities.Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(es.pcb.pcbgrupo16.Entities.Cuenta cuenta) {
        this.cuenta = cuenta;
    }

}