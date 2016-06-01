/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objekty;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Jakub
 */
public class VelkaBojovaLod extends Nepriatel implements IObjekt{
    
    private final Image aObrazok;
    private final int aRychlost = -1;
    private int aPocetZivotov = 13;
    
    public VelkaBojovaLod(int paY){
       super(paY,300,145,3000); // 3sekundy frekvencia strielania
       aObrazok = new ImageIcon(this.getClass().getResource("alien3.png")).getImage();
    }
    
    @Override
    public Image dajObrazok(){
        return aObrazok;
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
