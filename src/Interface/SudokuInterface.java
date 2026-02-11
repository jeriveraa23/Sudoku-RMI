import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SudokuInterface extends Remote{
    int[][] generar4x4() throws RemoteException;
    int[][] generar9x9() throws RemoteException;
    int[][] generar16x16() throws RemoteException;
}