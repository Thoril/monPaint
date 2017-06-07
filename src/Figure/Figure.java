package Figure;

import java.awt.*;

/**
 * Created by thomas on 02/05/17.
 */
public abstract class Figure {
    protected Point origine;
    protected Color couleur;
    protected Point departDessin;
    protected Point arriveDessin;
    public Figure(Point origine, Color couleur){
        this.origine=origine;
        this.couleur = couleur;
    }
    public  Figure(Point origine){
        this.origine=origine;
        this.couleur = Color.black;
    }

    public Figure(){
        this.origine = new Point();
        this.couleur = Color.black;
        this.arriveDessin = new Point();
        this.departDessin = new Point();
    }

    public void setOrigine(Point p){
        origine = p;
    }
    public Point getOrigine() {
        return this.origine;
    }
    public void setDepartDessin(Point p){departDessin = p;}
    public Point getDepartDessin() {
        return this.departDessin;
    }
    public void setCouleur(Color couleur){
        this.couleur = couleur;
    }
    public abstract void dessine(Graphics g);
    public abstract void  setBoundingBox(int hauteurBB, int largeurBB);
    public Point getArriveDessin() {
        return arriveDessin;
    }
    public void setArriveDessin(Point arriveDessin) {
        this.arriveDessin = arriveDessin;
    }
}
