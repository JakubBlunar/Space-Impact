/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objekty;

import java.util.ArrayList;
import ostatne.Generator;

/**
 *
 * @author Jakub
 */
public class Objekty {
    
    public static Objekty aInstancia;
    
    private ArrayList<IObjekt> aObjekty;
    private ArrayList<Strela> aStrely;
    private final Generator aGenerator;
    
    public static Objekty dajInstanciu() {
        if(aInstancia == null){
            aInstancia = new Objekty();
        }
        
        return aInstancia;
    }
    
    private Objekty(){
       
        aStrely = new ArrayList<>();
        aObjekty = new ArrayList<>();
        aGenerator = Generator.dajInstanciu();
        
    }
    
    public void vygenerujObjekt()
    {
        int cislo = aGenerator.generujCislo(3);
        if(cislo == 0){
           aObjekty.add(this.dajAsteroid());
        }else if (cislo == 1 ){
          aObjekty.add(this.dajNepriatela());//, aGenerator.generujCislo(3)+2));
        } else aObjekty.add(new CiernaDiera(aGenerator.generujCislo(22)*23));
    }

    public ArrayList<IObjekt> dajObjekty() {
        return aObjekty;
    }
    
    public void odstranObjekt(int paIndex){
        aObjekty.remove(paIndex);
    }
    
    public void nastavViditelnost(int paIndex, boolean paViditelnost){
        aObjekty.get(paIndex).nastavViditelnost(paViditelnost);
    }

    public void znizZivotObjektu(int j) {
       aObjekty.get(j).znizZivoty();
    }
    
    public void pridajStrelu(Strela paStrela){
       aStrely.add(paStrela);
        }
    
    public ArrayList<Strela> dajStrely(){
        return aStrely;
    }
    
    public void aktualizuj(){
        
        for(int j = 0; j< aObjekty.size(); j++){
            IObjekt objekt = aObjekty.get(j);
            if(objekt.jeViditelny()== true){
                objekt.hybSa();
            }else aObjekty.remove(j);
        }
        
        for(int i = 0; i < aStrely.size(); i++) {
            Strela strela = aStrely.get(i);
            if(strela.jeViditelna()== true){
                strela.hybSa();
            }else{
                aStrely.remove(i);
            }
        }    
        
    }
    
    private IObjekt dajAsteroid() {
       int nahodneCislo = aGenerator.generujCislo(3);
       IObjekt vratene = null;
       switch (nahodneCislo) {
            case 0:   vratene = new RychlyAsteroid(aGenerator.generujCislo(10)*60);
                     break;
            case 1:   vratene = new MalyAsteroid(aGenerator.generujCislo(13)*43);
                     break;
            case 2: vratene = new VelkyAsteroid(aGenerator.generujCislo(4)*91);
    }
    
    return vratene;
  }
    
    private IObjekt dajNepriatela() {
       int nahodneCislo = aGenerator.generujCislo(3);
       IObjekt vratene = null;
       
       switch (nahodneCislo) {
            case 0:   vratene = new VelkaBojovaLod(aGenerator.generujCislo(13)*33);
                     break;
            case 1:   vratene = new MalaBojovaLod(aGenerator.generujCislo(17)*31);
                     break;
            case 2: vratene = new RychlaBojovaLod(aGenerator.generujCislo(12)*47);
      
    } 
    return vratene;
  }

    public void odstranStrelu(int i) {
        aStrely.remove(i);
    }
}
