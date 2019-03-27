/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eselotto;

import java.util.Vector;

/**
 *
 * @author Samuele Peduzzi
 */
public class JRuotaRecord {
    
    private Vector numEstratti;
    private boolean ruotaVincente;
    private boolean numUnoTrovato;
    private boolean numDueTrovato; 

    public JRuotaRecord(Vector numEstratti) {
        this.numEstratti = numEstratti;
        ruotaVincente = false;
        numUnoTrovato = false;
        numDueTrovato = false;
    }
    
    public JRuotaRecord() {
        numEstratti = new Vector(1,1);
        ruotaVincente = false;
        numUnoTrovato = false;
        numDueTrovato = false;
    }
    
    

    public boolean isRuotaVincente() {
        return ruotaVincente;
    }
    public void setRuotaVincente(boolean ruotaVincente) {
        this.ruotaVincente = ruotaVincente;
    }
    
    public void pushNumber(int num) {
        numEstratti.add(num);
    }
    
    public int getNumAt(int index) {
        return (int)numEstratti.elementAt(index);
    }

    public void setNumUnoTrovato(boolean numUnoTrovato) {
        this.numUnoTrovato = numUnoTrovato;
    }

    public void setNumDueTrovato(boolean numDueTrovato) {
        this.numDueTrovato = numDueTrovato;
    }

    public boolean isNumUnoTrovato() {
        return numUnoTrovato;
    }

    public boolean isNumDueTrovato() {
        return numDueTrovato;
    }

    @Override
    public String toString() {
        return numEstratti.toString();
    }
    
    
    
    
}
