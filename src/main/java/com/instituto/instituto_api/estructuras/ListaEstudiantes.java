package com.instituto.instituto_api.estructuras;

import com.instituto.instituto_api.model.Estudiante;
import java.util.ArrayList;
import java.util.List;

public class ListaEstudiantes {
    private Nodo cabeza;

    public void insertar(Estudiante estudiante) {
        Nodo nuevo = new Nodo(estudiante);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    public List<Estudiante> obtenerTodos() {
        List<Estudiante> lista = new ArrayList<>();
        Nodo actual = cabeza;
        while (actual != null) {
            lista.add(actual.estudiante);
            actual = actual.siguiente;
        }
        return lista;
    }

    // Bubble sort descendente, solo estudiantes aprobados (puntaje >= 51)
    public List<Estudiante> ordenarAprobadosPorPuntaje() {
        List<Estudiante> aprobados = new ArrayList<>();
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.estudiante.getPuntaje() >= 51) {
                aprobados.add(actual.estudiante);
            }
            actual = actual.siguiente;
        }
        int n = aprobados.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (aprobados.get(j).getPuntaje() < aprobados.get(j + 1).getPuntaje()) {
                    Estudiante temp = aprobados.get(j);
                    aprobados.set(j, aprobados.get(j + 1));
                    aprobados.set(j + 1, temp);
                }
            }
        }
        return aprobados;
    }

    public Estudiante buscarPorNombre(String nombre) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.estudiante.getNombre().equalsIgnoreCase(nombre)) {
                return actual.estudiante;
            }
            actual = actual.siguiente;
        }
        return null;
    }
}
