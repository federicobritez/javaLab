package javalab;


/**
 * Write a description of class TestFraccion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestFraccion
{
    public static void main(String asdfadsfsd[]){
        
        /*
         * 4/5 + 6/3   = 42/15  (simplificado)=> 14/5;
        */
        Fraccion f1 = new Fraccion(new Numero(4), new Numero(5));
    
        Fraccion f2 = new Fraccion(new Numero(6), new Numero(3));
        
        Fraccion res = f1.sumar(f2);
        
        System.out.println(res);
    }
}
