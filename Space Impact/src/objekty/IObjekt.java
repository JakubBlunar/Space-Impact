/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objekty;

import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * @author Jakub
 */
public interface IObjekt {
    void hybSa();
    Image dajObrazok();
    int dajX();
    int dajY();
    boolean jeViditelny();
    Rectangle dajObdlznik();
    void nastavViditelnost(boolean paViditelnost);
    int dajPocetZivotov();
    void znizZivoty(); 
}
