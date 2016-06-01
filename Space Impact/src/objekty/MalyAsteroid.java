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
public class MalyAsteroid extends Asteroid implements IObjekt{
    
    private final Image aObrazok;
    private final int aVelkostX;
    private final int aVelkostY;
    private final int aRychlost = -3;
    private int aPocetZivotov = 8;
    
    public MalyAsteroid(int paY){
       super(paY);
       aObrazok = new ImageIcon(this.getClass().getResource("asteroid1.png")).getImage();
       aVelkostX = 70;
       aVelkostY = 70;  
    }
    
    @Override
    public Image dajObrazok(){
        return aObrazok;
    }
    
    @Override
    public Rectangle dajObdlznik() {
        return new Rectangle(super.dajX(),super.dajY(),aVelkostX,aVelkostY);
    }  
    
    @Override
    public void znizZivoty(){
        aPocetZivotov --;
    }
    
    @Override
     public int dajPocetZivotov(){
        return aPocetZivotov;
    }
     
    @Override
    public void hybSa(){
        super.hybSa(aRychlost);
    }
}
