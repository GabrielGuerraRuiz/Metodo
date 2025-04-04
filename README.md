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

8. [Importancia de los métodos en nuestros programas](#Importancia-de-los-métodos-en-nuestros-programas)

9. [Instrucciones para compilar los programas (Java)](#instrucciones-para-compilar-los-programas-java)

10. [Link del GitHub](#link-del-github)

---

## Descripción del Proyecto
Este documento presenta una comparación entre las versiones antiguas y nuevas de tres programas desarrollados en C y Java:

- **Gestor de Contactos**: Un programa que permite almacenar, buscar, eliminar y modificar contactos.
- **Sistema de Registros de Estudiantes**: Un sistema para registrar estudiantes con atributos como nombre, edad y matrícula.
- **Juego de Adivinanza**: Un juego que desafía al usuario a adivinar un número dentro de un rango específico.

Se analizará la evolución de cada programa desde su versión inicial hasta la final, resaltando mejoras en la estructura, optimización de código y nuevas funcionalidades.

---

# Comparación de Versiones: Gestor de Contactos

## Funcionalidad y estructura del Gestor de Contactos antiguo
El gestor de contactos original estaba implementado en C y utilizaba memoria dinámica para almacenar los contactos. Algunas de sus características principales eran:

- Uso de estructuras (`struct`) para definir un contacto.
- Almacenamiento en un arreglo dinámico con `malloc` y `realloc`.
- Implementación manual de funciones para agregar, buscar, eliminar y mostrar contactos.
- Manejo de archivos para guardar y cargar los contactos.
- Interacción a través de un menú en consola.

Ejemplo de código en C:


```c
void mostrarMenu() {
    printf("\n--- Gestor de Contactos ---\n");
    printf("1. Agregar contacto\n");
    printf("2. Mostrar contactos\n");
    printf("3. Buscar contacto\n");
    printf("4. Eliminar contacto\n");
    printf("5. Guardar contactos\n");
    printf("6. Cargar contactos\n");
    printf("0. Salir\n");
}
```


```c
void agregarContacto(Contacto **contactos, int *numContactos) {
    *contactos = realloc(*contactos, (*numContactos + 1) * sizeof(Contacto));
    if (*contactos == NULL){
        printf("Error al asignar memoria.\n");
        return;
    }

    printf("Ingrese el nombre: ");
    scanf(" %[^
]", (*contactos)[*numContactos].nombre);

    printf("Ingrese el teléfono: ");
    scanf(" %[^
]", (*contactos)[*numContactos].telefono);

    printf("Ingrese el email: ");
    scanf(" %[^
]", (*contactos)[*numContactos].email);

    (*numContactos)++;
    printf("Contacto agregado exitosamente.\n");
}
```

Sin embargo, la implementación en C presentaba algunos inconvenientes, como la gestión manual de memoria y la falta de abstracción orientada a objetos.

---

## Funcionalidad y estructura final del Gestor de Contactos actualizado
El gestor de contactos actualizado fue reescrito en Java, aprovechando la Programación Orientada a Objetos (POO) y las estructuras de datos modernas. Sus principales mejoras incluyen:

- Uso de la clase `ArrayList` para el almacenamiento dinámico de contactos.
- Implementación de una clase `Contacto` para encapsular los datos.
- Manejo eficiente de memoria sin necesidad de asignación manual.
- Métodos más estructurados y organizados en la clase `ContactosApp`.
- Uso de `Scanner` para la interacción con el usuario.
- Separación clara de responsabilidades entre métodos.

Ejemplo de código en Java:

```java
private void mostrarMenu() {
    System.out.println("\nMenú:");
    System.out.println("1. Agregar contacto");
    System.out.println("2. Mostrar contactos");
    System.out.println("3. Buscar contacto");
    System.out.println("4. Eliminar contacto");
    System.out.println("0. Salir");
}
```


```java
private void agregarContacto() {
    System.out.print("Ingrese nombre: ");
    String nombre = scanner.nextLine();
    System.out.print("Ingrese teléfono: ");
    String telefono = scanner.nextLine();
    contactos.add(new Contacto(nombre, telefono));
    System.out.println("Contacto agregado exitosamente.");
}
```

---

### Diferencias clave con la versión antigua
| Característica | Versión en C | Versión en Java |
|--------------|-------------|---------------|
| Almacenamiento | Arreglo dinámico con `malloc` y `realloc` | `ArrayList` |
| Manejo de memoria | Manual | Automático (Garbage Collector) |
| Organización del código | Procedimental | Orientado a Objetos |
| Interacción con usuario | `scanf` y `printf` | `Scanner` y `System.out.println` |
| Seguridad | Riesgo de fugas de memoria | Manejo seguro de memoria |
| Simplicidad | Complejo por la gestión manual | Más claro y estructurado |

**Beneficios de la nueva implementación:**
- Código más legible y modular.
- Reducción del riesgo de errores de memoria.
- Mayor facilidad para la escalabilidad y mantenimiento.
- Uso de estructuras de datos modernas como `ArrayList`.
- Aplicación de principios de Programación Orientada a Objetos.

Con estos cambios, la versión en Java ofrece una solución más robusta y fácil de mantener en comparación con la implementación original en C.

### Capturas del funcionamiento
#### Función: Agregar contacto
![image](https://github.com/user-attachments/assets/03926e30-3962-4fc6-ba96-7059a0912ec2)
#### Función: Mostrar contactos
![image](https://github.com/user-attachments/assets/5ac0b862-148c-4f3f-b948-d92e6a75f670)
#### Función: Buscar contacto
![image](https://github.com/user-attachments/assets/c4d3fc80-5417-4afa-a7bd-a4aea8bb3421)
#### Función: Eliminar contacto
![image](https://github.com/user-attachments/assets/6f2b9a55-bf11-4767-8f1b-b7fce6b63f16)
#### Función: Salir del programa
![image](https://github.com/user-attachments/assets/8c5fafbc-8573-4573-a89a-6df551817707)


# Comparación de Versiones: Sistema de Registro de Estudiantes

## Funcionalidad y estructura del Sistema antiguo
El sistema original de registro de estudiantes estaba implementado en Java de forma estructurada sin una clara separación de responsabilidades. Sus principales características eran:

- Uso de un arreglo estático de objetos `Estudiante`.
- Manejo de la lógica de operaciones dentro del `main`.
- Búsqueda, eliminación y visualización de estudiantes mediante iteraciones sobre el arreglo.
- Interacción con el usuario a través de un menú en consola.

Ejemplo de código en la versión antigua:


```java
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Estudiante[] estudiantes = new Estudiante[100];
    int numEstudiantes = 0;
    int opcion;
    
    do {
        System.out.println("\n--- Sistema de Registro de Estudiantes ---");
        System.out.println("1. Registrar estudiante");
        System.out.println("2. Mostrar estudiantes");
        System.out.println("3. Buscar estudiante por matrícula");
        System.out.println("4. Eliminar estudiante");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        opcion = scanner.nextInt();
        scanner.nextLine();
    
        switch (opcion) {
            case 1:
                if (numEstudiantes < 100) {
                    Estudiante nuevo = new Estudiante();
                    System.out.print("Ingrese el nombre: ");
                    nuevo.nombre = scanner.nextLine();
                    System.out.print("Ingrese la edad: ");
                    nuevo.edad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese la matrícula: ");
                    nuevo.matricula = scanner.nextLine();
                    System.out.print("Ingrese la carrera: ");
                    nuevo.carrera = scanner.nextLine();
                    estudiantes[numEstudiantes++] = nuevo;
                }
                break;
        }
    } while (opcion != 0);
    scanner.close();
}
```

Aunque funcional, este sistema presenta varios problemas como falta de encapsulamiento y reutilización de código, además de manejar los datos de forma ineficiente en un arreglo estático.

---

## Funcionalidad y estructura del Sistema actualizado
La versión mejorada sigue principios de Programación Orientada a Objetos, separando la lógica en métodos específicos y evitando el código monolítico. Las principales mejoras incluyen:

- Uso de `ArrayList` en lugar de un arreglo estático.
- Implementación de métodos modulares para cada operación.
- Separación clara entre la lógica de negocio y la interacción con el usuario.
- Mayor facilidad de mantenimiento y escalabilidad.

Ejemplo de código en la versión nueva:


```java
public static void ejecutar() {
    int opcion;
    do {
        mostrarMenu();
        opcion = scanner.nextInt();
        scanner.nextLine();
    
        switch (opcion) {
            case 1:
                registrarEstudiante();
                break;
            case 2:
                mostrarEstudiantes();
                break;
            case 3:
                buscarEstudiante();
                break;
            case 4:
                eliminarEstudiante();
                break;
            case 0:
                System.out.println("Saliendo del sistema...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    } while (opcion != 0);
}
```


```java
private static Estudiante crearEstudiante() {
    Estudiante nuevo = new Estudiante();
    System.out.print("Ingrese el nombre: ");
    nuevo.nombre = scanner.nextLine();
    System.out.print("Ingrese la edad: ");
    nuevo.edad = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Ingrese la matrícula: ");
    nuevo.matricula = scanner.nextLine();
    System.out.print("Ingrese la carrera: ");
    nuevo.carrera = scanner.nextLine();
    return nuevo;
}
```

---

### Diferencias clave entre ambas versiones
| Característica | Versión Antigua | Versión Nueva |
|--------------|----------------|--------------|
| Almacenamiento | Arreglo fijo de 100 estudiantes | `ArrayList` dinámico |
| Organización del código | Procedimental | Orientado a Objetos |
| Modularidad | Código monolítico | Métodos separados por funcionalidad |
| Escalabilidad | Límite de 100 estudiantes | Expansión sin límites predefinidos |
| Seguridad | Riesgo de acceso a elementos `null` | Validaciones antes de acceso |
| Mantenibilidad | Código acoplado | Más fácil de modificar |

### Beneficios de la nueva implementación
- **Mayor modularidad**: los métodos están bien definidos y separados.
- **Mejor gestión de datos**: uso de `ArrayList` permite crecimiento dinámico.
- **Más claridad y mantenimiento**: código más estructurado y reutilizable.
- **Facilidad de búsqueda y eliminación**: se optimiza la manipulación de datos.
- **Mejor separación de responsabilidades**: funciones específicas para cada tarea.

Con estas mejoras, el nuevo sistema es más robusto, flexible y fácil de mantener, proporcionando una mejor solución en comparación con la versión original.

### Capturas del funcionamiento
#### Función: Registrar Estudiante
![image](https://github.com/user-attachments/assets/deb64e57-0f01-4037-9cf6-5ebcf0c974b4)
#### Función: Mostrar estudiantes
![image](https://github.com/user-attachments/assets/b19dd115-20d3-4009-8f3c-33369acc5c55)
#### Función: Buscar estudiante
![image](https://github.com/user-attachments/assets/1503db95-9aa1-4994-9819-d06d30d3d763)
#### Función: Eliminar estudiante
![image](https://github.com/user-attachments/assets/9daf78be-6725-460a-a3ef-01b0a931191d)
#### Función: Salir del programa
![image](https://github.com/user-attachments/assets/b51648d9-74cb-4c0a-ac7d-6fb373094d72)



# Comparación de Versiones: Juego de Adivinanza

## Implementación antigua del Juego de Adivinanza
El juego original estaba implementado en Java y permitía a un usuario adivinar un número aleatorio entre 1 y 100 en un máximo de 10 intentos. Algunas de sus características principales eran:

- Uso de `Random` para generar un número aleatorio.
- Uso de `Scanner` para la entrada del usuario.
- Validación de entrada para evitar errores al ingresar datos no numéricos.
- Un bucle `while` para controlar los intentos y proporcionar retroalimentación.
- Sin modularización del código, todo estaba en el `main`.

Ejemplo de código en Java:

```java
import java.util.Random;
import java.util.Scanner;

public class JuegoAdivinanza {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int numeroAleatorio = rand.nextInt(100) + 1; // Número aleatorio entre 1 y 100

        int num = 0;
        int intentos = 0;
        int intentosMaximos = 10;
        boolean adivinado = false;

        System.out.println("Juego de Adivinanza");
        System.out.println("Tendrás " + intentosMaximos + " intentos para adivinar un número entre 1 y 100\n");

        while (intentos < intentosMaximos) {
            System.out.print("\nIngresa un número: ");
            
            if (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingresa un número válido.");
                scanner.next();
                continue;
            }

            num = scanner.nextInt();

            if (num < 1 || num > 100) {
                System.out.println("El número ingresado no está en el rango de 1 a 100.");
                continue;
            }

            intentos++;

            if (num == numeroAleatorio) {
                adivinado = true;
                System.out.println("¡Felicidades! Has adivinado el número " + numeroAleatorio + " en " + intentos + " intentos.");
                break;
            } else if (num < numeroAleatorio) {
                System.out.println("Tu número es menor al número aleatorio. Sigue intentando.");
            } else {
                System.out.println("Tu número es mayor al número aleatorio. Sigue intentando.");
            }
        }

        if (!adivinado) {
            System.out.println("\nLo siento, has agotado tus intentos. El número correcto era: " + numeroAleatorio);
        }

        scanner.close();
    }
}
```

---

## Implementación mejorada del Juego de Adivinanza
La versión mejorada del juego introduce modularización del código mediante métodos separados para mejorar la organización y reutilización. Sus principales mejoras incluyen:

- Uso de constantes para los valores límite y los intentos máximos.
- Modularización mediante métodos `jugarAdivinanza()`, `obtenerNumeroUsuario()` y `verificarNumero()`.
- Código más limpio y fácil de mantener.
- Separación de responsabilidades para mejorar la legibilidad y escalabilidad.

Ejemplo de código mejorado en Java:

```java
import java.util.Random;
import java.util.Scanner;

public class JuegoAdivinanzaMetodo {
    private static final int INTENTOS_MAXIMOS = 5;
    private static final int LIMITE_INFERIOR = 1;
    private static final int LIMITE_SUPERIOR = 100;

    public static void main(String[] args) {
        jugarAdivinanza();
    }

    public static void jugarAdivinanza() {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int numeroAleatorio = rand.nextInt(LIMITE_SUPERIOR) + LIMITE_INFERIOR;
        int intentos = 0;
        
        System.out.println("Juego de Adivinanza");
        System.out.println("Tendrás " + INTENTOS_MAXIMOS + " intentos para adivinar un número entre " + LIMITE_INFERIOR + " y " + LIMITE_SUPERIOR + "\n");
        
        while (intentos < INTENTOS_MAXIMOS) {
            int numeroUsuario = obtenerNumeroUsuario(scanner);
            
            if (numeroUsuario == -1) {
                System.out.println("El número ingresado no está en el rango de " + LIMITE_INFERIOR + " a " + LIMITE_SUPERIOR);
                continue;
            }
            
            intentos++;
            if (verificarNumero(numeroUsuario, numeroAleatorio)) {
                System.out.println("¡Felicidades! Has adivinado el número " + numeroAleatorio + " en " + intentos + " intentos.");
                scanner.close();
                return;
            }
        }
        
        System.out.println("Lo siento, has agotado tus intentos. El número correcto era: " + numeroAleatorio);
        scanner.close();
    }

    public static int obtenerNumeroUsuario(Scanner scanner) {
        System.out.print("Ingresa un número: ");
        int num = scanner.nextInt();
        return (num >= LIMITE_INFERIOR && num <= LIMITE_SUPERIOR) ? num : -1;
    }

    public static boolean verificarNumero(int numeroUsuario, int numeroAleatorio) {
        if (numeroUsuario == numeroAleatorio) {
            return true;
        } else if (numeroUsuario < numeroAleatorio) {
            System.out.println("El número es mayor. Sigue intentando.");
        } else {
            System.out.println("El número es menor. Sigue intentando.");
        }
        return false;
    }
}
```

---

### Diferencias clave con la versión antigua
| Característica | Versión Original | Versión Mejorada |
|--------------|----------------|-----------------|
| Modularización | Todo en `main` | Métodos separados |
| Intentos Máximos | 10 | 5 |
| Validación de Entrada | Directa en el `while` | Método `obtenerNumeroUsuario` |
| Comparación de números | Dentro del `while` | Método `verificarNumero` |
| Reutilización de código | Baja | Alta |

**Beneficios de la nueva implementación:**
- Código más modular y reutilizable.
- Mejor manejo de la entrada del usuario.
- Mayor claridad y facilidad de mantenimiento.
- Separación de responsabilidades para mayor escalabilidad.

Con estas mejoras, la nueva versión del juego de adivinanza es más eficiente, organizada y fácil de mantener en comparación con la versión original.

### Capturas del funcionamiento
#### Caso 1: El jugador pierde
![image](https://github.com/user-attachments/assets/313804db-a2b2-42fd-b9ec-50efca2cfaed)
#### Caso 2: El jugador gana
![image](https://github.com/user-attachments/assets/e0776c69-9a28-4d02-a5bf-6a1e9e43a6e4)
#### Caso 3: El jugador ingresa un número fuera del rango
![image](https://github.com/user-attachments/assets/4516ea75-e066-4224-8f39-2927dc4bcb4e)


----------------------------------------------------------------

### Importancia de los métodos en nuestros programas

Al comparar las versiones antiguas y mejoradas de los programas Sistema de Registro de Estudiantes y Juego de Adivinanza, se hace evidente la importancia de estructurar el código mediante métodos. La modularización del código es una de las mejores prácticas en programación, ya que permite una mayor organización, reutilización y mantenimiento del código.

- **1. Claridad y Legibilidad**
En la versión original de ambos programas, toda la lógica estaba concentrada en el main, lo que dificultaba la lectura y comprensión del código. En cambio, al dividir el código en métodos con funciones específicas, el flujo del programa se vuelve más claro y entendible.

-Por ejemplo, en la versión mejorada del Sistema de Registro de Estudiantes, la función registrarEstudiante() encapsula todo el proceso de registro, mientras que mostrarEstudiantes() se encarga exclusivamente de la visualización. Esto hace que el main sea más limpio y que cada método tenga una única responsabilidad.

- **2. Reutilización del Código**
El uso de métodos permite reutilizar fragmentos de código sin necesidad de repetir instrucciones. En el caso del Juego de Adivinanza, el método obtenerNumeroUsuario() se encarga de recibir y validar la entrada del usuario. Sin este método, la validación tendría que escribirse repetidamente dentro del while, lo que haría el código más largo y propenso a errores.

-En el Sistema de Registro de Estudiantes, el método encontrarEstudiante() facilita la búsqueda de un estudiante sin repetir la lógica en diferentes partes del código.

- **3. Facilidad de Mantenimiento y Escalabilidad**
Cuando un programa está estructurado con métodos bien definidos, cualquier modificación o corrección es mucho más sencilla. Si en el futuro se quiere cambiar la validación de entrada en el Juego de Adivinanza, basta con modificar obtenerNumeroUsuario(), en lugar de revisar múltiples partes del código.

- Asimismo, la versión mejorada del Sistema de Registro de Estudiantes permite agregar nuevas funcionalidades sin afectar la estructura general del programa. Por ejemplo, si se desea agregar una opción para actualizar los datos de un estudiante, se puede crear un nuevo método actualizarEstudiante() sin afectar el código existente.

- **4. Separación de Responsabilidades**
Cada método en la versión mejorada tiene una tarea específica, lo que facilita la depuración del código. Si ocurre un error en la eliminación de un estudiante, se puede revisar exclusivamente el método eliminarEstudiantePorMatricula() en lugar de revisar todo el código.

- En el Juego de Adivinanza, el método verificarNumero() separa la lógica de comparación del main, lo que hace que la estructura del programa sea más modular y fácil de entender.

## Instrucciones para compilar los programas (Java)
```sh
javac NombreDelPrograma.java
java NombreDelPrograma
```

---

## Link del GitHub
[Repositorio del Proyecto](https://github.com/GabrielGuerraRuiz/Metodo/tree/main)

