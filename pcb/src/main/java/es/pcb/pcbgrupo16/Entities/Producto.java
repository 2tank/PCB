package es.pcb.pcbgrupo16.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @Column(name = "SKU", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "GTIN", nullable = false)
    private es.pcb.pcbgrupo16.Entities.Tiendainterna gtin;

    @Column(name = "nombre", length = 45)
    private String nombre;

    @Column(name = "fechaCreacion")
    private LocalDate fechaCreacion;

    @Column(name = "fechaModificacion")
    private LocalDate fechaModificacion;

    @Column(name = "thumnail")
    private String thumnail;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cuenta", nullable = false)
    private Cuenta cuenta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public es.pcb.pcbgrupo16.Entities.Tiendainterna getGtin() {
        return gtin;
    }

    public void setGtin(es.pcb.pcbgrupo16.Entities.Tiendainterna gtin) {
        this.gtin = gtin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDate fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getThumnail() {
        return thumnail;
    }

    public void setThumnail(String thumnail) {
        this.thumnail = thumnail;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

}