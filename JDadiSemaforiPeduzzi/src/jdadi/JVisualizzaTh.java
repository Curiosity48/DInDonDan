/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdadi;

/**
 *
 * @author peduzzi_samuele
 */
public class JVisualizzaTh extends Thread {
    
    
    private Semaforo sem;
    private JDatiCondivisi dC;

    public JVisualizzaTh(Semaforo sem, JDatiCondivisi dC) {
        this.sem = sem;
        this.dC = dC;
    }
    
    
    
    @Override
    public void run() {
        
        while(!isInterrupted())
        {
            
            System.out.println(dC.getVal1());
            
            
            
            System.out.println(dC.getVal2());
            
            
            
            System.out.println(dC.getVal3());
            
        }
    }
            
    
}
