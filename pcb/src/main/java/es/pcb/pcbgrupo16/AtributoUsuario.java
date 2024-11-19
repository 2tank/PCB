package es.pcb.pcbgrupo16;

import jakarta.persistence.*;

@Entity
public class AtributoUsuario {
    @EmbeddedId
    private AtributoUsuarioId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contenido")
    private es.pcb.pcbgrupo16.Contenido contenido;

    public AtributoUsuarioId getId() {
        return id;
    }

    public void setId(AtributoUsuarioId id) {
        this.id = id;
    }

    public es.pcb.pcbgrupo16.Contenido getContenido() {
        return contenido;
    }

    public void setContenido(es.pcb.pcbgrupo16.Contenido contenido) {
        this.contenido = contenido;
    }

}