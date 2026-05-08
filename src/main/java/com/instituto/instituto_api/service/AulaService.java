package com.instituto.instituto_api.service;

import org.springframework.stereotype.Service;

@Service
public class AulaService {
    private static final int FILAS = 5;
    private static final int COLUMNAS = 5;
    private int[][] aula = new int[FILAS][COLUMNAS];

    public String ocupar(int fila, int columna) {
        if (fila < 0 || fila >= FILAS || columna < 0 || columna >= COLUMNAS) {
            return "Posicion fuera de rango. Fila: 0-" + (FILAS - 1) + ", Columna: 0-" + (COLUMNAS - 1);
        }
        if (aula[fila][columna] == 1) {
            return "El asiento [" + fila + "][" + columna + "] ya esta ocupado";
        }
        aula[fila][columna] = 1;
        return "Asiento [" + fila + "][" + columna + "] ocupado";
    }

    public String liberar(int fila, int columna) {
        if (fila < 0 || fila >= FILAS || columna < 0 || columna >= COLUMNAS) {
            return "Posicion fuera de rango. Fila: 0-" + (FILAS - 1) + ", Columna: 0-" + (COLUMNAS - 1);
        }
        if (aula[fila][columna] == 0) {
            return "El asiento [" + fila + "][" + columna + "] ya esta libre";
        }
        aula[fila][columna] = 0;
        return "Asiento [" + fila + "][" + columna + "] liberado";
    }

    public int[][] obtenerMatriz() {
        return aula;
    }

    public int contarOcupados() {
        int count = 0;
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (aula[i][j] == 1) count++;
            }
        }
        return count;
    }
}
