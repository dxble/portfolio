package assignment;

import java.util.Random;

/**
 *
 * @author D.Tea 15909644
 * Consumer.java creates a consumer object, which randomly sleeps between 1MS and 1000MS,
 * and prints out the information if removing item from the buffer is successful.
 */
public class Consumer implements Runnable {

    public Buffer buffer;
    public Random rn;
    public int randNumSleep = 1;
    public BufferItem item;
    public long threadId;

    public Consumer(Buffer buffer) { // Constructor
        this.buffer = buffer;
        rn = new Random();
    }

    public void run() { // Run for thread to call when starts

        while (true) {
            randNumSleep = rn.nextInt(1000) + 1; // Between 1 and 1000

            try {
                Thread.sleep(randNumSleep); // Sleeps
            } catch (InterruptedException ex) {
                System.out.print(ex.getMessage());
            }

            item = buffer.remove_item(); // Calls remove item method to return removed item or null

            if (item == null) {   // In buffer class it said to take in a buffer_item
                System.out.println("error CONSUMER~~~~~~~~~~~~~~~~~~~~~"); // but in producer class example, it shows imputing a random number
            } else {                                  // into the insert_item... *****************************
                threadId = Thread.currentThread().getId();
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Consumer [" + threadId + "] consumed: " + item);
                System.out.println("The buffer now contains " + buffer.size + " items");
                buffer.bufferToString(); // Print buffer array
            }
        }
    }
}
