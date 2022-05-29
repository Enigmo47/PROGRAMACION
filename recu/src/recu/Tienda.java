package recu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Tienda {
	ArrayList<Juego> juegos = new ArrayList<Juego>();
	Scanner in =null;
	
	public Tienda(String fichero) {
		try {
			in = new Scanner(new BufferedReader(new FileReader(fichero)));
			while(in.hasNext()) {
				juegos.add(new Juego(in.nextLine()));
			}
		}catch (FileNotFoundException e) {}
		finally {
			if(in != null)in.close();	
			
		}
	}
	
	public boolean addJuego(String nombre, String calificacion, String genero) {
		for(Juego x : juegos) {
			if(x.nombre.equals(nombre)) return false;
		}
		juegos.add(new Juego(nombre,calificacion,genero));
		return true;
	}
	
	public boolean delJuego(String nombre) {
		for(Juego x : juegos) {
			if(x.nombre.equals(nombre)) {
				juegos.remove(x);
				return true;
			}
		}
		return false;
	}
	
	public String ordenA() {
		String salida="";
		ArrayList<Juego> ordenados = new ArrayList<Juego>();
		ordenados.addAll(juegos);
		Collections.sort(ordenados);
		for(Juego x : ordenados) {
			salida+=x+"\r";
		}
		return salida;
	}
	
	public Juego buscarNombre(String nombre) {
		for(Juego x : juegos) {
			if(x.nombre.equals(nombre))return x;
		}
		return null;
	}
	
	public void addNota(String nombre, String calificacion, String genero) {
		for(Juego x : juegos) {
			if(x.nombre.equals(nombre))x.addNota(calificacion,genero);
		}
	}
	
	public void delNota(String nombre, String calificacion) {
		int index=0;
		boolean encontrado = false;
		for(Juego x : juegos) {
			if(encontrado=x.nombre.equals(nombre))index=juegos.indexOf(x);			
		}
		if(encontrado)juegos.get(index).delgenero(calificacion);
	}
	
	public String buscaCalificacion(String calificacion) {
		String salida="";
		for(Juego x : juegos) {
			for(Nota y : x.valoracion) {
				if(y.calificacion.equals(calificacion))salida+=x.nombre+"\r";
			}
		}
		return ((salida.equals(""))?"Ningun juego con esa nota":"Juegos con esa nota: \r" + salida);
	}
	
	public String  toString() {
		String salida="";
		for(Juego x : juegos) {
			salida+=x+"\r";
		}
		return salida;
	}
 	
}
