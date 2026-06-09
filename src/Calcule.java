import raytracer.Image;
import java.io.Serializable;

public class Calcule implements Serializable {

    private String sceneDescription;

    private int startX, startY;

    private int blockWidth, blockHeight;
    private int totalWidth, totalHeight;

    private boolean estTermine;
    private Image resultatPartiel;

    public Calcule(String sceneDescription, int startX, int startY,int blockWidth, int blockHeight, int totalWidth, int totalHeight) {
        this.sceneDescription = sceneDescription;
        this.startX = startX;
        this.startY = startY;
        this.estTermine = false;
        this.resultatPartiel = null;
        this.blockWidth = blockWidth;
        this.blockHeight = blockHeight;
        this.totalWidth = totalWidth;
        this.totalHeight = totalHeight;

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

    public int getBlockWidth() { return blockWidth; }
    public int getBlockHeight() { return blockHeight; }
    public int getTotalWidth() { return totalWidth; }
    public int getTotalHeight() { return totalHeight; }

    public boolean isEstTermine() {
        return estTermine;
    }

    public Image getResultatPartiel() {
        return resultatPartiel;
    }
}
