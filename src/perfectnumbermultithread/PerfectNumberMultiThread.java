/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perfectnumbermultithread;

import java.util.concurrent.Semaphore;

/**
 *
 * @author cagataycali
 */
public class PerfectNumberMultiThread {
    public static void main(String[] args) {
        

        int number = 28;
        int threadCount = 12;
        int zero = 1;
        int incr = (int) Math.round((number ) / threadCount);
        Sum summary = new Sum(number);
        Semaphore mutex = new Semaphore(1);
        Thread thread = null;
        for (int i = 0; i <= threadCount; i++) {
           thread = new Thread(new PerfectThread(zero, zero + incr, mutex, summary));
           thread.start();
           zero += incr;
        }
    }
}
