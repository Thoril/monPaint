package Figure;

import java.awt.*;

/**
 * Created by thomas on 02/05/17.
 */
public class Ellipse extends Figure {
    protected int petit_axe;
    protected int grand_axe;

    public Ellipse(){
        super();
        this.petit_axe = 0;
        this.grand_axe =0;
    }
    public Ellipse(Point origine,int petit_axe, int grand_axe){
        super(origine);
        this.grand_axe = grand_axe;
        this.petit_axe = petit_axe;
    }
    public Ellipse(Point origine,int petit_axe, int grand_axe, Color couleur){
        super(origine, couleur);
        this.grand_axe = grand_axe;
        this.petit_axe = petit_axe;
    }
    public Ellipse(int petit_axe, int grand_axe){
        super();
        this.grand_axe = grand_axe;
        this.petit_axe = petit_axe;
    }
    public double getPerimetre(){
        return(Math.PI*(this.petit_axe+this.grand_axe));
    }
    public double getSurface(){
        return((Math.PI*this.petit_axe*this.grand_axe)/4);
    }

    @Override
    public void dessine(Graphics g) {
        g.setColor(this.couleur);
        if(this.departDessin != null && this.grand_axe != 0 && this.petit_axe != 0) {
            g.fillOval(this.departDessin.getX(), this.departDessin.getY(), this.petit_axe, this.grand_axe);
        }
    }
    public void setBoundingBox(int hauteurBB, int largeurBB) {
        this.petit_axe =hauteurBB;
        this.grand_axe = largeurBB;
    }
}
