package com.inube.ProyectoTareas.repository;

import com.inube.ProyectoTareas.model.ProyectoModel;
import com.inube.ProyectoTareas.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
// Para buscar  por su estado  (activo/inactivo)
public interface ProyectoRepository extends JpaRepository<ProyectoModel, Integer> {
    List<ProyectoModel> findByEstado(Integer estado);

}
