package assignment;

/**
 *
 * @author D.Tea 15909644
 * Main.java is the main class, which sets all the arguments and creates the buffer and instantiates
 * the producer and consumer objects as threads. Sleeps for how long the sleep argument input is,
 * then stops the program.
 */
public class Main {
    
    public static void main(String[] args) throws InterruptedException { 

        int sleepTime = 0;
        int producers = 0;
        int consumers = 0;
        
        try { // Getting main arguements
            sleepTime = Integer.parseInt(args[0]) * 1000; // 10,000 ms = 10 secs, converting to seconds
            producers = Integer.parseInt(args[1]); // How many producers to create
            consumers = Integer.parseInt(args[2]); // How many consumers to create
        } catch (NullPointerException npe) {
            System.out.println(npe.getMessage());
        } catch (NumberFormatException nfe) {
            System.out.println(nfe.getMessage());
        }

        Buffer buffer = new Buffer(); // Instantiate buffer

        for (int i = 0; i < producers; ++i) { // For loop for creating producer threads in reference to main arguments
            Producer pro = new Producer(buffer);
            Thread producer = new Thread(pro);
            producer.start();
        }
        for (int i = 0; i < consumers; ++i) { // For loop for creating consumer threads in reference to main arguments
            Consumer con = new Consumer(buffer);
            Thread consumer = new Thread(con);
            consumer.start();
        }

        try {
            Thread.sleep(sleepTime); // Sleep for how ever long the sleep time is
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

        System.exit(0); // After sleep time is up, program will exit.
    }
}
