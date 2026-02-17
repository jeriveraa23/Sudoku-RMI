package Implement_RMI;

import Interface_RMI.SudokuInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author jeriveraa23 & SebastianP1610
 */

public class SudokuImplement extends UnicastRemoteObject implements SudokuInterface {

    private int conteo4x4 = 0;
    private int conteo9x9 = 0;
    private int conteo16x16 = 0;

    public int tamano;

    public int getTamano(){
        return tamano;
    }
    
    public void setTamano(int tamano){
        this.tamano = tamano;
    }

    public SudokuImplement(int tamano) throws RemoteException{
        this.tamano = tamano;
    }

    @Override
    public int[][] generar4x4() throws RemoteException{
        conteo4x4++;
        return crearMatriz(4);
    }

    @Override
    public int[][] generar9x9() throws RemoteException{
        conteo9x9++;
        return crearMatriz(9);
    }

    @Override
    public int[][] generar16x16() throws RemoteException{
        conteo16x16++;
        return crearMatriz(16);
    }

    @Override
    public String obtenerEstadisticas() throws RemoteException {
        return "Resumen del Servidor:\n" +
               "- Matrices 4x4 generadas: " + conteo4x4 + "\n" +
               "- Matrices 9x9 generadas: " + conteo9x9 + "\n" +
               "- Matrices 16x16 generadas: " + conteo16x16;
    }

    private int[][] crearMatriz(int n) {
        int[][] m = new int[n][n];
        int raiz = (int) Math.sqrt(n); 

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
              
                m[i][j] = ((i * raiz + i / raiz + j) % n) + 1;
            }
        }
        return m;
    }
}
