import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerMethod extends UnicastRemoteObject implements Pair{
    public ServerMethod() throws RemoteException{

    }
    @Override
    public int getSum(int a, int b) {
        int result = a + b;
        return result;
    }
    public int getMul(int a, int b){
        int result = a * b;
        return result;
    }
}
