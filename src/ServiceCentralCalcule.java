import java.rmi.RemoteException;
import java.util.ArrayList;

import ServiceCalcule.Calcule;
import raytracer.Image;

public class ServiceCentralCalcule implements ServiceCentral{

    private ArrayList<Calcule> listCalcule = new ArrayList<>();
    private ArrayList<ServiceCalcule> listService = new ArrayList<>();

    @Override
    public void envoyerCalcule(int w, int h) throws RemoteException {

    }

    @Override
    public void recevoirCalcule(Image img) throws RemoteException {

    }


    @Override
    public void diviserCalcule(int largeur, int hauteur) throws RemoteException {

    }
}
