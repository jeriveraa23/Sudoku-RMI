package Client_RMI;

import Interface_RMI.SudokuInterface;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;


/**
 *
 * @author jeriveraa23 & SebastianP1610
 */

public class SudokuClient {
    private static SudokuInterface sudoku;
    private static Scanner scanner;
    
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        
        try {
            // Conectar al servidor RMI
            sudoku = obtenerRemoto();
            
            if (sudoku == null) {
                System.out.println("Error: No se pudo conectar al servidor. Asegúrese de que está ejecutándose.");
                System.exit(1);
            }
            
            // Menú principal
            int opcion = 0;
            while (opcion != 4) {
                mostrarMenu();
                opcion = obtenerOpcion();
                
                switch (opcion) {
                    case 1:
                        generarYMostrar(4, "4x4");
                        break;
                    case 2:
                        generarYMostrar(9, "9x9");
                        break;
                    case 3:
                        generarYMostrar(16, "16x16");
                        break;
                    case 4:
                        System.out.println("¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente de nuevo.");
                }
            }
            
        } catch (RemoteException e) {
            System.out.println("Error de conexión RMI: " + e.getMessage());
        } catch (NotBoundException e) {
            System.out.println("Error: El objeto 'SudokuRemoto' no está registrado en el servidor.");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
    
    /**
     * Obtiene la referencia remota del servidor
     */
    private static SudokuInterface obtenerRemoto() throws RemoteException, NotBoundException {
        try {
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
            return (SudokuInterface) registro.lookup("SudokuRemoto");
        } catch (RemoteException | NotBoundException e) {
            throw e;
        }
    }
    
    /**
     * Muestra el menú de opciones
     */
    private static void mostrarMenu() {
        System.out.println("\n====== GENERADOR SUDOKU ======");
        System.out.println("1. Matriz 4x4");
        System.out.println("2. Matriz 9x9");
        System.out.println("3. Matriz 16x16");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }
    
    /**
     * Obtiene la opción del usuario
     */
    private static int obtenerOpcion() {
        try {
            int opcion = Integer.parseInt(scanner.nextLine().trim());
            return opcion;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    /**
     * Genera y muestra la matriz sudoku
     */
    private static void generarYMostrar(int tamaño, String descripcion) throws RemoteException {
        try {
            int[][] matriz = null;
            
            System.out.println("\nGenerando matriz " + descripcion + "...\n");
            
            if (tamaño == 4) {
                matriz = sudoku.generar4x4();
            } else if (tamaño == 9) {
                matriz = sudoku.generar9x9();
            } else if (tamaño == 16) {
                matriz = sudoku.generar16x16();
            }
            
            mostrarMatriz(matriz, descripcion);
            
        } catch (RemoteException e) {
            System.out.println("Error al generar la matriz: " + e.getMessage());
        }
    }
    
    /**
     * Muestra la matriz en formato legible
     */
    private static void mostrarMatriz(int[][] matriz, String descripcion) {
        if (matriz == null) return;
        
        int n = matriz.length;
        int raiz = (int) Math.sqrt(n);

        System.out.println("\n========= MATRIZ " + descripcion + " =========");
        
        for (int i = 0; i < n; i++) {
            // Imprimir línea horizontal divisoria de bloques
            if (i > 0 && i % raiz == 0) {
                System.out.println("-".repeat(n * 4 + raiz));
            }

            for (int j = 0; j < n; j++) {
                // Imprimir línea vertical divisoria de bloques
                if (j > 0 && j % raiz == 0) {
                    System.out.print("| ");
                }
                System.out.printf("%2d ", matriz[i][j]);
            }
            System.out.println();
        }
        System.out.println("=====================================\n");
    }
}

