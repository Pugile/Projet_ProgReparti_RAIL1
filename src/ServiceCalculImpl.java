import raytracer.Scene;
import raytracer.Image;

public class ServiceCalculImpl implements ServiceCalcul {

    public ServiceCalculImpl() {
        super();
    }

    @Override
    public Image calcule(Calcule calcule) {
        System.out.println("Demande de calcul reçue pour les lignes " + calcule.getStartY() + " à " + calcule.getStartY()+calcule.getHeight());

        Scene scene = new Scene(calcule.getSceneDescription(), calcule.getWidth(), calcule.getHeight());

        Image partialImage = scene.compute(calcule.getStartX(), calcule.getStartY(), calcule.getWidth(), calcule.getHeight());

        System.out.println("Calcul de la portion terminé.");
        return partialImage;
    }
}
