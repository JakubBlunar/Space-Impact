/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objekty;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Jakub
 */
public class CiernaDiera implements IObjekt {
    
    private boolean aViditelnost;
    private final int aSuradnicaY;
    private int aSuradnicaX;
    private final Image aObrazok;
    private final int aVelkostX;
    private final int aVelkostY;
    private final int aRychlost;
    
    public CiernaDiera(int paY){
       aRychlost = -5;
       aSuradnicaX = 850;
       aViditelnost = true;
       aObrazok = new ImageIcon(this.getClass().getResource("ciernaDiera.png")).getImage();
       aVelkostX = 85;
       aVelkostY = 85;
       aSuradnicaY = paY;
    } 
    
    @Override
    public void hybSa() {
        aSuradnicaX += aRychlost;
        if(aSuradnicaX< -100){
            aViditelnost = false;
        }
    }

    @Override
    public Image dajObrazok() {
         return aObrazok;
    }

    @Override
    public int dajX() {
       return aSuradnicaX;
    }

    @Override
    public int dajY() {
        return aSuradnicaY;
    }

    @Override
    public boolean jeViditelny() {
       return aViditelnost;
    }

    @Override
    public Rectangle dajObdlznik() {
       return new Rectangle(aSuradnicaX+6,aSuradnicaY+6,aVelkostX,aVelkostY);
    }

    @Override
    public void nastavViditelnost(boolean paViditelnost) {
       aViditelnost = paViditelnost;
    }

    @Override
    public int dajPocetZivotov() {
       return 3;
    }

    @Override
    public void znizZivoty() {
        
    }
    
}
