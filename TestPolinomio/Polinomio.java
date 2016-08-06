package matematicas.nueva;

import java.util.HashMap;

public class Polinomio {
	private HashMap<Numero, Termino> terminos = new HashMap<Numero, Termino>();
	
	public void agregar(Termino t){
		if (t==null) return;
		if (t.getCoeficiente().esCero()) return;

		Termino te = terminos.get(t.getExponente());
		if (te != null){
			t = t.sumar(te);
		}
		terminos.put(t.getExponente(), t);
	}
	public Fraccion evaluar(Fraccion x){
		Fraccion r = new Fraccion(0,1);
		for (Termino t : terminos.values()){
			r = r.sumar(t.evaluar(x));
		}
		return r;
	}
	public Numero grado(){
		Numero grado=new Numero(0);
		for(Numero g : terminos.keySet()){
			if (g.compareTo(grado)>0){
				grado = g;
			}
		}
		return grado;
	}
	@Override
	public String toString(){
		String str="";
		int cant = this.grado().getValor();
		for (int i=cant; i>=0; i--){
			Termino t = terminos.get(new Numero(i));
			if (t!=null){
				if (t.getCoeficiente().esNegativo()){
					str+=t;
				}else{
					str+=((i==cant)?"":" +")+t;
				}
			}
		}
		return str;
	}

}