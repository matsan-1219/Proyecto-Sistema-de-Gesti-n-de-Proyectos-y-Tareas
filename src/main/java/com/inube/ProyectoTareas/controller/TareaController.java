package com.inube.ProyectoTareas.controller;

import com.inube.ProyectoTareas.dto.ApiResponse;
import com.inube.ProyectoTareas.model.TareaModel;
import com.inube.ProyectoTareas.service.TareaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.inube.ProyectoTareas.util.UtilConstants.*;

@RestController
@RequestMapping("/api/tareas")
@RequiredArgsConstructor
@Tag(name = "TAREA", description = "Operaciones de TAREAS")
public class TareaController {

    private final TareaService service;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> guardar(@RequestBody TareaModel tarea) {

       return ResponseEntity.ok(new ApiResponse<>(true,MSG11, service.guardar(tarea)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<?>> listar() {
        return ResponseEntity.ok(new ApiResponse<>(true, MSG, service.listar()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>>  buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(new ApiResponse<>(true,MSG, service.buscarPorId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<?>>cambiar(@PathVariable Integer id, @RequestBody TareaModel tarea) {

        return ResponseEntity.ok(new ApiResponse<>(true, MSG12, service.cambiar(id,tarea)));
    }


}
