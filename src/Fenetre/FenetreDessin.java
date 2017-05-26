package Fenetre;

import Figure.*;
import Figure.Point;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.*;
import Figure.Rectangle;
public class FenetreDessin extends JFrame implements ActionListener,MouseMotionListener,MouseListener {
    private ArrayList listeZoneDessin =  new ArrayList();
    private JTabbedPane mesOnglets = new JTabbedPane();
    private enum TypeOutil {FIGURE, PINCEAU, GOMME}
    private TypeOutil typeOutil;
    private Color couleurActuelle;
    public FenetreDessin(String titre){
        super(titre);
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        Container contentPane = this.getContentPane() ;
        JPanel monPanel = new JPanel();
        monPanel.setLayout(new FlowLayout());
        monPanel.add( panelCouleur());
        monPanel.add(panelFigure());
        monPanel.add(panelOutil());
        contentPane.add(monPanel,BorderLayout.SOUTH);
        this.listeZoneDessin.add(new ZoneDessin());
        this.listeZoneDessin.add(new ZoneDessin());
        int i = 1;
        for (Object item: this.listeZoneDessin) {
            ZoneDessin zoneDessin = (ZoneDessin) item;
            mesOnglets.add(zoneDessin,"zone n°"+i);
            zoneDessin.addMouseListener(this);
            zoneDessin.addMouseMotionListener(this);
            i++;
        }
        //mesOnglets.add(listeZoneDessin[0],"zone n°1");
        contentPane.add(mesOnglets,BorderLayout.CENTER);

        this.setJMenuBar(monMenu());
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ZoneDessin zoneDessin;
        zoneDessin = (ZoneDessin) this.listeZoneDessin.get(this.mesOnglets.getSelectedIndex());
        String cmd = e.getActionCommand();
        switch (cmd){
            case"Noir":
                zoneDessin.setCouleur(Color.black);
                this.couleurActuelle =Color.black;
                break;
            case"Rouge":
                zoneDessin.setCouleur(Color.RED);
                this.couleurActuelle =Color.red;
                break;
            case"Vert":
                zoneDessin.setCouleur(Color.green);
                this.couleurActuelle =Color.green;
                break;
            case"Bleu":
                zoneDessin.setCouleur(Color.blue);
                this.couleurActuelle =Color.blue;
                break;
            case"Jaune":
                zoneDessin.setCouleur(Color.YELLOW);
                this.couleurActuelle =Color.yellow;
                break;
            case"Rose":
                zoneDessin.setCouleur(Color.PINK);
                this.couleurActuelle =Color.pink;
                break;
            case"Magenta":
                zoneDessin.setCouleur(Color.magenta);
                this.couleurActuelle =Color.magenta;
                break;
            case"Orange":
                zoneDessin.setCouleur(Color.orange);
                this.couleurActuelle =Color.orange;
                break;
            case"Ellipse":
                zoneDessin.setFigureSelectionne(new Ellipse());
                typeOutil = TypeOutil.FIGURE;
                break;
            case"Cercle":
                zoneDessin.setFigureSelectionne(new Cercle());
                typeOutil = TypeOutil.FIGURE;
                break;
            case"Carre":
                zoneDessin.setFigureSelectionne(new Carre());
                typeOutil = TypeOutil.FIGURE;
                break;
            case"Rectangle":
                zoneDessin.setFigureSelectionne(new Rectangle());
                typeOutil = TypeOutil.FIGURE;
                break;
            case"Pinceau":
                typeOutil = TypeOutil.PINCEAU;
                break;
            case"Effacer":
                zoneDessin.effacer();
                break;
            case"Quitter":
                System.exit(0);
                break;
            default:
                System.err.println(cmd);
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        ZoneDessin zoneDessin;
        zoneDessin = (ZoneDessin) this.listeZoneDessin.get(this.mesOnglets.getSelectedIndex());
       if(typeOutil == TypeOutil.FIGURE) {
           Point origine = new Point(e.getX(), e.getY());
           zoneDessin.setOrigineFigure(origine);
       }
        if(typeOutil == TypeOutil.PINCEAU) {
            pinceau(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        ZoneDessin zoneDessin;
        zoneDessin = (ZoneDessin) this.listeZoneDessin.get(this.mesOnglets.getSelectedIndex());
        if(typeOutil == TypeOutil.FIGURE) {
            if( zoneDessin.getDepartDessin() != null) {
                zoneDessin.addListeFigure(zoneDessin.getFigureSelectionne());
                String nomFigure = zoneDessin.getFigureSelectionne().getClass().getName();
                switch (nomFigure) {
                    case "Figure.Carre":
                        zoneDessin.setFigureSelectionne(new Carre());
                        break;
                    case "Figure.Cercle":
                        zoneDessin.setFigureSelectionne(new Cercle());
                        break;
                    case "Figure.Rectangle":
                        zoneDessin.setFigureSelectionne(new Rectangle());
                        break;
                    case "Figure.Ellipse":
                        zoneDessin.setFigureSelectionne(new Ellipse());
                        break;

                }
            }
        }
        if(typeOutil == TypeOutil.PINCEAU) {
            pinceau(e);
        }
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {


    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        ZoneDessin zoneDessin;
        zoneDessin = (ZoneDessin) this.listeZoneDessin.get(this.mesOnglets.getSelectedIndex());
        if(typeOutil == TypeOutil.FIGURE) {
            Point origine = zoneDessin.getOrigineFigure();
            Point depart = new Point(),arrive = new Point();
            if(origine.getX()> e.getX()){
                depart.setX(e.getX());
                arrive.setX(origine.getX());
            }else{
                depart.setX(origine.getX());
                arrive.setX(e.getX());
            }
            if(origine.getY()> e.getY()){
                depart.setY(e.getY());
                arrive.setY(origine.getY());
            }else{
                depart.setY(origine.getY());
                arrive.setY(e.getY());
            }
            int largeur = arrive.getX() - depart.getX();
            int hauteur = arrive.getY() - depart.getY();
            int longueurMax = Math.max(hauteur,largeur);
            String nomFigure = zoneDessin.getFigureSelectionne().getClass().getName();
            if(nomFigure == "Figure.Carre" || nomFigure == "Figure.Cercle"){
                if(origine.getX()> e.getX()) {
                    if (largeur < longueurMax) {
                        depart.setX(depart.getX() - (longueurMax - largeur));
                    }
                }
                if(origine.getY()> e.getY()) {
                    if (hauteur < longueurMax) {
                        depart.setY(depart.getY() - (longueurMax - hauteur));
                    }
                }
            }
            zoneDessin.setOrigineDessinFigure(depart);
            zoneDessin.setDimensionFigure(largeur, hauteur);

        }
        if(typeOutil == TypeOutil.PINCEAU) {
         pinceau(e);
        }
        zoneDessin.repaint();


    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    private void pinceau(MouseEvent  e){
        ZoneDessin zoneDessin;
        zoneDessin = (ZoneDessin) this.listeZoneDessin.get(this.mesOnglets.getSelectedIndex());
        zoneDessin.setFigureSelectionne(new Cercle());
        Point origine = new Point(e.getX(), e.getY());
        zoneDessin.setOrigineFigure(origine);
        zoneDessin.setOrigineDessinFigure(origine);
        zoneDessin.setDimensionFigure(8, 8);
        zoneDessin.addListeFigure(zoneDessin.getFigureSelectionne());
        zoneDessin.setFigureSelectionne(new Cercle());
    }
    private JPanel panelCouleur(){
        JPanel panneauCouleur = new JPanel();
        panneauCouleur.setLayout((new GridLayout(2,4) ));
        Bouton bNoir = new Bouton("Noir",Color.black, this);
        panneauCouleur.add(bNoir);
        Bouton bRouge = new Bouton("Rouge",Color.red,this);
        panneauCouleur.add(bRouge);
        Bouton bVert = new Bouton("Vert",Color.green,this);
        panneauCouleur.add(bVert);
        Bouton bBleu = new Bouton("Bleu",Color.blue,this);
        panneauCouleur.add(bBleu);
        Bouton bJaune = new Bouton("Jaune",Color.yellow,this);
        panneauCouleur.add(bJaune);
        Bouton bRose = new Bouton("Rose",Color.pink,this);
        panneauCouleur.add(bRose);
        Bouton bMagenta = new Bouton("Magenta",Color.MAGENTA, this);
        panneauCouleur.add(bMagenta);
        Bouton bOrange = new Bouton("Orange",Color.ORANGE, this);
        panneauCouleur.add(bOrange);
        return (panneauCouleur);
    }

    private JPanel panelFigure(){
        JPanel panneauFigure= new JPanel();
        panneauFigure.setLayout(new GridLayout(2,2));
        Bouton bEllipse = new Bouton("Ellipse",Color.white,this);
        panneauFigure.add(bEllipse);
        Bouton bCercle = new Bouton("Cercle",Color.white,this);
        panneauFigure.add(bCercle);
        Bouton bCarre = new Bouton("Carre",Color.white,this);
        panneauFigure.add(bCarre);
        Bouton bRectangle = new Bouton("Rectangle",Color.white,this);
        panneauFigure.add(bRectangle);
        return (panneauFigure);
    }
    private JPanel panelOutil(){
        JPanel panneauOutil= new JPanel();
        panneauOutil.setLayout(new GridLayout(2,1));

        Bouton pinceau = new Bouton("Pinceau",Color.white,this);
        panneauOutil.add(pinceau);
        Bouton gomme = new Bouton("Gomme",Color.white,this);
        panneauOutil.add(gomme);
        return (panneauOutil);
    }

    private JMenuBar monMenu(){
        JMenuBar menuBar = new JMenuBar();
        JMenu   fichier = new JMenu("Fichier"),
                edition = new JMenu("Edition"),
                apropos = new JMenu("A propos");

        JMenuItem   effacer = new JMenuItem("Effacer"),
                quitter = new JMenuItem("Quitter"),
                sauvegarder = new JMenuItem("Sauvegarder"),
                auteur = new JMenuItem("Auteur");

        sauvegarder.setAccelerator(KeyStroke.getKeyStroke('S',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),
                false));
        quitter.setAccelerator(KeyStroke.getKeyStroke('Q',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),
                false));
        effacer.setAccelerator(KeyStroke.getKeyStroke('E',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),
                false));
        fichier.add(effacer);
        fichier.add(sauvegarder);
        fichier.addSeparator();
        fichier.add(quitter);
        //fichier.setMnemonic('F');
        apropos.add(auteur);
        quitter.addActionListener(this);
        effacer.addActionListener(this);

        menuBar.add(fichier);
        menuBar.add(edition);
        menuBar.add(apropos);

        this.setJMenuBar(menuBar);
        return (menuBar);
    }
}