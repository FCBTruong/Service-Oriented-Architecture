import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Pair extends Remote {
    public int getSum(int a, int b) throws RemoteException;
    public int getMul(int a, int b) throws RemoteException;
}