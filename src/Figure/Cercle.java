package Figure;

import java.awt.*;

/**
 * Created by thomas on 02/05/17.
 */
public class Cercle extends Ellipse{
    /**
     * Constructeur sans parametre
     */
    public Cercle()
    {
        super();
    }

    /**
     * Methode pour dessiner un Cercle
     * @param g
     */
    @Override
    public void dessine(Graphics g) {
        g.setColor(this.couleur);
        if(this.departDessin != null && this.grand_axe != 0) {
            if(remplissage) {
                g.fillOval(this.departDessin.getX(), this.departDessin.getY(), this.grand_axe, this.grand_axe);
            }else{
                g.drawOval(this.departDessin.getX(), this.departDessin.getY(), this.grand_axe, this.grand_axe);
            }
        }
    }

    /**
     * Methode pour définir le diametre du cercle
     * @param hauteurBB
     * @param largeurBB
     */
    public void setBoundingBox(int hauteurBB, int largeurBB) {
        int dimension = Math.max(hauteurBB, largeurBB);
        this.petit_axe =dimension;
        this.grand_axe = dimension;
    }
}
