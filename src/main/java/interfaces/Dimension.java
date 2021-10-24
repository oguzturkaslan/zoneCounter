
package interfaces;

/**
 *
 * @author oguz_
 */
public class Dimension {

    public int width, height;

    public Dimension(int w, int h) {
        width = w;
        height = h;
    }

    /**
     * Checks the map location of the point
     *
     * @param x column
     * @param y row
     * @return
     */
    public boolean CheckWithin(int x, int y) {
        return (x >= 0 && x < width && y >= 0 && y < height);
    }

}
