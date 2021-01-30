import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AdditionClient {
    public static void main (String[] args){
        System.setProperty("java.security.policy", "security.policy");
        AdditionInterface hello;
        try {
            System.setSecurityManager(new RMISecurityManager());
            Registry registry = LocateRegistry.getRegistry(2000);
            hello = (AdditionInterface) registry.lookup("rmi://localhost/ABC");

            int result= hello.add(8, 100);
            System.out.println("Result = " + result);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
