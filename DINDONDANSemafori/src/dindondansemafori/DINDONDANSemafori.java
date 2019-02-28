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
    public static void main(String[] args) throws IOException, InterruptedException {
           
        
        JDatiCondivisi dC = new JDatiCondivisi();
        
        DinDonDanTh din = new DinDonDanTh(dC, 1);
        DinDonDanTh don = new DinDonDanTh(dC, 2);
        DinDonDanTh dan = new DinDonDanTh(dC, 3);
       
        JVisualizzaTh vis = new JVisualizzaTh(dC);
        
        din.start();
        don.start();
        dan.start();
        
        vis.start();
        
        
        System.in.read();
        
        if(din.isAlive()) {
            din.interrupt();
            din.join();
        }
        if(don.isAlive())  {
            don.interrupt();
            don.join();
        }
        if(dan.isAlive())  {
            dan.interrupt();
            dan.join();
        }
        if(vis.isAlive()) {
            vis.interrupt();
            vis.join();
        }
        
        
    }
    
}
