import java.util.Random;
import java.util.Scanner;

public class ahorcado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Dibujo del ahorcado
        String[][] ahorcado = {
                {
                        " +---+",
                        "     |",
                        "     |",
                        "     |",
                        "    ==="
                },
                {
                        " +---+",
                        " O   |",
                        "     |",
                        "     |",
                        "    ==="
                },
                {
                        " +---+",
                        " O   |",
                        " |   |",
                        "     |",
                        "    ==="
                },
                {
                        " +---+",
                        " O   |",
                        "/|   |",
                        "     |",
                        "    ==="
                },
                {
                        " +---+",
                        " O   |",
                        "/|\\  |",
                        "     |",
                        "    ==="
                },
                {
                        " +---+",
                        " O   |",
                        "/|\\  |",
                        "/    |",
                        "    ==="
                },
                {
                        " +---+",
                        " O   |",
                        "/|\\  |",
                        "/ \\  |",
                        "    ==="
                }
        };

        // Declaración de variables
        int tourn;
        int limit = 6;

        String[] words = { "Naranja", "Coche", "Mesa", "Sol" };
        String word;
        String letter;

        // Buscar palabra
        int wordIndex = random.nextInt(words.length);
        word = words[wordIndex];

        // Inicio juego
        System.out.println("\nEl Juego del Ahorcado!");
        System.out.println("********************************************");
        System.out.println("La palabra tiene: " + word.length() + " letras");
        System.out.println("********************************************");

        for (int i = 0; i < word.length(); i++) {
            System.out.print(" _ ");
        }

        do {
            for (int i = 0; i < word.length(); i++) {
                System.out.print(" _ ");
                System.out.print("Turno " + (i + 1) + ":");

                System.out.println("Introduce una letra: ");
                letter = scanner.next();
            }

            for (int i = 0; i < ahorcado.length; i++) {
                for (int j = 0; j < ahorcado[i].length; j++) {
                    System.out.println(ahorcado[i][j]);
                }
                System.out.println();
            }

            limit--;
        } while (limit != 0);

        if (limit == 0) {
            System.out.println("Game Over... No te quedan más intentos!");
        }

        scanner.close();
    }
}