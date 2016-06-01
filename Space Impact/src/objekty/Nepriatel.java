/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objekty;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Jakub
 */
public class Nepriatel implements ActionListener{

    private int aPolohaX;
    private final int aPolohaY;
    private final int aVelkostX;
    private final int aVelkostY;
    private boolean aJeViditelny;
    private Objekty aObjekty;
    
     
    public Nepriatel(int paY,int paVelkostX, int paVelkostY, int paFrekvenciaStrelby){
        aPolohaX = 850;
        aPolohaY = paY;
        aVelkostX = paVelkostX; 
        aVelkostY = paVelkostY;
        aJeViditelny = true;
        aObjekty = Objekty.dajInstanciu();
        Timer casovac = new Timer(paFrekvenciaStrelby, this);
        casovac.start();
    }
    
    public void hybSa(int paRychlost) {
        aPolohaX += paRychlost;
        if(aPolohaX < -350){
            aJeViditelny = false;
        }
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
    
    public void nastavViditelnost(boolean paViditelnost) {
        aJeViditelny = paViditelnost;
    }
    
    private void strel() { 
        if(aJeViditelny == true) {          
          aObjekty.pridajStrelu(new Strela(aPolohaX - 33, aPolohaY + aVelkostY/2,-5 ,"laser2"));
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
         this.strel();
    }
    
    public Rectangle dajObdlznik() {
        return new Rectangle(aPolohaX,aPolohaY,aVelkostX,aVelkostY);
    }
    
}
