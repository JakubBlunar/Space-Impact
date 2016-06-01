/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ostatne;

import java.util.Random;

/**
 *
 * @author Jakub
 */
public class Generator {
    
    private static Generator aInstancia;
    private final Random aNahoda;
    
    private Generator(){
        aNahoda = new Random();
    }
    
    public static Generator dajInstanciu(){
        if(aInstancia == null){
            aInstancia = new Generator();
        }
        return aInstancia;
    }
    
    public int generujCislo(int paRozsah){
       int cislo = aNahoda.nextInt(paRozsah);
       return cislo;
    }
}
