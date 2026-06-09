import java.rmi.NotBoundException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class LancerServiceCalcule {
    public static void main(String[] args) {
        try {
            ServiceCalcule serviceCalcule = new ServiceCalculeImpl();

            ServiceCalcule s = (ServiceCalcule) UnicastRemoteObject.exportObject(serviceCalcule, 0);

            Registry registry = LocateRegistry.createRegistry(1100);
            registry.rebind("ServiceCalcule", s);

            Registry reg = LocateRegistry.getRegistry(args[0], Integer.parseInt(args[1]));
            ServiceCentral sc = (ServiceCentral) reg.lookup("ServiceCentral");

            sc.enregistrerClient(s);
            System.out.println("Service de calcul prêt à recevoir des tâches de calcul !");
        }
        catch (RemoteException e) {
            e.printStackTrace();
        }
        catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}
