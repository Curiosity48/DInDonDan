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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Semaforo mutex = new Semaforo(1);
        
        JDatiCondivisi dC = new JDatiCondivisi();
        
        JCavalloTh clop1 = new JCavalloTh("CLOP1", mutex, dC);
        JCavalloTh clop2 = new JCavalloTh("CLOP2", mutex, dC);
        JCavalloTh clop3 = new JCavalloTh("CLOP3", mutex, dC);
        JCavalloTh clop4 = new JCavalloTh("CLOP4", mutex, dC);
        JCavalloTh clop5 = new JCavalloTh("CLOP5", mutex, dC);
        
        JVisualizzaTh vis = new JVisualizzaTh(dC);
        
        
        clop1.start();
        clop2.start();
        clop3.start();
        clop4.start();
        clop5.start();
        
        vis.start();
        
        clop1.join();
        clop2.join();
        clop3.join();
        clop4.join();
        clop5.join();
        
        
        if (vis.isAlive())
            vis.interrupt();
        
    }
    
}
