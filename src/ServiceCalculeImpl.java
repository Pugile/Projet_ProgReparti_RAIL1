import raytracer.Image;
import raytracer.RayTracer;
import raytracer.Scene;

import java.rmi.RemoteException;

public class ServiceCalculeImpl implements ServiceCalcule{

    public ServiceCalculeImpl() throws RemoteException {
        super();
    }

    @Override
    public Image calcule(String sceneDescription, int width, int height, int startY, int startX) throws RemoteException {
        System.out.println("Demande de calcul reçue pour les lignes " + startY + " à " + startY+height);

        Scene scene = new Scene(sceneDescription, width, height);

        Image partialImage = scene.compute(startX, startY, width, height);

        System.out.println("Calcul de la portion terminé.");
        return partialImage;
    }
}
