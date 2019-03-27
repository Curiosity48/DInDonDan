/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eselotto;

import java.util.Vector;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Samuele Peduzzi
 */
public class JDatiCondivisi {

    private Vector estrazioni;
    
    private Semaphore synchCountRuotaUnoGenerata; 
    private Semaphore synchCountRuotaUnoConteggiata;
    
    private Semaphore synchCountRuotaDueGenerata; 
    private Semaphore synchCountRuotaDueConteggiata;
    
    
    public JDatiCondivisi() {
        estrazioni = new Vector(1,1);
        
        synchCountRuotaUnoGenerata = new Semaphore(0);
        synchCountRuotaUnoConteggiata = new Semaphore(1);
        
        synchCountRuotaDueGenerata = new Semaphore(0);
        synchCountRuotaDueConteggiata = new Semaphore(1);
        
    }
    
    public synchronized void pushEstrazione(Vector numeriEstratti)
    {
        estrazioni.add(new JRuotaRecord(numeriEstratti));
    }
    public synchronized JRuotaRecord getLastRuota() {
        return (JRuotaRecord)estrazioni.lastElement();
    }
    
    public synchronized int getNumRuoteVincenti()
    {
        int numVincenti = 0;
        for (int i = 0; i < estrazioni.size(); i++) {
            if(((JRuotaRecord)estrazioni.elementAt(i)).isRuotaVincente())
                numVincenti++;
        }
        return numVincenti;
    }
    
    
    //Metodi per la gestione dei semafori
    public void attendiRuotaUnogenerata() throws InterruptedException     
    {
        synchCountRuotaUnoGenerata.acquire();
    }
    
    public void segnalaRuotaUnoGenerata() 
    {
        synchCountRuotaUnoGenerata.release();
        
    }
    
    public void attendiRuotaUnoConteggiata() throws InterruptedException     
    {
        synchCountRuotaUnoConteggiata.acquire();
    }
    
    public void segnalaRuotaUnoConteggiata() throws InterruptedException     
    {
        synchCountRuotaUnoConteggiata.release();
    }
    
    public void attendiRuotaDuegenerata() throws InterruptedException     
    {
        synchCountRuotaDueGenerata.acquire();
    }
    
    public void segnalaRuotaDueGenerata() 
    {
        synchCountRuotaDueGenerata.release();
        
    }
    
    public void attendiRuotaDueConteggiata() throws InterruptedException     
    {
        synchCountRuotaDueConteggiata.acquire();
    }
    
    public void segnalaRuotaDueConteggiata() throws InterruptedException     
    {
        synchCountRuotaDueConteggiata.release();
    }

    
    public String ruoteToString()
    {
        String ris = "";
        for (int i = 0; i < estrazioni.size(); i++) {
            ris += estrazioni.elementAt(i).toString() + "\n";
        }
        return ris;
    }
    
    public int getEstrazioniLenght()
    {
        return estrazioni.size();
    }
    
    
    
}
