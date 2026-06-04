import raytracer.Image;

import java.rmi.RemoteException;

public class ServiceCalculeImpl implements ServiceCalcule{

    public ServiceCalculeImpl() throws RemoteException {
        super();
    }

    @Override
    public Image calcule(String sceneDescription, int width, int height, int startY, int endY) throws RemoteException {
        System.out.println("Demande de calcul reçue pour les lignes " + startY + " à " + endY);

        Raytracer raytracer = new Raytracer(width, height, sceneDescription);
        Image partialImage = raytracer.compute(startY, endY);

        System.out.println("Calcul de la portion terminé.");
        return partialImage;
    }
}
