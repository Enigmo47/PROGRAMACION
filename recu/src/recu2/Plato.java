package recu2;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class Plato implements Comparable<Plato> {

	String nombreP;
	double precio;
	ArrayList<Ingrediente> ing = new ArrayList<Ingrediente>();

	public Plato(String nombreP, double precio) {
		this.precio = precio;
		this.nombreP = nombreP;
		// addIngrediente(nombre,cantidad);
	}

	public Plato(String entrada) {
		fromString(entrada);
	}

	public void addIngrediente(String nombre, int cantidad) {
		ing.add(new Ingrediente(nombre, cantidad));
	}

	public void delIngrediente(String nombre) {
		try {
			for (Ingrediente x : ing) {

				if (x.nombre.equals(nombre))
					ing.remove(x);

			}

		} catch (ConcurrentModificationException e) {
		}
	}

	public String toString() {

		String salida = nombreP + ";" + precio + ";";
		for (Ingrediente x : ing) {
			salida += x + ";";
		}
		if (ing.isEmpty())
			salida += "sin ingredientes";
		return salida;

	}

	private void fromString(String entrada) {

		nombreP = entrada.substring(0, entrada.indexOf(";"));
		entrada = entrada.substring(entrada.indexOf(";") + 1, entrada.length());
		precio = Double.parseDouble(entrada.substring(0 ,entrada.indexOf(";")));
		entrada = entrada.substring(entrada.indexOf(";") + 1, entrada.length() );
	//	if (entrada.lastIndexOf(";") == entrada.length() - 1) {
			while (entrada.indexOf(";") <= entrada.lastIndexOf(";") && entrada.indexOf(";") >= 0) {
				ing.add(new Ingrediente(entrada.substring(0, entrada.indexOf(";")+1)));
				entrada = entrada.substring(entrada.indexOf(";") + 1, entrada.length() );
			}

	//	}

	}

	public int compareTo(Plato o) {
		return nombreP.compareTo(o.nombreP);
	}

}