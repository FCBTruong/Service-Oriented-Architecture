import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Locale;

public class Server {
    public static String pathProject;
    public static void main (String[] argv){
        // System.setProperty("java.rmi.server.hostname","192.168.1.2");
        System.setProperty("java.security.policy", "security.policy");
        try {
            System.setSecurityManager(new RMISecurityManager());

            ServerMethod Hello = new ServerMethod();
            Registry registry = LocateRegistry.createRegistry(2000);
            registry.rebind("rmi://localhost/ABC", Hello);
            System.out.println("Addition Server is ready");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
