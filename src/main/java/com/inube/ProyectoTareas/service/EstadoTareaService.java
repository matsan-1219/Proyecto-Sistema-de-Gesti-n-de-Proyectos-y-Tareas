package com.inube.ProyectoTareas.service;

import com.inube.ProyectoTareas.model.EstadoTareaModel;
import com.inube.ProyectoTareas.repository.EstadoTareaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import static com.inube.ProyectoTareas.util.UtilConstants.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstadoTareaService {

    private final EstadoTareaRepository repository;



    public List<EstadoTareaModel> lista() {
        // CODEPOS debe ser un Integer en tu clase UtilConstants
        return repository.findByEstado(CODEPOS);
    }

    public EstadoTareaModel buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(MSG1));
    }

    public EstadoTareaModel cambiar(Integer id, EstadoTareaModel request) {
        EstadoTareaModel estadoTarea = buscarPorId(id);
        estadoTarea.setNombre(request.getNombre());



        return repository.save(estadoTarea);
    }
}

