import java.util.Random;
import java.util.Scanner;

public class JuegoAdivinanza {
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
                continue; // No cuenta como intento
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
