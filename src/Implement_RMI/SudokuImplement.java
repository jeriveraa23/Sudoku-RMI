package Implement_RMI;

import Interface_RMI.SudokuInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author jeriveraa23 & SebastianP1610
 */

public class SudokuImplement extends UnicastRemoteObject implements SudokuInterface {

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
        return crearMatriz(4);
    }

    @Override
    public int[][] generar9x9() throws RemoteException{
        return crearMatriz(9);
    }

    @Override
    public int[][] generar16x16() throws RemoteException{
        return crearMatriz(16);
    }

    private int[][] crearMatriz(int n){
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                m[i][j] = (i + j) % n + 1;
            }
        }
        return m;
    }
}
