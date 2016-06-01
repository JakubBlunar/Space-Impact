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
public class MalaBojovaLod extends Nepriatel implements IObjekt{
    
    private final Image aObrazok;
    private final int aRychlost;
    private int aPocetZivotov;
    
    public MalaBojovaLod(int paY){
      
       super(paY,100,73,1500); //1500- frekvencia strelby kazde 2 sekundy
       aPocetZivotov = 7;
       aRychlost = -3;
       aObrazok = new ImageIcon(this.getClass().getResource("alien2.png")).getImage();
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
