import java.rmi.RemoteException;
import java.util.ArrayList;

public class ServiceCentralCalcule implements ServiceCentral{

    private ArrayList<Calcule> lCalcule = new ArrayList<>();
    private ArrayList<ServiceCalcule> lService = new ArrayList<>();

    @Override
    public void envoyerCalcule() throws RemoteException {

    }

    @Override
    public void recevoirClacule() throws RemoteException {

    }

    @Override
    public void diviserCalcule() throws RemoteException {

    }
}
