package com.mycompany.oguz_turkaslan;

import interfaces.Dimension;
import interfaces.MapInterface;
import interfaces.ZoneCounterInterface;

/**
 *
 * @author oguz_
 */
public class ZoneCounter implements ZoneCounterInterface {

    boolean[][] points;
    Dimension dimension;// = new Dimension(0, 0);
    int count = 0;// Number of areas found

    public ZoneCounter(Dimension dimension) {
        this.dimension = dimension;
    }

    @Override
    public void Init(MapInterface map) throws Exception {
        map.GetSize(dimension);
        points = new boolean[dimension.width][dimension.height];
        for (int i = 0; i < dimension.width; i++) {
            for (int j = 0; j < dimension.height; j++) {
                points[i][j] = map.IsBorder(i, j);
            }
        }
    }

    @Override
    public int Solve() throws Exception {
        return numberOfZones(points);
    }

    public int numberOfZones(boolean[][] points) {
        int rows = points.length;
        int columns = points[0].length;
        for (int row = 0; row < rows; ++row) {
            for (int column = 0; column < columns; ++column) {
                if (!points[row][column]) {
                    if (search(points, row, column) > 1) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int search(boolean[][] points, int x, int y) {
        if (!dimension.CheckWithin(x, y) || (points[x][y])) {
            return 0;
        }

        points[x][y] = true; // visited 

        return 1
                + search(points, x - 1, y) // North
                + search(points, x + 1, y) // East
                + search(points, x, y - 1) // South
                + search(points, x, y + 1); // West

    }

}
