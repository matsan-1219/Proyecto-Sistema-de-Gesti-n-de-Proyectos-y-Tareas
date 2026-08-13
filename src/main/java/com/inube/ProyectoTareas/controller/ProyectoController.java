package com.inube.ProyectoTareas.controller;
import com.inube.ProyectoTareas.dto.ApiResponse;
import com.inube.ProyectoTareas.model.ProyectoModel;
import com.inube.ProyectoTareas.model.TareaModel;
import com.inube.ProyectoTareas.model.UsuarioModel;
import com.inube.ProyectoTareas.service.ProyectoService;
import com.inube.ProyectoTareas.service.TareaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static com.inube.ProyectoTareas.util.UtilConstants.*;

@RestController
@RequestMapping("/api/proyecto")
@RequiredArgsConstructor
@Tag(name = "PROYECTO", description = "Operaciones de los proyectos")

public class ProyectoController {
    private final ProyectoService service;
    private final TareaService tareaService;

    @PostMapping

    public ResponseEntity<ApiResponse<?>> guardar(@RequestBody ProyectoModel proyecto){
        return ResponseEntity.ok(new ApiResponse<>(true,MSG6, service.guardar(proyecto)));

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
    public ResponseEntity<ApiResponse<?>>actualizar(@PathVariable Integer id,@RequestBody ProyectoModel proyecto){
        return ResponseEntity.ok(
                new ApiResponse<>(true, MSG7, service.actualizar(id,proyecto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>>eliminar(@PathVariable Integer id){
        service.eliminar(id);
        return ResponseEntity.ok(new ApiResponse<>(true,MSG8, null));
    }
    @GetMapping("/{id}/tareas")
    public ResponseEntity<ApiResponse<?>> obtenerTareasPorProyecto(@PathVariable Integer id) {

        List<TareaModel> tareas = tareaService.listarTareasPorProyecto(id);
        return ResponseEntity.ok(new ApiResponse<>(true, MSG, tareas));
    }

}
