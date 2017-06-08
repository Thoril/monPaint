package Fenetre;

import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import java.awt.*;

/**
 * Created by tartru on 07/06/2017.
 */
public class MonJColorChooser extends JColorChooser {
    /**
     * Constructeur d'un JcolorChooser en ne gardant que la selection de la palette de couleur
     */
    public MonJColorChooser() {
        super();
        //On recupere le nom des éléments et on supprime ceux qui ne nous interessent pas
        AbstractColorChooserPanel[] oldPanels = this.getChooserPanels();
        for (AbstractColorChooserPanel p : oldPanels) {
            switch (p.getDisplayName()) {
                case "HSV":
                case "HSL":
                case "CMYK":
                case "TSV":
                case "TSL":
                case "RVB":
                    this.removeChooserPanel(p);
                    //System.out.println("Element Supprimé "+p.getDisplayName());
                    break;
                default:
                    //System.out.println("Element Conservé "+p.getDisplayName());
                    break;
            }
        }

    }

}
