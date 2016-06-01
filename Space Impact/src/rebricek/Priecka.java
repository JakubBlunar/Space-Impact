/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rebricek;

/**
 *
 * @author Jakub
 */
public class Priecka {
    
    private final String aMeno;
    private final int aSkore;
    
    public Priecka(String paMeno, int paSkore){
        aMeno = paMeno;
        aSkore = paSkore; 
    }
    
    @Override
    public String toString(){
        return aMeno + "-"+ aSkore;
    }

    public String dajMeno() {
        return aMeno;
    }

    public int dajSkore() {
        return aSkore;
    }
    
    
}
