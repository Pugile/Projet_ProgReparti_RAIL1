package ServiceCalcule;

public class Calcule {

        private int x0;
        private int y0;
        private int largeur;
        private int hauteur;

        public Calcule(int x0, int y0, int largeur, int hauteur) {
            this.x0 = x0;
            this.y0 = y0;
            this.largeur = largeur;
            this.hauteur = hauteur;
        }

        public int getX0() {
            return x0;
        }

        public int getY0() {
            return y0;
        }

        public int getLargeur() {
            return largeur;
        }

        public int getHauteur() {
            return hauteur;
        }

}
