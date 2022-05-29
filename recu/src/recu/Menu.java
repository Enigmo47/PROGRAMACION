package recu;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Menu {
	String fichero = "lista.txt";
	Tienda lista = new Tienda(fichero);
	String menu = "1-.Añadir un juego\r2-.Borrar un juego\r3-.Listado en orden alfabetico\r"
			+ "4-.Buscar por nombre\r5-.Añadir una nota\r6-.Borrar una nota\r" + "7-.Buscar por nota\r0-.Salir";
	Scanner tec = new Scanner(System.in);
	PrintStream out = null;

	public Menu() {
		int opcion;
		do {
			System.out.println(menu);
			do {
				System.out.println("-->");
				opcion = tec.nextInt();
				tec.nextLine();
			} while (!(opcion <= 7 && opcion >= 0));

			switch (opcion) {

			case 1:
				anadirJuego();
				break;
			case 2:
				borrarJuego();
				break;
			case 3:
				listaOrdenado();
				break;
			case 4:
				buscarNombre();
				break;
			case 5:
				anadirNota();
				break;
			case 6:
				borrarNota();
				break;
			case 7:
				buscarCalificacion();
				break;
			}
		} while (opcion != 0);
	}

	private void anadirJuego() {
		String nombre, calificacion, genero;
		do {
			System.out.println("Nombre del juego");
			nombre = tec.nextLine();
			if (lista.buscarNombre(nombre) != null)
				System.out.println("Ya existe ese juego");
		} while (lista.buscarNombre(nombre) != null);
		do {
			System.out.println("Calificacion:");
			calificacion = tec.nextLine();
		} while (!Nota.calificacionValida(calificacion));

		System.out.println("Genero:");
		genero = tec.nextLine();
		lista.addJuego(nombre, calificacion, genero);
		transiccion();
	}

	private void borrarJuego() {
		String nombre;
		System.out.println("nombre:");
		nombre = tec.nextLine();
		if (!lista.delJuego(nombre))
			System.out.println("No se pudo eliminar");
		transiccion();
	}

	private void listaOrdenado() {
		System.out.println(lista.ordenA());
	}

	private void buscarNombre() {
		String nombre;
		System.out.println("Nombre:");
		nombre = tec.nextLine();
		System.out.println((lista.buscarNombre(nombre) != null) ? lista.buscarNombre(nombre)
				: "No existe ningun contacto con ese nombre");
	}

	private void anadirNota() {
		String nombre, calificacion, genero;
		do {
			System.out.println("Nombre del juego");
			nombre = tec.nextLine();
		} while (lista.buscarNombre(nombre) == null);
		do {
			System.out.println("Calificacion:");
			calificacion = tec.nextLine();
		} while (!Nota.calificacionValida(calificacion));
		System.out.println("Genero:");
		genero = tec.nextLine();
		lista.addNota(nombre, calificacion, genero);
		transiccion();
	}

	private void borrarNota() {
		String nombre, calificacion, genero;
		do {
			System.out.println("Nombre del juego:");
			nombre = tec.nextLine();
		} while (lista.buscarNombre(nombre) == null);
		do {
			System.out.println("Calificacion:");
			calificacion = tec.nextLine();
		} while (!Nota.calificacionValida(calificacion));
		lista.delNota(nombre, calificacion);
		transiccion();
	}

	private void buscarCalificacion() {
		String calificacion;
		System.out.println("Calificacion:");
		calificacion = tec.nextLine();
		System.out.println(lista.buscaCalificacion(calificacion));
	}

	private void transiccion() {
		try {
			out = new PrintStream(new FileOutputStream(fichero, false));
			out.print(lista);
		} catch (FileNotFoundException e) {
		} finally {
			if (out != null)
				out.close();
		}
	}
}
