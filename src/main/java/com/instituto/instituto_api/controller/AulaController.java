package com.instituto.instituto_api.controller;

import com.instituto.instituto_api.service.AulaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aula")
public class AulaController {
    private final AulaService service;

    public AulaController(AulaService service) {
        this.service = service;
    }

    @GetMapping
    public int[][] obtenerMatriz() {
        return service.obtenerMatriz();
    }

    @GetMapping("/ocupados")
    public String ocupados() {
        return "Asientos ocupados: " + service.contarOcupados();
    }

    @GetMapping("/ocupar")
    public String ocupar(@RequestParam int fila, @RequestParam int columna) {
        return service.ocupar(fila, columna);
    }

    @GetMapping("/liberar")
    public String liberar(@RequestParam int fila, @RequestParam int columna) {
        return service.liberar(fila, columna);
    }
}
