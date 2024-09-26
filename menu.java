import java.util.Scanner;

public class menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        int option;

        while (!exit) {

            System.out.println();
            System.out.println("GAMES MENU - Seleccione una opción: ");
            System.out.println("1.- Adivinar Número");
            System.out.println("2.- Ahorcado");
            System.out.println("3.- Conecta 4");
            System.out.println("4.- Salir");

            System.out.println();
            System.out.println("Seleccione la opcion deseada: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Has seleccionado Adivinar Juego");
                    adivinarJuego.main(null);

                    break;
                case 2:
                    System.out.println("Has seleccionado Ahorcado");
                    ahorcado.main(null);

                    break;
                case 3:
                    System.out.println("Has seleccionado Conecta 4");
                    conecta.main(null);

                    break;
                case 4:
                    exit = true;
                    scanner.close();
                    System.out.println("Gracias por utilizar el sistema de juegos! Bye bye! ");

                    break;

                default:
                    System.out.println("Las opciones son entre 1 y 4");
            }
        }
    }
}