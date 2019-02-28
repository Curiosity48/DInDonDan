/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dindondansemafori;

import java.util.logging.Level;
import java.util.logging.Logger;

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
        while(true)
        {
            try {
                dC.aquire(4);
                System.out.print(dC.getLast());
                dC.release(5);
            } catch (InterruptedException ex) {
                break;
            }
        }
    }
    
    
}
