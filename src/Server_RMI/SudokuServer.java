package Server_RMI;

import Implement_RMI.SudokuImplement;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author jeriveraa23 & SebastianP1610
 */

public class SudokuServer{
    public static void main(String[] args) throws RemoteException{

        System.setProperty("java.rmi.server.hostname", "127.0.0.1");
        
        Registry reg = LocateRegistry.createRegistry(1099);

        SudokuImplement sudokuImplement = new SudokuImplement(0);

        reg.rebind(("SudokuRemoto"), sudokuImplement);

        System.out.println("Servidor de Sudoku iniciado...");
    }
}