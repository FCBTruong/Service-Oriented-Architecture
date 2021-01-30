import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main (String[] args){
        System.setProperty("java.security.policy", "security.policy");
        Pair hello;
        try {
            System.setSecurityManager(new RMISecurityManager());
            Registry registry = LocateRegistry.getRegistry(2000);
            hello = (Pair) registry.lookup("rmi://localhost/ABC");

            int SumResult= hello.getSum(8, 100);
            int MulResult = hello.getMul(8, 15);
            System.out.println("SumResult = " + SumResult);
            System.out.println("MulResult = " + MulResult);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
