// application/Main.java
package application;

import domain.Cancha;
import service.CanchaService;
import serviceImpl.CanchaServiceImpl;

import java.util.Scanner;

public class Main {
    private static CanchaService canchaService = new CanchaServiceImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            switch (opcion) {
                case 1: registrarCancha(); break;
                case 2: actualizarCancha(); break;
                case 3: eliminarCancha(); break;
                case 4: listarCanchas(); break;
                case 5: buscarCancha(); break;
                case 6: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    private static void mostrarMenu() {
        System.out.println("1. Registrar Cancha");
        System.out.println("2. Actualizar Cancha");
        System.out.println("3. Eliminar Cancha");
        System.out.println("4. Listar Canchas");
        System.out.println("5. Buscar Cancha");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void registrarCancha() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Tipo: ");
        String tipo = scanner.nextLine();
        System.out.print("Ubicación: ");
        String ubicacion = scanner.nextLine();
        System.out.print("¿Está disponible? (true/false): ");
        boolean disponible = scanner.nextBoolean();

        Cancha nuevaCancha = new Cancha(nombre, tipo, ubicacion, disponible);
        canchaService.registrarCancha(nuevaCancha);
    }

    private static void actualizarCancha() {
        System.out.print("Nombre de la cancha a actualizar: ");
        String nombre = scanner.nextLine();
        Cancha canchaExistente = canchaService.buscarCancha(nombre);

        if (canchaExistente != null) {
            System.out.print("Nuevo Nombre: ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Nuevo Tipo: ");
            String nuevoTipo = scanner.nextLine();
            System.out.print("Nueva Ubicación: ");
            String nuevaUbicacion = scanner.nextLine();
            System.out.print("¿Está disponible? (true/false): ");
            boolean disponible = scanner.nextBoolean();

            Cancha canchaActualizada = new Cancha(nuevoNombre, nuevoTipo, nuevaUbicacion, disponible);
            canchaService.actualizarCancha(nombre, canchaActualizada);
        } else {
            System.out.println("Cancha no encontrada.");
        }
    }

    private static void eliminarCancha() {
        System.out.print("Nombre de la cancha a eliminar: ");
        String nombre = scanner.nextLine();
        canchaService.eliminarCancha(nombre);
    }

    private static void listarCanchas() {
        canchaService.listarCanchas().forEach(System.out::println);
    }

    private static void buscarCancha() {
        System.out.print("Nombre de la cancha a buscar: ");
        String nombre = scanner.nextLine();
        Cancha cancha = canchaService.buscarCancha(nombre);
        if (cancha != null) {
            System.out.println(cancha);
        } else {
            System.out.println("Cancha no encontrada.");
        }
    }
}
