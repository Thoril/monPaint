package Figure;
import java.awt.*;

/**
 * Created by artru on 06/06/2017.
 */

public class Segment  extends Figure{

    /**
     * Constructeur par default sans parametre
     */
    public Segment(){
        super();
    }

    /**
     * Methode pour dessiner le point
     * @param g
     */
    @Override
    public void dessine(Graphics g) {
         g.setColor(this.couleur);
         g.drawLine(origine.getX(),origine.getY(),arriveDessin.getX(),arriveDessin.getY());
    }

    /**
     * Methode non utilisé par le Segment
     * @param hauteurBB
     * @param largeurBB
     */
    @Override
    public void setBoundingBox(int hauteurBB, int largeurBB) {

    }
}
