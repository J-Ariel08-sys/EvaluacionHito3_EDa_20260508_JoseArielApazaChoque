package com.instituto.instituto_api.controller;

import com.instituto.instituto_api.model.Estudiante;
import com.instituto.instituto_api.service.EstudiantesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudiantesController {
    private final EstudiantesService service;

    public EstudiantesController(EstudiantesService service) {
        this.service = service;
    }

    @GetMapping("/agregar")
    public String agregar(@RequestParam int id, @RequestParam String nombre, @RequestParam int puntaje) {
        return service.agregar(id, nombre, puntaje);
    }

    @GetMapping
    public List<Estudiante> obtenerTodos() {
        return service.obtenerTodos();
    }

    @GetMapping("/ordenados")
    public List<Estudiante> ordenados() {
        return service.obtenerOrdenados();
    }

    @GetMapping("/buscar/{nombre}")
    public Object buscar(@PathVariable String nombre) {
        Estudiante e = service.buscarPorNombre(nombre);
        if (e == null) return "Estudiante no encontrado";
        return e;
    }
}
