/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perfectnumbermultithread;

/**
 *
 * @author cagataycali
 */
public class Sum {

    public Sum (int number) {
        this.sum = 0;
        this.number = number;
        this.perfect = false;
    }
    int sum;
    int number;
    boolean perfect;
    
    boolean debug = false;
    
    public void add (int var) {
        if (this.debug) {
            System.out.println("[SUM ADD] " + var);
        }
        if (var != 0 && this.number % var == 0) {
            this.sum += var;
        }
    }
    
    public boolean check () {
        if (this.debug) {
            System.out.println("[SUM CHECK] number: " + this.number + " this.sum: " + this.sum + " RESULT: " + (this.number == this.sum));
        }
        return this.perfect == false && this.number == this.sum;
    }
    
    public void setPerfect () {
        this.perfect = true;
    }
   
    public boolean isPerfect () {
        return this.perfect;
    }
}
