import java.rmi.RemoteException;
import java.util.ArrayList;

import ServiceCalcule.Calcule;

public class ServiceCentralCalcule implements ServiceCentral{

    private ArrayList<Calcule> listCalcule = new ArrayList<>();
    private ArrayList<ServiceCalcule> listService = new ArrayList<>();

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
