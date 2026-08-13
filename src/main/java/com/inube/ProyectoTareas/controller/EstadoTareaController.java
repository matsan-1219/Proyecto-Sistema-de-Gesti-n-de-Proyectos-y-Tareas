package com.inube.ProyectoTareas.controller;

import com.inube.ProyectoTareas.dto.ApiResponse;
import com.inube.ProyectoTareas.model.EstadoTareaModel;
import com.inube.ProyectoTareas.service.EstadoTareaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.inube.ProyectoTareas.util.UtilConstants.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/estadotarea")
@RequiredArgsConstructor
@Tag(name = "ESTADOTAREA", description = "Operaciones de estado tarea")
public class EstadoTareaController {
    private final EstadoTareaService service;



    @GetMapping
    public ResponseEntity<List<EstadoTareaModel>> listar() {
        List<EstadoTareaModel> lista = service.lista();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoTareaModel> buscarPorId(@PathVariable Integer id) {
        EstadoTareaModel estadoTarea = service.buscarPorId(id);
        return ResponseEntity.ok(estadoTarea);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoTareaModel> cambiar(@PathVariable Integer id, @RequestBody EstadoTareaModel request) {
        EstadoTareaModel estadoActualizado = service.cambiar(id, request);
        return ResponseEntity.ok(estadoActualizado);
    }
}



