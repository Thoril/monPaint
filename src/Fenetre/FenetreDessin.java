package Fenetre;

import Figure.*;
import Figure.Point;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Figure.Rectangle;

/**
 * Classe qui instinci une fenetre type paint
 */
public class FenetreDessin extends JFrame implements ActionListener, MouseMotionListener, MouseListener, ItemListener, ChangeListener {
    private ArrayList listeZoneDessin = new ArrayList();
    private int indiceOnglet = 0;
    private JTabbedPane mesOnglets = new JTabbedPane();
    private enum TypeOutil {FIGURE, PINCEAU, GOMME}
    private TypeOutil typeOutil;
    private int taillePinceau = 5;
    private Color couleurActuelle;
    private String figureActuelle = "";
    private boolean remplissage;

    /**
     * Constructeur avec en parametre le titre de la fenetre
     * @param titre
     */
    public FenetreDessin(String titre) {
        super(titre);
        GraphicsEnvironment.getLocalGraphicsEnvironment();
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        Container contentPane = this.getContentPane();
        remplissage = false;

        contentPane.add((panelOutil()),BorderLayout.NORTH);
        contentPane.add(panelFigure(),BorderLayout.WEST);
        contentPane.add(panelCouleur(), BorderLayout.SOUTH);
        ZoneDessin zoneDessin = new ZoneDessin();
        this.listeZoneDessin.add(zoneDessin);
        mesOnglets.add(zoneDessin, "zone n°" + ++indiceOnglet);
        zoneDessin.addMouseListener(this);
        zoneDessin.addMouseMotionListener(this);
        mesOnglets.addChangeListener(this);
        contentPane.add(mesOnglets, BorderLayout.CENTER);
        typeOutil = TypeOutil.PINCEAU;
        this.couleurActuelle = Color.black;
        this.setJMenuBar(monMenu());
        this.setVisible(true);
    }

    /**
     * methode actionPerfomed permet de réaliser des actions lors d'évenement
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        ZoneDessin zoneDessin;
        //on selectionne la zone de l'onglet actif
        if (this.mesOnglets.getSelectedIndex() != -1) {
            zoneDessin = (ZoneDessin) this.listeZoneDessin.get(this.mesOnglets.getSelectedIndex());
            System.out.println("Onglet:"+this.mesOnglets.getSelectedIndex());
        } else {
            zoneDessin = new ZoneDessin();
        }
        String cmd = e.getActionCommand();
        //switch en fonction du bouton / element activé
        switch (cmd) {
            case "Noir":
                zoneDessin.setCouleur(Color.black);
                this.couleurActuelle = Color.black;
                break;
            case "Rouge":
                zoneDessin.setCouleur(Color.RED);
                this.couleurActuelle = Color.red;
                break;
            case "Vert":
                zoneDessin.setCouleur(Color.green);
                this.couleurActuelle = Color.green;
                break;
            case "Bleu":
                zoneDessin.setCouleur(Color.blue);
                this.couleurActuelle = Color.blue;
                break;
            case "Blanc":
                zoneDessin.setCouleur(Color.WHITE);
                this.couleurActuelle = Color.WHITE;
                break;
            case "Plus...":
                MonJColorChooser tcc = new MonJColorChooser();
                this.couleurActuelle = tcc.showDialog(tcc, "Selectionner une Couleur", Color.WHITE);

                zoneDessin.setCouleur(this.couleurActuelle);
                break;
            case "Jaune":
                zoneDessin.setCouleur(Color.YELLOW);
                this.couleurActuelle = Color.yellow;
                break;
            case "Rose":
                zoneDessin.setCouleur(Color.PINK);
                this.couleurActuelle = Color.pink;
                break;
            case "Magenta":
                zoneDessin.setCouleur(Color.magenta);
                this.couleurActuelle = Color.magenta;
                break;
            case "Orange":
                zoneDessin.setCouleur(Color.orange);
                this.couleurActuelle = Color.orange;
                break;
            case "Ellipse":
                zoneDessin.setFigureSelectionne(new Ellipse());
                typeOutil = TypeOutil.FIGURE;
                this.figureActuelle = "Ellipse";
                break;
            case "Coeur":
                zoneDessin.setFigureSelectionne(new Coeur());
                typeOutil = TypeOutil.FIGURE;
                this.figureActuelle = "Coeur";
                break;
            case "Cercle":
                zoneDessin.setFigureSelectionne(new Cercle());
                typeOutil = TypeOutil.FIGURE;
                this.figureActuelle = "Cercle";
                break;
            case "Carre":
                zoneDessin.setFigureSelectionne(new Carre());
                typeOutil = TypeOutil.FIGURE;
                this.figureActuelle = "Carre";
                break;
            case "Rectangle":
                zoneDessin.setFigureSelectionne(new Rectangle());
                typeOutil = TypeOutil.FIGURE;
                this.figureActuelle = "Rectangle";
                break;
            case "Segment":
                zoneDessin.setFigureSelectionne(new Segment());
                typeOutil = TypeOutil.FIGURE;
                this.figureActuelle = "Segment";
                break;
            case "Pinceau":
                typeOutil = TypeOutil.PINCEAU;
                break;
            case "Effacer":
                zoneDessin.effacer();
                break;
            case "Quitter":
                System.exit(0);
                break;
            case "Nouvel Onglet":
                ZoneDessin z = new ZoneDessin();
                mesOnglets.add(z, "zone n°" + ++indiceOnglet);
                z.addMouseListener(this);
                z.addMouseMotionListener(this);
                z.setCouleur(couleurActuelle);
                switch (figureActuelle) {
                    case "Carre":
                        z.setFigureSelectionne(new Carre());
                        break;
                    case "Coeur":
                        z.setFigureSelectionne(new Coeur());
                        break;
                    case "Rectangle":
                        z.setFigureSelectionne(new Rectangle());
                        break;
                    case "Ellipse":
                        z.setFigureSelectionne(new Ellipse());
                        break;
                    case "Cercle":
                        z.setFigureSelectionne(new Cercle());
                        break;
                    case "Segment":
                        z.setFigureSelectionne(new Segment());
                        break;
                    default:

                        break;
                }
                this.listeZoneDessin.add(z);
                break;
            case "Supprimer Onglet":
                int indiceOngletActif = this.mesOnglets.getSelectedIndex();
                System.out.println("indice:" + indiceOngletActif);
                mesOnglets.removeTabAt(indiceOngletActif);
                this.listeZoneDessin.remove(indiceOngletActif);
                System.out.println("Suppresion d'un Onglet");
                break;
            case "Sauvegarder":
                JFileChooser save = new JFileChooser();
                int r=save.showSaveDialog(this);
                if(r==JFileChooser.APPROVE_OPTION){
                    zoneDessin.save(save.getSelectedFile().getAbsolutePath());
                }
                break;
            case "Gomme":
                typeOutil = TypeOutil.GOMME;
                break;
            case "Remplissage":
                remplissage = ((JCheckBox)e.getSource()).isSelected();
                break;
            case "Précédent":
                zoneDessin.precedent();
                zoneDessin.repaint();
                break;
            case "Suivant":
                zoneDessin.suivant();
                zoneDessin.repaint();
                break;
            case "Ouvrir":
                JFileChooser choix = new JFileChooser();
                MonFiltre mfi = new MonFiltre( new String[]{"gif","jpeg","jpg", "png"},"Les fichiers image");
                choix.addChoosableFileFilter(mfi);
                int retour=choix.showOpenDialog(this);
                if(retour==JFileChooser.APPROVE_OPTION){
                    String chemin =choix.getSelectedFile().getAbsolutePath();
                    zoneDessin.load(chemin);
                }
                break;
            default:
                System.err.println(cmd);
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    /**
     * Quand on appuie sur la souris
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {
        ZoneDessin zoneDessin;
        //on recupere la zone de dessin active
        zoneDessin = (ZoneDessin) this.listeZoneDessin.get(this.mesOnglets.getSelectedIndex());

        if (typeOutil == TypeOutil.FIGURE) {
            //on definit l'origine de la figure
            Point origine = new Point(e.getX(), e.getY());
            zoneDessin.setOrigineFigure(origine);
            zoneDessin.setRemplissage(this.remplissage);
            zoneDessin.setArriveSegment(origine);
        }
        if (typeOutil == TypeOutil.PINCEAU) {
            pinceau(e);
        }
    }

    /**
     * quand la souris est relaché
     * @param e
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        ZoneDessin zoneDessin;
        zoneDessin = (ZoneDessin) this.listeZoneDessin.get(this.mesOnglets.getSelectedIndex());
        if (typeOutil == TypeOutil.FIGURE) {
            if (zoneDessin.getDepartDessin() != null) {
                //on ajoute lma figure courante a la liste de figure
                zoneDessin.addListeFigure(zoneDessin.getFigureSelectionne());
                //on reset la figure courante
                String nomFigure = zoneDessin.getFigureSelectionne().getClass().getName();
                switch (nomFigure) {
                    case "Figure.Carre":
                        zoneDessin.setFigureSelectionne(new Carre());
                        break;
                    case "Figure.Coeur":
                        zoneDessin.setFigureSelectionne(new Coeur());
                        break;
                    case "Figure.Rectangle":
                        zoneDessin.setFigureSelectionne(new Rectangle());
                        break;
                    case "Figure.Ellipse":
                        zoneDessin.setFigureSelectionne(new Ellipse());
                        break;
                    case "Figure.Cercle":
                        zoneDessin.setFigureSelectionne(new Cercle());
                        break;
                    case "Figure.Segment":
                        zoneDessin.setFigureSelectionne(new Segment());
                        break;
                }
            }
        }
        if (typeOutil == TypeOutil.PINCEAU) {
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
    //quand on dépalce la souris en gardant le clique appuyé
    public void mouseDragged(MouseEvent e) {

        ZoneDessin zoneDessin;
        zoneDessin = (ZoneDessin) this.listeZoneDessin.get(this.mesOnglets.getSelectedIndex());
        if (typeOutil == TypeOutil.FIGURE) {
            //on définit le point de départ et le point d'arrivé du dessin en fonction du positionement
            Point origine = zoneDessin.getOrigineFigure();
            Point depart = new Point(), arrive = new Point();
            if (origine.getX() > e.getX()) {
                depart.setX(e.getX());
                arrive.setX(origine.getX());
            } else {
                depart.setX(origine.getX());
                arrive.setX(e.getX());
            }
            if (origine.getY() > e.getY()) {
                depart.setY(e.getY());
                arrive.setY(origine.getY());
            } else {
                depart.setY(origine.getY());
                arrive.setY(e.getY());
            }
            int largeur = arrive.getX() - depart.getX();
            int hauteur = arrive.getY() - depart.getY();
            int longueurMax = Math.max(hauteur, largeur);
            String nomFigure = zoneDessin.getFigureSelectionne().getClass().getName();
            if (nomFigure.equals("Figure.Carre") || nomFigure.equals("Figure.Cercle") || nomFigure.equals("Figure.Coeur")) {
                if (origine.getX() > e.getX()) {
                    if (largeur < longueurMax) {
                        depart.setX(depart.getX() - (longueurMax - largeur));
                    }
                }
                if (origine.getY() > e.getY()) {
                    if (hauteur < longueurMax) {
                        depart.setY(depart.getY() - (longueurMax - hauteur));
                    }
                }
            }else if(nomFigure.equals("Figure.Segment")){
                arrive.setX(e.getX());
                arrive.setY(e.getY());
                zoneDessin.setArriveSegment(arrive);
            }
            zoneDessin.setOrigineDessinFigure(depart);
            zoneDessin.setDimensionFigure(largeur, hauteur);

        }
        if (typeOutil == TypeOutil.PINCEAU) {
            pinceau(e);

        }
        if (typeOutil == TypeOutil.GOMME) {
            gomme(e);
        }
        zoneDessin.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }

    /**
     * Methode pinceau permet de dessiné des cercles de la taillePinceau de la calsse et de la couleur courante de la classe
     * @param e
     */
    private void pinceau(MouseEvent e) {
        ZoneDessin zoneDessin;
        zoneDessin = (ZoneDessin) this.listeZoneDessin.get(this.mesOnglets.getSelectedIndex());
        zoneDessin.setFigureSelectionne(new Cercle());
        Point origine = new Point(e.getX(), e.getY());
        zoneDessin.setOrigineFigure(origine);
        zoneDessin.setRemplissage(true);
        zoneDessin.setOrigineDessinFigure(origine);
        zoneDessin.setDimensionFigure(taillePinceau, taillePinceau);
        zoneDessin.addListeFigure(zoneDessin.getFigureSelectionne());
        zoneDessin.setFigureSelectionne(new Cercle());
    }

    /**
     * Methode gomme permet de déssiné des carrés blanc de la taillePinceau de la classe
     * @param e
     */
    private void gomme(MouseEvent e) {
        ZoneDessin zoneDessin;
        zoneDessin = (ZoneDessin) this.listeZoneDessin.get(this.mesOnglets.getSelectedIndex());
        zoneDessin.setFigureSelectionne(new Carre());
        Point origine = new Point(e.getX(), e.getY());
        zoneDessin.setOrigineFigure(origine);
        zoneDessin.setRemplissage(true);
        zoneDessin.setCouleur(Color.WHITE);
        zoneDessin.setOrigineDessinFigure(origine);
        zoneDessin.setDimensionFigure(taillePinceau, taillePinceau);
        zoneDessin.addListeFigure(zoneDessin.getFigureSelectionne());
        zoneDessin.setFigureSelectionne(new Carre());
    }

    /**
     * Toolbar des couleurs
     * @return la toolbar des couleurs
     */
    private JToolBar panelCouleur() {
        JToolBar panneauCouleur = new JToolBar("Couleur"    );
        panneauCouleur.setLayout((new FlowLayout(FlowLayout.LEFT)));
        Bouton bNoir = new Bouton(Color.black, this,"Noir" );
        panneauCouleur.add(bNoir);
        Bouton bRouge = new Bouton( Color.red, this,"Rouge");
        panneauCouleur.add(bRouge);
        Bouton bVert = new Bouton( Color.green, this,"Vert");
        panneauCouleur.add(bVert);
        Bouton bBleu = new Bouton( Color.blue, this,"Bleu");
        panneauCouleur.add(bBleu);
        Bouton bJaune = new Bouton( Color.yellow, this,"Jaune");
        panneauCouleur.add(bJaune);
        Bouton bRose = new Bouton( Color.pink, this,"Rose");
        panneauCouleur.add(bRose);
        Bouton bMagenta = new Bouton( Color.MAGENTA, this,"Magenta");
        panneauCouleur.add(bMagenta);
        Bouton bOrange = new Bouton( Color.ORANGE, this,"Orange");
        panneauCouleur.add(bOrange);
        Bouton bBlanc = new Bouton( Color.WHITE, this,"Blanc");
        panneauCouleur.add(bBlanc);
        Bouton bSelectColor = new Bouton("Plus...", this,new ImageIcon("./Ressources/palette.png"));
        panneauCouleur.add(bSelectColor);
        return (panneauCouleur);
    }

    /**
     * Methode pour creer la toolbar des figures
     * @return toolbar des figures
     */
    private JToolBar panelFigure() {
        JToolBar panneauFigure = new JToolBar("Figures",1);
        panneauFigure.setLayout(new GridLayout(14,2));
        Bouton bEllipse = new Bouton("Ellipse", this, new ImageIcon("./Ressources/ellipse.png"));
        panneauFigure.add(bEllipse);
        Bouton bCercle = new Bouton("Cercle", this, new ImageIcon("./Ressources/cercle.png"));
        panneauFigure.add(bCercle);
        Bouton bCarre = new Bouton("Carre", this, new ImageIcon("./Ressources/carre.png"));
        panneauFigure.add(bCarre);
        Bouton bRectangle = new Bouton("Rectangle",  this, new ImageIcon("./Ressources/Rectangle.png"));
        panneauFigure.add(bRectangle);
        Bouton bCoeur = new Bouton("Coeur",  this, new ImageIcon("./Ressources/coeur.png"));
        panneauFigure.add(bCoeur);
        Bouton bSegment = new Bouton("Segment",  this, new ImageIcon("./Ressources/segment.png"));
        panneauFigure.add(bSegment);
        return (panneauFigure);
    }

    /**
     * Permet de creer la toobar des outils
     * @return toolbar des outils
     */
    private JToolBar panelOutil() {
        JToolBar panneauOutil = new JToolBar("Outils");
        panneauOutil.setLayout(new FlowLayout(FlowLayout.LEFT));

        Bouton pinceau = new Bouton("Pinceau", this, new ImageIcon("./Ressources/pinceau.png"));
        panneauOutil.add(pinceau);
        Bouton gomme = new Bouton("Gomme", this, new ImageIcon("./Ressources/gomme.png"));
        panneauOutil.add(gomme);
        JComboBox taillePinceau = new JComboBox();
        taillePinceau.add(new Label("Epaisseur"));
        taillePinceau.addItem("5px");
        taillePinceau.addItem("10px");
        taillePinceau.addItem("15px");
        taillePinceau.addItem("20px");
        taillePinceau.addItemListener(this);
        panneauOutil.add(taillePinceau);
        JCheckBox remplissage = new JCheckBox("Remplissage");
        remplissage.addActionListener(this);
        panneauOutil.add(remplissage);
        Bouton precedent = new Bouton("Précédent",  this, new ImageIcon("./Ressources/precedent.png"));
        panneauOutil.add(precedent);
        Bouton suivant = new Bouton("Suivant",  this, new ImageIcon("./Ressources/suivant.png"));
        panneauOutil.add(suivant);

        return (panneauOutil);
    }

    /**
     * Permet de creer le Menu
     * @return le Menu
     */
    private JMenuBar monMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fichier = new JMenu("Fichier"),
                edition = new JMenu("Edition"),
                apropos = new JMenu("A propos");

        JMenuItem effacer = new JMenuItem("Effacer"),
                quitter = new JMenuItem("Quitter"),
                sauvegarder = new JMenuItem("Sauvegarder"),
                auteur = new JMenuItem("Auteur"),
                nouvelOnglet = new JMenuItem("Nouvel Onglet"),
                supprimerOnglet = new JMenuItem("Supprimer Onglet"),
                ouvrir = new JMenuItem("Ouvrir"),
                precedent = new JMenuItem("Précédent"),
                suivant = new JMenuItem("Suivant");

        sauvegarder.setAccelerator(KeyStroke.getKeyStroke('S',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),
                false));
        quitter.setAccelerator(KeyStroke.getKeyStroke('Q',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),
                false));
        effacer.setAccelerator(KeyStroke.getKeyStroke('E',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),
                false));
        nouvelOnglet.setAccelerator(KeyStroke.getKeyStroke('N',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),
                false));
        supprimerOnglet.setAccelerator(KeyStroke.getKeyStroke('W',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),
                false));
        ouvrir.setAccelerator(KeyStroke.getKeyStroke('O',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),
                false));
        ouvrir.setAccelerator(KeyStroke.getKeyStroke('O',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),
                false));
        ouvrir.setAccelerator(KeyStroke.getKeyStroke('O',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),
                false));
        suivant.setAccelerator(KeyStroke.getKeyStroke('Y',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),
                false));
        precedent.setAccelerator(KeyStroke.getKeyStroke('Z',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),
                false));


        fichier.add(sauvegarder);
        fichier.add(ouvrir);
        fichier.addSeparator();
        fichier.add(quitter);
        fichier.setMnemonic('F');

        apropos.add(auteur);

        edition.add(suivant);
        edition.add(precedent);
        edition.add(effacer);
        edition.addSeparator();
        edition.add(nouvelOnglet);
        edition.add(supprimerOnglet);

        quitter.addActionListener(this);
        effacer.addActionListener(this);
        nouvelOnglet.addActionListener(this);
        supprimerOnglet.addActionListener(this);
        sauvegarder.addActionListener(this);
        ouvrir.addActionListener(this);
        precedent.addActionListener(this);
        suivant.addActionListener(this);
        auteur.addActionListener(this);

        menuBar.add(fichier);
        menuBar.add(edition);
        menuBar.add(apropos);

        return (menuBar);
    }

    /**
     * Methode qui gerer les évenements lors du chanegment d'etat de certain élément
     * @param e
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        String str = (String) e.getItem();
        switch (str) {
            case "5px":
                this.taillePinceau = 5;
                break;
            case "10px":
                this.taillePinceau = 10;
                break;
            case "15px":
                this.taillePinceau = 15;
                break;
            case "20px":
                this.taillePinceau = 20;
                break;
            default:
                System.out.println("événement déclenché sur : " + e.getItem());
                break;

        }
    }


}