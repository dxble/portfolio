package assignment;

import java.util.Random;

/**
 *
 * @author D.Tea 15909644
 * Producer.java creates a producer object, which randomly sleeps between 1MS and 1000MS,
 * and prints out the information if inserting into the buffer is successful.
 */
public class Producer implements Runnable{
    
    public Random rn;
    public int randNumSleep = 1;
    public int randMax = 20;
    public BufferItem item;
    public long threadId;
    Buffer buffer;
    
    public Producer(Buffer buffer){ // Constructor
        this.buffer = buffer;
        rn = new Random();
    }
    
    public void run(){ // Run for thread to call when starts
        
        while(true){
            randNumSleep = rn.nextInt(1000) + 1; // Between 1 and 1000
            
            try {
                Thread.sleep(randNumSleep); // Sleeps
            } catch (InterruptedException ex) {
                System.out.print(ex.getMessage());
            }
            
            item = new BufferItem(rn.nextInt(randMax) + 1); // Create value for item object
        

            if(!buffer.insert_item(item)){  // In buffer class it said to take in a buffer_item
                System.out.println("error PRODUCER~~~~~~~~~~~~~~~~~~~~~"); // but in producer class example, it shows imputing a random number
            }else{                                 // into the insert_item... *****************************
                threadId = Thread.currentThread().getId();
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Producer [" + threadId + "] produced: " + item);
                System.out.println("The buffer now contains " + buffer.size + " items");
                buffer.bufferToString(); // Print buffer array             
            }
        }   
    }
}
