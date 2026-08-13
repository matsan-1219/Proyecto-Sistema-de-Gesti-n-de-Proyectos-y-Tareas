package com.inube.ProyectoTareas.controller;

import com.inube.ProyectoTareas.dto.ApiResponse;
import com.inube.ProyectoTareas.model.UsuarioModel;
import com.inube.ProyectoTareas.service.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static com.inube.ProyectoTareas.util.UtilConstants.*;

@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
@Tag(name = "USUARIO", description = "Operaciones de los usuarios")
public class UsuarioController {
    private final UsuarioService service;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> guardar(@RequestBody UsuarioModel usuario){
        return ResponseEntity.ok(new ApiResponse<>(true,MSG2, service.guardar(usuario)));

    }

    @GetMapping
    public ResponseEntity<ApiResponse<?>> listar(){
       return ResponseEntity.ok(new ApiResponse<>(true, MSG, service.listar()));

    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(new ApiResponse<>(true,MSG, service.buscarPorId(id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<?>>actualizar(@PathVariable Integer id,@RequestBody UsuarioModel usuario){
        return ResponseEntity.ok(
                new ApiResponse<>(true, MSG3, service.actualizar(id,usuario)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>>eliminar(@PathVariable Integer id){
        service.eliminar(id);
        return ResponseEntity.ok(new ApiResponse<>(true,MSG4, null));
    }
}
