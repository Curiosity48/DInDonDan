/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcavallisemafori;

/**
 *
 * @author Samuele Peduzzi
 */
public class JCavalloTh extends Thread{
    
    private String verso;
    private Semaforo mutex;
    private JDatiCondivisi dC;

    public JCavalloTh(String verso, Semaforo mutex, JDatiCondivisi dC) {
        this.verso = verso;
        this.mutex = mutex;
        this.dC = dC;
    }
    
    public void run()
    {
        for(int i= 0 ;i < 50; i++)
        {
            mutex.Wait();
            dC.push(verso);
            mutex.Signal();
        }
            
    }
    
}
