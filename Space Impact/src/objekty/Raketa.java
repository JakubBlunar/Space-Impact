/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objekty;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Jakub
 */
public class Raketa {
    
    private final int aVelkostRaketyX = 60;
    private final int aVelkostRaketyY = 27;
    private int aRozdielX;
    private int aRozdielY;
    private int aSuradnicaX;
    private int aSuradnicaY;
    private Image aObrazok;
    private final int aRychlost;
    private ArrayList<Strela> aStrely;
    
    public Raketa(){
        
        aObrazok = new ImageIcon(this.getClass().getResource("raketa.png")).getImage();
        aRychlost = 4;
        aSuradnicaX = 0;
        aSuradnicaY = 250;
        aStrely = new ArrayList<>();
        
    }
    
    public int dajX(){
        return aSuradnicaX;
    }

    public int dajY() {
        return aSuradnicaY;
    }
    
    public void odstranStrelu(int paIndex)
    {
        aStrely.remove(paIndex);
    }
    
    public void aktualizuj(){
        this.hybSa();
        this.pohniStrely();
    }
    
    public void hybSa(){
            if(aSuradnicaX>785 - aVelkostRaketyX){
                if(aRozdielX < 0){
                aSuradnicaX += aRozdielX;
                } 
            }else if(aSuradnicaX < 0){
                if(aRozdielX > 0){
                    aSuradnicaX += aRozdielX;
                }
            }else aSuradnicaX += aRozdielX;
             
            if(aSuradnicaY>598 - aVelkostRaketyY){
                 if(aRozdielY < 0){
                aSuradnicaY += aRozdielY;
                } 
            }else if(aSuradnicaY < 0 ){
                if(aRozdielY > 0){
                    aSuradnicaY += aRozdielY;
                }
            }else aSuradnicaY += aRozdielY;    
    }
    
    public ArrayList dajStrely(){
        return aStrely;
    }

    public int dajRychlost() {
        return aRychlost;
    } 
    
    public Image dajObrazok()
    {
        return aObrazok;
    }
    
    public Rectangle dajObdlznik(){
         return new Rectangle(aSuradnicaX, aSuradnicaY, aVelkostRaketyX, aVelkostRaketyY);
    }
    
    public void strel() {
        aStrely.add(new Strela(aSuradnicaX + aVelkostRaketyX + 1, aSuradnicaY + aVelkostRaketyY/2 -5, aRychlost+3, "laser"));
    }
    
    public void stlacenaKlavesa(KeyEvent paKlavesa)
    {
        int stlacene = paKlavesa.getKeyCode();
       
        if(stlacene == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
        
        if (stlacene == KeyEvent.VK_SPACE) {
            strel();
        }
        
        if(stlacene == KeyEvent.VK_LEFT){
            aRozdielX = -1 * aRychlost;
        }
           
        if (stlacene == KeyEvent.VK_RIGHT)
        {
            aRozdielX = 1 * aRychlost;
        }
        
        if(stlacene == KeyEvent.VK_UP )
        {
            aRozdielY = -1 * aRychlost ;
            
        } 
        
        if(stlacene == KeyEvent.VK_DOWN){
            aRozdielY = 1* aRychlost;
        }    
       
    }
    
    
    public void uvolnenaKlavesa(KeyEvent paKlavesa){
        int uvolnene = paKlavesa.getKeyCode();
        
         if(uvolnene == KeyEvent.VK_LEFT){
            aRozdielX = 0;
        }
        
        if (uvolnene == KeyEvent.VK_RIGHT)
        {
            aRozdielX = 0;
        }
        
        if(uvolnene == KeyEvent.VK_UP)
        {
            aRozdielY = 0 ;
        }
        
        if(uvolnene == KeyEvent.VK_DOWN){
            aRozdielY = 0;
        }
        
    }
    
    private void pohniStrely() {
        
        for (int i = 0; i < aStrely.size(); i++ ) {
            Strela strela = aStrely.get(i);
            if(strela.jeViditelna()== true){
                strela.hybSa();
            }else{
               aStrely.remove(i);
            }
        }
    }
}
