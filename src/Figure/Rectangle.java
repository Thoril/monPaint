package Figure;

import java.awt.*;

/**
 * Created by thomas on 02/05/17.
 */

public class Rectangle extends Figure {
    protected int longueur;
    protected int largeur;

    /**
     * Constructeur sans parametre
     */
    public Rectangle(){
        super();
    }

    /**
     * Methode pour dessiner le rectangle
     * @param g
     */
    @Override
    public void dessine(Graphics g) {
        g.setColor(this.couleur);
        if(this.departDessin != null && this.largeur != 0 && this. longueur != 0) {
            if(remplissage) {
                g.fillRect(this.departDessin.getX(), this.departDessin.getY(), this.largeur, this.longueur);
            }else {
                g.drawRect(this.departDessin.getX(), this.departDessin.getY(), this.largeur, this.longueur);
            }
        }
    }

    /**
     * Methode pour definir la taille des cotés du Rectangle
     * @param hauteurBB
     * @param largeurBB
     */
    @Override
    public void setBoundingBox(int hauteurBB, int largeurBB) {
        this.largeur =hauteurBB;
        this.longueur = largeurBB;
    }
}
