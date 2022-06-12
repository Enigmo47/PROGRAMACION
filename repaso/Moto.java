package repaso;

public class Moto extends Vehiculo {

	int cilindros;
	boolean sidecar;

	public Moto(String marca, String modelo, int agno, int Tvida, int cilindros, boolean sidecar) {
		super(marca, modelo, agno, Tvida);
		// TODO Auto-generated constructor stub
		this.cilindros = cilindros;
		this.sidecar = sidecar;
	}

	public String toString() {
		return super.toString() + "El numero de cilindros de la moto es: " + cilindros + " "
				+ (sidecar ? "Tiene sidecar" : "No tiene sidecar");
	}

}
