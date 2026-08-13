package com.inube.ProyectoTareas.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "PROYECTO")
@Data
public class ProyectoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_proyecto")
    @SequenceGenerator(name = "seq_proyecto", sequenceName = "SEQ_PROYECTO", allocationSize = 1)

    @Column(name = "ID_PROYECTO")
    private Integer idProyecto;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "FECHA_INICIO")
    private LocalDateTime fechaInicio = LocalDateTime.now();

    @Column(name = "FECHA_FIN")
    private LocalDateTime fechaFin = LocalDateTime.now();

    @Column(name = "ESTADO")
    private Integer estado = 1;


}

