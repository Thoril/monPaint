package Figure;

import java.awt.*;

/**
 * Created by thomas on 02/05/17.
 */
public class Carre extends Rectangle{
    public Carre(Point origine, int largeur, Color couleur){
        super(origine,largeur,largeur, couleur);
    }
    public Carre(Point origine, int largeur){
        super(origine,largeur,largeur);
    }
    public Carre(){
        super();
    }
    public Carre(int largeur){
        super(largeur,largeur);
    }
    public void setLargeur(int largeur) {
        this.largeur = largeur;
        this.longueur =largeur;
    }
    public void setLongueur(int longueur) {
        this.longueur = longueur;
        this.largeur = longueur;
    }
    public void dessine(Graphics g) {
        g.setColor(this.couleur);
        if(this.departDessin != null && this.largeur != 0) {
            g.fillRect(this.departDessin.getX(), this.departDessin.getY(), this.largeur, this.largeur);
        }
    }
    @Override
    public void setBoundingBox(int hauteurBB, int largeurBB) {
        int dimension = Math.max(hauteurBB, largeurBB);
        this.largeur =dimension;
        this.longueur = dimension;
    }
}
