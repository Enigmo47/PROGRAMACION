package recu;

public class Ganador extends Juego {
	String nombre = G;
	boolean ganar;
	public Ganador(boolean ganar, Juego nombre) {
		this.ganar=ganar;
	}
	public String toString() {
		return nombre+" "+((ganar)?"ha ganado":"no ha ganado");
	}
}
