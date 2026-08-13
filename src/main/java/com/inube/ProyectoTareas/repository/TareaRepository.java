package com.inube.ProyectoTareas.repository;

import com.inube.ProyectoTareas.model.TareaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<TareaModel, Integer> {

    // Para buscar por su estad  (activo/inactivo)
    List<TareaModel> findByEstado(Integer estado);
    List<TareaModel> findByProyectoIdProyecto(Integer idProyecto);
}
