/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author oguz_
 */
public interface MapInterface {
    // Creates / Allocates a map of given size.

    void SetSize(Dimension dim);
// Get dimensions of given map.

    void GetSize(Dimension dim);
// Sets border at given point.

    void SetBorder(int x, int y) throws Exception;
// Clears border at given point.

    void ClearBorder(int x, int y) throws Exception;
// Checks if given point is border.

    boolean IsBorder(int x, int y) throws Exception;
// Show map contents.

    void Show();

}
