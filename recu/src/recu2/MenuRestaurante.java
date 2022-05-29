package recu2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuRestaurante {
	String fichero = "menu.txt";
	Restaurante carta = new Restaurante(fichero);
	String menu = "1-.Añadir un plato\r2-.Borrar un plato\r3-.Listado en orden alfabetico\r"
			+ "4-.Buscar por plato\r5-.Añadir un ingrediente\r6-.Borrar un ingrediente\r"
			+ "7-.Buscar ingrediente\r8-.Buscar platos sin ingrediente deseado\r0-.Salir";
	Scanner tec = new Scanner(System.in);
	PrintStream out = null;

	public MenuRestaurante() {

		int opcion;
		do {
			System.out.println(menu);
			do {
				System.out.println("-->");
				opcion = tec.nextInt();
				tec.nextLine();
			} while (!(opcion <= 9 && opcion >= 0));

			switch (opcion) {

			case 1:
				anadirPlato();
				break;
			case 2:
				borrarPlato();
				break;
			case 3:
				listadoOrdenado();
				break;
			case 4:
				buscaNombre();
				break;
			case 5:
				anadirIngrediente();
				break;
			case 6:
				borrarIngrediente();
				break;
			case 7:
				buscaIngrediente();
				break;
			case 8:
				buscaContrario();
				break;
			case 9: 
				transaccion();
				break;
			}
		} while (opcion != 0);

	}

	private void anadirPlato() {

		String nombreP;
		double precio;
		do {
			System.out.println("nombre del plato");
			nombreP = tec.nextLine();
			if (carta.buscaNombre(nombreP) != null)
				System.out.println("ya existe otro plato con este nombre");
			System.out.println("precio del plato");
			precio = tec.nextDouble();
			transaccion();
		} while (carta.buscaNombre(nombreP) != null);
		carta.addPlato(nombreP, precio);
	}

	private void borrarPlato() {

		String nombreP;
		System.out.println("nombre:");
		nombreP = tec.nextLine();
		if (!carta.delPlato(nombreP))
			System.out.println("No se pudo eliminar");
		transaccion();

	}

	private void listadoOrdenado() {

		System.out.println(carta.listadoAZ());

	}

	private void buscaNombre() {

		String nombreP;
		System.out.println("nombre:");
		nombreP = tec.nextLine();
		System.out.println((carta.buscaNombre(nombreP) != null) ? carta.buscaNombre(nombreP)
				: "No existe ningun plato con ese nombre");

	}

	private void anadirIngrediente() {

		String nombreP, nombre;
		int cantidad = 0;
		do {
			System.out.println("nombre del plato:");
			nombreP = tec.nextLine();
		} while (carta.buscaNombre(nombreP) == null);
		int num;
		System.out.println("Cuantos ingredientes desea añadir");
		num = tec.nextInt();
		tec.nextLine();
		for (int i = 0; i < num; i++) {
			System.out.println("ingrediente:");
			nombre = tec.nextLine();
			do {
				try {
					System.out.println("Cantidad");
					cantidad = tec.nextInt();
					tec.nextLine();
				} catch (InputMismatchException e) {
					System.out.println("Introduce un valor válido");
				}

			} while (!Ingrediente.valida(cantidad));
			carta.addIngrediente(nombreP, nombre, cantidad);
			transaccion();
		}

	}

	private void borrarIngrediente() {

		String nombreP, nombre;
		int cantidad = 0;
		do {
			System.out.println("nombre del plato:");
			nombreP = tec.nextLine();
		} while (carta.buscaNombre(nombreP) == null);
		do {
			System.out.println("ingrediente");
			nombre = tec.nextLine();
		} while (carta.buscaIngrediente(nombre) == null);
		carta.delIngrediente(nombreP, nombre, cantidad);
		transaccion();

	}

	private void buscaIngrediente() {

		String nombre;
		System.out.println("ingrediente:");
		nombre = tec.nextLine();
		System.out.println(carta.buscaIngrediente(nombre));

	}

	private void buscaContrario() {

		String nombre;
		System.out.println("ingrediente:");
		nombre = tec.nextLine();
		System.out.println(carta.buscaContrario(nombre));

	}

	private void transaccion() {

		try {
			out = new PrintStream(new FileOutputStream(fichero, false));
			out.print(carta);
		} catch (FileNotFoundException e) {
		} finally {
			if (out != null)
				out.close();
		}

	}

}