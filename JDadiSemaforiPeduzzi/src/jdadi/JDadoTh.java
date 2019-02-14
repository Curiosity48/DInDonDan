/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdadi;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Samuele Peduzzi
 * @brief Classe per la gestione del thread dado.
 */
public class JDadoTh extends Thread {

    /**
     * @author Samuele Peduzzi
     * @brief variabile int contenente il valore random del dado.
     */
    private int valDado;
    /**
     * @author Samuele Peduzzi
     * @brief bool che memorizza la presenza o l'assenza dello yeld.
     */
    private boolean usaYield;
    /**
     * @author Samuele Peduzzi
     * @brief bool che memorizza la presenza o l'assenza del Delay.
     */
    private boolean usaDelay;
    /**
     * @author Samuele Peduzzi
     * @brief int che memorizza il numero del dado.
     */
    private int numDado;
    
    /**
     * @author Samuele Peduzzi
     * @brief variabile che fungerà da puntatore all'oggrtto di tipo JDatiCondivisi nel main.
     */
    private JDatiCondivisi dCond;
    
    private Semaforo sem;
    
    
    
    
    /**
     * @author Samuele Peduzzi
     * @brief Costruttore vuoto.
     */
    public JDadoTh() {
        super();
        usaYield = false;
        usaDelay = false;
        numDado = 1;
        
    }
    /**
     * @author Samuele Peduzzi
     * @brief Costruttore con parametri.
     */
    public JDadoTh(boolean yield, boolean delay, int numDado, JDatiCondivisi dCond, Semaforo sem) {
        super();
        this.usaYield = yield;
        this.usaDelay = delay;
        
        this.numDado = numDado;

        this.dCond = dCond;
        
        this.sem = sem;

        
    }

    /**
     * @author Samuele Peduzzi
     * @brief Override del metodo run, permette di calcolare un numero random da
     * 1 a 6 e stamparlo in output.
     */
    @Override
    public void run() {

        try {
            while (!isInterrupted()) {

                

                valDado = (int) (1 + (Math.random() * 6));
//                System.out.println("Il dado " + numDado + " ha restituito il valore --> " + valDado);

                

                switch (numDado) {
                    case 1:
                        sem.Wait();
                        dCond.setVal1(valDado);
                        sem.Signal();
                        break;
                    case 2:
                        sem.Wait();
                        dCond.setVal2(valDado);
                        sem.Signal();
                        break;
                    case 3:
                        sem.Wait();
                        dCond.setVal3(valDado);
                        sem.Signal();
                        break;
                    default:
                        break;
                }

                if (usaYield) {
                    yield();
                }

                if (usaDelay) {
                    sleep((int) (0 + (Math.random() * 100)));
                }
            }
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }

    }

}
