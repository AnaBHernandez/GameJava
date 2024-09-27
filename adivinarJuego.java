import java.util.Random;
import java.util.Scanner;

public class adivinarJuego {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Variable reinicio;
        String reboot;

        // Iniciar el juego
        playGame(scanner, random);

        // Switch - REINICIO
        do {
            System.out.println("¿Deseas reiniciar el juego? SI o NO");
            reboot = scanner.next().toUpperCase();

            switch (reboot) {
                case "SI":
                    playGame(scanner, random);
                    break;

                case "NO":
                    System.out.println("¡Gracias por jugar! Hasta la próxima.");
                    break;

                default:
                    System.err.println("Debe introducir SI o NO. Inténtelo de nuevo");
                    break;
            }
        } while (!reboot.equals("NO"));

        // Finalización
        // Se finaliza en el MENU || Opcional, incluir scanner.close();
    }

    // Método para jugar al juego
    public static void playGame(Scanner scanner, Random random) {
        // Generar un número aleatorio entre 0 y 100 || 100 + 1 para dejar fuera el nº 0
        int number = random.nextInt(100) + 1;
        int x;
        int count = 0;

        // Bucle do-while
        do {
            System.out.println("Adivina el número del 1 al 100! Introduce un número: ");
            x = scanner.nextInt();

            // Condiciones
            if (x < 0 || x > 100) {
                System.out.println("Error: el número debe estar comprendido entre 1 y 100");
            } else if (x > number) {
                System.out.println("Ups... El número aleatorio que buscamos es MENOR");
            } else if (x < number) {
                System.out.println("Ups... El número aleatorio que buscamos es MAYOR");
            }

            // Incrementar el contador de intentos
            count++;
        } while (x != number);

        // Mensaje número adivinado
        System.out.println("Enhorabuena! Has adivinado el número " + number + ". Número de intentos: " + count);
    }
}
