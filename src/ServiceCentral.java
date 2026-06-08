import raytracer.Image;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceCentral extends Remote {
    ServiceCalcule envoyerService() throws RemoteException;
    void enregistrerClient(ServiceCalcule noeud) throws RemoteException;
    void updateService(ServiceCalcule noeud) throws RemoteException;
}
