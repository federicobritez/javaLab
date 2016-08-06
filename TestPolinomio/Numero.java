package matematicas.nueva;

public class Numero implements Comparable<Numero>{
    private int valor;
    
    public Numero(int valor){
        this.setValor(valor);
    }
    public Numero(Numero nro){
    	this(nro.valor);
    }
    public void setValor(int valor){
        this.valor = valor;
    }
    public int getValor(){ return this.valor; }
    @Override
    public boolean equals(Object obj){
        if (obj==null) return false;
        if (!(obj instanceof Numero)) return false;
        Numero n = (Numero) obj;
        return this.valor == n.valor;
    }
    @Override
    public int hashCode(){
        return this.valor;
    }
    public Numero mcd(Numero otro){
        if ((this.valor == 0)||(otro.valor == 0)) throw new RuntimeException("No existe el mcd para: "+this.valor+" y "+otro.valor);
        int a = Math.abs(this.valor),
            b = Math.abs(otro.valor);
        while (a != b){
            if (a > b) a -= b;
            else b -= a;
        }
        return new Numero(a);
    }
    public Numero mcm(Numero otro){
    	return new Numero((this.multiplicar(otro)).dividir(this.mcd(otro)));
    }
    public Numero abs(){
        return new Numero(Math.abs(this.valor));
    }
    public Numero negado() {
    	return new Numero(-this.valor);
    }
    public Numero elevar(Numero exp){
    	return new Numero((int)Math.pow(this.valor, exp.valor));
    }
    public Numero sumar(Numero nro){
        return new Numero(this.valor + nro.valor);
    }
    public Numero restar(Numero nro){
        return new Numero(this.valor - nro.valor);
    }
    public Numero dividir(Numero nro){
        return new Numero(this.valor / nro.valor);
    }
    public Numero multiplicar(Numero nro){
        return new Numero(this.valor * nro.valor);
    }
    public boolean esNegativo() { return this.valor < 0; }
    public boolean esCero()     { return this.valor == 0; }
    public boolean esUnidad()   { return Math.abs(this.valor) == 1; }
    public Numero factorial(){
        if (this.valor < 0) throw new RuntimeException("No hay factorial para negativos: "+this.valor);
        int resultado=1;
        for(int i=1  ; i <= this.valor; i++){
            resultado *= i;
        }
        return new Numero(resultado);
    }
    public boolean esPrimo(){
        int n = Math.abs(this.valor);
        if ((n==0)||(n==1)) return false;
        for(int i=2; i < n; i++){
            if ((n % i)==0) return false;
        }
        return true;
    }
    public String aBinario(){
        char[] buffer = new char[32];
        final int MASK = 1;
        int n = this.valor;
        for(int i=31; i>=0; i--){
            if ((n & MASK)==MASK) buffer[i] = '1';
            else buffer[i] = '0';
            n = n >> 1;
        }
        return String.valueOf(buffer);
    }
    @Override
    public String toString(){
        return String.valueOf(this.valor);
    }
	@Override
	public int compareTo(Numero o) {
		return this.valor - o.valor;
	}
}
