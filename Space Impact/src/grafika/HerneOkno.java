/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grafika;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import objekty.CiernaDiera;
import objekty.IObjekt;
import objekty.Objekty;
import objekty.Raketa;
import objekty.Strela;
import ostatne.Hrac;
import ostatne.ManazerPohybu;


/**
 *
 * @author Jakub
 */
public class HerneOkno extends JPanel implements ActionListener{
    
    private final Hrac aHrac;
    private final Timer  aCasovac;
    private final Raketa aRaketa;
    private final Image aPozadie;
    private final Objekty aObjekty;
    private int aGenerovacieCislo;
    private final ManazerPohybu aManazer;
    private boolean aKoniecHry;
    private int aPocetVygenerovanychObjektov = 0;
    
    public HerneOkno(Hrac paHrac){
       setFocusable(true);
       aPozadie = new ImageIcon(this.getClass().getResource("rsz_pozadie.jpg")).getImage();
       aHrac = paHrac;
       aRaketa = new Raketa();
       aObjekty = Objekty.dajInstanciu();
       aGenerovacieCislo = 150;
       aKoniecHry = false;
       ManazerPohybu.priradRaketu(aRaketa);
       aManazer = ManazerPohybu.dajInstanciu();
       addKeyListener(aManazer);
       aCasovac = new Timer(20, this);
       aCasovac.start();
    }
    
    public void skontrolujKolizie(){
        Rectangle raketa = aRaketa.dajObdlznik();
        
        ArrayList<IObjekt> objekty = aObjekty.dajObjekty();
        for (int i = 0; i< objekty.size(); i++) {
            Rectangle objekt = objekty.get(i).dajObdlznik();
            if(raketa.intersects(objekt)){
                if(objekty.get(i) instanceof CiernaDiera){
                    aKoniecHry = true;
                }else{
                    aHrac.znizZivoty();
                }
                aObjekty.nastavViditelnost(i, false);
                aObjekty.odstranObjekt(i);
            }
        }
        
        ArrayList<Strela> nepriatelskeStrely = aObjekty.dajStrely();
        for (int i = 0; i < nepriatelskeStrely.size() ; i++) {
           Strela strela = nepriatelskeStrely.get(i);
           Rectangle obdlznikStrela = strela.dajObdlznik();
            if(raketa.intersects(obdlznikStrela)){
                aHrac.znizZivoty();
                aObjekty.odstranStrelu(i);
            }
        }
  
        ArrayList<Strela> strely = aRaketa.dajStrely();
         for (int i = 0; i < strely.size(); i++) {
           Strela strela = strely.get(i);
           Rectangle obdlznikStrela = strela.dajObdlznik();

            for (int j = 0; j<objekty.size(); j++) {
                IObjekt objekt = objekty.get(j);
                Rectangle r2 = objekt.dajObdlznik();

                if (obdlznikStrela.intersects(r2)) {
                    aObjekty.znizZivotObjektu(j);
                    if(objekt.dajPocetZivotov()== 0){
                        aHrac.zvysSkore();
                        aObjekty.nastavViditelnost(j, false);
                        aObjekty.odstranObjekt(j);
                    }
                    aRaketa.odstranStrelu(i);
                }
            }
        }  
         
        if(aHrac.dajPocetZivotov() == 0){
                   aKoniecHry = true;
                }
    }
     
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g; 
        
        g2d.drawImage(aPozadie, 0,0 , this);
        g2d.drawImage(aRaketa.dajObrazok(), aRaketa.dajX(), aRaketa.dajY(), this);
        
        ArrayList<IObjekt> objekty = aObjekty.dajObjekty();
        for (IObjekt objekt : objekty) {
            g2d.drawImage(objekt.dajObrazok(), objekt.dajX(), objekt.dajY(), this);
        }
        
        ArrayList<Strela> strely = aRaketa.dajStrely();
        for (Strela strela : strely) {
            g2d.drawImage(strela.dajObrazok(), strela.dajX(), strela.dajY(), this);
        }
        
        ArrayList<Strela> nepriatelskeStrely = aObjekty.dajStrely();
        for (Strela strela : nepriatelskeStrely) {
            g2d.drawImage(strela.dajObrazok(), strela.dajX(), strela.dajY(), this);
        }
        
        g2d.setColor(Color.red);
        g2d.scale(1.5, 1.5);
        g2d.drawString("Pocet zivotov: " + aHrac.dajPocetZivotov(), 10,410);
        g2d.drawString("Skore: "+ aHrac.dajSkore() , 10,420);
        g2d.drawString("Level: "+ aHrac.dajLevel() , 200 ,410);
        g2d.drawString("Pohyb : sipkami", 410, 410);
        g2d.drawString("Strelba: medzernik",410 ,420);
        g2d.drawString("Ukoncenie: ESC",410 ,430);
        
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {        
        
        if(aGenerovacieCislo > 150 - 10* aHrac.dajLevel()){
        aObjekty.vygenerujObjekt();
        aPocetVygenerovanychObjektov++;
        
            if(aPocetVygenerovanychObjektov == 10+aHrac.dajLevel()*10){
                aHrac.zvysLevel();
                aPocetVygenerovanychObjektov = 0;
            }
            aGenerovacieCislo = 0;
        }
        
        aGenerovacieCislo++;
        if(aKoniecHry == false){
            this.skontrolujKolizie();
            aObjekty.aktualizuj();
            aRaketa.aktualizuj();
            repaint();
        }else{
            aCasovac.stop();
            aHrac.aktualizujUmiestnenie();
            JOptionPane.showMessageDialog(this, "Koniec hry!\nUmiestnil si sa na "+ aHrac.dajUmiestnenie()+". priečke.\nNahral si "+ aHrac.dajSkore()+" bodov.\nDostal si sa do "+aHrac.dajLevel()+" levelu.");
            JOptionPane.showMessageDialog(this,rebricek.Rebricek.dajInstanciu().toString(),"Highskore",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
   
}
