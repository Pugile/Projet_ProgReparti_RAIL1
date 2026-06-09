import raytracer.Scene;
import raytracer.Image;

public class ServiceCalculeImpl implements ServiceCalcule {

    public ServiceCalculeImpl() {
        super();
    }

    @Override
    public Image calcule(Calcule calcule) {
        System.out.println("Demande de calcul reçue pour les lignes " + calcule.getStartY() + " à " + calcule.getStartY()+calcule.getBlockHeight());

        Scene scene = new Scene(calcule.getSceneDescription(), calcule.getTotalWidth(), calcule.getTotalHeight());

        Image partialImage = scene.compute(calcule.getStartX(), calcule.getStartY(), calcule.getBlockWidth(), calcule.getBlockHeight());

        System.out.println("Calcul de la portion terminé.");
        return partialImage;
    }
}
