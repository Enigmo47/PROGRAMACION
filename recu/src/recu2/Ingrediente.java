package recu2;

public class Ingrediente {
	String nombre;
	int cantidad;

	public Ingrediente(String nombre, int cantidad) {
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	public Ingrediente(String entrada) {
		fromString(entrada);
	}

	public String toString() {
		return nombre + "_" + cantidad;
	}

	private void fromString(String entrada) {
		nombre = entrada.substring(0, entrada.indexOf("_"));
		entrada = entrada.substring(entrada.indexOf("_")+1, entrada.length()-1 );
		cantidad =Integer.parseInt(entrada);
	}

	public static boolean valida(int cantidad) {
		if (cantidad < 0 && cantidad > 1000) {
			return false;
		}
		return true;
	}

}