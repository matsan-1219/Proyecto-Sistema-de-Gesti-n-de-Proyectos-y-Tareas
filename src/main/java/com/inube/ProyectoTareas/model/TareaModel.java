package com.inube.ProyectoTareas.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Table(name = "TAREA")
@Data
public class TareaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tarea")
    @SequenceGenerator(name = "seq_tarea", sequenceName = "SEQ_TAREA", allocationSize = 1)
    @Column(name = "ID_TAREA")
    private Integer idTarea;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "FECHA_CREACION")
    private LocalDate fechaCreacion;

    @Column(name = "FECHA_LIMITE")
    private LocalDateTime fechaLimite;

    @Column(name = "PRIORIDAD")
    private String prioridad;

    @ManyToOne
    @JoinColumn(name = "ID_PROYECTO")
    private ProyectoModel proyecto;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private UsuarioModel usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_ESTADO")
    private EstadoTareaModel estadoTarea;

    @Column(name = "ESTADO")
    private Integer estado = 1;
}
