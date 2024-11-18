package com.example.pcb.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="imagen")
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="nombre")
    private String imageName;

    @Column(name="imagen", columnDefinition = "MEDIUMBLOB")
    private byte[] imageImagen;
}
