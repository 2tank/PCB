package es.pcb.pcbgrupo16;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Contenido {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "contenido")
    private byte[] contenido;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }

}