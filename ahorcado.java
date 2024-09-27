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
        int turn = 0;
        int limit = ahorcado.length - 1;
        int errors = 0;
        boolean success = false;
        boolean win = false;

        String[] words = { "Naranja", "Coche", "Mesa", "Sol" };
        String word;
        String letter;

        // Buscar palabra a adivinar
        int wordIndex = random.nextInt(words.length);
        word = words[wordIndex].toUpperCase();

        // Convertimos word en un Array
        char[] guessWord = new char[word.length()];

        // Inicio juego
        System.out.println("\nEl Juego del Ahorcado!");
        System.out.println("********************************************");
        System.out.println("La palabra tiene: " + word.length() + " letras");
        System.out.println("********************************************");
        System.out.println();

        // Letras que quedan por adivinar
        for (int i = 0; i < guessWord.length; i++) {
            guessWord[i] = '_';
        }

        // Lógica del juego
        while (errors < limit && !win) {
            for (char c : guessWord) {
                System.out.print(c + " ");
            }

            System.out.print("|| Turno " + (turn + 1) + ": ");
            System.out.println("Introduzca una letra");
            letter = scanner.next().toUpperCase(); // A

            // Buscamos si se ha acertado
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == letter.charAt(0)) {
                    guessWord[i] = letter.charAt(0);
                    success = true;
                }
            }

            System.out.println();

            // Si hay fallo, enseña parte de ahorcado == errors
            if (success == false) {
                System.out.println("Ups... Ha fallado! Error número: " + (errors + 1));
                System.out.println();

                for (String dibujo : ahorcado[errors + 1]) {
                    System.out.println(dibujo);
                }

                errors++;
                turn++;
            } else {
                System.out.println("Correcto! Ha acertado una letra");
                success = false;
                turn++;
            }

            // Verificar si están todas las letras con un forEach
            win = true;
            for (char value : guessWord) {
                if (value == '_') {
                    win = false;
                    break;
                }
            }

            // Salir del while si win == true
            if (win) {
                break;
            }
        }

        // Comprobante de si ha ganado
        if (win == true) {
            System.out.println("Enhorabuena! Ha acertado la palabra " + word + " en " + turn + " turnos!");
        } else {
            System.out.println("Game Over... No te quedan más intentos!");
        }

        // Finalización
    }
}