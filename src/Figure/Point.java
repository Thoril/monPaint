package Figure;

/**
 * Created by thomas on 02/05/17.
 */
public class Point {
    private int x;
    private int y;

    /**
     * Constructeur du point sans parametre par default (0,0)
     */
    public Point(){
        this.x=0;
        this.y=0;
    }

    /**
     * Constructeur d'un point
     * @param x coordonnée x du point
     * @param y coordonnée y du point
     */
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }

    /**
     * @return la positione en x
     */
    public int getX() {
        return x;
    }

    /**
     * @return la position en y
     */
    public int getY() {
        return y;
    }

    /**
     *  le x du point prend la valeur du param
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * le y du point prend la valeur du param
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }
}

