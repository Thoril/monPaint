package Fenetre;

import Figure.*;
import Figure.Point;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Figure.Rectangle;
public class FenetreDessin extends JFrame implements ActionListener,MouseMotionListener,MouseListener {
    private Fenetre.zoneDessin zoneDessin;

    public FenetreDessin(String titre){
        super(titre);
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        Container contentPane = this.getContentPane() ;
        JPanel monPanel = new JPanel();
        monPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        monPanel.add( panelCouleur());
        monPanel.add(panelFigure());

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
                break;
            case"Rouge":
                this.zoneDessin.setCouleur(Color.RED);
                break;
            case"Vert":
                this.zoneDessin.setCouleur(Color.green);
                break;
            case"Bleu":
                this.zoneDessin.setCouleur(Color.blue);
                break;
            case"Jaune":
                this.zoneDessin.setCouleur(Color.YELLOW);
                break;
            case"Rose":
                this.zoneDessin.setCouleur(Color.PINK);
                break;
            case"Magenta":
                this.zoneDessin.setCouleur(Color.magenta);
                break;
            case"Orange":
                this.zoneDessin.setCouleur(Color.orange);
                break;
            case"Ellipse":
                this.zoneDessin.setFigureSelectionne(new Ellipse());
                break;
            case"Cercle":
                this.zoneDessin.setFigureSelectionne(new Cercle());
                break;
            case"Carre":
                this.zoneDessin.setFigureSelectionne(new Carre());
                break;
            case"Rectangle":
                this.zoneDessin.setFigureSelectionne(new Rectangle());
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
        Point origine = new Point(e.getX(), e.getY());
        this.zoneDessin.setOrigineFigure(origine);
        //System.out.println("moussePressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //System.out.println("mousseReleased");
        this.zoneDessin.addListeFigure(this.zoneDessin.getFigureSelectionne());
        String nomFigure =  this.zoneDessin.getFigureSelectionne().getClass().getName();
        //System.out.println(nomFigure);
        switch (nomFigure){
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

    @Override
    public void mouseEntered(MouseEvent e) {


    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //System.out.println("mousseDragged");
        Point origine = this.zoneDessin.getOrigineFigure();
        this.zoneDessin.setDimensionFigure(e.getX()-origine.getX(),e.getY()- origine.getY());
        this.zoneDessin.repaint();

    }

    @Override
    public void mouseMoved(MouseEvent e) {

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
        JPanel panneauOutil= new JPanel();
        panneauOutil.setLayout(new GridLayout(2,2));
        Bouton bEllipse = new Bouton("Ellipse",Color.white,this);
        panneauOutil.add(bEllipse);
        Bouton bCercle = new Bouton("Cercle",Color.white,this);
        panneauOutil.add(bCercle);
        Bouton bCarre = new Bouton("Carre",Color.white,this);
        panneauOutil.add(bCarre);
        Bouton bRectangle = new Bouton("Rectangle",Color.white,this);
        panneauOutil.add(bRectangle);
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