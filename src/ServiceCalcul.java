import raytracer.Image;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceCalcul extends Remote {
    Image calcule(Calcule calcule) throws RemoteException;
}
