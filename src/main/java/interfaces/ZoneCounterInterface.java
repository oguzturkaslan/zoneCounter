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
public interface ZoneCounterInterface {
    // Feeds map data into solution class, then get ready for Solve() method.

    void Init(MapInterface map) throws Exception;
// Counts zones in map provided with Init() method, then return the result.

    int Solve() throws Exception;
}
