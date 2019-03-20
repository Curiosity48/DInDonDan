/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esestatistiche;

import java.util.Vector;
import java.util.concurrent.Semaphore;

/**
 *
 * @author peduzzi_samuele
 */
public class JDatiCondivisi {
    
    private Vector buffer;
    private Semaphore sem1, sem2, sem3;
    private int numSpaziInseriti, numPuntiInseriti;
    private int numSpaziLetti, numPuntiLetti;
    
    

    public JDatiCondivisi() {
        buffer = new Vector(1,1);
        
        sem1 = new Semaphore(0);
        sem2 = new Semaphore(0);
        sem3 = new Semaphore(0);
        
        numSpaziInseriti = 0;
        numPuntiInseriti = 0;
        numSpaziLetti = 0;
        numPuntiLetti = 0;
    }
    
    
    //Metodi per la gestione del buffer 
    public synchronized char getLastChar()
    {
        return (char)buffer.lastElement();
    }
    
    public synchronized void pushChar(char carattere)
    {
        buffer.add(carattere);
    }
    
    public int getBufferLenght()
    {
        return buffer.size();
    }
    
    public char getElementAt(int index)
    {
        return (char)buffer.elementAt(index);
    }
    public String bufferToString()
    {
        return buffer.toString();
    }
    
    
    //Metodi per la gestione del numero di spazii e punti
    public synchronized void incnumSpaziInseriti()
    {
        numSpaziInseriti++;
    }
    
    public synchronized void incnumPuntiInseriti()
    {
        numPuntiInseriti++;
    }
    
    public synchronized void incnumSpaziLetti()
    {
        numSpaziLetti++;
    }
    
    public synchronized void incnumPuntiLetti()
    {
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

    public Semaphore getSem1() {
        return sem1;
    }

    public Semaphore getSem2() {
        return sem2;
    }

    public Semaphore getSem3() {
        return sem3;
    }
    

 
    
    
    
    
    
    
    
    
    
}
