package es.pcb.pcbgrupo16.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "cuenta")
public class Cuenta {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "fechaDeCreacion")
    private Instant fechaDeCreacion;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "tipoSuscripcion")
    private Integer tipoSuscripcion;

    @Lob
    @Column(name = "descripcion")
    private String descripcion;

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

    public Instant getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(Instant fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getTipoSuscripcion() {
        return tipoSuscripcion;
    }

    public void setTipoSuscripcion(Integer tipoSuscripcion) {
        this.tipoSuscripcion = tipoSuscripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}