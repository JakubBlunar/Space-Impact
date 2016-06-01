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
public class Strela {
    
    private Image aObrazok;
    private int aPolohaX;
    
    private final int aPolohaY;
    private boolean aJeViditelna;
    private final int aRychlostStrely;
    private final int aSirkaHracejPlochy = 800;
    private final int aVelkostX;
    private final int aVelkostY;
    
    public Strela(int paX , int paY, int paRychlost, String paTyp){
        aPolohaX = paX;
        aPolohaY = paY;
        aRychlostStrely = paRychlost;
        aObrazok = new ImageIcon(this.getClass().getResource(paTyp+".png")).getImage();
        aJeViditelna = true;
        aVelkostX = 32;
        aVelkostY = 10;
    }
    
    public void hybSa(){
        aPolohaX += aRychlostStrely;
        if(aPolohaX> aSirkaHracejPlochy || aPolohaX < -100){
            aJeViditelna = false;
        }
    }
    
    public Image dajObrazok(){
        return aObrazok;
    }

    public int dajX(){
        return aPolohaX;
    }

    public int dajY() {
        return aPolohaY;
    }

    public boolean jeViditelna() {
        return aJeViditelna;
    }

    public Rectangle dajObdlznik() {
        return new Rectangle(aPolohaX,aPolohaY,aVelkostX,aVelkostY);
    }

    
}
