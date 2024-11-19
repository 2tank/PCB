package es.pcb.pcbgrupo16;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
public class Cuenta {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "contrasena", nullable = false)
    private String contrasena;

    @Column(name = "email", nullable = false)
    private String email;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "fechaDeCreacion")
    private Instant fechaDeCreacion;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "tipoSuscripcion")
    private Integer tipoSuscripcion;

    @Lob
    @Column(name = "descripcion")
    private String descripcion;

    @ColumnDefault("0")
    @Column(name = "esOwner")
    private Boolean esOwner;

    @ColumnDefault("0")
    @Column(name = "esAgente")
    private Boolean esAgente;

    @ColumnDefault("1")
    @Column(name = "esUsuario")
    private Boolean esUsuario;

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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Boolean getEsOwner() {
        return esOwner;
    }

    public void setEsOwner(Boolean esOwner) {
        this.esOwner = esOwner;
    }

    public Boolean getEsAgente() {
        return esAgente;
    }

    public void setEsAgente(Boolean esAgente) {
        this.esAgente = esAgente;
    }

    public Boolean getEsUsuario() {
        return esUsuario;
    }

    public void setEsUsuario(Boolean esUsuario) {
        this.esUsuario = esUsuario;
    }

}