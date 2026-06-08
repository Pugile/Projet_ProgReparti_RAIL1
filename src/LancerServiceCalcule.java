import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class LancerServiceCalcule {
    public static void main(String[] args) {
        try {
            ServiceCalcule serviceCalcule = new ServiceCalculeImpl();

            ServiceCalcule s = (ServiceCalcule) UnicastRemoteObject.exportObject(serviceCalcule, 0);

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("ServiceCalcule", s);
            System.out.println("Service de calcul prêt à recevoir des tâches de calcul !");
        }
        catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
