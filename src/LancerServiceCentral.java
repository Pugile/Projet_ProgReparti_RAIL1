import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class LancerServiceCentral {
    public static void main(String[] args) {
        try{
            ServiceCentral sCentral = new ServiceCentralImpl();
            ServiceCentral s = (ServiceCentral) UnicastRemoteObject.exportObject(sCentral, 0);

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("ServiceCentral", s);
            System.out.println("Serveur central prêt à recevoir des ServiceCalcule et les distribuer");
        } catch (RemoteException e) {
            System.out.println("Erreur lors de l'exportation de l'objet : " + e.getMessage());
        }
    }
}
