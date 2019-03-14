/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esestatistiche;

import java.util.Vector;

/**
 *
 * @author peduzzi_samuele
 */
public class JDatiCondivisi {
    
    private Vector buffer;
    private int numSpaziInseriti, numPuntiInseriti;
    private int numSpaziLetti, numPuntiLetti;
    
    

    public JDatiCondivisi() {
        buffer = new Vector(0,1);
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
    
    public synchronized void pushChar(char carattere )
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
    
    
    
    
    
    
}
