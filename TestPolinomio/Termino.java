package matematicas.nueva;

public class Termino {
	private Fraccion coeficiente;
	private Numero   exponente;
	
	public Termino(Fraccion coeficiente, Numero exponente){
		if (exponente.esNegativo()) throw new RuntimeException("El exponente no puede ser negativo.");
		this.coeficiente = coeficiente;
		this.exponente   = exponente;
	}
	public Termino(int coeficiente, int exponente){
		this(new Fraccion(coeficiente, 1), new Numero(exponente));
	}
	public Termino(Fraccion coeficiente, int exponente){
		this(coeficiente, new Numero(exponente));
	}
	public Termino sumar(Termino t){
		if (!this.exponente.equals(t.exponente)) throw new RuntimeException("No es posible la suma de termino con grados diferentes.");
		
		return new Termino(this.coeficiente.sumar(t.coeficiente), new Numero(t.getExponente().getValor()));
	}
	public Fraccion evaluar(Fraccion x){
		return  x.elevar(exponente).multiplicar(coeficiente);
	}
	public Fraccion getCoeficiente() {
		return coeficiente;
	}
	public Numero getExponente() {
		return exponente;
	}
	@Override
	public String toString(){
		String exp="", coef;
		if (this.coeficiente.esCero()) return "";
		if (this.exponente.esCero()) exp="";        
		else if (this.exponente.esUnidad()) exp="X";
		else exp="X^"+this.exponente;
		if (this.coeficiente.esUnidad()){
			if (this.coeficiente.esNegativo())coef = " -";
			else coef = "";
		}else{ coef = this.coeficiente.toString();}
		return coef+exp;
	}
}
