package com.example.pcb.entidades;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Data
@Table(name = "Cateogoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nombre")
    private int numProductos;

    //asociaciones

    @ManyToMany
    @JoinColumn(name = "Producto")
    private List<Producto> listaProductos;

    @ManyToOne
    @JoinColumn(name = "Cuenta")
    private Cuenta cuenta;

    public Categoria(int id, String nombre, int numProductos) {
        this.id = id;
        this.nombre = nombre;
        this.numProductos = numProductos;
        listaProductos = new ArrayList<>();
    }
}
