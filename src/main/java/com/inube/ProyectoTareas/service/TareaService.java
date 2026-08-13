package com.inube.ProyectoTareas.service;

import com.inube.ProyectoTareas.model.TareaModel;
import com.inube.ProyectoTareas.repository.TareaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import static com.inube.ProyectoTareas.util.UtilConstants.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TareaService {

    private final TareaRepository repository;

    public TareaModel guardar(TareaModel tarea) {
        return repository.save(tarea);
    }
    public List<TareaModel> listar() {

        return repository.findByEstado(CODEPOS);
    }
    public TareaModel buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(MSG1));
    }
    public TareaModel cambiar(Integer id, TareaModel request) {
        TareaModel tarea = buscarPorId(id);
        tarea.setTitulo(request.getTitulo());
        tarea.setDescripcion(request.getDescripcion());
        tarea.setProyecto(request.getProyecto());
        tarea.setUsuario(request.getUsuario());
        tarea.setFechaLimite(request.getFechaLimite());
        tarea.setPrioridad(request.getPrioridad());
        tarea.setEstadoTarea(request.getEstadoTarea());


        return repository.save(tarea);
    }
    public List<TareaModel> listarTareasPorProyecto(Integer idProyecto) {
        return repository.findByProyectoIdProyecto(idProyecto);
    }
}
