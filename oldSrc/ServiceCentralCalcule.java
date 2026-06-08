import java.rmi.RemoteException;
import java.util.ArrayList;

import raytracer.Disp;
import raytracer.Image;

public class ServiceCentralCalcule implements ServiceCentral{

    private ArrayList<ServiceCalcule> listService = new ArrayList<>();
    private Disp disp;

    @Override
    public synchronized void envoyerCalcule(Calcule c) throws RemoteException {
        System.out.println("Début du calcul de l'image de taille " + c.getWidth() + "x" + c.getHeight() + " !");

        this.disp = new Disp("Raytracer Réparti - Serveur Central", c.getWidth(), c.getHeight());
        diviserCalcule(c.getWidth(), c.getHeight());
    }

    @Override
    public synchronized void envoyerImage(Image imgPartielle, int startY) throws RemoteException {
        System.out.println("Réception d'une bande ! Affichage à partir de la ligne " + startY);

        this.disp.setImage(imgPartielle, 0, startY);
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
                    Calcule mission = new Calcule("simple.txt", 0, startY, largeur, hauteurA_Calculer);

                    Image imagePartielle = noeud.calcule(mission);

                    envoyerImage(imagePartielle, startY);
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
