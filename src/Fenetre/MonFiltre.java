package Fenetre;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by artru on 08/06/2017.
 */
public class MonFiltre extends FileFilter {
    String [] listeExtension;
    String  description;

    public MonFiltre(String [] listeExtension, String description){
        this.listeExtension = listeExtension;
        this.description = description;
    }
    boolean appartient( String extension ){
        for( int i = 0; i< listeExtension.length; ++i) {
            if (extension.equals(listeExtension[i])) {
                return true;
            }
        }
        return false;
    }
    public boolean accept(File f) {
        if (f.isDirectory())  return true;
        String extension = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');
        if(i > 0 && i < s.length() - 1) {
            extension = s.substring(i + 1).toLowerCase();
        }
        if(extension!= null && appartient((extension))){
            return true;
        }
        return false;

    }
    // la description du filtre
    public String getDescription() {
        return description;
    }
}
