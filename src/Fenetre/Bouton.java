package Fenetre;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by thomas on 09/05/17.
 */

public class Bouton extends JButton implements MouseMotionListener,MouseListener {

    /**
     * Bouton classique avec non et couleur
     * @param name nom du bouton
     * @param color couleur du bouton
     * @param ActList action listener
     */
    public Bouton(String name, Color color, ActionListener ActList){
        super(name);
        this.setBackground(color);
        this.addActionListener(ActList);
    }

    /**
     * Bouton avec icone
     * @param name nom du bouton
     * @param ActList action listener
     * @param icon icon du bouton
     */
    public Bouton( String name, ActionListener ActList, Icon icon ){
        super(icon);
        this.addActionListener(ActList);
        this.setActionCommand(name);

    }

    /**
     * Bouton couleur
     * @param color couleur du bouton
     * @param ActList action listener
     * @param actionCommand nom de l'action command
     */
    public Bouton(Color color, ActionListener ActList,String actionCommand){
        super();
        this.setBackground(color);
        this.addActionListener(ActList);
        this.setActionCommand(actionCommand);
        Dimension d = new Dimension(30,30);
        this.setPreferredSize(d);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}

