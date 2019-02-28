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
public class JVisualizzaTh extends Thread{
 
    JDatiCondivisi dC;

    public JVisualizzaTh(JDatiCondivisi dC) {
        this.dC = dC;
    }
    
    
    
    
    public void run()
    {
        while(!isInterrupted())
        {
            System.out.print(dC.getLast());
        }
    }
    
    
}
