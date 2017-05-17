package Figure;

import java.awt.*;

/**
 * Created by thomas on 02/05/17.
 */
public class Cercle extends Ellipse{
    public Cercle(Point origine, int rayon)
    {
        super(origine,rayon,rayon);
    }
    public Cercle(Point origine, int rayon, Color couleur)
    {
        super(origine,rayon,rayon,couleur);
    }
    public Cercle( int rayon)
    {
        super(rayon,rayon);
    }
    public Cercle()
    {
        super();
    }

    @Override
    public void dessine(Graphics g) {
        g.setColor(this.couleur);
        g.fillOval(this.origine.getX(),this.origine.getY(),this.grand_axe,this.grand_axe);
    }
    public void setBoundingBox(int hauteurBB, int largeurBB) {
        this.petit_axe =hauteurBB;
        this.grand_axe = hauteurBB;
    }
}
