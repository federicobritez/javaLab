package javalab;


/**
 * 
 * Clase Numero con operacione basicas sobre valores enteros;
 * 
 * @author (Federico Britez) 
 * @version (10/06/2016)
 */
public class Numero
{
    // Atributo implementado con un entero primitivo
    private int valor;

    /**
     * Constructor 
     */
    public Numero(int valor)
    {
  
        this.valor = valor;
    }
    
    
    public void setValor(int v){
        valor = v;
    }
    
    
    public int getValor(){
        return valor;
    }
    
    
   // Operaciones básicas
    
    public Numero sumar(Numero n){
        Numero res = new Numero(this.valor + n.valor);
        return res;
    }
    
    
    public Numero restar(Numero n){
        Numero res = new Numero(this.valor - n.valor);
        return res;
    }
    
    
    public Numero dividir(Numero n){
        Numero  res = new Numero((this.valor / n.valor));
        return  res;
    }
    
    
      public Numero multiplicar(Numero n){
        Numero  res = new Numero((int)(this.valor * n.valor));
        return  res;
    }
    
    
    // Calcula el factorial del numero
    
    public Numero factorial(){
        
        //Si es negativo lanza una excepción
        if(this.valor < 0){
            throw new RuntimeException("No se puede caluclar el factorial de numero negativo : " + this.valor);
        }
        Numero  res = new Numero(1); //El factorial de 0  es 1 :D
        
        for(int i=1; i <= this.valor; i++){
            res.valor *= i;
        }
        return res;
    }
    
    
    // Verifica si el numero es primo
    
    public boolean esPrimo(){
            
        int i = 2;
        int valAux = Math.abs(this.valor);  // Tomo el valor absoluto
        int raiz = (int)Math.sqrt(valAux);  // La raiz cuadrada del numero es mi cota. 
        
        if ( (valAux == 1 )|| (valAux == 0) ) return false;
        
        while( i <= raiz ){
            if(valAux % i == 0){
                return false;  //hay numero en el intervalo [i - raiz] que divide al numero, NO es primo
            }
            i++;
        }
        return true;
    }
    
    
    // Calcula el Minimo Común Divisor contra otro número
    
    public Numero mcd(Numero otro){
        if((this.valor == 0 )|| (otro.valor == 0)){ 
            throw new RuntimeException("NO existe MDC para.. ");
        }
        
        int a = Math.abs(this.valor), b = Math.abs(otro.valor);
        
        while(a != b){
            if(a > b) a-=b;
            else b-=a;
        }
        return new Numero(b);
    }
    
    
    //  Calcula el Máximo Común Divisor
    
    public Numero mcm(Numero otro){
        if((this.valor == 0 )|| (otro.valor == 0)){ 
            throw new RuntimeException("NO existe MDC para.. ");
        }
        
        int mcm = 0;
        int a = Math.max(this.valor, otro.valor);
        int b = Math.min(this.valor, otro.valor);
        Numero mcd = this.mcd(otro);
        mcm = (a/mcd.valor)*b;
        return new Numero(mcm);
       
       
    }
    
    public Numero elevar(Numero e){
        return new Numero(this.valor ^ e.valor);
    }
    
    public boolean esNegativo(){
        return (this.valor < 0);
    }
    
    
    public String mostrarBinario(){
        
        // Int de java es 32 bits , pero si no importa el signo necesito 31 posiciones. 
        char[] bin= new char[31]; //Arreglo de caracterres para la cadena binaria
        char[] signedBin= new char[32];
        int aux2 = this.valor;
        int aux = this.valor;
  
        //Inferir el resultado usando desplazamiento de bits y mascaras. 
        for(int i = 31 ; i >= 0 ; i--){
            if((aux & 1) == 1) bin[i]='1';
            else bin[i]='0';
            aux = aux >> 1;  //Desplazo a la deracha
        }
        
        return String.valueOf(bin);
    }

    
    @Override 
    public boolean equals(Object obj){
        if(obj != null && obj instanceof Numero ){
            Numero nObj = (Numero)obj;
            return (nObj.valor == this.valor);  //Puedo acceder al valor privado porque estoy en la misma  clase. 
        }
        return false;
    }
    
    
    @Override
    public int hashCode(){
        return this.valor;  
    }
    
    
    @Override
    public String toString(){
        return String.valueOf(valor);
    }
}
