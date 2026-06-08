import raytracer.Image;
import raytracer.RayTracer;
import raytracer.Scene;

import java.rmi.RemoteException;

public class ServiceCalculeImpl implements ServiceCalcule{

    public ServiceCalculeImpl() throws RemoteException {
        super();
    }

    @Override
    public Image calcule(Calcule calcule) throws RemoteException {
        System.out.println("Demande de calcul reçue pour les lignes " + calcule.getStartY() + " à " + calcule.getStartY()+calcule.getHeight());

        Scene scene = new Scene(calcule.getSceneDescription(), calcule.getWidth(), calcule.getHeight());

        Image partialImage = scene.compute(calcule.getStartX(), calcule.getStartY(), calcule.getWidth(), calcule.getHeight());

        System.out.println("Calcul de la portion terminé.");
        return partialImage;
    }
}
