import raytracer.Image;
import java.io.Serializable;

public class Calcule implements Serializable {

    private String sceneDescription;

    private int startX, startY, width, height;

    private boolean estTermine;
    private Image resultatPartiel;

    public Calcule(int startX, int startY, int largeur, int hauteur) {
        this.startX = startX;
        this.startY = startY;
        this.width = largeur;
        this.height = hauteur;
        this.estTermine = false;
        this.resultatPartiel = null;
    }

    public String getSceneDescription() {
        return sceneDescription;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isEstTermine() {
        return estTermine;
    }

    public Image getResultatPartiel() {
        return resultatPartiel;
    }
}
