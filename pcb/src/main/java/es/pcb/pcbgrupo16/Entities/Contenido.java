package es.pcb.pcbgrupo16.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "contenido")
public class Contenido {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "contenido")
    private String contenido;

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

}