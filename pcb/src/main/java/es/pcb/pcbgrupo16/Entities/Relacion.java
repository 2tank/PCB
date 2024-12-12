package es.pcb.pcbgrupo16.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "relacion")
public class Relacion {
    @EmbeddedId
    private RelacionId id;

    @MapsId("prod1")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "prod1", nullable = false)
    private Producto prod1;

    @MapsId("prod2")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "prod2", nullable = false)
    private Producto prod2;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cuenta", nullable = false)
    private Cuenta cuenta;

    public RelacionId getId() {
        return id;
    }

    public void setId(RelacionId id) {
        this.id = id;
    }

    public Producto getProd1() {
        return prod1;
    }

    public void setProd1(Producto prod1) {
        this.prod1 = prod1;
    }

    public Producto getProd2() {
        return prod2;
    }

    public void setProd2(Producto prod2) {
        this.prod2 = prod2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

}