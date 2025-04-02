import java.util.ArrayList;
import java.util.Scanner;

class Contacto {
    String nombre;
    String telefono;
    
    Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }
}

public class ContactosApp {
    private static final ArrayList<Contacto> contactos = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    agregarContacto();
                    break;
                case 2:
                    mostrarContactos();
                    break;
                case 3:
                    buscarContacto();
                    break;
                case 4:
                    eliminarContacto();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Agregar contacto");
        System.out.println("2. Mostrar contactos");
        System.out.println("3. Buscar contacto");
        System.out.println("4. Eliminar contacto");
        System.out.println("0. Salir");
    }

    private static void agregarContacto() {
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese telefono: ");
        String telefono = scanner.nextLine();
        contactos.add(new Contacto(nombre, telefono));
        System.out.println("Contacto agregado exitosamente.");
    }

    private static void mostrarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos disponibles.");
        } else {
            System.out.println("Lista de contactos:");
            for (int i = 0; i < contactos.size(); i++) {
                Contacto c = contactos.get(i);
                System.out.println((i + 1) + ". " + c.nombre + " - " + c.telefono);
            }
        }
    }

    private static void buscarContacto() {
        System.out.print("Ingrese nombre a buscar: ");
        String nombre = scanner.nextLine();
        boolean encontrado = false;
        for (Contacto c : contactos) {
            if (c.nombre.equalsIgnoreCase(nombre)) {
                System.out.println("Encontrado: " + c.nombre + " - " + c.telefono);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Contacto no encontrado.");
        }
    }

    private static void eliminarContacto() {
        System.out.print("Ingrese nombre a eliminar: ");
        String nombre = scanner.nextLine();
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).nombre.equalsIgnoreCase(nombre)) {
                contactos.remove(i);
                System.out.println("Contacto eliminado exitosamente.");
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }
}
