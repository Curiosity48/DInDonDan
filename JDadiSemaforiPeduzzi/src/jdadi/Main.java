/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdadi;

import java.io.IOException;
import static java.lang.Thread.sleep;
import static java.lang.Thread.yield;
import java.util.Scanner;
import static java.lang.Thread.sleep;

/**
 *
 * @author Samuele Peduzzi
 * @brief Classe Main.
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, IOException {

        /**
         * @author Samuele Peduzzi
         * @brief Dichiarazione oggetto di tipo scanner per leggere da testiera.
         */
        Scanner scanner = new Scanner(System.in);
        /**
         * @author Samuele Peduzzi
         * @brief Dichiarazione oggetto di tipo JDatiCondivisi per la
         * memorizzazione di dati condivisi.
         */
        JDatiCondivisi dC = new JDatiCondivisi();

        /**
         * @author Samuele Peduzzi
         * @brief Dichiarazione del primo thread
         */
        Semaforo sem = new Semaforo(1);
        
        
        JDadoTh d1 = new JDadoTh(false, false, 1, dC, sem);
        /**
         * @author Samuele Peduzzi
         * @brief Dichiarazione del secondo thread
         */
        JDadoTh d2 = new JDadoTh(false, false, 2, dC, sem);
        /**
         * @author Samuele Peduzzi
         * @brief Dichiarazione del terzo thread
         */
        JDadoTh d3 = new JDadoTh(false, false, 3, dC, sem);
        
        JVisualizzaTh vis = new JVisualizzaTh(sem , dC);

        d1.start();
        d2.start();
        d3.start();
        vis.start(); 
        
        System.in.read();
        
        if (d1.isAlive())
            d1.interrupt();
        if (d2.isAlive())
            d2.interrupt();
        if (d3.isAlive())
            d3.interrupt();

        if (vis.isAlive())
            vis.interrupt();
        

    }

}
