import raytracer.Image;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceCalcule extends Remote {
    Image calcule(String sceneDescription, int width, int height, int startY, int startX) throws RemoteException;

}
