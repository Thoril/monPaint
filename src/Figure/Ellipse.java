package Figure;

import java.awt.*;

/**
 * Created by thomas on 02/05/17.
 */
public class Ellipse extends Figure {
    protected int petit_axe;
    protected int grand_axe;

    /**
     * Constructeur sans parametres
     */
    public Ellipse(){
        super();
        this.petit_axe = 0;
        this.grand_axe =0;
    }

    /**
     * Construire une ellipse
     * @param origine origine de l'ellipse
     * @param petit_axe largeur de l'ellipse
     * @param grand_axe hauteur de l'ellipse
     */
    public Ellipse(Point origine,int petit_axe, int grand_axe){
        super(origine);
        this.grand_axe = grand_axe;
        this.petit_axe = petit_axe;
    }

    /**
     * Construire une ellipse avec une couleur
     * @param origine origine de l'ellipse
     * @param petit_axe largeur de l'ellipse
     * @param grand_axe hauteur de l'ellipse
     * @param couleur couleur de l'ellipse
     */
    public Ellipse(Point origine,int petit_axe, int grand_axe, Color couleur){
        super(origine, couleur);
        this.grand_axe = grand_axe;
        this.petit_axe = petit_axe;
    }

    /**
     * Construire une ellipse sans origine
     * @param petit_axe largeur de l'ellipse
     * @param grand_axe hauteur de l'ellipse
     */
    public Ellipse(int petit_axe, int grand_axe){
        super();
        this.grand_axe = grand_axe;
        this.petit_axe = petit_axe;
    }

    /**
     * Methode pour dessiner l'ellipse
     * @param g
     */
    @Override
    public void dessine(Graphics g) {
        g.setColor(this.couleur);
        if(this.departDessin != null && this.grand_axe != 0 && this.petit_axe != 0) {
            if(remplissage){
                g.fillOval(this.departDessin.getX(), this.departDessin.getY(), this.petit_axe, this.grand_axe);
            }else {
                g.drawOval(this.departDessin.getX(), this.departDessin.getY(), this.petit_axe, this.grand_axe);
            }
        }
    }

    /**
     * Methode pour définir la hauteur et la largeur de l'ellipse
     * @param hauteurBB
     * @param largeurBB
     */
    public void setBoundingBox(int hauteurBB, int largeurBB) {
        this.petit_axe =hauteurBB;
        this.grand_axe = largeurBB;
    }
}
