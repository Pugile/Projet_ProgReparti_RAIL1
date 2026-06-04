import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceCentral extends Remote {
    void envoyerCalcule() throws RemoteException;
    void recevoirClacule() throws RemoteException;
    void diviserCalcule() throws RemoteException;

}
