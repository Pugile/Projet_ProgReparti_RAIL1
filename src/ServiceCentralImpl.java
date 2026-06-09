import java.rmi.RemoteException;
import java.util.ArrayList;

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
        ServiceCalcule sc = listService.get(i);
        i++;
        if(i>=listService.size()){
            i=0;
        }
        return sc;
    }

    @Override
    public void updateService(ServiceCalcule noeud) throws RemoteException  {
        if(listService.contains(noeud)) listService.remove(noeud);
    }
}
