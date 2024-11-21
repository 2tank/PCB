package es.pcb.pcbgrupo16.Entities;

import jakarta.persistence.*;

@Entity
public class AtributoUsuario {
    @EmbeddedId
    private AtributoUsuarioId id;

    @MapsId("idAtributo")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idAtributo", nullable = false)
    private Atributo idAtributo;

    @MapsId("idUsuario")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idUsuario", nullable = false)
    private es.pcb.pcbgrupo16.Entities.Cuenta idUsuario;

    public AtributoUsuarioId getId() {
        return id;
    }

    public void setId(AtributoUsuarioId id) {
        this.id = id;
    }

    public Atributo getIdAtributo() {
        return idAtributo;
    }

    public void setIdAtributo(Atributo idAtributo) {
        this.idAtributo = idAtributo;
    }

    public es.pcb.pcbgrupo16.Entities.Cuenta getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(es.pcb.pcbgrupo16.Entities.Cuenta idUsuario) {
        this.idUsuario = idUsuario;
    }

}