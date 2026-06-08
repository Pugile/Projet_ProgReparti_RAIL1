import raytracer.Image;

import java.rmi.RemoteException;

public class ServiceCalculeImpl implements ServiceCalcule{

    public ServiceCalculeImpl() throws RemoteException {
        super();
    }

    @Override
    public Image calcule(String sceneDescription, int width, int height, int startY, int endY) throws RemoteException {
        System.out.println("Calcul des lignes " + startY + " à " + endY);

        raytracer.Scene scene = new raytracer.Scene(sceneDescription, width, height);

        int hauteurBande = endY - startY;
        Image partialImage = scene.compute(0, startY, width, hauteurBande);

        return partialImage;
    }
}
