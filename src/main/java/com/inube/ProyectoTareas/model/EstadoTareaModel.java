package com.inube.ProyectoTareas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ESTADOTAREA")
@Data
public class EstadoTareaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_estadotarea")
    @SequenceGenerator(name = "seq_estadotarea", sequenceName = "SEQ_ESTADOTAREA", allocationSize = 1)
    @Column(name = "ID_ESTADO")
    private Integer idEstado;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "ESTADO")
    private Integer estado = 1;
}
