package repaso;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Operaciones {
	String fichero;

	public static ArrayList<Vehiculo> leer(String fichero) {

		ArrayList<Vehiculo> vector = new ArrayList<Vehiculo>();

		ObjectInputStream lecturaObjetos = null;
		try {
			lecturaObjetos = new ObjectInputStream(new FileInputStream(fichero));
			while (true) {
				Vehiculo o = (Vehiculo) lecturaObjetos.readObject();
				vector.add(o);
			}

		} catch (FileNotFoundException ex) {
			return null;
		} catch (EOFException ex) {
			System.out.println("Vehiculos añadidos del fichero");
			if (lecturaObjetos != null) {
				try {
					lecturaObjetos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return vector;
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} catch (ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
		if (lecturaObjetos != null) {
			try {
				lecturaObjetos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return vector;

	}

	public static void escribir(String fichero, ArrayList<Vehiculo> asd) {
		ObjectOutputStream escribirObjeto = null;
		try {
			escribirObjeto = new ObjectOutputStream(new FileOutputStream(fichero));
			for (Object contactos : asd) {
				escribirObjeto.writeObject(contactos);
			}

		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		if (escribirObjeto != null) {
			try {
				escribirObjeto.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
