package com.instituto.instituto_api.estructuras;

import com.instituto.instituto_api.model.Estudiante;

public class Nodo {
    public Estudiante estudiante;
    public Nodo siguiente;

    public Nodo(Estudiante estudiante) {
        this.estudiante = estudiante;
        this.siguiente = null;
    }
}
