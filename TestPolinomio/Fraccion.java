package matematicas.nueva;

public class Fraccion {
	private Numero numerador, denominador;

	public Fraccion(int numerador, int denominador){
		this(new Numero(numerador), new Numero(denominador));
	}
	public Fraccion(Numero numerador, Numero denominador){
		if (denominador.esCero()){
			throw new RuntimeException("El denominador no puede ser negativo en una Fraccion.");
		}
		this.numerador   = numerador;
		this.denominador = denominador;
	}
	public Fraccion elevar(Numero exp){
		return new Fraccion(this.numerador.elevar(exp), this.denominador.elevar(exp));
	}
	public Fraccion multiplicar(Fraccion otra){
		return new Fraccion(this.numerador.multiplicar(otra.numerador),
				this.denominador.multiplicar(otra.denominador));
	}
	public Fraccion dividir(Fraccion otra){
		return this.multiplicar(otra.invertido());
	}
	public Fraccion sumar(Fraccion otra){
		Numero comp1=new Numero(0), comp2=new Numero(0), mcm=this.denominador.mcm(otra.denominador);
		comp1 = mcm.dividir(this.denominador).multiplicar(this.numerador);
		comp2 = mcm.dividir(otra.denominador).multiplicar(otra.numerador);
		return new Fraccion(comp1.sumar(comp2), mcm);
	}
	public Fraccion restar(Fraccion otra){
		return this.sumar(otra.negado());
	}
	public Fraccion invertido(){
		return new Fraccion(this.denominador, this.numerador);
	}
	public Fraccion negado(){
		return new Fraccion(this.numerador.negado(), this.denominador);
	}
	public boolean esCero(){ return this.numerador.esCero(); }
	public boolean esNegativo(){
		if (this.esCero()) return false;
		return (this.numerador.esNegativo()) ^ (this.denominador.esNegativo());
	}
	public boolean esUnidad() { return this.numerador.abs().equals(this.denominador.abs()); }
	protected Fraccion simplificada(){
		Numero n=this.numerador, d=this.denominador;
		if (this.numerador.esCero()||this.numerador.esUnidad()||this.denominador.esUnidad()) return new Fraccion(n,d);
		try{
			Numero c = this.numerador.mcd(this.denominador);
			n = this.numerador.abs().dividir(c);
			d = this.denominador.abs().dividir(c);
		}catch(RuntimeException e){}
		return new Fraccion(n,d);
	}
	@Override
	public String toString(){
		String strDeno;
		Fraccion simple = this.simplificada();
		if (simple.numerador.esCero()||simple.denominador.esUnidad()) strDeno="";
		else strDeno = "/" + simple.denominador.abs();
		return (this.esNegativo()?"-":"")+simple.numerador.abs()+strDeno;
	}
	public Numero getNumerador()   { return this.numerador; }
	public Numero getDenominador() { return this.denominador; }
}
