/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdadi;

/**
 * @author Samuele Peduzzi
 * @brief Classe per la gestione dei sati condivisi.
 */
public class JDatiCondivisi {

    //Attributi
    /**
     * @author Samuele Peduzzi
     * @brief Valore primo dado.
     */
    private int val0;
    /**
     * @author Samuele Peduzzi
     * @brief Valore del secondo dado.
     */
    private int val1;
    /**
     * @author Samuele Peduzzi
     * @brief Valore del terzo dado.
     */
    private int val2;

    //Metodi 
    
    /**
     * @author Samuele Peduzzi
     * @brief Costruttore vuoto.
     */
    public JDatiCondivisi() {

        val0 = 0;
        val1 = 0;
        val2 = 0;
    }
    
    /**
     * @author Samuele Peduzzi
     * @return restituisce il valore del primo dado
     */
    public synchronized int getVal1() {
        return val0;
    }
    /**
     * @author Samuele Peduzzi
     * @return restituisce il valore del secondo dado
     */
    public synchronized int getVal2() {
        return val1;
    }
    /**
     * @author Samuele Peduzzi
     * @return restituisce il valore del terzo dado
     */
    public synchronized int getVal3() {
        return val2;
    }
    /**
     * @author Samuele Peduzzi
     * @param val0
     * @brief permette di impostare il valore del primo dado.
     */
    public synchronized void setVal1(int val0) {
        this.val0 = val0;
    }
    /**
     * @author Samuele Peduzzi
     * @param val1
     * @brief permette di impostare il valore del secodno dado.
     */
    public synchronized void setVal2(int val1) {
        this.val1 = val1;
    }
    /**
     * @author Samuele Peduzzi
     * @param val2
     * @brief permette di impostare il valore del terzo dado.
     */
    public synchronized void setVal3(int val2) {
        this.val2 = val2;
    }

    @Override
    public String toString() {
        return val0 + "/" + val1 + "/" + val2;
    }

}
