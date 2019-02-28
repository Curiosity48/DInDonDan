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
public class DinDonDanTh extends Thread{
    
    private JDatiCondivisi dC;
    private int suono;

    public DinDonDanTh(JDatiCondivisi dC, int suono) {
        this.dC = dC;
        this.suono = suono;
    }
    
    
    
    
    
    @Override
    public void run()
    {
        try {
            while(!isInterrupted())
        {       
            switch (suono) {
                case 1:
                    dC.aquire(1);
                    dC.push("DIN");
                    dC.release(2);
                    break;
                case 2:
                    dC.aquire(2);
                    dC.push("DON");
                    dC.release(3);
                    break;
                case 3:
                    dC.aquire(3);
                    dC.push("DAN");
                    dC.release(1);
                    break;
                default:
                    break;
            } 
        }

        } catch (InterruptedException ex) {
            // Logger.getLogger(DinDonDanTh.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
            
    }
    
}
