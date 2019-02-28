/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dindondansemafori;

import java.util.Vector;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Samuele Peduzzi
 */
public class JDatiCondivisi {

    private Vector v;
    private Semaphore sem1;
    private Semaphore sem2;
    private Semaphore sem3;
    private Semaphore sem4;
    private Semaphore sem5;

    public JDatiCondivisi() {

        v = new Vector(1, 1);
        sem1 = new Semaphore(1);
        sem2 = new Semaphore(0);
        sem3 = new Semaphore(0);
        sem4 = new Semaphore(0);
        sem5 = new Semaphore(1);
    }

    public synchronized String getLast() {
        if (v.isEmpty()) {
            return "";
        }
        return (String) v.lastElement();
    }

    public void push(String suono) throws InterruptedException {
//        System.out.println(suono);
        aquire(5);
        v.add(suono + "\n");
        release(4);
    }

    public void aquire(int numSem) throws InterruptedException {
        switch (numSem) {
            case 1:
                sem1.acquire();
                break;
            case 2:
                sem2.acquire();
                break;
            case 3:
                sem3.acquire();
                break;
            case 4:
                sem4.acquire();
                break;
            case 5:
                sem5.acquire();
                break;
            default:
                break;
        }
    }

    public void release(int numSem) {
        switch (numSem) {
            case 1:
                sem1.release();
                break;
            case 2:
                sem2.release();
                break;
            case 3:
                sem3.release();
                break;
            case 4:
                sem4.release();
                break;
            case 5:
                sem5.release();
                break;
            default:
                break;
        }
    }

}
