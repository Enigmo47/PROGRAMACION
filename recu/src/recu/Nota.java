package recu;

public class Nota {
	String calificacion,genero;
		
//	const DELIMINADOR = ":";
	
	public Nota(String calificacion,String genero) {
		this.calificacion=calificacion;
		this.genero=genero;
	}
	
	public Nota(String entrada) {
		fromString(entrada);
	}
	
	public String toString() {
		return calificacion+":"+genero;
	}
	
	private void fromString(String entrada) {
		calificacion=entrada.substring(0,entrada.indexOf(":"));
		genero=entrada.substring(entrada.indexOf(":")+1,entrada.length()-1);
	}
	public static boolean calificacionValida(String calificacion) {
		
		//return !(calificacion.length()!=1 && ((calificacion.charAt(0)<'0' || calificacion.charAt(0)>'5'))); 
		
		if (calificacion.length()!=1)
				return false;
			if ((calificacion.charAt(0)<'0' || calificacion.charAt(0)>'5')) 
				return false;
			else {
				return true;
			}
	}
}
/*		if (calificacion.length()!=1 && ((calificacion.charAt(0)<'0' || calificacion.charAt(0)>'5'))) {
return false;
} else {
return true;
}
*/
