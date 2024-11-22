package es.pcb.pcbgrupo16.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "atributo")
public class Atributo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "tipo", nullable = false, length = 45)
    private String tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contenido")
    private es.pcb.pcbgrupo16.Entities.Contenido contenido;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public es.pcb.pcbgrupo16.Entities.Contenido getContenido() {
        return contenido;
    }

    public void setContenido(es.pcb.pcbgrupo16.Entities.Contenido contenido) {
        this.contenido = contenido;
    }

}