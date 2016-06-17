package javalab;


/**
 * Write a description of class Complejo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Complejo
{
    // instance variables - replace the example below with your own
    private Numero real;
    private Numero img;
    
    

    /**
     * Constructor for objects of class Complejo
     */
    public Complejo(Numero r , Numero i)
    {
        this.real = r;
        this.img = i;
        
    }

    
    
    public Numero getReal(){
        return this.real;
    }
    
    
    public Numero getImaginario(){
        return this.img;
    }
    
    public Complejo sumar(Complejo c){
        return  new Complejo(c.real.sumar(this.real), c.img.sumar(this.img));
        
    }
    
    public Complejo restar(Complejo c ){
        return  new Complejo(c.real.restar(this.real), c.img.restar(this.img));
    }
    
    //public Complejo dividir(){
    
    //}
    
    
    public Complejo multiplicar(Complejo c){
        
        // (A + Bi)* (C + Di)  =
        // AC -BD  , AD + CB
        
        Numero ac =  c.real.multiplicar(this.real);
        Numero bd = (c.img == this.img)?new Numero(c.img.getValor()*this.img.getValor()* -1): this.img.multiplicar(c.img);
        
        Numero ad = this.real.multiplicar(c.img);
        Numero cd = this.img.multiplicar(c.real);
        
        Complejo result = new Complejo(ac.restar(bd), ad.sumar(cd));
        return result;
    }
    
    @Override
    public boolean equals(Object obj){
        return false;
    }
   
     
    @Override
    public String toString() {
         return "("+this.real+", "+this.img+"i)"; 
     }
    
}
