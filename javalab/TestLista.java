package javalab;

import java.util.LinkedList;


/**
 * Write a description of class TestLista here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestLista
{  
    public static void main(String args[]){
        
        LinkedList<Numero> list = new LinkedList<Numero>();
        list.add(new Numero(2));
        list.add(new Numero(4));
        list.add(new Numero(9));
        list.add(new Numero(22));
        
        TestLista.listar(list);
        
    }
    
    
    public static void listar(Iterable<Numero> iter){
        System.out.println("Listar valores");
        
        for(Numero n : iter){
            System.out.println(n);
        }
    
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    
    
}
