import java.rmi.RemoteException;
import java.util.ArrayList;

import raytracer.Disp;
import raytracer.Image;

public class ServiceCentralImpl implements ServiceCentral{

    private ArrayList<ServiceCalcule> listService = new ArrayList<>();
    private int i = listService.size();

    @Override
    public void enregistrerClient(ServiceCalcule noeud) throws RemoteException {
        listService.add(noeud);
        System.out.println("Un nouveau nœud de calcul vient de se connecter ! (Total : " + listService.size() + ")");
    }

    @Override
    public ServiceCalcule envoyerService() throws RemoteException {
        ServiceCalcul sc = listService.get(i);
        i++;
        if(i>=listService.size()){
            i=0;
        }
        return sc;
    }
}
