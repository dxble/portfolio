package week5labs;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

/**
 *
 * @author D.Tea 15909644
 */
public class ArrayQueue<E> implements QueueADT<E> {

    private int numElements;
    private int firstIndex;
    private int lastIndex;
    private E[] elements;
    private final int INITIAL_SIZE = 8;

    public ArrayQueue() {
        elements = (E[]) new Object[INITIAL_SIZE];
        numElements = INITIAL_SIZE;
        firstIndex = 0;
        lastIndex = 0;
    }

    // adds one element to the rear of this queue
    public void enqueue(E element) {
        int size = 0;
        for (E i : elements) {
            if (i != null) {
                size++;
            }
        }   
        if (size+1 > elements.length) {
            System.out.println("Full");
            elements = extendQueue();
        }
        
        if (lastIndex >= elements.length) {
            lastIndex = 0;
        }

        elements[lastIndex] = element;
        lastIndex++;
    }

    // removes and returns the front element of the queue
    public E dequeue() throws NoSuchElementException {
        E returned = elements[firstIndex];
//        while (true) {
        elements[firstIndex] = null;
        firstIndex++;
        if (firstIndex >= elements.length) {
            firstIndex = 0;
        }

        return returned;
    }

    // returns without removing the front element of this queue
    public E first() throws NoSuchElementException {
        return elements[firstIndex];
    }

    // returns true if this queue contains no elements
    public boolean isEmpty() {
        for (E i : elements) {
            if (i != null) {
                return false;
            }
        }

        return true;
    }
    
    // returns the number of elements in this queue
    public int size() {
        return numElements;
    }

    public String toString() {
        String string = "[";
        for (int i = 0; i < elements.length; ++i) {
            if (elements[i] != null) {
                string += elements[i].toString();
            } else {
                string += "null";
            }

            if (i < elements.length - 1) {
                string += ", ";
            }

        }
        string += "]";
        return string + firstIndex;
    }
    
    public E[] extendQueue() {
        numElements *= 2;
        
        E[] newArray = (E[]) new Object[numElements];
        for (int i = 0; i < elements.length; ++i) {
            newArray[i] = elements[firstIndex];
            firstIndex++;
            if (firstIndex >= elements.length) {
                firstIndex = 0;
            }       
        }
        
        firstIndex = 0;
        lastIndex = elements.length;
        
        return newArray;   
    }
}
