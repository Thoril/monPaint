package Fenetre;

import Figure.*;
import Figure.Point;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.image.*;

/**
 * Classe zone de dessin qui herite de Jpanel
 */
public class ZoneDessin extends JPanel {
    private Figure figureSelectionne;
    private ArrayList<Figure> listeFigure;
    private Color couleur;
    private ArrayList<Figure> listeBackUpFigure;
    private Image img;

    /**
     * constructeur de zone Dessin sans parametre
     */
    public ZoneDessin(){
        super();
        this.listeFigure= new ArrayList<Figure>();
        this.listeBackUpFigure = new ArrayList<Figure>();
        this.listeFigure.clear();
        this.couleur = Color.black;
        figureSelectionne = new Cercle();

    }

    /**
     * methode qui permet d'afficher des éléments a l'écran
     * @param g
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        if(this.img != null) {
            g.drawImage(img, 0, 0, null);
        }

        if(!this.listeFigure.isEmpty()) {
            this.afficheListeFigure(g);
        }
        if(this.figureSelectionne != null) {
            this.figureSelectionne.setCouleur(this.couleur);
            this.figureSelectionne.dessine(g);
        }

    }

    /**
     * On definit la couleur utilisé
     * @param couleur color
     */
    public void setCouleur(Color couleur) {
        this.couleur = couleur;
        //System.out.println("Couleur set a "+this.couleur);

    }

    /**
     * Affiche les figures dans la liste attribut de la classe
     * @param g
     */
    public void afficheListeFigure(Graphics g){
        for(Figure f : this.listeFigure) {
            f.dessine(g);
        }
     }

    /**
     *
     * @return la figure selectionne
     */
    public Figure getFigureSelectionne() {
        return this.figureSelectionne;
    }

    /**
     * Set la figure selectionne a celle passe en parametre
     * @param figureSelectionne Figure
     */
    public void setFigureSelectionne(Figure figureSelectionne) {
        //System.out.println("FigureSelectionne");
        this.figureSelectionne = figureSelectionne;
    }

    /**
     * Ajouite la figure passe en parametre a la liste de Figure de la classe
     * @param f
     */
    public void addListeFigure(Figure f){
        int indice = this.listeFigure.size();
        System.out.println("Ajout d'une figure indice:"+indice);
        f.setCouleur(this.couleur);
        this.listeFigure.add(f);
    }

    /**
     * Definit l'origine de al figure selectionné au point passé en parametre
     * @param origine Point
     */
    public void setOrigineFigure(Point origine){
        //System.out.println("Origine set en "+origine.getX()+" ,"+origine.getY() );
        this.figureSelectionne.setOrigine(origine);
    }

    /**
     * Retourne l'orifine de la figure selectionné
     * @return Point
     */
    public Point getOrigineFigure(){
        return(this.figureSelectionne.getOrigine());
    }

    /**
     * Definit la taille de la figure selectionne
     * @param hauteur int
     * @param largeur int
     */
    public void setDimensionFigure(int hauteur, int largeur){
        //System.out.println("Dimension set en "+hauteur+" ,"+largeur );
        this.figureSelectionne.setBoundingBox(hauteur, largeur);
    }

    /**
     * Pour la figure segment definit le point d'arrivé
     * @param arrive Point
     */
    public void setArriveSegment(Point arrive){
        this.figureSelectionne.setArriveDessin(arrive);
    }

    /**
     * Definit le point de départ de tracer de la figure
     * @param p Point
     */
    public void setOrigineDessinFigure(Point p){
        this.figureSelectionne.setDepartDessin(p);
    }

    /**
     * Retourne le point de depart du déssin de la figure
     * @return Point
     */
    public Point getDepartDessin(){
        return(this.figureSelectionne.getDepartDessin());
    }

    /**
     * Permet d'effacer l'écran
     */
    public void effacer(){
        this.listeFigure = new ArrayList<Figure>();
        this.img = null;
        repaint();
    }

    /**
     * Sauvegarde le dessin en png a l'adresse passer en parametre
     * @param name String
     */
    public void save(String name){
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        print(g);
        g.dispose();
        try {
            ImageIO.write(image, "png", new File(name+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Permet de charger l'image a l'adresse passer en parametre
     * @param name String
     */
    public void load(String name){
        this.img= new ImageIcon(name).getImage();
        repaint();
    }

    /**
     * Permet de definir si le remplissage de la figure selectionné est a true ou false
     * @param remplissage boolean
     */
    public void setRemplissage(boolean remplissage){
        figureSelectionne.setRemplissage(remplissage);
    }

    /**
     * Permet d'annuler la deniere figure ajouté
     */
    public void precedent(){
        if(!listeFigure.isEmpty()) {
            listeBackUpFigure.add(listeFigure.get(listeFigure.size() - 1));
            listeFigure.remove(listeFigure.size() - 1);
        }
    }

    /**
     * Permet de remettre la derniere figure supprimé
     */
    public void suivant(){
        if(!listeBackUpFigure.isEmpty()) {
            listeFigure.add(listeBackUpFigure.get(listeBackUpFigure.size() - 1));
            listeBackUpFigure.remove(listeBackUpFigure.size() - 1);
        }

    }
}
