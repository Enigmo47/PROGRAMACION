package recu;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
public class Juego implements Comparable<Juego> {

	/**
	 * nombre del juego
	 */
	String nombre;
	//String calificacion;
	/**
	 * valoración del juego
	 */
	ArrayList <Nota> valoracion = new ArrayList<Nota>();

//  juan
//	ArrayList <String> notas= new ArrayList<String>();		
//	ArrayList <String> generos = new ArrayList<String>();
	
	
	/**
	 * en lugar de usar la clase Nota, que contiene una nota y un género,
	 * utiliza tipos básicos como Int y String en la clase juego
	 * Juego: nombre(string), nota(int), genero(string)
	 * 
	 * ya no necesitas la clase nota, excepto por la función calificacionValida
	 * tienes varias opciones:
	 * 
	 * 1. Añadir una clase Validacion con un método static nota. Entonces en menu llamarías a Validacion.Nota(3)
	 * 
	 * 2. Añadir un método static esNotaValida en Juego o Menu, llamarías a Juego.esNotaValida(3)  ...
	 * 
	 * 3. Creas una clase Nota:
	 *		tiene una propiedad Int
	 *		tiene una función static esValida(int):true/false
	 *		el constructor de la Nota puede llamar a su validador:
	 *			
	 *		public Nota(int nota) {
	 *         this.validar(nota)
	 *      }
	 *      public static boolean function esValida(int nota) {
	 *      	return false; 
	 *      }
	 *      public static boolean function validar(int nota) {
	 *      	throw new Exception("Nota no es válida"); 
	 *      }
	 *      
	 *      menu.java
	 *      try {
	 *      	Nota.validar(16);
	 *      } catch {
	 *         out(
	 *      }
	 */		
	
	public Juego(String nombre, String calificacion, String genero) {
			
		this.nombre = nombre;
//		juan
//		this.notas.add(calificacion);
//		this.generos.add(genero);
		
		addNota(calificacion,genero);
	}
	
	/*public Juego(Juego Goty) {
		this.nombre = Goty.nombre;
		for(Nota x : valoracion) {
			
		}
	}*/
	
	
	public Juego(String entrada) {
		fromString(entrada);
	}

	public void addNota(String entrada) {
		valoracion.add(new Nota(entrada));
	}
	public void addNota(String calificacion, String genero) {
		valoracion.add(new Nota(calificacion,genero));
	}
	public void addGenero(String calificacion, String genero) {
		valoracion.add(new Nota(calificacion,genero));
	}
	public void delgenero(String genero) {
		try {
			for(Nota x : valoracion) {
				if(x.calificacion.equals(genero))valoracion.remove(x);
			}
		}catch(ConcurrentModificationException e) {}
		
	}
	
	private void fromString(String entrada) {
		nombre=entrada.substring(0,entrada.indexOf(";"));
		entrada=entrada.substring(entrada.indexOf(";")+1,entrada.length()-1);
		while(entrada.indexOf(";")<=entrada.lastIndexOf(";") && entrada.indexOf(";")>=0) {
			addNota(entrada.substring(0,entrada.indexOf(";")));
			entrada=entrada.substring(entrada.indexOf(";")+1,entrada.length()-1);
		}
	}
	public String toString() {
		String salida = "";
		salida+=nombre+";";
		for(Nota x : valoracion)salida+=x+";";
		return salida;
	}
	
	public int compareTo(Juego o) {
		return nombre.compareTo(o.nombre);
	}
}
