import java.util.Scanner;
public class conecta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Declarar variables
        int filas = 6;
        int columnas = 7;
        char[][] table = new char[filas][columnas];
        int valueInput;
        int count = 1;

        // True => Player1, False => Player2
        boolean turnPlayer = true;
        boolean win = false;
        System.out.println();
        System.out.println("Bienvenido al Juego de CONECTA 4!");

        do {
            System.out.println();
            System.out.println("Jugador 1 = X || Jugador 2 = O");

            if (turnPlayer) {
                System.out.println("Turno jugador: Jugador 1 | Nº: " + count);
            } else {
                System.out.println("Turno jugador: Jugador 2 | Nº: " + count);
            }

            System.out.println();
            printTable(table);
            System.out.println();

            // Intrucciones de movimiento
            System.out.println("MENÚ - Seleccione una columna del 1 al 7 (de izq a dcha)");
            valueInput = scanner.nextInt() - 1;

            // AQUÍ VA LA PARTE DE INCLUIR FICHA
            // addMove(table, columnas, turnPlayer);

            turnPlayer = !turnPlayer;
            count++;
        } while (!win);

        scanner.close();
    }

    public static void printTable(char[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print("[" + table[i][j] + "]");
            }

            System.out.println();
        }
    }

    public static boolean addMove(char[][] table, int columnas, boolean turnPlayer) {
        boolean move = false;

        // Buscamos desde la última fila
        for (int i = table.length - 1; i >= 0; i--) {
            if (table[i][columnas] == ' ') {
                if (turnPlayer) {
                    table[i][columnas] = 'X';
                } else {
                    table[i][columnas] = 'O';
                }

                move = true;
                break;
            }
        }
        
        return move;
    }
}