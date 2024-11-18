package com.example.pcb.entidades;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Data
@NoArgsConstructor
@Entity

@Table(name = "Producto")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "contraseña")
    private String contraseña;

    @Column(name = "email")
    private String email;

    @Column(name = "fecha_creacion")
    private Date fecha_creacion;

    @OneToOne
    @JoinColumn(name = "avatar")
    private Imagen avatar;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipoSuscripcion")
    private TipoSuscripcion tipoSuscripcion;

    @Column(name = "descripcion")
    private String descripcion;

    // asociaciones

    @OneToMany
    @JoinColumn(name = "Categoria")
    private List<Categoria> listaCategoria;

    @OneToMany
    @JoinColumn(name = "Producto")
    private List<Producto> listaProducto;

    @ManyToMany
    @JoinColumn(name = "AtributoUsuario")
    private List<AtributoUsuario> listaAtributoUsuario;


    public Cuenta(int id, String nombre, String contraseña,
                  String email, Date fecha_creacion, Imagen avatar,
                  TipoSuscripcion tipoSubscripcion,String descripcion){
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
        this.fecha_creacion = fecha_creacion;
        this.avatar = avatar;
        this.tipoSuscripcion = tipoSubscripcion;
        this.descripcion = descripcion;
        this.listaCategoria = new ArrayList<>();
        this.listaProducto = new ArrayList<>();
        this.listaAtributoUsuario = new ArrayList<>();
    }


}
