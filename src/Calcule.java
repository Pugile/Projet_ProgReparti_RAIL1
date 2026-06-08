import raytracer.Image;
import java.io.Serializable;

public class Calcule implements Serializable {

    private int startX;
    private int startY;
    private int largeur;
    private int hauteur;

    private boolean estTermine;
    private Image resultatPartiel;

    public Calcule(int startX, int startY, int largeur, int hauteur) {
        this.startX = startX;
        this.startY = startY;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.estTermine = false;
        this.resultatPartiel = null;
    }

    public int getStartX() {
        return startX;
    }
    public int getStartY() {
        return startY;
    }
    public int getLargeur() {
        return largeur;
    }
    public int getHauteur() {
        return hauteur;
    }

    public boolean isEstTermine() {
        return estTermine;
    }

    public void marquerCommeTermine(Image image) {
        this.resultatPartiel = image;
        this.estTermine = true;
    }

    public Image getResultatPartiel() {
        return resultatPartiel;
    }
}