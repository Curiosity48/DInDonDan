/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eselotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuele Peduzzi
 */
public class EseLotto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        try {
            // TODO code application logic here
            BufferedReader in;
            JDatiCondivisi dC = new JDatiCondivisi();
            
            JEstrattoreTh estrattore;
            JContatoreTh contatoreUno;
            JContatoreTh contatoreDue;
            
            int numEstrazioni;
            int numUno, numDue;
            int numRuoteVincenti;
            
            in = new BufferedReader(new InputStreamReader(System.in));
            
            do {
                System.out.println("Quante estrazioni si desidera simulare ?");
                numEstrazioni = Integer.parseInt(in.readLine());
            } while (numEstrazioni <= 0);
            
            estrattore = new JEstrattoreTh(numEstrazioni, dC);
            
            do {
                System.out.println("Inserisci il primo numero da cercare");
                numUno = Integer.parseInt(in.readLine());
            } while (numUno <= 0);
            
            contatoreUno = new JContatoreTh(numUno, true, dC);
            
            do {
                System.out.println("Inserisci il secondo numero da cercare");
                numDue = Integer.parseInt(in.readLine());
            } while (numDue <= 0);
            
            contatoreDue = new JContatoreTh(numDue, false, dC);
            
            estrattore.start();
            contatoreUno.start();
            contatoreDue.start();
            
            estrattore.join();
            contatoreUno.join();
            contatoreDue.join();
            
            if(estrattore.isAlive())
                estrattore.interrupt();
            if(contatoreUno.isAlive())
                contatoreUno.interrupt();
            if(contatoreDue.isAlive())
                contatoreDue.interrupt();
            
            System.out.println(dC.ruoteToString());
            
            numRuoteVincenti = dC.getNumRuoteVincenti();
            
            
            
            if(numRuoteVincenti > 0)
                System.out.println("Hai vinto ! Numero di ruote vincenti --> " + numRuoteVincenti);
            else 
                System.out.println("Hai perso ! Nessuna ruota vincente");
            
            
            
            
        } catch (InterruptedException ex) {
            Logger.getLogger(EseLotto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
