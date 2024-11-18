package com.example.pcb.entidades;

import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.Date;

@NoArgsConstructor
public class Usuario extends Cuenta{

        public Usuario(int id, String nombre, String contraseña,
                       String email, Date fecha_creacion, Imagen avatar,
                       TipoSuscripcion tipoSubscripcion, String descripcion){
            super(id,nombre,contraseña,email,fecha_creacion,avatar,tipoSubscripcion,descripcion);
        }
}
