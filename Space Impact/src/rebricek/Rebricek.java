/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rebricek;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Jakub
 */
public class Rebricek {

    private static Rebricek aInstancia;
    
    private File aSubor;
    private Priecka[] aPoradie;
    
 
    public Rebricek(){
       aSubor = new File("rebricek.txt");
       aPoradie = new Priecka[10];
       try{   
           nacitajZoSuboru();
       }catch(FileNotFoundException c){
           try {
               aSubor.createNewFile();
               this.resetniPoradia();
               Object[] moznosti = {"OK"};
               JOptionPane.showOptionDialog(null,"Subor s highskore neexistuje alebo nie je v rovnakej zlozke ako spustací subor. Vytvorili sa nove data.","Varovanie!",JOptionPane.PLAIN_MESSAGE,JOptionPane.ERROR_MESSAGE,null,moznosti,moznosti[0]);
               nacitajZoSuboru();
                
           } catch (IOException ex) {
               Object[] moznosti = {"OK"};
               JOptionPane.showOptionDialog(null,"Súbor s highskore sa nepodarilo vytvoriť. highskore nebude fungovať.","Varovanie!",JOptionPane.PLAIN_MESSAGE,JOptionPane.ERROR_MESSAGE,null,moznosti,moznosti[0]);
           }
           
       } 
    }
    
    public static Rebricek dajInstanciu(){
        if(aInstancia == null){
            aInstancia = new Rebricek();
        }
        return aInstancia;
    }
    
    public int zistiUmiestnenie(Priecka paPriecka)
    {
        int pozicia = 0;
        boolean najdene = false;
        
        while(najdene == false){
           if(aPoradie[pozicia].dajSkore() > paPriecka.dajSkore()){
               
           }else{
               najdene = true;
           }
           pozicia++;
        } 
        return pozicia;
    }
    
    public void vlozDoSuboru(){
        PrintWriter zapisovac = null;
        try {
            zapisovac = new PrintWriter(aSubor);
        } catch (FileNotFoundException ex) {
            
        }
        
        if(zapisovac != null){
         for (int i = 0; i < 10; i++) {
               zapisovac.println(aPoradie[i].dajMeno()+" " + aPoradie[i].dajSkore());
               zapisovac.close();
           }
         }else{
            System.out.println("Subor neexistuje nemožem donho zapisovat!");
        }
         
    }
    
    public void nacitajZoSuboru() throws FileNotFoundException{
        
        Scanner citac = new Scanner(aSubor);
        
        try{
        for(int i = 0; i<10;i++){
            String meno = citac.next();
            int skore = citac.nextInt();
            aPoradie[i] = new Priecka(meno, skore);
        }
        citac.close();
        }catch(Exception e){
            this.resetniPoradia();
            this.nacitajZoSuboru();
        }
        
    }
     
    
    public void vlozZaznam(Priecka paPriecka, int paPozicia){
        
        
       for (int i= aPoradie.length -1; i >= paPozicia; i--){
           aPoradie[i] = aPoradie[i-1];
       }            
        aPoradie[paPozicia-1] = paPriecka;
    }
    
    public void resetniPoradia(){
        
        for (int i = 0; i < 10; i++) {
            aPoradie[i] = new Priecka("Prazdne", 0);
        }
        this.vlozDoSuboru();
    
    }
    
    @Override
    public String toString(){
        String vratene = "";
        for (int i = 0; i < 10; i++) {
            vratene+=(i+1)+". "+ aPoradie[i].toString()+"\n";
        }
        
        return vratene;
    }
   
}
