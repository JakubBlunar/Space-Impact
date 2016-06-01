/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import grafika.HerneOkno;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import ostatne.Hrac;

/**
 *
 * @author Jakub
 */
public class Hra extends JFrame{  
    
    public Hra(Hrac paHrac){         
        add(new HerneOkno(paHrac));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 710);
        setLocationRelativeTo(null);
        setTitle("Raketka");
        setResizable(false);
        setVisible(true);    
         
    }
    
      public static void main(String[] args) {
         int g = -1;
         String hlaska ="";
          while (g < 0){
              String vstup = JOptionPane.showInputDialog(null,hlaska+"\nZadaj svoje meno: ",null, 1);
             
              if (vstup == null){
                  Object[] moznosti = {"OK"};
                  int vysledok = JOptionPane.showOptionDialog(null,"Zrušil si zadávanie mena!\nAk sa chceš hrať musíš zadať svoje meno.\nHra sa vypne.","Varovanie!",JOptionPane.PLAIN_MESSAGE,JOptionPane.ERROR_MESSAGE,null,moznosti,moznosti[0]);      
                  System.exit(0);
              }
              
              if(!vstup.contains(" ")){
              if(vstup.length()> 0){
                 int vstup2= JOptionPane.showConfirmDialog(null, "Ahoj " + vstup + " chceš spustiť hru ?\nPohybuješ sa šípkami a strieľaš medzerníkom.\nPokús sa zostreliť čo najviac mimozemšťanov a asteroidov.\nNezabudni sa vyhýbať čiernym dieram.", "Spustiť hru ?", JOptionPane.YES_NO_OPTION);
                 if(vstup2 == 0  ){
                     
                     Hra hra = new Hra(new Hrac(vstup));
                     g++;
                 }else{
                     Object[] moznosti = {"OK"};
                     int vysledok = JOptionPane.showOptionDialog(null,"Prečo si nechcel spustiť tak dobrú hru ?\nNo dobre nech je teda po tvojom.\nHra sa vypne :-(","Škoda!",JOptionPane.PLAIN_MESSAGE,JOptionPane.ERROR_MESSAGE,null,moznosti,moznosti[0]);
                     System.exit(0);
                 }
                 
              }
          }else{
                  hlaska ="Meno nesmie obsahovať medzery!";
              }
          
        }
          
    }
}
