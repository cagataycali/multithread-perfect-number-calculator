/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perfectnumbermultithread;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cagataycali
 */
public class PerfectThread implements Runnable {
    
    int start;
    int end;
    Sum sum;
    
    Semaphore mutex;

    public PerfectThread (int start, int end, Semaphore mutex, Sum sum) {
        this.start = start;
        this.end = end;
        this.mutex = mutex;
        this.sum = sum;
    }
 
 
    @Override
    public void run () {
        try {
            mutex.acquire();
            // System.out.println("bu thread " + start + " ile " + (end) + " arasında çalışacak");
            for (int i = start; i < end; i++) {
                sum.add(i);
                if (sum.check()) {
                    System.out.println("Mükemmel sayı");
                    sum.setPerfect();
                    break;
                } 
            }
            mutex.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(PerfectThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
