/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eselotto;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuele Peduzzi
 */
public class JContatoreTh extends Thread {

    private JDatiCondivisi dC;
    private int numCercato;
    private boolean mode; //true --> Cerca il primo numero //False cerca il secondo numero

    public JContatoreTh(int numCercato, boolean mode, JDatiCondivisi dC) {
        this.numCercato = numCercato;
        this.mode = mode;
        this.dC = dC;
    }

    private void verificaVincita() {
        if (dC.getLastRuota().isNumUnoTrovato() && dC.getLastRuota().isNumDueTrovato()) {
            dC.getLastRuota().setRuotaVincente(true);
        }
    }

    private void verificaPresenzaNumero() {
        for (int i = 0; i < 5; i++) {

            if (mode) {
                try {
                    
                    dC.attendiRuotaUnogenerata();
                    if (numCercato == dC.getLastRuota().getNumAt(i)) {
                        dC.getLastRuota().setNumUnoTrovato(true);
                    }
                    verificaVincita();
//                    dC.segnalaRuotaUnoConteggiata();
                    
                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(JContatoreTh.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    
                    dC.attendiRuotaDuegenerata();
                    if (numCercato == dC.getLastRuota().getNumAt(i)) {
                        dC.getLastRuota().setNumDueTrovato(true);
                    }
                    verificaVincita();
//                    dC.segnalaRuotaDueConteggiata();
                    
                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(JContatoreTh.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            

        }
        
        
    }

    @Override
    public void run() {
        
        for (int i = 0; i < dC.getEstrazioniLenght(); i++) {
            //Attende che venga generata la ruota
            verificaPresenzaNumero();
            //Segnala che la verifica è avvenuta
        }

    }

}
