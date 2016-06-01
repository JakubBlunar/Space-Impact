/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objekty;

import java.awt.Rectangle;

/**
 *
 * @author Jakub
 */
public class Asteroid{
    
    private boolean aJeViditelny;
    private int aPolohaX;
    private final int aPolohaY;
    
    public  Asteroid(int paPolohaY){
        aPolohaY = paPolohaY;
        aJeViditelny = true;
        aPolohaX = 850;
    }

    public int dajX() {
        return aPolohaX;
    }

    public int dajY() {
        return aPolohaY;
    }

    public boolean jeViditelny() {
        return aJeViditelny;
    }
    
    public void nastavViditelnost(boolean paViditelnost){
        aJeViditelny = paViditelnost;
    }
    
    public void hybSa(int paRychlost){
        aPolohaX += paRychlost;
        if(aPolohaX < -300){
            aJeViditelny = false;
        }
    }   
    
 
    
}
