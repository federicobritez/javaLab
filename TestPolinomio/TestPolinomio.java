package matematicas.nueva;

public class TestPolinomio {
	private static Polinomio p = new Polinomio();
	
	public static void main(String[] args){
		Termino t1 = new Termino(new Fraccion(3,2), new Numero(2));
		p.agregar(t1);
		p.agregar(new Termino(-1, 1));
		p.agregar(new Termino(new Fraccion(1,2), 0));
		
		evaluar(new Fraccion(2,1));
		p.agregar(new Termino(2,1));
		evaluar(new Fraccion(2,1));
	}
	public static Fraccion evaluar(Fraccion x){
		Fraccion r = p.evaluar(x);
		System.out.println("Grado: "+p.grado());
		System.out.println("P(x): "+p);
		System.out.println("P("+x+"): "+r);
		return r;
	}
}
