package com.instituto.instituto_api.service;

import com.instituto.instituto_api.estructuras.ListaEstudiantes;
import com.instituto.instituto_api.model.Estudiante;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudiantesService {
    private final ListaEstudiantes lista = new ListaEstudiantes();

    public String agregar(int id, String nombre, int puntaje) {
        Estudiante estudiante = new Estudiante(id, nombre, puntaje);
        lista.insertar(estudiante);
        return "Estudiante " + nombre + " agregado con puntaje " + puntaje;
    }

    public List<Estudiante> obtenerTodos() {
        return lista.obtenerTodos();
    }

    public List<Estudiante> obtenerOrdenados() {
        return lista.ordenarAprobadosPorPuntaje();
    }

    public Estudiante buscarPorNombre(String nombre) {
        return lista.buscarPorNombre(nombre);
    }
}
