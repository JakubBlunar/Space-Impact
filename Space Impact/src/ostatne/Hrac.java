/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ostatne;

import rebricek.Priecka;
import rebricek.Rebricek;

/**
 *
 * @author Jakub
 */
public class Hrac {
    
    private final String aMeno;
    private int aPocetZivotov;
    private int aLevel;
    private int aSkore;
    private Rebricek aRebricek;
    
    public Hrac(String paMeno)
    {
        aMeno = paMeno;
        aLevel = 1;
        aSkore = 1;
        aPocetZivotov =4;
        aRebricek = Rebricek.dajInstanciu();
    }
    
    public void znizZivoty(){
        aPocetZivotov --;
    }
    
    public void zvysSkore(){
        aSkore += aLevel*1;
    }
    
    public void zvysLevel(){
        aLevel++;
    }
            
    public int dajLevel(){
        return aLevel;
    }
    
    public int dajSkore(){
        return aSkore;
    }
    
    public int dajPocetZivotov(){
        return aPocetZivotov;
    }
    
    public void aktualizujUmiestnenie(){
        Priecka priecka = new Priecka(aMeno,aSkore);
        int umiestnenie = aRebricek.zistiUmiestnenie(priecka);
       
        if(umiestnenie < 10 ){
          aRebricek.vlozZaznam(priecka, umiestnenie);
          aRebricek.vlozDoSuboru();
        }
    }

    public String dajUmiestnenie() {
        Priecka priecka = new Priecka(aMeno,aSkore);
        String vratene = "";
        int pozicia = aRebricek.zistiUmiestnenie(priecka);
        if(pozicia <=10){
            vratene += pozicia;
        }else{
            vratene+="Viac ako 10";
        }
        return vratene;
    }
    
    
    
    
    
}
