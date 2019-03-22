/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esestatistiche;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author peduzzi_samuele
 */
public class EseStatistiche {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        
        //Dati condivisi 
        BufferedReader in;
        JDatiCondivisi dC = new JDatiCondivisi();
        JCharGeneratorTh charGenerator;
        JContatoreTh contaPunti, contaSpazii;
        JVisualizzaTh monitor = new JVisualizzaTh(dC);
        int numChar;
        
        in = new BufferedReader(new InputStreamReader(System.in));
        
        do {
            System.out.println("Quanti caratteri si desidera generare ?");
            numChar =  Integer.parseInt(in.readLine());
        } while(numChar <= 0);
        

        
        charGenerator = new JCharGeneratorTh(numChar, dC);
        contaSpazii = new JContatoreTh(dC, true);
        contaPunti = new JContatoreTh(dC, false); 
        
        charGenerator.start();
        contaSpazii.start();
        contaPunti.start();
        monitor.start();
        
        
        charGenerator.join();
        contaSpazii.join();
        contaPunti.join();
//        monitor.join();
        
        if(charGenerator.isAlive())
            charGenerator.interrupt();
        if(contaSpazii.isAlive())
            contaSpazii.interrupt();
        if(contaPunti.isAlive())
            contaPunti.interrupt();
        if(monitor.isAlive())
            monitor.interrupt();
        
        
        if(dC.getNumPuntiInseriti() == dC.getNumPuntiLetti() 
                && dC.getNumSpaziInseriti() == dC.getNumSpaziLetti())
            System.out.println("I valori letti e inseriti corrispondono !!");
        
        else
            System.out.println("Attenzione !! I valori non corrispondono !!");
        
        
        System.out.println("Spazii inseriti " + dC.getNumSpaziInseriti());
        System.out.println("Spazii letti " + dC.getNumSpaziLetti());
        
        System.out.println("Punti inseriti " + dC.getNumPuntiInseriti());
        System.out.println("Punti letti " + dC.getNumPuntiLetti());
        
    }
    
}
