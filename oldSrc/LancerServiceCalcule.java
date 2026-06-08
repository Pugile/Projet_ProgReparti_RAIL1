import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class LancerServiceCalcule {

    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.getRegistry(args[0], 1099);

            ServiceCentral serviceCentral = (ServiceCentral) reg.lookup("ServiceCentral");

            ServiceCalcule serviceCalcule = new ServiceCalculeImpl();

            ServiceCalcule stubCalcule = (ServiceCalcule) UnicastRemoteObject.exportObject(serviceCalcule, 0);

            serviceCentral.enregistrerClient(stubCalcule);

            System.out.println("Service de calcul prêt et enregistré auprès du serveur central !");

        } catch (RemoteException e) {
            System.out.println("Erreur de communication RMI : " + e.getMessage());
        } catch (NotBoundException e) {
            System.out.println("Le Serveur Central est introuvable sur le registre : " + e.getMessage());
        }
    }
}