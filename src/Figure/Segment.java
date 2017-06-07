package Figure;
import java.awt.*;

/**
 * Created by artru on 06/06/2017.
 */

public class Segment  extends Figure{
    private Point arrive =  new Point();

    public Segment(Point origine, Color couleur, Point arrive) {
        super(origine, couleur);
        this.arrive = arrive;
    }

    public Segment(Point origine,Point arrive) {
        super(origine);
        this.arrive = arrive;
    }

    public Segment(){
        super();
    }

    @Override
    public double getPerimetre() {
        return 0;
    }

    @Override
    public double getSurface() {
        return 0;
    }

    @Override
    public void dessine(Graphics g) {
        g.drawLine(origine.getX(),origine.getY(),arrive.getX(),arrive.getY());
    }

    @Override
    public void setBoundingBox(int hauteurBB, int largeurBB) {

    }
}
