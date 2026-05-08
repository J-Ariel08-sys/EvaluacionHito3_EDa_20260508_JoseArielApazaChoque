package com.instituto.instituto_api.service;

import org.springframework.stereotype.Service;

@Service
public class CalificacionesService {
    private static final int CAPACIDAD = 10;
    private double[] calificaciones = new double[CAPACIDAD];
    private int contador = 0;

    public String agregar(double valor) {
        if (contador >= CAPACIDAD) {
            return "Arreglo lleno, maximo " + CAPACIDAD + " calificaciones";
        }
        calificaciones[contador++] = valor;
        return "Calificacion " + valor + " agregada. Total: " + contador + "/" + CAPACIDAD;
    }

    public double[] obtenerTodas() {
        double[] resultado = new double[contador];
        for (int i = 0; i < contador; i++) {
            resultado[i] = calificaciones[i];
        }
        return resultado;
    }

    public double calcularPromedio() {
        if (contador == 0) return 0;
        double suma = 0;
        for (int i = 0; i < contador; i++) {
            suma += calificaciones[i];
        }
        return suma / contador;
    }

    public double obtenerMax() {
        if (contador == 0) return 0;
        double max = calificaciones[0];
        for (int i = 1; i < contador; i++) {
            if (calificaciones[i] > max) max = calificaciones[i];
        }
        return max;
    }

    public double obtenerMin() {
        if (contador == 0) return 0;
        double min = calificaciones[0];
        for (int i = 1; i < contador; i++) {
            if (calificaciones[i] < min) min = calificaciones[i];
        }
        return min;
    }
}
