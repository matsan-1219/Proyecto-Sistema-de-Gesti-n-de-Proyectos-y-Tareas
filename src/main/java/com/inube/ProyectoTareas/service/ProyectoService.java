package com.inube.ProyectoTareas.service;

import com.inube.ProyectoTareas.model.ProyectoModel;
import com.inube.ProyectoTareas.model.UsuarioModel;
import com.inube.ProyectoTareas.repository.ProyectoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import static com.inube.ProyectoTareas.util.UtilConstants.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProyectoService {
    private final ProyectoRepository repository;

    public ProyectoModel guardar(ProyectoModel proyecto){return repository.save(proyecto);}

    public List<ProyectoModel> listar(){
        return repository.findByEstado(CODEPOS);
    }
    public ProyectoModel buscarPorId(Integer id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException(MSG5));
    }
    public ProyectoModel actualizar(Integer id, ProyectoModel request) {
        ProyectoModel proyecto = buscarPorId(id);
        proyecto.setNombre(request.getNombre());
        proyecto.setDescripcion(request.getDescripcion());
        return repository.save(proyecto);
    }
    public void eliminar(Integer id){
        ProyectoModel proyecto = buscarPorId(id);
        proyecto.setEstado(CODENEG);
        repository.save(proyecto);
    }




}
