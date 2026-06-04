import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class LancerServiceCalcule {

    public static void main(String[] args) throws RemoteException {
        try {
            Registry reg = LocateRegistry.getRegistry(args[0], 1099);
            ServiceCentral serviceCentral = (ServiceCentral) reg.lookup("ServiceCentrale");
            ServiceCalcule serviceCalcule = new ServiceCalculeImpl(serviceCentral);

            serviceCentral.enregistrerClient(serviceCalcule);
            System.out.println("service calcule bien enregistré");


        } catch (NotBoundException e) {
            System.out.println(e.getMessage());

        }
    }
}
