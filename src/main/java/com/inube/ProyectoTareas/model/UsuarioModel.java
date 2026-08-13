package com.inube.ProyectoTareas.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "USUARIO")
@Data
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    @SequenceGenerator(name = "seq_usuario", sequenceName = "SEQ_USUARIO", allocationSize = 1)

    @Column(name = "ID_USUARIO")
    private Integer idUsuario;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDO")
    private String apellido;

    @Column(name = "CORREO")
    private String correo;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "ESTADO")
    private Integer estado = 1;

    @Column(name = "FECHA_REGISTRO")
    private LocalDateTime fechaRegistro = LocalDateTime.now();

}
