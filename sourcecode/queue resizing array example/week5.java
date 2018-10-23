/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week5labs;

/**
 *
 * @author D.Tea 15909644
 */
public class week5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayQueue<Character> queue = new ArrayQueue<Character>();
        
        char a = 'A';
        char b = 'B';
        char c = 'C';
        
        queue.enqueue('a');
        queue.enqueue('b');
        queue.enqueue('c');
        queue.enqueue('d');
        queue.enqueue('e');
        queue.enqueue('f');
        queue.enqueue('g');
        queue.enqueue('h');
        System.out.println(queue.toString());
        queue.dequeue();
        System.out.println(queue.toString());
        queue.dequeue();
        System.out.println(queue.toString());
        queue.dequeue();
        System.out.println(queue.toString());
        queue.dequeue();
        System.out.println(queue.toString());
        queue.enqueue('a');
        queue.enqueue('b');
        queue.enqueue('c');
        System.out.println(queue.toString());
        queue.dequeue();
        System.out.println(queue.toString());
        queue.dequeue();
        System.out.println(queue.toString());
        queue.dequeue();
        System.out.println(queue.toString());
        queue.dequeue();
        System.out.println(queue.toString());
        queue.dequeue();
        System.out.println(queue.toString());
        queue.enqueue('a');
        queue.enqueue('b');
        queue.enqueue('c');
        queue.enqueue('d');
        queue.enqueue('e');
        System.out.println(queue.toString());
        queue.enqueue('f');
        System.out.println(queue.toString());
        queue.enqueue('f');
        System.out.println(queue.toString());
        
        queue.enqueue('a');
        queue.enqueue('b');
        queue.enqueue('c');
        queue.enqueue('a');
        queue.enqueue('b');
        queue.enqueue('c');
        queue.enqueue('a');
        queue.enqueue('b');
        queue.enqueue('c');
        queue.enqueue('a');
        queue.enqueue('b');
        queue.enqueue('c');
        
        System.out.println(queue.toString());
        
        
    }
    
}
