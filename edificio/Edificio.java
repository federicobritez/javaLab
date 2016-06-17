
/**
 * Clase Edificio
 * 
 * Contiene un Ascensor 
 * 
 * 
 * @author (Federico) 
 * @version (0.1)
 */
public class Edificio
{
    private int cantidadPisos;
    private int pisoActual;
    
    public Edificio(int cantPisos){
        this.cantidadPisos = cantPisos;
        this.pisoActual = 0;
    }
    
    private void setPisoActual (int piso){
        
        this.pisoActual = (piso <= cantidadPisos && piso > 0)? piso:this.pisoActual;
        System.out.println("PisoActual :" + this.pisoActual);

    }
    
    public void ir(int piso){
        for(int i= this.pisoActual ; i < piso; i++){
            this.subir();
        }
    }
    
    public  void subir(){
        this.setPisoActual(this.pisoActual+1);
    }
    
    
    
    public int getPisoActual() { return this.pisoActual;}
    
    public int getCantidadPisos(){  return this.cantidadPisos;}
}
