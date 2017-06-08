package Figure;

import java.awt.*;

public class Coeur extends Figure {
    protected int petit_axe;
    protected int grand_axe;

    /**
     * Constructeur sans parametre du coeur
     */
    public Coeur() {
        super();
        this.petit_axe = 0;
        this.grand_axe = 0;
    }

    /**
     * Methode pour desiner un coeur
     * @param g
     */
    @Override
    public void dessine(Graphics g) {
        g.setColor(this.couleur);
        if (this.departDessin != null && this.grand_axe != 0 && this.petit_axe != 0) {
            int x = this.departDessin.getX();
            int y = this.departDessin.getY();
            int height = petit_axe;
            int width = petit_axe;
            int[] triangleX = {x - 2 * width / 18, x + width + 2 * width / 18, (x - 2 * width / 18 + x + width + 2 * width / 18) / 2};
            int[] triangleY = {y + height - 2 * height / 3, y + height - 2 * height / 3, y + height};
            g.fillOval((int) (x - width / 8), y, (int) (width / 2 + width / 4.4), height / 2);
            g.fillOval((int) (x + width / 2 - width / 11), y, (int) (width / 2 + width / 4.4), height / 2);
            g.fillPolygon(triangleX, triangleY, triangleX.length);
        }

    }

    /**
     * Methode pour définir le diametre du cercle
     * @param hauteurBB
     * @param largeurBB
     */
    public void setBoundingBox(int hauteurBB, int largeurBB) {
        this.petit_axe = hauteurBB;
        this.grand_axe = largeurBB;
    }
}


