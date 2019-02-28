/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dindondansemafori;

/**
 *
 * @author Samuele Peduzzi
 */
public class DinDonDanTh extends Thread{
    
    private JDatiCondivisi dC;
    private String suono;
    private Semaforo mutex;

    public DinDonDanTh(JDatiCondivisi dC, String suono, Semaforo mutex) {
        this.dC = dC;
        this.suono = suono;
        this.mutex = mutex;
    }
    
    
    
    
    
    @Override
    public void run()
    {
        while(!isInterrupted())
        {
            mutex.Wait();
            dC.push(suono);
            mutex.Signal();
        }
            
            
    }
    
}
