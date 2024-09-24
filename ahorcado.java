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
        int tourn = 0;
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

        // Limite de 6 errores o NO success
        while (errors < limit && !win) {
            for (char c : guessWord) {
                System.out.print(c + " ");
            }

            System.out.print("|| Turno " + (tourn + 1) + ": ");
            System.out.println("Introduzca una letra");
            letter = scanner.next().toUpperCase();

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
                tourn++;
            } else {
                System.out.println("Correcto! Ha acertado una letra");
                success = false;
                tourn++;
            }
        }

        // Verificar si están todas las letras con un forEach
        win = true;
        for (char c : guessWord) {
            if (c == '_') {
                win = false;
                break;
            }
        }

        // Comprobante de si ha ganado
        if (win) {
            System.out.println("Enhorabuena! Ha acertado la palabra " + word);
        } else {
            System.out.println("Game Over... No te quedan más intentos!");
        }

        // Finalización
        scanner.close();
    }
}