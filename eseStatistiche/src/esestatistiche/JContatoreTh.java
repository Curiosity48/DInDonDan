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
        
        dC.attendiCountCarattereGenerato();
        
        for (int i = 0; i < dC.getBufferLenght(); i++) {
            
            if (mode) {
                if (dC.getElementAt(i) == ' ') {
                    dC.incnumSpaziLetti();
                }
            } else if (dC.getElementAt(i) == '.') {
                dC.incnumPuntiLetti();
            }
            

        }

    }

}
