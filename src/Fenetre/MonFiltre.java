package Fenetre;


import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by artru on 08/06/2017.
 */

/**
 * Creation d'un File Filter
 */
public class MonFiltre extends FileFilter {
    String [] listeExtension;
    String  description;

    /**
     * Creation d'un filtre
     * @param listeExtension liste des extension autorise tableau de string
     * @param description description du filtre string
     */
    public MonFiltre(String [] listeExtension, String description){
        this.listeExtension = listeExtension;
        this.description = description;
    }

    /**
     * Methode qui verifie si une extension apprtient a la liste d'extension valide
     * @param extension extension dont on verifie la presence dans la liste
     * @return true si l'extension est dans la liste false sinon
     */
    boolean appartient( String extension ){
        for( int i = 0; i< listeExtension.length; ++i) {
            if (extension.equals(listeExtension[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Regarde si l'extension d'un fichier est valide
     * @param f fichier que l'on traite
     * @return true si le fichier estt ok false sinon
     */
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

    /**
     *
     * @return la description du fichier (string)
     */
    public String getDescription() {
        return description;
    }
}
