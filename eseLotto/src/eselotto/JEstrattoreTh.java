/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eselotto;

import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuele Peduzzi
 */
public class JEstrattoreTh extends Thread{
    
    private int numEstrazioniDaSimulare;
    private JDatiCondivisi dC;

    public JEstrattoreTh(int numEstrazioniDaSimulare, JDatiCondivisi dC) {
        this.numEstrazioniDaSimulare = numEstrazioniDaSimulare;
        this.dC = dC;
    }
    
    
    private Vector getEstrazione() {
        
        Random rn = new Random();
        Vector estrazione = new Vector(1,1);
        
        for (int i = 0; i < 5; i++) {
            estrazione.add(rn.nextInt(10));
        }
        
        return estrazione;
    }
    
    @Override
    public void run()
    {
        for (int i = 0; i < numEstrazioniDaSimulare; i++) {
            
//            try {
                //Attende che venga conteggiata la ruota
//                dC.attendiRuotaUnoConteggiata();
//                dC.attendiRuotaDueConteggiata();
                
                dC.pushEstrazione(getEstrazione());
                
                //Segnala il completamento di una nuova ruota
                dC.segnalaRuotaUnoGenerata();
                dC.segnalaRuotaDueGenerata();
                
//            } catch (InterruptedException ex) {
//                Logger.getLogger(JEstrattoreTh.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
    }
    
    
}
