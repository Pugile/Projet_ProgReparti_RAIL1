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
    public void diviserCalcule(int largeur,int hauteur) throws RemoteException {
        int nbCalcule = lService.size();
        int largeurCalcule = largeur/nbCalcule;
        int hauteurCalcule = hauteur/nbCalcule;

        for(int i=0; i<nbCalcule; i++) {
            Calcule calcule = new Calcule(i*largeurCalcule, i*hauteurCalcule, largeurCalcule, hauteurCalcule);
            lCalcule.add(calcule);
            lService.get(i).calcule(largeurCalcule, hauteurCalcule);
        }
    }
}
