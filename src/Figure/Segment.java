package Figure;
import java.awt.*;

/**
 * Created by artru on 06/06/2017.
 */

public class Segment  extends Figure{


    public Segment(){
        super();
    }

    @Override
    public void dessine(Graphics g) {
         g.setColor(this.couleur);
         g.drawLine(origine.getX(),origine.getY(),arriveDessin.getX(),arriveDessin.getY());
    }
    @Override
    public void setBoundingBox(int hauteurBB, int largeurBB) {

    }
}
