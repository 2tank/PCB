package com.example.pcb.entidades;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.*;

@Entity
@NoArgsConstructor
@Data
@Table(name = "AtributoUsuario")
public class AtributoUsuario {

    @Id
    @Column(name = "nombre")
    private String nombre;

    @Id
    @Column(name = "tipo")
    private String tipo;

    //asociaciones

    @OneToOne
    @JoinColumn(name = "Contenido")
    private Contenido contenido;

    public AtributoUsuario(String nombre, String tipo){
        this.nombre = nombre;
        this.tipo = tipo;
    }
}
