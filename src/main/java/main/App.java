package main;

import dataStructure.LinkedList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        LinkedList list = new LinkedList("Elemento 1");
        list.append("Elemento 2");
        list.append("Elemento 3");
        list.prepend("Elemento 0");
     
        list.remove(2);
        list.print();
    
    
        // list.insert(3, "elemento 2.5");
        // list.print();
    
        // list.set(1, "elemento 0.5");
        // list.print();
    
    
        // System.out.println(list.get(2).data);
    
        // System.out.println(list.removeFirst().data);
        // list.print();
        
        // list.getHead();
        // list.getTail();
        // list.getLength();
        // list.print();
    }
}
