package repaso;

public class CocheE extends Vehiculo {

	int plazas;
	int potencia;
	int autonomia;
	boolean cargaR;

	public CocheE(String marca, String modelo, int agno, int Tvida, int plazas, int potencia, int autonomia,
			boolean cargaR) {
		super(marca, modelo, agno, Tvida);
		// TODO Auto-generated constructor stub
		this.plazas = plazas;
		this.potencia = potencia;
		this.autonomia = autonomia;
		this.cargaR = cargaR;
	}

	public String toString() {
		return super.toString() + "El numero de plazas es: " + plazas + " " + "La potencia es: " + potencia + " "
				+ "La autonomía es: " + autonomia + " " + (cargaR ? "Tiene carga rapida" : "No tiene carga rapida");
	}

}
