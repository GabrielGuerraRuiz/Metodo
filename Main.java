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
