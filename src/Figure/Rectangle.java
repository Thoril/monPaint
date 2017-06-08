package Figure;

import java.awt.*;

/**
 * Created by thomas on 02/05/17.
 */
public class Rectangle extends Figure {
    protected int longueur;
    protected int largeur;

    public Rectangle(){
        super();
    }
    public Rectangle(Point origine){
        super(origine);
        this.longueur=0;
        this.largeur=0;
    }
    public Rectangle(int longueur, int largeur){
        super();
        this.longueur = longueur;
        this.largeur = largeur;
    }
    public Rectangle(Point origine , int longueur, int largeur){
        super(origine);
        this.longueur = longueur;
        this.largeur = largeur;
    }
    public Rectangle(Point origine , int longueur, int largeur, Color couleur){
        super(origine, couleur);
        this.longueur = longueur;
        this.largeur = largeur;
    }
    public double getPerimetre(){
        return(2*(this.largeur+this.longueur));
    }
    public double getSurface(){
        return(this.largeur*this.longueur);
    }
    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }
    public String toString(){
        StringBuffer sb=new StringBuffer();
        for(int x = 0 ; x<this.largeur;x++){
            for(int y =0; y<this.longueur;y++) {
                if (x == 0 || x == this.largeur-1) {
                    if(y==0 || y ==this.longueur-1){
                        sb.insert(0,"+");
                    }else{
                        sb.insert(0,"--");
                    }
                }else if(y==0 || y== this.longueur -1){
                    sb.insert(0,"|");
                }else{
                    sb.insert(0,"  ");
                }
            }
            sb.insert(0,"\n");
        }
        String str = sb.toString();
        return (str);
    }

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

    @Override
    public void setBoundingBox(int hauteurBB, int largeurBB) {
        this.largeur =hauteurBB;
        this.longueur = largeurBB;
    }
}
