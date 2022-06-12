package repaso;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import java.util.Random;

public class Menu {
	String fichero = "prueba.txt";
	Operaciones garaje = new Operaciones();
	Scanner tec = new Scanner(System.in);
	ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
	// ObjectInputStream lol = null;
	// ObjectOutputStream out = null;
	String menu = "1.- Añadir un vehículo\n2.- Eliminar un vehículo\n3.- Listado Vehiculos\n4.- Datos del Vehiculo\n5.- Añadir moto\n6.- Añadir coche de combustion\n7.- añadir coche electrico\n8.- Guardar datos\n";

	public Menu() {

		try {
			leer();
		} catch (NullPointerException | IOException ex) {
			guardar();
		}
		int opcion;
		do {
			System.out.println(menu);
			do {
				System.out.println("-->");
				opcion = tec.nextInt();
				tec.nextLine();
			} while (!(opcion <= 8 && opcion >= 0));

			switch (opcion) {
			case 1:
				agregaVehiculo();
				break;
			case 2:
				eliminaVehiculo();
				break;
			case 3:
				System.out.println(listadoAZ());
				break;
			case 4:
				busca();
				break;
			case 5:
				creaMoto();
				break;
			case 6:
				creaC();
				break;
			case 7:
				creaE();
				break;
			case 8:
				guardar();
				break;
			}
		} while (opcion != 0);

	}

	public Vehiculo buscaVehiculo(String marca, String modelo) {

		for (Vehiculo x : vehiculos) {

			if (x.marca.equals(marca) && x.modelo.equals(modelo))
				return x;

		}
		return null;

	}

	public void agregaVehiculo() {
		Random r = new Random();
		String marca;
		String modelo;
		int agno;
		int Tvida;
		do {
			System.out.println("Marca del Vehiculo:");
			marca = tec.nextLine();
			System.out.println("Modelo del vehiculo:");
			modelo = tec.nextLine();
		} while (buscaVehiculo(marca, modelo) != null);
		do {
			System.out.println("Año que salio al mercado:");
			agno = tec.nextInt();
		} while (!Vehiculo.validar(agno));
		Tvida = r.nextInt(20 - 5) + 5;
		vehiculos.add(new Vehiculo(marca, modelo, agno, Tvida));

	}

	public void eliminaVehiculo() {
		String marca;
		String modelo;
		System.out.println("Marca del Vehiculo:");
		marca = tec.nextLine();
		System.out.println("Modelo del vehiculo:");
		modelo = tec.nextLine();
		if (buscaVehiculo(marca, modelo) != null)
			vehiculos.remove(buscaVehiculo(marca, modelo));
	}

	public String listadoAZ() {

		String salida = "";
		ArrayList<Vehiculo> ordenados = new ArrayList<Vehiculo>();

		ordenados.addAll(vehiculos);
		Collections.sort(ordenados);
		for (Vehiculo x : ordenados) {
			salida += x + "\n";
		}
		return salida;
	}

	public void busca() {
		String marca;
		String modelo;
		System.out.println("Marca del Vehiculo:");
		marca = tec.nextLine();
		System.out.println("Modelo del vehiculo:");
		modelo = tec.nextLine();
		if (buscaVehiculo(marca, modelo) != null)
			System.out.println(buscaVehiculo(marca, modelo));
	}

	public void creaMoto() {
		String marca;
		String modelo;
		int cilindros;
		boolean sidecar;
		System.out.println("Marca del Vehiculo:");
		marca = tec.nextLine();
		System.out.println("Modelo del vehiculo:");
		modelo = tec.nextLine();
		if (buscaVehiculo(marca, modelo) != null) {
			System.out.println("Numero de cilindros:");
			cilindros = tec.nextInt();
			System.out.println("Tiene sidecar 0: no , 1:si");
			sidecar = (tec.nextInt() == 1 ? true : false);
			Vehiculo v = buscaVehiculo(marca, modelo);
			v = new Moto(v.marca, v.modelo, v.agno, v.Tvida, cilindros, sidecar);
		}
	}

	public void creaE() {
		String marca;
		String modelo;
		int plazas;
		int potencia;
		int autonomia;
		boolean cargaR;
		System.out.println("Marca del Vehiculo:");
		marca = tec.nextLine();
		System.out.println("Modelo del vehiculo:");
		modelo = tec.nextLine();
		if (buscaVehiculo(marca, modelo) != null) {
			System.out.println("Numero de plazas:");
			plazas = tec.nextInt();
			System.out.println("Potencia:");
			potencia = tec.nextInt();
			System.out.println("Autonomia:");
			autonomia = tec.nextInt();
			System.out.println("Tiene carga rapida 0: no , 1:si");
			cargaR = (tec.nextInt() == 1 ? true : false);
			Vehiculo v = buscaVehiculo(marca, modelo);
			v = new CocheE(v.marca, v.modelo, v.agno, v.Tvida, plazas, potencia, autonomia, cargaR);
		}
	}

	public void creaC() {
		String marca;
		String modelo;
		int plazas;
		int potencia;
		int cilindros;
		String tipoC;
		System.out.println("Marca del Vehiculo:");
		marca = tec.nextLine();
		System.out.println("Modelo del vehiculo:");
		modelo = tec.nextLine();
		if (buscaVehiculo(marca, modelo) != null) {
			System.out.println("Numero de plazas:");
			plazas = tec.nextInt();
			System.out.println("Potencia:");
			potencia = tec.nextInt();
			System.out.println("Cilindros:");
			cilindros = tec.nextInt();
			System.out.println("Tipo de combustible:");
			tipoC = tec.nextLine();
			Vehiculo v = buscaVehiculo(marca, modelo);
			v = new CocheC(v.marca, v.modelo, v.agno, v.Tvida, plazas, potencia, cilindros, tipoC);
		}
	}

	public void guardar() {
		Operaciones.escribir(fichero, vehiculos);
	}

	public void leer() throws IOException {
		vehiculos.addAll(Operaciones.leer(fichero));
	}

}
