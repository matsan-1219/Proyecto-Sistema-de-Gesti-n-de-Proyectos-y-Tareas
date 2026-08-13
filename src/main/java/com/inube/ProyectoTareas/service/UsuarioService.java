package com.inube.ProyectoTareas.service;

import com.inube.ProyectoTareas.model.UsuarioModel;
import com.inube.ProyectoTareas.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import static com.inube.ProyectoTareas.util.UtilConstants.*;
import java.util.List;



@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioModel guardar(UsuarioModel usuario) { return repository.save(usuario); }

    public List<UsuarioModel> listar(){
        return repository.findByEstado(CODEPOS);
    }
    public UsuarioModel buscarPorId(Integer id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException(MSG1));
    }

    public UsuarioModel actualizar(Integer id, UsuarioModel request){
        UsuarioModel usuario = buscarPorId(id);
        usuario.setNombre(request.getNombre());
        usuario.setApellido(request.getApellido());
        usuario.setCorreo(usuario.getCorreo());
        usuario.setTelefono(request.getTelefono());

        return repository.save(usuario);
    }
    public void eliminar(Integer id){
         UsuarioModel usuario = buscarPorId(id);
         usuario.setEstado(CODENEG);
         repository.save(usuario);
    }

}
