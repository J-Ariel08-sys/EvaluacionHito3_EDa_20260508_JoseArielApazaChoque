package com.instituto.instituto_api.controller;

import com.instituto.instituto_api.service.CalificacionesService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notas")
public class CalificacionesController {
    private final CalificacionesService service;

    public CalificacionesController(CalificacionesService service) {
        this.service = service;
    }

    @GetMapping("/agregar")
    public String agregar(@RequestParam double valor) {
        return service.agregar(valor);
    }

    @GetMapping
    public double[] obtenerTodas() {
        return service.obtenerTodas();
    }

    @GetMapping("/promedio")
    public String promedio() {
        return "Promedio: " + service.calcularPromedio();
    }

    @GetMapping("/max")
    public String max() {
        return "Nota maxima: " + service.obtenerMax();
    }

    @GetMapping("/min")
    public String min() {
        return "Nota minima: " + service.obtenerMin();
    }
}
