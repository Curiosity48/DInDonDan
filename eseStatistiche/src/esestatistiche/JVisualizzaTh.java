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
public class JVisualizzaTh extends Thread {

    JDatiCondivisi dC;

    public JVisualizzaTh(JDatiCondivisi dC) {
        this.dC = dC;
    }

    public void run() {
        while (!isInterrupted()) {
            
            dC.attendiVisCarattereGenerato();
            
            System.out.println("Stato variabili condivise");
            System.out.println(dC.bufferToString());
            System.out.println("Numero di spazi inseriti " + dC.getNumSpaziInseriti());
            System.out.println("Numero di punti inseriti " + dC.getNumPuntiInseriti());
            System.out.println("Numero di punti letti " + dC.getNumPuntiLetti());
            System.out.println("Numero di spazi letti " + dC.getNumSpaziLetti());
            
            dC.segnalaVisVisualizzato();
        }
    }

}
