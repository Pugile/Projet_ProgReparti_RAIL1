package ServiceCalcule;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class LancerServiceCalcule {

    public static void main(String[] args) throws RemoteException {
        try{


            Registry reg = LocateRegistry.getRegistry(args[0], 1099);
            ServiceCentrale sc = (ServiceCentrale) reg.lookup("ServiceCentrale");
            Calcule calcule = new Calcule(sc);

            ServiceCalcule stb = (ServiceCalcule) UnicastRemoteObject.exportObject(calcule ,0);
            sc.enregistrerClient(stb);


        }catch(NotBoundException e){
            System.out.println(e.getMessage());

    }
}
