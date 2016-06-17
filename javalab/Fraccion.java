package javalab;


/**
 * Clase Fraccion, abtrae una fracción compuesta por dos objetos Numero
 * 
 * @author (Federioc Britez) 
 * @version (10/06/2016)
 */
public class Fraccion
{
    
    //Atributos
    private Numero numerador;
    private Numero denominador;

    /**
     * Constructor a partir de dos objetos numero
     */
    public Fraccion(Numero n , Numero d)
    {   
        this.numerador = n;
        this.denominador = d;
        
    }
    
    
    /**
     * Constructor sobreacargado a partir de dos enteros primitivos
     */
    public Fraccion(int n, int d){
        this.numerador = new Numero(n);
        this.denominador = new Numero(d);
    }
    
    public Numero getNumerador(){
        return this.numerador;
    }
    
    public Numero getDenominador(){
        return this.denominador;
    }

    public Fraccion sumar(Fraccion f){
        Numero mcm = this.denominador.mcm(f.denominador);
        System.out.println("Mcm :" + mcm.toString());
        Numero num = this.numerador.multiplicar(mcm.dividir(this.denominador)).sumar(f.numerador.multiplicar(mcm.dividir(f.denominador)));
        Numero denom = mcm;
        return new Fraccion(num , denom );
    }
    
    public Fraccion restar(Fraccion f){
        Numero mcm = this.denominador.mcm(f.denominador);
        Numero num = this.numerador.multiplicar(mcm.dividir(this.numerador)).restar(f.numerador.multiplicar(mcm.dividir(this.denominador)));
        Numero denom = mcm;
        return new Fraccion(num , denom );
    }
    
    public Fraccion multiplicar(Fraccion f){
        return new Fraccion(this.numerador.multiplicar(f.numerador),
                            this.denominador.multiplicar(f.denominador));
    }
    
     public Fraccion dividir(Fraccion f){
        return this.multiplicar(f.invertido());
    }
    
    public Fraccion elevar(Numero e){
        return  new Fraccion(this.numerador.elevar(e), this.denominador.elevar(e));
        
    }
    
    public Fraccion invertido(){
        return new Fraccion(this.denominador, this.numerador);
    }

    public boolean esNegativo(){
        return (this.numerador.esNegativo()) ^ (this.denominador.esNegativo());
    }
    
        @Override
    public String toString(){
        
        int c = this.numerador.mcd(this.denominador).getValor(); 
        int n = Math.abs(this.numerador.getValor()) / c ;
        int d = Math.abs(this.denominador.getValor()) / c;
        
        //Si es negativo colocamos el signo - depante de la cadena
        return (this.esNegativo())?"-":""+ n + "/" + d; 
    }
    
    
    
    
    
    
}
