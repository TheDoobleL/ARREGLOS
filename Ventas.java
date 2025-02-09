import java.util.Scanner;

public class Ventas {
    private static final String[] MESES = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    private static final String[] DEPARTAMENTOS = {"Ropa", "Deportes", "Jugueteria"};
    private static final int[][] tabla = new int[MESES.length][DEPARTAMENTOS.length];
    private static final Scanner scanner = new Scanner(System.in);

    private static void mostrarTabla() {
        System.out.println("\nVentas x Mes");
        System.out.printf("%-10s | %s | %s | %s%n", "Mes", DEPARTAMENTOS[0], DEPARTAMENTOS[1], DEPARTAMENTOS[2]);
        System.out.println("-".repeat(40));
        for (int i = 0; i < MESES.length; i++) {
            System.out.printf("%-10s | %d | %d | %d%n", MESES[i], tabla[i][0], tabla[i][1], tabla[i][2]);
        }
    }

    private static void registrarVenta() {
        System.out.print("Capture el mes que se realizó la venta: ");
        String mesVenta = scanner.nextLine();
        System.out.print("Capture el departamento: ");
        String depar = scanner.nextLine();
        
        int fila = buscarIndice(MESES, mesVenta);
        int columna = buscarIndice(DEPARTAMENTOS, depar);
        
        if (fila != -1 && columna != -1) {
            System.out.print("Capture la venta realizada: ");
            tabla[fila][columna] = scanner.nextInt();
            scanner.nextLine();
        } else {
            System.out.println("No se ha encontrado el mes/departamento ingresado");
        }
    }

    private static void eliminarVenta() {
        System.out.print("Capture el mes que se realizó la venta: ");
        String mesVenta = scanner.nextLine();
        System.out.print("Capture el departamento: ");
        String depar = scanner.nextLine();
        
        int fila = buscarIndice(MESES, mesVenta);
        int columna = buscarIndice(DEPARTAMENTOS, depar);
        
        if (fila != -1 && columna != -1) {
            tabla[fila][columna] = 0;
            System.out.println("La venta ha sido eliminada");
        } else {
            System.out.println("No se ha encontrado el mes/departamento ingresado");
        }
    }
    
    private static int buscarIndice(String[] arreglo, String valor) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i].equalsIgnoreCase(valor)) {
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Mostrar tabla");
            System.out.println("2. Registrar venta");
            System.out.println("3. Eliminar venta");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            
            String opcion = scanner.nextLine();
            
            switch (opcion) {
                case "1":
                    mostrarTabla();
                    break;
                case "2":
                    registrarVenta();
                    break;
                case "3":
                    eliminarVenta();
                    break;
                case "4":
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }
}
