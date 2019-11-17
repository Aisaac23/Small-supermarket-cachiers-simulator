/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StacksAndQueues;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author isaac.huerta
 */
/*********** Programming Projects: 4.5 ***********************/

public class SuperMarket extends Thread {

    private final int Ncashiers = 8;
    private final int custPerLine = 20;
    private final int hrs = 15*1000*60*60;
    private long secs;
    private final Queue[] lines;
    private final Thread[] checkers;
    private boolean closing;
    private final long NewCustTime = 1000*5;
    private final long groceryPass = 1000;
    private final long maxGroceries = 200;
    private final long otherTransac = 1000*60*2;
    
    public SuperMarket(String string) {
        super(string);
        secs = 0;
        this.lines = new Queue[Ncashiers];
        closing = false;
        this.checkers = new Thread[Ncashiers];
    }

    @Override
    public void run() {
       
        for (int i = 0; i < Ncashiers; i++) 
        {
            final int index;
            
            index = i;
            lines[i] = new Queue(this.custPerLine); //queues
            checkers[i] = new Thread() //cashiers
            {
                @Override
                public void run() {
                    while(true)
                    {
                        if( !lines[index].isEmpty() )
                            try {
                                /**The thread waits as it simulates the cashier chargin the current customer, 
                                 then it removes it.**/
                                Thread.sleep(lines[index].peekFront() * groceryPass + otherTransac );
                                System.out.println("From checker " + index + " Removing: " + lines[index].remove());
                             
                            } catch (InterruptedException ex) {
                                Logger.getLogger(SuperMarket.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        else
                            try 
                            {
                                /**The cashier waits for the arrival of a new customer if the current queue is empty **/
                                Thread.sleep(NewCustTime);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(SuperMarket.class.getName()).log(Level.SEVERE, null, ex);
                            }
                    }
                }
                
            };
            checkers[i].start();
        }
            int best; 
            long groseries;
            
            while(!closing)
            {
                best = this.pickTheBest();
                if( !this.lines[best].isFull() )
                {    
                    secs+=5;
                    groseries = (long)(Math.random()*this.maxGroceries) + 1 ;//Queuing customers with random amount of groceries
                    this.lines[best].insert( groseries );
                    System.out.println("Checker " + best + ": " + groseries);//displays where the last customer has queued

                    for (int i = 0; i < this.Ncashiers; i++)
                        if(!lines[i].isEmpty())
                            this.lines[i].displayQueue();
                    closing = secs>hrs;
                }

                    
            }
    }

/*With this function customer decides which line is the best to queuing
    by picking the one with the lowest amount of customers queued*/
    private int pickTheBest()
    {
        int temp = this.lines[0].size(), pos = 0;
        
        for (int i = 0; i < this.lines.length; i++)
            if(this.lines[i].size() < temp)
            {
                temp = this.lines[i].size();
                pos = i; 
            }
        return pos;
    }   
}
/*****************************************************************/