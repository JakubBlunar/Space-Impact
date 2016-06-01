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
public class RychlaBojovaLod extends Nepriatel implements IObjekt{
    
    private final Image aObrazok;
    private final int aRychlost = -4;
    private int aPocetZivotov = 5;
    
    
    public RychlaBojovaLod(int paY){
       super(paY,80,36,1500); // 1500- každých 1,5 sekundy vystreli 
       aObrazok = new ImageIcon(this.getClass().getResource("alien1.png")).getImage();
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
