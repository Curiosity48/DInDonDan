/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esestatistiche;

import java.util.Random;

/**
 *
 * @author peduzzi_samuele
 */
public class JCharGeneratorTh extends Thread{
     
    private int numCaratteri;
    private String charDictionary;
    private JDatiCondivisi dC;

    private char getRandomChar()
    {
        Random rn = new Random();
        int randomIndex = rn.nextInt(charDictionary.length());
        
        return charDictionary.toCharArray()[randomIndex];
    }
    
    public JCharGeneratorTh(int numCaratteri, JDatiCondivisi dC) {
        this.numCaratteri = numCaratteri;
        dC = new JDatiCondivisi();
        charDictionary = ". abcdefghilmnopqrstuvz0123456789";
    }
    
    @Override
    public void run()
    {
        for (int i = 0; i < numCaratteri; i++) {
            dC.pushChar(getRandomChar());
            
            if (getRandomChar() == '.') 
                dC.incnumPuntiInseriti();
            else if (getRandomChar() == ' ')
                dC.incnumSpaziInseriti();     
        }
    }
    
    
    
    
    
    
}
