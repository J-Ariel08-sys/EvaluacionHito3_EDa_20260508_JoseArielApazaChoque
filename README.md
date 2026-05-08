# Instituto API

## Estudiante - Jose Ariel Apaza Choque
## Materia - Estructura de Datos
## Docente - Ing. Ruben Gonzalo Soria Soria

API REST desarrollada con Spring Boot para administrar calificaciones de estudiantes, distribución de asientos en aulas y participantes ordenados por puntaje.

## Requisitos

- Java 25
- Maven
- Spring Boot 4.0.6

## Ejecutar el proyecto

```bash
mvnw spring-boot:run
```

El servidor inicia en `http://localhost:8080`

---

## Endpoints

### Parte 1 - Calificaciones (`/notas`)

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/notas/agregar?valor=90` | Agregar calificación (máx 10) |
| GET | `/notas` | Mostrar todas las calificaciones |
| GET | `/notas/promedio` | Calcular promedio |
| GET | `/notas/max` | Nota máxima |
| GET | `/notas/min` | Nota mínima |

**Ejemplo:**
```
GET http://localhost:8080/notas/agregar?valor=85
GET http://localhost:8080/notas/promedio
```

---

### Parte 2 - Aula (`/aula`) — Matriz 5x5

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/aula` | Mostrar matriz completa |
| GET | `/aula/ocupados` | Cantidad de asientos ocupados |
| GET | `/aula/ocupar?fila=1&columna=2` | Ocupar asiento |
| GET | `/aula/liberar?fila=1&columna=2` | Liberar asiento |

**Ejemplo:**
```
GET http://localhost:8080/aula/ocupar?fila=0&columna=0
GET http://localhost:8080/aula/ocupados
```

> Las filas y columnas van de 0 a 4.

---

### Parte 3 - Estudiantes (`/estudiantes`)

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/estudiantes/agregar?id=1&nombre=Ana&puntaje=95` | Agregar estudiante |
| GET | `/estudiantes` | Mostrar todos los estudiantes |
| GET | `/estudiantes/ordenados` | Aprobados ordenados por puntaje (mayor a menor) |
| GET | `/estudiantes/buscar/Ana` | Buscar estudiante por nombre |

**Ejemplo:**
```
GET http://localhost:8080/estudiantes/agregar?id=1&nombre=Ana&puntaje=95
GET http://localhost:8080/estudiantes/ordenados
```

> Aprobados: puntaje >= 51. El ordenamiento usa Bubble Sort.
