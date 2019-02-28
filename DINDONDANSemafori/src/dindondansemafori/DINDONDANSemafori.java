/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dindondansemafori;

import java.io.IOException;

/**
 *
 * @author Samuele Peduzzi
 */
public class DINDONDANSemafori {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        Semaforo mutex = new Semaforo(1);
        
        JDatiCondivisi dC = new JDatiCondivisi();
        
        DinDonDanTh din = new DinDonDanTh(dC, "DIN, ",mutex);
        DinDonDanTh don = new DinDonDanTh(dC, "DON, ",mutex);
        DinDonDanTh dan = new DinDonDanTh(dC, "DAN, ",mutex);
        
        JVisualizzaTh vis = new JVisualizzaTh(dC);
        
        din.start();
        don.start();
        dan.start();
        
        vis.start();
        
        
        System.in.read();
        
        if(din.isAlive()) 
            din.interrupt();
        if(don.isAlive()) 
            don.interrupt();
        if(dan.isAlive()) 
            dan.interrupt();
        if(vis.isAlive())
            vis.interrupt();
        
        
    }
    
}
