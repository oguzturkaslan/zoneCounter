package com.mycompany.oguz_turkaslan;

import interfaces.Dimension;
import interfaces.MapInterface;

/**
 *
 * @author oguz_
 */
public class Map implements MapInterface {

    private boolean[][] map = null;
    private int rows = 0;
    private int columns = 0;

    @Override
    public void SetSize(Dimension dim) {
        rows = dim.width;
        columns = dim.height;
        map = new boolean[rows][columns];
    }

    @Override
    public void GetSize(Dimension dim) {
        dim.width = rows;
        dim.height = columns;
    }

    @Override
    public void SetBorder(int x, int y) throws Exception {
        map[x][y] = true;
    }

    @Override
    public void ClearBorder(int x, int y) throws Exception {
        map[x][y] = false;
    }

    @Override
    public boolean IsBorder(int x, int y) throws Exception {
        return isBorderInMap(x, y);
    }

    @Override
    public void Show() {
        for (int j = 0; j < columns + 2; ++j) {
            System.out.print("X ");
        }
        System.out.println("");
        for (int i = 0; i < rows; i++) {
            System.out.print("X ");
            for (int j = 0; j < columns; j++) {
                System.out.print(isBorderInMap(i, j) ? "X " : "* ");
            }
            System.out.print("X ");
            System.out.println("");
        }

        for (int j = 0; j < columns + 2; ++j) {
            System.out.print("X ");
        }
    }

    public boolean isBorderInMap(int x, int y) {
        return map[x][y];
    }

}
