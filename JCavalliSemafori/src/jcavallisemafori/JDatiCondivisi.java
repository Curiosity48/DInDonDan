/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcavallisemafori;

import java.util.Vector;

/**
 *
 * @author Samuele Peduzzi
 */
public class JDatiCondivisi {
    
    Vector v;

    public JDatiCondivisi(Vector v) {
        this.v = v;
    }

    public JDatiCondivisi() {
        v = new Vector(1,1);
    }
    
    
    
    public String getLast() {
        
        return (String)v.lastElement();
    }
    public void push(String verso)
    {
        v.add(verso);
    }
    
    
    
}
