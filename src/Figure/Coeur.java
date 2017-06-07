package Figure;

import java.awt.*;

public class Coeur extends Figure {
    protected int petit_axe;
    protected int grand_axe;

    public Coeur() {
        super();
        this.petit_axe = 0;
        this.grand_axe = 0;
    }

    public Coeur(Point origine, int petit_axe, int grand_axe) {
        super(origine);
        this.grand_axe = grand_axe;
        this.petit_axe = petit_axe;
    }

    public Coeur(Point origine, int petit_axe, int grand_axe, Color couleur) {
        super(origine, couleur);
        this.grand_axe = grand_axe;
        this.petit_axe = petit_axe;
    }

    public Coeur(int petit_axe, int grand_axe) {
        super();
        this.grand_axe = grand_axe;
        this.petit_axe = petit_axe;
    }

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

    public void setBoundingBox(int hauteurBB, int largeurBB) {
        this.petit_axe = hauteurBB;
        this.grand_axe = largeurBB;
    }
}


