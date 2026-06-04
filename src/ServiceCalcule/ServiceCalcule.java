package ServiceCalcule;

import raytracer.Image;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceCalcule extends Remote {
    Image calcule() throws RemoteException;

}
