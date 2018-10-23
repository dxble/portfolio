package assignment;

import java.util.Arrays;
import java.util.concurrent.Semaphore;
import static assignment.Constant.BUFFER_SIZE;

/**
 *
 * @author D.Tea 15909644 Buffer.java constructs the buffer, and handles the
 * insert_item and remove_item methods. The semaphores control the insert and
 * remove methods.
 */
public class Buffer {

    public BufferItem buffer[]; //[] = new Buffer_Item[BUFFER_SIZE];
    public int head, tail;
    public int size; // Size variable to check if buffer is full
    public Semaphore mutex; // Lock when aquire and unlock when released
    public Semaphore empty;
    public Semaphore full;

    public Buffer() { // Constructor for buffer
        buffer = new BufferItem[BUFFER_SIZE];

        empty = new Semaphore(BUFFER_SIZE); // Empty has buffer size at start
        mutex = new Semaphore(1);
        full = new Semaphore(0); // Full has 0 at start

        size = 0;
        head = -1; // Start at -1, because when inserting item, head++ to 0 
        tail = 0;
    }

    public boolean insert_item(BufferItem item) { // Insert item by calling method parsing in item
        boolean insertBool = false;

        try {
            // Insert item into buffer
            empty.acquire(); // Acquiring one empty, empty--
            mutex.acquire(); // Acquring mutex, sets to 0

        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

        if (size < BUFFER_SIZE) {
            head++;
            if (head >= BUFFER_SIZE) {
                head = 0; // Circular array, setting heard to 0 when reaches buffer size limit
            }
            //System.out.println(item); // Prints item
            buffer[head] = item; // Stores item in buffer at index head
            size++; // When storing item, increase size
            insertBool = true;
        }

        mutex.release(); // Release mutex, sets to 1
        full.release(); // Release full, full++
        return insertBool; // Return true if insert item worked, else return false
    }

    public BufferItem remove_item() { // Removing item by calling method 
        BufferItem remove = null;
        try {
            full.acquire();
            mutex.acquire();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

        if (size > 0) { // If size is bigger than 0, buffer is not empty
            remove = buffer[tail]; // Stores removed item first
            buffer[tail] = null; // Set buffer index tail to null
            tail++; // Circular array, tail moves up after removing item
            if (tail >= BUFFER_SIZE) { // When tail is equal to buffer size, it is at the limit, therefore set to 0
                tail = 0;
            }
            size--; // When removing item, minus size
        }

        mutex.release();
        empty.release();
        return remove; // If remove item successful, return removed item, if not retturn null
    }

    public void bufferToString() { // Printing buffer array
        System.out.println(Arrays.toString(buffer));
    }
}
