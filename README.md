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

# Comparación de Versiones: Gestor de Contactos, Sistema de Registros Estudiantes y Juego de Adivinanza

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

## Funcionalidad y estructura Gestor de Contactos antiguo

### Implementación de los métodos

**Ejemplo de código de la versión antigua (C)**:
```c
void eliminarContacto(Contacto **contactos, int *numContactos, const char *nombre){
    int encontrado = 0;
    for (int i=0; i < *numContactos; i++){
        if (strcmp((*contactos)[i].nombre, nombre) == 0){
            encontrado = 1;
            for (int j = i; j < *numContactos - 1; j++){
                (*contactos)[j] = (*contactos)[j + 1];
            }
            (*numContactos)--;
            *contactos = realloc(*contactos, (*numContactos) * sizeof(Contacto));
            printf("Contacto eliminado exitosamente. \n");
            break;
        }
    }
    if (!encontrado){
        printf("Contacto no encontrado\n");
    }
}
```

Problemas de esta versión:
- Manejo de memoria poco eficiente.
- No hay validaciones robustas.
- Uso de `realloc` sin verificación de errores.

---

## Funcionalidad y estructura final del Gestor de Contactos (Java)

**Ejemplo de código de la versión nueva en Java**:
```java
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
```

Mejoras:
- Uso de `ArrayList` en lugar de arreglos estáticos.
- Implementación de `Iterator` para eliminar elementos de manera segura.
- Se mantiene la integridad de la lista sin manipular memoria manualmente.

---

## Funcionalidad y estructura Sistema Registros Estudiantes antiguo

### Implementación de los métodos
```java
public static void mostrarEstudiantes(Estudiante[] estudiantes) {
    for (Estudiante estudiante : estudiantes) {
        if (estudiante != null) {
            System.out.println("Nombre: " + estudiante.nombre);
            System.out.println("Edad: " + estudiante.edad);
            System.out.println("Matrícula: " + estudiante.matricula);
            System.out.println("Carrera: " + estudiante.carrera);
        }
    }
}
```

Problemas de esta versión:
- Uso de arreglos de tamaño fijo.
- Posibles errores de `NullPointerException`.

---

## Funcionalidad y estructura final del Sistema Registros Estudiantes

```java
public void mostrarEstudiantes() {
    for (Estudiante estudiante : listaEstudiantes) {
        System.out.println(estudiante);
    }
}
```

Mejoras:
- Uso de `ArrayList` para manejar estudiantes dinámicamente.
- Evita `NullPointerException`.
- Se sobrescribe `toString()` para mejor formato de salida.

---

## Funcionalidad y estructura Juego Adivinanza antiguo

### Implementación de los métodos
```java
Random rand = new Random();
int numeroSecreto = rand.nextInt(100) + 1;
int intentos = 0;
boolean acertado = false;
```

Problemas:
- No maneja errores si el usuario ingresa letras.
- No permite reiniciar la partida sin cerrar el programa.

---

## Funcionalidad y estructura final del Juego Adivinanza

```java
try {
    Scanner scanner = new Scanner(System.in);
    while (true) {
        System.out.print("Ingrese un número (1-100): ");
        int numeroUsuario = scanner.nextInt();
        if (numeroUsuario == numeroSecreto) {
            System.out.println("¡Adivinaste!");
            break;
        }
    }
} catch (InputMismatchException e) {
    System.out.println("Ingrese solo números.");
}
```

Mejoras:
- Manejo de excepciones con `try-catch`.
- Permite repetir sin reiniciar el programa.

---

## Instrucciones para compilar los programas (Java)
```sh
javac NombreDelPrograma.java
java NombreDelPrograma
```

---

## Link del GitHub
[Repositorio del Proyecto](https://github.com/GabrielGuerraRuiz)

