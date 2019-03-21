/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esestatistiche;

import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author peduzzi_samuele
 */
public class JDatiCondivisi {

    private Vector buffer;
    private Semaphore synchVisCarattereGenerato;
    private Semaphore synchVisVisualizzato;
    
    private Semaphore synchCountCarattereGenerato;
    private Semaphore synchCountCarattereLetto;
    
    
    
    

    private int numSpaziInseriti, numPuntiInseriti;
    private int numSpaziLetti, numPuntiLetti;

    public JDatiCondivisi() {
        buffer = new Vector(1, 1);

        synchVisCarattereGenerato = new Semaphore(0);
        synchVisVisualizzato = new Semaphore(1);
        
        synchCountCarattereGenerato = new Semaphore(0);
        synchCountCarattereLetto = new Semaphore(1);
        
        numSpaziInseriti = 0;
        numPuntiInseriti = 0;
        numSpaziLetti = 0;
        numPuntiLetti = 0;
    }

    //Metodi per la gestione del buffer 
    public synchronized char getLastChar() {
        return (char) buffer.lastElement();
    }

    public synchronized void pushChar(char carattere) {
        buffer.add(carattere);
    }

    public int getBufferLenght() {
        return buffer.size();
    }

    public char getElementAt(int index) {
        return (char) buffer.elementAt(index);
    }

    public String bufferToString() {
        return buffer.toString();
    }

    //Metodi per la gestione del numero di spazii e punti
    public synchronized void incnumSpaziInseriti() {
        numSpaziInseriti++;
    }

    public synchronized void incnumPuntiInseriti() {
        numPuntiInseriti++;
    }

    public synchronized void incnumSpaziLetti() {
        numSpaziLetti++;
    }

    public synchronized void incnumPuntiLetti() {
        numPuntiLetti++;
    }

    public int getNumSpaziInseriti() {
        return numSpaziInseriti;
    }

    public int getNumPuntiInseriti() {
        return numPuntiInseriti;
    }

    public int getNumSpaziLetti() {
        return numSpaziLetti;
    }

    public int getNumPuntiLetti() {
        return numPuntiLetti;
    }

    //Metodi per la sincronizzazione dei thread
    public void attendiVisCarattereGenerato() {
        try {
            synchVisCarattereGenerato.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(JDatiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void segnalaVisCarattereGenerato() {
        synchVisCarattereGenerato.release();
    }

    public void attendiVisVisualizzato() {
        try {
            synchVisVisualizzato.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(JDatiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void segnalaVisVisualizzato() {
        synchVisVisualizzato.release();
    }
    
    
    public void attendiCountCarattereGenerato() {
        try {
            synchCountCarattereGenerato.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(JDatiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void segnalaCountCarattereGenerato() {
        synchCountCarattereGenerato.release();
    }
    
    public void attendiCountCarattereLetto() {
        try {
            synchCountCarattereLetto.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(JDatiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void segnalaCountCarattereLetto() {
        synchCountCarattereLetto.release();
    }
    
}
