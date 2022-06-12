package repaso;

import java.io.Serializable;

public class Vehiculo implements Comparable<Vehiculo>, Serializable {
	public String marca;
	public String modelo;
	int agno;
	int Tvida;

	public Vehiculo(String marca, String modelo, int agno, int Tvida) {
		this.marca = marca;
		this.modelo = modelo;
		this.agno = agno;
		this.Tvida = Tvida;
	}

	public String toString() {
		return "La marca es: " + marca + " " + "El modelo es: " + modelo + " "
				+ "El año en el que salio al mercado es: " + agno + " " + "El tiempo estimado de vida es: " + Tvida;
	}

	public static boolean validar(int agno) {

		if (agno < 1885) {
			return false;
		}

		return true;
	}

	@Override
	public int compareTo(Vehiculo o) {
		return marca.compareTo(o.marca);
	}

}
