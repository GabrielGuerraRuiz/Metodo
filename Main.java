import java.util.*;

class Estudiante {
    String nombre;
    int edad;
    String matricula;
    String carrera;
}

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Estudiante[] estudiantes = new Estudiante[100];
    static int numEstudiantes = 0;

    public static void registrarEstudiante() {
        if (numEstudiantes < 100) {
            Estudiante nuevo = crearEstudiante();
            estudiantes[numEstudiantes] = nuevo;
            numEstudiantes++;
            System.out.println("Estudiante registrado exitosamente.");
        } else {
            System.out.println("No se pueden registrar más estudiantes.");
        }
    }

    private static Estudiante crearEstudiante() {
        Estudiante nuevo = new Estudiante();
        System.out.print("Ingrese el nombre: ");
        nuevo.nombre = scanner.nextLine();
        System.out.print("Ingrese la edad: ");
        nuevo.edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese la matrícula: ");
        nuevo.matricula = scanner.nextLine();
        System.out.print("Ingrese la carrera: ");
        nuevo.carrera = scanner.nextLine();
        return nuevo;
    }

    public static void mostrarEstudiantes() {
        if (numEstudiantes == 0) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        for (Estudiante estudiante : estudiantes) {
            if (estudiante != null) {
                mostrarDetallesEstudiante(estudiante);
            }
        }
    }

    private static void mostrarDetallesEstudiante(Estudiante estudiante) {
        System.out.println("Nombre: " + estudiante.nombre);
        System.out.println("Edad: " + estudiante.edad);
        System.out.println("Matrícula: " + estudiante.matricula);
        System.out.println("Carrera: " + estudiante.carrera);
        System.out.println("--------------------------");
    }

    public static void buscarEstudiante() {
        System.out.print("Ingrese la matrícula del estudiante: ");
        String matricula = scanner.nextLine();
        Estudiante estudiante = encontrarEstudiante(matricula);
        if (estudiante != null) {
            mostrarDetallesEstudiante(estudiante);
        } else {
            System.out.println("No se encontró ningún estudiante con esa matrícula.");
        }
    }

    private static Estudiante encontrarEstudiante(String matricula) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante != null && estudiante.matricula.equals(matricula)) {
                return estudiante;
            }
        }
        return null;
    }

    public static void eliminarEstudiante() {
        System.out.print("Ingrese la matrícula del estudiante a eliminar: ");
        String matricula = scanner.nextLine();
        numEstudiantes = eliminarEstudiantePorMatricula(matricula);
    }

    private static int eliminarEstudiantePorMatricula(String matricula) {
        for (int i = 0; i < numEstudiantes; i++) {
            if (estudiantes[i].matricula.equals(matricula)) {
                for (int j = i; j < numEstudiantes - 1; j++) {
                    estudiantes[j] = estudiantes[j + 1];
                }
                estudiantes[numEstudiantes - 1] = null;
                System.out.println("Estudiante eliminado exitosamente.");
                return numEstudiantes - 1;
            }
        }
        System.out.println("No se encontró ningún estudiante con esa matrícula.");
        return numEstudiantes;
    }

    public static void mostrarMenu() {
        System.out.println("\n--- Sistema de Registro de Estudiantes ---");
        System.out.println("1. Registrar estudiante");
        System.out.println("2. Mostrar estudiantes");
        System.out.println("3. Buscar estudiante por matrícula");
        System.out.println("4. Eliminar estudiante");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

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

    public static void main(String[] args) {
        ejecutar();
    }
}
