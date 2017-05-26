package Fenetre;

import Figure.Figure;
import Figure.Point;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class zoneDessin extends JPanel {
    private Figure figureSelectionne;
    private ArrayList<Figure> listeFigure;
    private Color couleur;

    public zoneDessin(){
        super();
        this.listeFigure= new ArrayList<Figure>();
        this.listeFigure.clear();
        this.couleur = Color.black;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        //System.out.println("On dessine la figure sélectionné");
        if(!this.listeFigure.isEmpty()) {
            this.afficheListeFigure(g);
        }
        if(this.figureSelectionne != null) {
            this.figureSelectionne.setCouleur(this.couleur);
            this.figureSelectionne.dessine(g);
        }

    }


    public void setCouleur(Color couleur) {
        this.couleur = couleur;
        //System.out.println("Couleur set a "+this.couleur);

    }

    public void afficheListeFigure(Graphics g){
        for(Figure f : this.listeFigure) {
            f.dessine(g);
        }
     }

    public Figure getFigureSelectionne() {
        return this.figureSelectionne;
    }

    public void setFigureSelectionne(Figure figureSelectionne) {
        //System.out.println("FigureSelectionne");
        this.figureSelectionne = figureSelectionne;
    }
    public void addListeFigure(Figure f){
        int indice = this.listeFigure.size();
        System.out.println("Ajout d'une figure indice:"+indice);
        f.setCouleur(this.couleur);
        this.listeFigure.add(f);
    }

    public void setOrigineFigure(Point origine){
        //System.out.println("Origine set en "+origine.getX()+" ,"+origine.getY() );
        this.figureSelectionne.setOrigine(origine);
    }
    public Point getOrigineFigure(){
        return(this.figureSelectionne.getOrigine());
    }

    public void setDimensionFigure(int hauteur, int largeur){
        //System.out.println("Dimension set en "+hauteur+" ,"+largeur );
        this.figureSelectionne.setBoundingBox(hauteur, largeur);
    }
    public void setOrigineDessinFigure(Point p){
        this.figureSelectionne.setDepartDessin(p);
    }
    public Point getDepartDessin(){
        return(this.figureSelectionne.getDepartDessin());
    }

    public void effacer(){
        this.listeFigure = new ArrayList<Figure>();
        repaint();
    }
}
