package repaso;

public class CocheC extends Vehiculo {

	int plazas;
	int potencia;
	int cilindros;
	String tipoC;

	public CocheC(String marca, String modelo, int agno, int Tvida, int plazas, int potencia, int cilindros,
			String tipoC) {
		super(marca, modelo, agno, Tvida);
		// TODO Auto-generated constructor stub
		this.plazas = plazas;
		this.potencia = potencia;
		this.cilindros = cilindros;
		this.tipoC = tipoC;
	}

	public String toString() {
		return super.toString() + "El numero de plazas es: " + plazas + " " + "La potencia es: " + potencia + " "
				+ "El numero de cilindros es : " + cilindros + " " + "El tipo de combustible que usa es: " + tipoC;
	}

}
