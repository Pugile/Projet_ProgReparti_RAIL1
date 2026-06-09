import raytracer.Image;
import raytracer.Disp;
import raytracer.Scene;

import javax.swing.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class Clients {

    private ServiceCentral serviceCentrale;
    private Disp disp;

    Clients(ServiceCentral sc, Disp disp) {
        this.serviceCentrale = sc;
        this.disp = disp;
    }

    public void diviserCalcule(int largeur, int hauteur) throws RemoteException {

        //Découpage en bandes horizontales
        int hauteurBande = hauteur / 100;
        int reste = hauteur % 100;

        for (int i = 0; i < 100; i++) {
            final int index = i;
            final int startY = i * hauteurBande;
            final int endY = (i == 100 - 1) ? (startY + hauteurBande + reste) : (startY + hauteurBande);


            new Thread(() -> {
                ServiceCalcule noeud = null;
                try {
                    noeud = this.serviceCentrale.envoyerService();

                    System.out.println("Envoi de la bande " + startY + " à " + endY + " au nœud " + index);
                    int hauteurBandeSpe = endY - startY;
                    Calcule c = new Calcule("simple.txt",0, startY, largeur, hauteurBandeSpe,largeur,hauteur);
                    Image imagePartielle = noeud.calcule(c);

                    SwingUtilities.invokeLater(() -> {
                        this.disp.setImage(imagePartielle, c.getStartX(), c.getStartY());
                    });

                } catch (RemoteException e) {
                    System.out.println("Échec de communication avec le nœud " + index + " : " + e.getMessage());
                    if(noeud != null) {
                        try {
                            this.serviceCentrale.updateService(noeud);
                        } catch (RemoteException ex) {
                            throw new RuntimeException(ex);
                        }
                    }else{
                        System.out.println("Erreur le noeud est null");
                    }
                }
            }).start();
        }
    }


public static void main(String[] args) {
    try {
        if (args.length != 2) {
            System.out.println("Usage: java Clients <ip> <port>");
        }
        Registry reg = LocateRegistry.getRegistry(args[0], Integer.parseInt(args[1]));
        ServiceCentral sc = (ServiceCentral) reg.lookup("ServiceCentral");
        Scanner scan = new Scanner(System.in);

        System.out.println("Entrez la largeur : ");
        int largeur = Integer.parseInt(scan.nextLine());
        System.out.println("Entrez la hauteur : ");
        int hauteur = Integer.parseInt(scan.nextLine());
        Clients c = new Clients(sc,new Disp("raytracing",largeur,hauteur));
        c.diviserCalcule(largeur,hauteur);
    }
    catch (RemoteException e) {
        e.printStackTrace();
    } catch (NotBoundException e) {
        throw new RuntimeException(e);
    }

}

}
