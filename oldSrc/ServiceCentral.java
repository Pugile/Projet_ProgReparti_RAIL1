import raytracer.Image;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceCentral extends Remote {
    void envoyerCalcule(Calcule c) throws RemoteException;
    void envoyerImage(Image i,int startY) throws RemoteException;
    void diviserCalcule(int largeur,int hauteur) throws RemoteException;
    void enregistrerClient(ServiceCalcule noeud) throws RemoteException;

}
