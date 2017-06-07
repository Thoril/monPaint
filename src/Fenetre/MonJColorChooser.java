package Fenetre;

import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import java.awt.*;

/**
 * Created by tartru on 07/06/2017.
 */
public class MonJColorChooser extends JColorChooser {
    public MonJColorChooser() {
        super();
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
