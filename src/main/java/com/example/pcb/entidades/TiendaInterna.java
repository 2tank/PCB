package com.example.pcb.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@Entity

@Table(name = "TiendaInterna")
public class TiendaInterna {

    @Id
    @Column
    private int GTIN;

    //asociaciones

    @OneToMany
    @JoinColumn(name = "Cuenta")
    private List<Cuenta> listaCuentas;

    public TiendaInterna(int GTIN){
        this.GTIN = GTIN;
    }
}
