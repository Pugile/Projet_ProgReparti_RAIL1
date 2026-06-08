import java.rmi.RemoteException;
import java.util.ArrayList;


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
        int nbNoeuds = listService.size();
        if (nbNoeuds == 0) {
            System.out.println("Aucun nœud de calcul enregistré !");
            return;
        }

        //Découpage en bandes horizontales
        int hauteurBande = hauteur / nbNoeuds;
        int reste = hauteur % nbNoeuds;

        for (int i = 0; i < nbNoeuds; i++) {
            final int index = i;
            final int startY = i * hauteurBande;
            final int endY = (i == nbNoeuds - 1) ? (startY + hauteurBande + reste) : (startY + hauteurBande);

            new Thread(() -> {
                try {
                    ServiceCalcule noeud = listService.get(index);

                    System.out.println("Envoi de la bande " + startY + " à " + endY + " au nœud " + index);
                    Image imagePartielle = noeud.calcule(new Calcule("simple.txt", largeur, hauteur, startY, endY));

                    recevoirCalcule(imagePartielle);

                } catch (RemoteException e) {
                    System.out.println("Échec de communication avec le nœud " + index + " : " + e.getMessage());
                }
            }).start();
        }
    }

    @Override
    public void enregistrerClient(ServiceCalcule noeud) throws RemoteException {
        listService.add(noeud);
        System.out.println("Un nouveau nœud de calcul vient de se connecter ! (Total : " + listService.size() + ")");
    }
}
