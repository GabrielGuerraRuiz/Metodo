# Metodo
## Descripción General del Proyecto

Este repositorio contiene tres programas diseñados para resolver problemas específicos de manera eficiente. Cada programa está desarrollado con un enfoque modular y es fácil de usar.

## Programas Incluidos

1. **JuegoAdivinanzaMetodo.java**: El código es un juego de adivinanza en Java donde el usuario intenta adivinar un número aleatorio entre 1 y 100 en un máximo de 5 intentos. El programa utiliza un método jugarAdivinanza para gestionar el flujo del juego, obtenerNumeroUsuario para validar la entrada del usuario, y verificarNumero para comparar el número ingresado con el número aleatorio, proporcionando pistas si es mayor o menor. Si el usuario acierta o agota los intentos, el juego termina mostrando el resultado.

2. **SistemaRegistroEstudiantesMetodo.java**: El programa es un sistema de registro de estudiantes en Java que permite realizar las siguientes operaciones: registrar nuevos estudiantes, mostrar la lista de estudiantes registrados, buscar un estudiante por su matrícula, y eliminar un estudiante por matrícula. Utiliza un arreglo para almacenar hasta 100 estudiantes y un menú interactivo para que el usuario seleccione las opciones. Cada estudiante tiene atributos como nombre, edad, matrícula y carrera.

3. **Programa 3**: Breve descripción del propósito del programa.

## Instalación

1. Clona este repositorio en tu máquina local:
    ```bash
    git clone https://github.com/GabrielGuerraRuiz/Metodo.git
    ```
2. Navega al directorio del proyecto:
    ```bash
    cd Metodo
    ```
3. Asegúrate de tener instaladas las dependencias necesarias. Consulta las instrucciones específicas en los directorios de cada programa.

## Uso

1. Dirígete al directorio del programa que deseas ejecutar:
    ```bash
    cd Programa1
    ```
2. Sigue las instrucciones específicas en el archivo `README.md` de cada programa para ejecutarlo.

# Comparación de Versiones

## Índice
1. [Descripción del Proyecto](#descripcion-del-proyecto)
2. [Funcionalidad y estructura Gestor de Contactos antiguo](#funcionalidad-y-estructura-gestor-de-contactos-antiguo)
   - [Implementación de los métodos](#implementacion-de-los-metodos)
3. [Funcionalidad y estructura final del Gestor de Contactos](#funcionalidad-y-estructura-final-del-gestor-de-contactos)
4. [Funcionalidad y estructura Sistema Registros Estudiantes antiguo](#funcionalidad-y-estructura-sistema-registros-estudiantes-antiguo)
   - [Implementación de los métodos](#implementacion-de-los-metodos)
5. [Funcionalidad y estructura final del Sistema Registros Estudiantes](#funcionalidad-y-estructura-final-del-sistema-registros-estudiantes)
6. [Funcionalidad y estructura Juego Adivinanza antiguo](#funcionalidad-y-estructura-juego-adivinanza-antiguo)
   - [Implementación de los métodos](#implementacion-de-los-metodos)
7. [Funcionalidad y estructura final del Juego Adivinanza](#funcionalidad-y-estructura-final-del-juego-adivinanza)
8. [Instrucciones para compilar los programas (Java)](#instrucciones-para-compilar-los-programas-java)
9. [Link del GitHub](#link-del-github)

---

## Descripción del Proyecto
Este documento presenta una comparación entre las versiones antiguas y nuevas de tres programas desarrollados en C y Java:

- **Gestor de Contactos**: Un programa que permite almacenar, buscar, eliminar y modificar contactos.
- **Sistema de Registros de Estudiantes**: Un sistema para registrar estudiantes con atributos como nombre, edad y matrícula.
- **Juego de Adivinanza**: Un juego que desafía al usuario a adivinar un número dentro de un rango específico.

Se analizará la evolución de cada programa desde su versión inicial hasta la final, resaltando mejoras en la estructura, optimización de código y nuevas funcionalidades.

---

# Comparación de Versiones: Gestor de Contactos

## Funcionalidad y estructura Gestor de Contactos antiguo

El **Gestor de Contactos** en su versión inicial fue desarrollado en C, utilizando una estructura basada en arreglos dinámicos. Cada contacto se almacenaba en una estructura de datos definida mediante `struct`, y el programa permitía agregar, buscar y eliminar contactos de manera secuencial. Sin embargo, esta versión presentaba varias limitaciones:

- **Uso de arreglos estáticos/dinámicos con `realloc`**: Esto podía generar problemas de fragmentación de memoria y aumentar el tiempo de ejecución al necesitar reasignaciones de memoria frecuentes.
- **Manejo manual de memoria**: Se debía realizar la liberación manual con `free()`, lo que llevaba a posibles fugas de memoria si no se manejaba correctamente.
- **Búsqueda ineficiente**: Para encontrar un contacto, se realizaba una búsqueda secuencial sin optimización alguna, lo que podía afectar el rendimiento en listas grandes.
- **Eliminación ineficiente**: Al eliminar un contacto, se tenía que desplazar los elementos manualmente y reasignar memoria.

### Implementación de los métodos

A continuación se presenta un fragmento del código en C que implementa la eliminación de un contacto:

```c
void eliminarContacto(Contacto **contactos, int *numContactos, const char *nombre) {
    int encontrado = 0;
    for (int i = 0; i < *numContactos; i++) {
        if (strcmp((*contactos)[i].nombre, nombre) == 0) {
            encontrado = 1;
            for (int j = i; j < *numContactos - 1; j++) {
                (*contactos)[j] = (*contactos)[j + 1];
            }
            (*numContactos)--;
            *contactos = realloc(*contactos, (*numContactos) * sizeof(Contacto));
            printf("Contacto eliminado exitosamente.\n");
            break;
        }
    }
    if (!encontrado) {
        printf("Contacto no encontrado.\n");
    }
}
```

**Problemas de esta implementación:**
- **Uso de `realloc` en cada eliminación**: Esto podía ralentizar el programa y generar errores de memoria.
- **Comparación de cadenas sin normalización**: Se utilizaba `strcmp()`, lo que significaba que `"Juan"` y `"juan"` eran considerados diferentes.
- **No se manejaban excepciones o errores en `realloc`**: Si la reasignación de memoria fallaba, el programa podía comportarse de manera inesperada.

---

## Funcionalidad y estructura final del Gestor de Contactos (Java)

En la versión moderna, el programa fue reescrito en Java, mejorando su estructura y eficiencia. La principal diferencia es el uso de **colecciones dinámicas (`ArrayList`) en lugar de arreglos estáticos**, eliminando la necesidad de manejar memoria manualmente.

**Principales mejoras:**
- **Uso de `ArrayList<Contacto>` en lugar de arreglos**: Esto permite manejar contactos de manera dinámica sin preocuparse por la reasignación manual de memoria.
- **Eliminación eficiente con `Iterator`**: Se evita el desplazamiento manual de elementos y se usa `iterator.remove()` para eliminar de manera segura.
- **Comparaciones sin sensibilidad a mayúsculas/minúsculas**: Se usa `equalsIgnoreCase()` para mejorar la precisión en la búsqueda.
- **Mensajes de salida más descriptivos**: Se mejora la interfaz textual para el usuario.
- **Mejor manejo de errores y excepciones**: Se evita el acceso a posiciones inexistentes de memoria.

### Implementación de los métodos

**Ejemplo de código de la versión nueva en Java:**

```java
import java.util.ArrayList;
import java.util.Iterator;

public class GestorContactos {
    private ArrayList<Contacto> listaContactos;

    public GestorContactos() {
        this.listaContactos = new ArrayList<>();
    }

    public void eliminarContacto(String nombre) {
        Iterator<Contacto> iterator = listaContactos.iterator();
        while (iterator.hasNext()) {
            Contacto contacto = iterator.next();
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                iterator.remove();
                System.out.println("Contacto eliminado exitosamente.");
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }
}
```

### Diferencias clave con la versión antigua

| Característica              | Versión Antigua (C) | Versión Nueva (Java) |
|-----------------------------|--------------------|--------------------|
| Estructura de datos        | Arreglo dinámico (`realloc`) | `ArrayList<Contacto>` |
| Eliminación de contactos  | Desplazamiento manual y `realloc` | Uso de `Iterator.remove()` |
| Manejo de memoria          | Manual (`malloc`, `free`) | Automático (garbage collector) |
| Comparación de nombres    | `strcmp()` (sensible a mayúsculas) | `equalsIgnoreCase()` |
| Seguridad                 | Posibles fugas de memoria | Sin problemas de memoria |
| Manejo de errores         | Limitado (sin validaciones robustas) | Excepciones y validaciones adecuadas |

**Beneficios de la nueva implementación:**
- **Mayor eficiencia y menor consumo de memoria**: Al evitar el uso de `realloc`, se reducen los costos de reasignación de memoria.
- **Mejor legibilidad y mantenibilidad**: El código

# Comparación de Versiones: Sistema de Registro de Estudiantes

## Funcionalidad y estructura del Sistema de Registro de Estudiantes antiguo

El **Sistema de Registro de Estudiantes** en su versión inicial fue desarrollado en C y utilizaba estructuras de arreglos estáticos para almacenar la información de los estudiantes. Su funcionamiento principal consistía en permitir a los usuarios agregar, mostrar y buscar estudiantes por su identificador.

Sin embargo, esta versión presentaba varias limitaciones:

- **Uso de arreglos de tamaño fijo**: No permitía agregar estudiantes más allá del tamaño predefinido del arreglo, lo que limitaba la escalabilidad del sistema.
- **Búsqueda ineficiente**: La búsqueda de un estudiante requería recorrer secuencialmente el arreglo.
- **Eliminación complicada**: No existía un mecanismo eficiente para eliminar estudiantes, lo que implicaba desplazar elementos manualmente.
- **Manejo manual de memoria**: No existía una gestión automática de memoria, lo que podía generar errores o fugas de memoria.

### Implementación de los métodos

A continuación se muestra un fragmento del código en C utilizado en la versión antigua:

```c
#include <stdio.h>
#include <string.h>

#define MAX_ESTUDIANTES 100

typedef struct {
    char nombre[50];
    int edad;
    char matricula[15];
} Estudiante;

Estudiante estudiantes[MAX_ESTUDIANTES];
int numEstudiantes = 0;

void agregarEstudiante(const char *nombre, int edad, const char *matricula) {
    if (numEstudiantes < MAX_ESTUDIANTES) {
        strcpy(estudiantes[numEstudiantes].nombre, nombre);
        estudiantes[numEstudiantes].edad = edad;
        strcpy(estudiantes[numEstudiantes].matricula, matricula);
        numEstudiantes++;
    } else {
        printf("No se pueden agregar más estudiantes.\n");
    }
}
```

**Problemas de esta implementación:**
- Uso de `strcpy` sin validaciones, lo que podía causar desbordamientos de búfer.
- No permitía eliminar estudiantes de forma eficiente.
- El sistema no podía crecer dinámicamente.

---

## Funcionalidad y estructura final del Sistema de Registro de Estudiantes (Java)

En la nueva versión, el programa fue reescrito en Java utilizando **colecciones dinámicas (`ArrayList`)** en lugar de arreglos estáticos. Esto resolvió las limitaciones de la versión anterior y mejoró la eficiencia del sistema.

### Mejoras implementadas:
- **Uso de `ArrayList<Estudiante>`**: Permite agregar y eliminar estudiantes de manera dinámica sin restricciones de tamaño.
- **Mejor organización del código**: Se introdujeron clases y encapsulamiento, mejorando la legibilidad y mantenibilidad.
- **Búsqueda eficiente**: Uso de `stream().filter()` para buscar estudiantes más rápidamente.
- **Manejo de excepciones**: Se agregó validación para evitar errores en entradas de datos.

### Implementación de los métodos

Ejemplo de la nueva implementación en Java:

```java
import java.util.ArrayList;

class Estudiante {
    private String nombre;
    private int edad;
    private String matricula;

    public Estudiante(String nombre, int edad, String matricula) {
        this.nombre = nombre;
        this.edad = edad;
        this.matricula = matricula;
    }

    public String getNombre() { return nombre; }
    public String getMatricula() { return matricula; }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad + ", Matrícula: " + matricula;
    }
}

class RegistroEstudiantes {
    private ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();

    public void agregarEstudiante(String nombre, int edad, String matricula) {
        listaEstudiantes.add(new Estudiante(nombre, edad, matricula));
    }

    public Estudiante buscarEstudiante(String matricula) {
        return listaEstudiantes.stream()
            .filter(e -> e.getMatricula().equalsIgnoreCase(matricula))
            .findFirst()
            .orElse(null);
    }
}
```

### Diferencias clave con la versión antigua

| Característica              | Versión Antigua (C) | Versión Nueva (Java) |
|-----------------------------|---------------------|---------------------|
| Estructura de datos        | Arreglo estático (`MAX_ESTUDIANTES`) | `ArrayList<Estudiante>` |
| Búsqueda de estudiantes   | Recorrido secuencial | Uso de `stream().filter()` |
| Eliminación de estudiantes | No soportada o complicada | Uso de `removeIf()` |
| Manejo de memoria          | Manual (`malloc`, `free`) | Automático (garbage collector) |
| Seguridad                 | Posibles errores de memoria | Manejo seguro de objetos |
| Escalabilidad             | Limitada al tamaño del arreglo | Dinámica sin límite |

### Beneficios de la nueva implementación
- **Mayor flexibilidad y escalabilidad**: Se pue
- **Mayor flexibilidad y escalabilidad:** Se pueden agregar tantos estudiantes como sea necesario sin preocuparnos por límites.
- **Mejor rendimiento:** La búsqueda de estudiantes es más eficiente gracias a los streams.
- **Código más modular y reutilizable:** La implementación en Java está bien organizada y permite mejoras fáciles.
- **Mejor seguridad y manejo de errores:** Se evita el acceso a memoria incorrecta o desbordamientos de búfer.

  
# Comparación de Versiones: Juego de Adivinanza

## Funcionalidad y estructura Juego de Adivinanza antiguo

La versión original del **Juego de Adivinanza** fue desarrollada en C y se basaba en la generación de un número aleatorio que el usuario debía adivinar mediante intentos sucesivos. El programa utilizaba `rand()` para generar el número y pedía al usuario que ingresara valores hasta acertar.

**Principales características y limitaciones:**
- **Generación de números pseudoaleatorios con `rand()`**: No tan impredecibles sin una semilla aleatoria (`srand(time(NULL))`).
- **Interacción basada en `scanf()`**: Sin validaciones robustas para entradas incorrectas.
- **Ciclo `while` para repetir intentos**: Se repetía hasta que el usuario acertara.
- **Mensajes de pista limitados**: Solo indicaba si el número era mayor o menor.
- **Sin control de intentos máximos**: El usuario podía adivinar indefinidamente.

### Implementación de los métodos en C

```c
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main() {
    int numeroSecreto, intento;
    srand(time(NULL));
    numeroSecreto = rand() % 100 + 1; // Número entre 1 y 100
    
    printf("Adivina el número entre 1 y 100:\n");
    
    while (1) {
        printf("Ingresa un número: ");
        scanf("%d", &intento);
        
        if (intento < numeroSecreto) {
            printf("Demasiado bajo. Intenta de nuevo.\n");
        } else if (intento > numeroSecreto) {
            printf("Demasiado alto. Intenta de nuevo.\n");
        } else {
            printf("\nFelicidades! Has adivinado el número!\n");
            break;
        }
    }
    return 0;
}
```

**Problemas de esta implementación:**
- **Ausencia de validación de entrada**: Si el usuario ingresaba un valor no numérico, el programa podía fallar.
- **Uso de `scanf()` sin limpieza del buffer**: Puede causar problemas si se ingresan caracteres no esperados.
- **Ejecución indefinida**: No hay un límite de intentos.
- **Falta de modularidad**: Toda la lógica está en `main()`, lo que dificulta la extensión del código.

---

## Funcionalidad y estructura final del Juego de Adivinanza (Java)

En la versión moderna, el juego fue reescrito en Java con mejoras en estructura y usabilidad. Se utilizó la clase `Random` para una mejor generación de números aleatorios y se implementó validación de entradas con `Scanner`.

**Principales mejoras:**
- **Uso de `Random` para generación de números aleatorios**.
- **Validación de entradas**: Manejo de errores para evitar fallos por entradas no numéricas.
- **Límite de intentos**: Se establece un número máximo de intentos.
- **Mayor modularidad**: Se separa la lógica en métodos para mejor mantenimiento.
- **Mensajes de ayuda mejorados**: Indica si el jugador está cerca del número correcto.

### Implementación de los métodos en Java

```java
import java.util.Random;
import java.util.Scanner;

public class JuegoAdivinanza {
    private static final int MAX_INTENTOS = 10;
    
    public static void main(String[] args) {
        Random random = new Random();
        int numeroSecreto = random.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);
        int intentos = 0;
        boolean adivinado = false;
        
        System.out.println("Adivina el número entre 1 y 100. Tienes " + MAX_INTENTOS + " intentos.");
        
        while (intentos < MAX_INTENTOS) {
            System.out.print("Ingresa un número: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Entrada no válida. Ingresa un número.");
                scanner.next(); // Limpiar entrada incorrecta
                continue;
            }
            
            int intento = scanner.nextInt();
            intentos++;
            
            if (intento < numeroSecreto) {
                System.out.println("Demasiado bajo. Te quedan " + (MAX_INTENTOS - intentos) + " intentos.");
            } else if (intento > numeroSecreto) {
                System.out.println("Demasiado alto. Te quedan " + (MAX_INTENTOS - intentos) + " intentos.");
            } else {
                System.out.println("\nFelicidades! Has adivinado el número en " + intentos + " intentos!");
                adivinado = true;
                break;
            }
        }
        
        if (!adivinado) {
            System.out.println("Lo siento, se te acabaron los intentos. El número era " + numeroSecreto);
        }
        scanner.close();
    }
}
```

### Diferencias clave con la versión antigua

| Característica            | Versión Antigua (C) | Versión Nueva (Java) |
|---------------------------|--------------------|--------------------|
| Generación de números   | `rand()` con `srand(time(NULL))` | `Random.nextInt(100) + 1` |
| Entrada del usuario       | `scanf()` sin validación | `Scanner` con verificación de tipo |
| Límite de intentos       | No implementado | `MAX_INTENTOS = 10` |
| Modularidad               | Todo en `main()` | Separación de lógica en métodos |
| Manejo de errores         | No validaciones | Se evita ingreso de datos incorrectos |
| Mensajes de pista         | Solo "mayor" o "menor" | Indica intentos restantes |

**Beneficios de la nueva implementación:**
- **Mejor experiencia de usuario**: Se agregaron mensajes de pista más claros.
- **Mayor seguridad**: Se evita el ingreso de datos inválidos.
- **Ejecución controlada**: Se establece un límite de intentos.
- **Código más mantenible**: La estructura modular facilita futuras mejoras.

---


## Instrucciones para compilar los programas (Java)
```sh
javac NombreDelPrograma.java
java NombreDelPrograma
```

---

## Link del GitHub
[Repositorio del Proyecto](https://github.com/GabrielGuerraRuiz)

