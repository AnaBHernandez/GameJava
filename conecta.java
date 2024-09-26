import java.util.Scanner;

public class conecta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Declarar variables
        int filas = 6;
        int columnas = 7;
        char symbol = 'X';
        char[][] table = new char[filas][columnas];

        int valueInput;
        int count = 1;

        // True => Player1, False => Player2
        boolean turnPlayer = true;
        boolean win = false;

        System.out.println();
        System.out.println("Bienvenido al Juego de CONECTA 4!");

        // Inicializamos tablero con casillas vacías
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                table[i][j] = ' ';
            }
        }

        // Bucle siempre que WIN no sea true
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

            // Llamamos método para incluir ficha del jugador
            if (addMove(table, columnas, turnPlayer, valueInput)) {
                symbol = turnPlayer ? 'X' : 'O';

                // Comprobar si hay X | O repetido 4 veces en vertial u horizontal
                if (checkWinner(table, columnas, filas, symbol)) {
                    win = true;
                }

                turnPlayer = !turnPlayer;
                count++;
            }
        } while (!win);

        if (win) {
            if (turnPlayer) {
                System.out.println();
                System.out.println("Enhorabuena! Ha ganado el Jugador 1 en " + count + " movimientos");
                System.out.println();

                printTable(table);

                System.out.println();
            } else {
                System.out.println();
                System.out.println("FINAL!! Enhorabuena! Ha ganado el Jugador 2 en " + count + " movimientos");
                System.out.println();

                printTable(table);

                System.out.println();
            }
        }

        scanner.close();
    }

    // Dibujo de tabla
    public static void printTable(char[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print("[" + table[i][j] + "]");
            }

            System.out.println();
        }
    }

    // Añadir ficha-movimiento del jugador
    public static boolean addMove(char[][] table, int columnas, boolean turnPlayer, int valueInput) {
        boolean move = false;

        // Condición valor > 0 || valor fuera de rango columnas
        if (valueInput < 0 || valueInput >= columnas) {
            System.out.println("Movimiento inválido! El número de columna está fuera del rango");
            return move;
        }

        // Buscamos desde la última fila
        for (int i = table.length - 1; i >= 0; i--) {
            if (table[i][valueInput] == ' ') {
                if (turnPlayer) {
                    table[i][valueInput] = 'X';
                } else {
                    table[i][valueInput] = 'O';
                }
                move = true;
                break;
            }
        }

        // Debemos comprobar que la columna no está llena
        if (!move) {
            System.out.println("La columna está llena! Debe insertar ficha en otra distinta");
        }

        return move;
    }

    // Comprobación de winner por columnas, filas y diagonal
    public static boolean checkWinner(char[][] table, int columnas, int filas, char symbol) {
        // Horizontal
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length - 3; j++) {
                if (table[i][j] == symbol && table[i][j + 1] == symbol && table[i][j + 2] == symbol
                        && table[i][j + 3] == symbol) {
                    return true;
                }
            }
        }

        // Vertical
        for (int i = 0; i < table.length - 3; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] == symbol && table[i + 1][j] == symbol && table[i + 2][j] == symbol
                        && table[i + 3][j] == symbol) {
                    return true;
                }
            }
        }

        // Diagonal de izquierda a derecha
        for (int i = 0; i < table.length - 3; i++) {
            for (int j = 0; j < table[i].length - 3; j++) {
                if (table[i][j] == symbol && table[i + 1][j + 1] == symbol && table[i + 2][j + 2] == symbol
                        && table[i + 3][j + 3] == symbol) {
                    return true;
                }
            }
        }

        // Diagonal de derecha a izquierda
        for (int i = 3; i < table.length; i++) {
            for (int j = 0; j < table[i].length - 3; j++) {
                if (table[i][j] == symbol && table[i - 1][j + 1] == symbol && table[i - 2][j + 2] == symbol
                        && table[i - 3][j + 3] == symbol) {
                    return true;
                }
            }
        }
        
        return false;
    }
}