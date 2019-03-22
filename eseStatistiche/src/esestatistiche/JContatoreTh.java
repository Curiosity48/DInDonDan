/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esestatistiche;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author peduzzi_samuele
 */
public class JContatoreTh extends Thread {

    JDatiCondivisi dC;
    boolean mode;

    public JContatoreTh(JDatiCondivisi dC, boolean mode) { //Mode = true --> conta spazi Altrimenti conta i punti
        this.dC = dC;
        this.mode = mode;
    }

    @Override
    public void run() {

        if (mode) {
            contaSpazii();
        }
        else 
            contaPunti();

    }

    private void contaSpazii() {
        dC.attendiCountSpaziiCarattereGenerato();
        for (int i = 0; i < dC.getBufferLenght(); i++) {
//            dC.attendiCountSpaziiCarattereGenerato();
            if(dC.getElementAt(i) == ' ')
                dC.incnumSpaziLetti();
//            dC.segnalaCountSpaziiCarattereLetto();
        }
    }
    
    private void contaPunti() {
        dC.attendiCountPuntiCarattereGenerato();
        for (int i = 0; i < dC.getBufferLenght(); i++) {
//            dC.attendiCountPuntiCarattereGenerato();
            if(dC.getElementAt(i) == '.')
                dC.incnumPuntiLetti();
//            dC.segnalaCountPuntiCarattereLetto();
        }
    }

}
