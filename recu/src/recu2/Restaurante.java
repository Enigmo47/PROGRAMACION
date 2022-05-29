package recu2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Restaurante {

	ArrayList<Plato> platos = new ArrayList<Plato>();
	Scanner in = null;

	public Restaurante(String fichero) {
		try {
			in = new Scanner(new BufferedReader(new FileReader(fichero)));
			while (in.hasNext()) {
				platos.add(new Plato(in.nextLine()));
			}
		} catch (FileNotFoundException e) {
		} finally {
			if (in != null)
				in.close();
		}

	}

	public boolean addPlato(String nombreP, double precio) {
		for (Plato x : platos) {
			if (x.nombreP.equals(nombreP))
				return false;
		}
		platos.add(new Plato(nombreP, precio));
		return true;

	}

	public boolean delPlato(String nombreP) {
		Iterator<Plato> iter = platos.iterator();
		while (iter.hasNext()) {
			if (nombreP.equals(iter.next().nombreP)) {
				iter.remove();
				return true;
			}

		}
		return false;

	}

	public String listadoAZ() {

		String salida = "";
		ArrayList<Plato> ordenados = new ArrayList<Plato>();

		ordenados.addAll(platos);
		Collections.sort(ordenados);
		for (Plato x : ordenados) {
			salida += x + "\r";
		}
		return salida;

	}

	public Plato buscaNombre(String nombreP) {

		for (Plato x : platos) {

			if (x.nombreP.equals(nombreP))
				return x;

		}
		return null;

	}

	public boolean addIngrediente(String nombreP, String nombre, int cantidad) {

		for (Plato x : platos) {

			if (x.nombreP.equals(nombreP)) {

				x.addIngrediente(nombre, cantidad);
				return true;
			}
			
		}
		System.out.println("No hay platos con ese nombre.");
		return false;

	}

	public boolean delIngrediente(String nombreP, String nombre, int cantidad) {

		for (Plato x : platos) {
			if (nombreP.equals(x.nombreP)) {

				Iterator<Ingrediente> iter = x.ing.iterator();
				while (iter.hasNext()) {
					if (nombreP.equals(iter.next().nombre)) {
						iter.remove();
						return true;

					}

				}
			}

		}
		return false;

	}

	public String buscaIngrediente(String nombre) {

		String salida = "";
		for (Plato x : platos) {

			for (Ingrediente y : x.ing) {

				if (y.nombre.equals(nombre))
					salida += x + "\r";

			}

		}
		return ((salida.equals("")) ? "No hay platos con este ingrediente" : "Platos con ese ingrediente: \r" + salida);

	}

	public String buscaContrario(String nombre) {

		String salida = "";
		for (Plato x : platos) {

			if (x.ing.contains(new Ingrediente(nombre, 0))) {

				salida += x + "\r";
			}

		}
		return ((salida.equals("")) ? "No hay platos con este ingrediente" : "Platos con ese ingrediente: \r" + salida);

	}

	public String toString() {

		String salida = "";
		for (Plato x : platos) {

			salida += x + "\r";

		}
		return salida;

	}

}
