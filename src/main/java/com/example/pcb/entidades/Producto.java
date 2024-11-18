package com.example.pcb.entidades;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@NoArgsConstructor
@Data
@Table(name = "Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SKU")
    private int SKU;

    @Column(name = "Nombre")
    private String Nombre;

    @Column(name = "FechaCreacion")
    private Date FechaCreacion;

    @Column(name = "FechaModificacion")
    private Date FechaModificacion;

    @OneToOne
    @JoinColumn(name = "Thumbmail")
    private Imagen Thumbmail;

    // asociaciones

    @ManyToMany
    @JoinColumn(name = "categoria")
    private List<Categoria> categoria;

    @ManyToOne
    @JoinColumn(name = "Cuenta")
    private Cuenta cuenta;

    @Id
    @ManyToOne
    @JoinColumn(name = "TiendaInterna")
    private TiendaInterna tiendaInterna;

    @ManyToMany
    @JoinColumn(name = "Producto")
    private List<Producto> asociacionProductos;


    public Producto(int SKU, String Nombre, Date FechaCreacion, Date FechaModificacion, Imagen Thum) {
        this.Nombre = Nombre;
        this.FechaCreacion = FechaCreacion;
        this.SKU = SKU;
        this.FechaModificacion = FechaModificacion;
        this.Thumbmail = Thum;
    }
}