package recu;

public class Nominado extends Juego {
	String nombre = N;
	int nominaciones;
	public Nominado(int nominaciones, Juego nombre) {
		
		this.nominaciones=nominaciones;
	}
	public String toString() {
		return nombre+" "+((nominaciones>0)?nominaciones+" nominaciones":"sin nominaciones");
	}
}
