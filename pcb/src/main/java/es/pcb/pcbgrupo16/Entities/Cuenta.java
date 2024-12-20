package es.pcb.pcbgrupo16.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "cuenta")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "fechaDeCreacion")
    private LocalDate fechaDeCreacion;

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

    public LocalDate getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDate fechaDeCreacion) {
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