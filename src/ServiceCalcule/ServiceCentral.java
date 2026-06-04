package ServiceCalcule;

import raytracer.Image;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceCentral extends Remote {
    void envoyerCalcule(int w, int h) throws RemoteException;
    void recevoirCalcule(Image img) throws RemoteException;
    void diviserCalcule(int largeur,int hauteur) throws RemoteException;

}
