package Fenetre;

import Figure.*;
import Figure.Point;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Figure.Rectangle;
public class FenetreDessin extends JFrame implements ActionListener,MouseMotionListener,MouseListener {
    private Fenetre.zoneDessin zoneDessin;
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
        monPanel.setLayout(new GridLayout(1,3));
        monPanel.add( panelCouleur());
        monPanel.add(panelFigure());
        monPanel.add(panelOutil());
        contentPane.add(monPanel,BorderLayout.SOUTH);
        this.zoneDessin = new zoneDessin();
        contentPane.add(this.zoneDessin,BorderLayout.CENTER);
        zoneDessin.addMouseListener(this);
        zoneDessin.addMouseMotionListener(this);


        this.setJMenuBar(monMenu());

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch (cmd){
            case "Quit":
                System.exit(0);
                break;
            case"Noir":
                this.zoneDessin.setCouleur(Color.black);
                this.couleurActuelle =Color.black;
                break;
            case"Rouge":
                this.zoneDessin.setCouleur(Color.RED);
                this.couleurActuelle =Color.red;
                break;
            case"Vert":
                this.zoneDessin.setCouleur(Color.green);
                this.couleurActuelle =Color.green;
                break;
            case"Bleu":
                this.zoneDessin.setCouleur(Color.blue);
                this.couleurActuelle =Color.blue;
                break;
            case"Jaune":
                this.zoneDessin.setCouleur(Color.YELLOW);
                this.couleurActuelle =Color.yellow;
                break;
            case"Rose":
                this.zoneDessin.setCouleur(Color.PINK);
                this.couleurActuelle =Color.pink;
                break;
            case"Magenta":
                this.zoneDessin.setCouleur(Color.magenta);
                this.couleurActuelle =Color.magenta;
                break;
            case"Orange":
                this.zoneDessin.setCouleur(Color.orange);
                this.couleurActuelle =Color.orange;
                break;
            case"Ellipse":
                this.zoneDessin.setFigureSelectionne(new Ellipse());

                typeOutil = TypeOutil.FIGURE;
                break;
            case"Cercle":
                this.zoneDessin.setFigureSelectionne(new Cercle());
                typeOutil = TypeOutil.FIGURE;
                break;
            case"Carre":
                this.zoneDessin.setFigureSelectionne(new Carre());
                typeOutil = TypeOutil.FIGURE;
                break;
            case"Rectangle":
                this.zoneDessin.setFigureSelectionne(new Rectangle());
                typeOutil = TypeOutil.FIGURE;
                break;
            case"Pinceau":
                typeOutil = TypeOutil.PINCEAU;
                break;
            default:
                System.err.println(cmd);
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(typeOutil == TypeOutil.PINCEAU) {
            pinceau(e);
        }
        repaint();

    }

    @Override
    public void mousePressed(MouseEvent e) {
       if(typeOutil == TypeOutil.FIGURE) {
           Point origine = new Point(e.getX(), e.getY());
           this.zoneDessin.setOrigineFigure(origine);
       }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(typeOutil == TypeOutil.FIGURE) {
            this.zoneDessin.addListeFigure(this.zoneDessin.getFigureSelectionne());
            String nomFigure = this.zoneDessin.getFigureSelectionne().getClass().getName();
            switch (nomFigure) {
                case "Figure.Carre":
                    this.zoneDessin.setFigureSelectionne(new Carre());
                    break;
                case "Figure.Cercle":
                    this.zoneDessin.setFigureSelectionne(new Cercle());
                    break;
                case "Figure.Rectangle":
                    this.zoneDessin.setFigureSelectionne(new Rectangle());
                    break;
                case "Figure.Ellipse":
                    this.zoneDessin.setFigureSelectionne(new Ellipse());
                    break;

            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {


    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(typeOutil == TypeOutil.FIGURE) {
            Point origine = this.zoneDessin.getOrigineFigure();
            this.zoneDessin.setDimensionFigure(e.getX() - origine.getX(), e.getY() - origine.getY());
        }
        if(typeOutil == TypeOutil.PINCEAU) {
         pinceau(e);
        }
        this.zoneDessin.repaint();


    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    private void pinceau(MouseEvent  e){
        this.zoneDessin.setFigureSelectionne(new Cercle());
        Point origine = new Point(e.getX(), e.getY());
        this.zoneDessin.setOrigineFigure(origine);
        this.zoneDessin.setDimensionFigure(5, 5);
        this.zoneDessin.addListeFigure(this.zoneDessin.getFigureSelectionne());
        this.zoneDessin.setFigureSelectionne(new Cercle());
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
        JMenuBar monMenu= new JMenuBar();
        JMenu file=new JMenu("File");
        file.add(new JMenuItem("New"));
        file.add(new JMenuItem("Open"));

        JMenuItem fileSave = new JMenuItem("Save");
        fileSave.setAccelerator(KeyStroke.getKeyStroke('S',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),
                false));
        file.add(fileSave);
        file.addSeparator();
        file.add((new JMenuItem("Quit") ));
        monMenu.add(file);
        JMenu aPropos = new JMenu("A propos");
        aPropos.add(new JMenuItem("Auteurs"));
        monMenu.add(aPropos);
        return (monMenu);
    }
}