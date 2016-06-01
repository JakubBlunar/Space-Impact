/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ostatne;

import objekty.Raketa;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Jakub
 */
public class ManazerPohybu extends KeyAdapter {
    
    private static ManazerPohybu aInstancia;
    private static Raketa aRaketa;
    
    private ManazerPohybu(){
        
    }
    
    public static ManazerPohybu dajInstanciu()
    {
        if(aInstancia == null){
            aInstancia = new ManazerPohybu();
        }
        return aInstancia;
    }
    
    public static void priradRaketu(Raketa paRaketa)
    {
        aRaketa = paRaketa;
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        aRaketa.uvolnenaKlavesa(e);
        }

    @Override
    public void keyPressed(KeyEvent e) {    
        aRaketa.stlacenaKlavesa(e);
        }
}
