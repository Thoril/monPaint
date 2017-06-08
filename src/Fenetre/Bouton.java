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

    public Bouton(String name, Color color, ActionListener ActList){
        super(name);
        this.setBackground(color);
        this.addActionListener(ActList);
    }
    public Bouton( String name, Color color, ActionListener ActList, Icon icon ){
        super(icon);
        this.setBackground(color);
        this.addActionListener(ActList);
        this.setActionCommand("name");
    }
    public Bouton(Color color, ActionListener ActList,String actionCommand){
        super();
        this.setBackground(color);
        this.addActionListener(ActList);
        this.setActionCommand(actionCommand);
        Dimension d = new Dimension(25,25);
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

