package ServiceCalcule;

import raytracer.Image;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceCalcule extends Remote {
    Image calcule(int w,int h) throws RemoteException;

}
