package com.inube.ProyectoTareas.repository;

import com.inube.ProyectoTareas.model.EstadoTareaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//Para buscar  por su estado  (activo/inactivo)
public interface EstadoTareaRepository extends JpaRepository<EstadoTareaModel, Integer> {


    List<EstadoTareaModel> findByEstado(Integer estado);
}
