package Figure;

import java.awt.*;

/**
 * Created by thomas on 02/05/17.
 */

/**
 * Classe carre
 */
public class Carre extends Rectangle{

    /**
     * Constructeur sans parametre
     */
    public Carre(){
        super();
    }

    /**
     *
     * @param largeur dimension des cotés du carré
     */
    public void setLargeur(int largeur) {
        this.largeur = largeur;
        this.longueur =largeur;
    }

    /**
     * @param longueur dimension des cotés du carré
     */
    public void setLongueur(int longueur) {
        this.longueur = longueur;
        this.largeur = longueur;
    }

    /**
     * Methode pour dessiner le carré
     * @param g
     */
    public void dessine(Graphics g) {
        g.setColor(this.couleur);
        if(this.departDessin != null && this.largeur != 0) {
            if(remplissage) {
                g.fillRect(this.departDessin.getX(), this.departDessin.getY(), this.largeur, this.largeur);
            }else{
                g.drawRect(this.departDessin.getX(), this.departDessin.getY(), this.largeur, this.largeur);
            }
        }
    }

    /**
     * Definit la taille des cotés du carré
     * @param hauteurBB
     * @param largeurBB
     */
    @Override
    public void setBoundingBox(int hauteurBB, int largeurBB) {
        int dimension = Math.max(hauteurBB, largeurBB);
        this.largeur =dimension;
        this.longueur = dimension;
    }
}
