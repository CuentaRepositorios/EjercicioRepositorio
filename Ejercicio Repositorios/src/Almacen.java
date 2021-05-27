package pctrunk1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Almacen {

	Producto productos[];
	String Localidad;
	int codPostal;

	//ESTA ES LA TERCERA VERSION DEL CODIGO PARA EL APARTADO 4 DEL EJERCICIO
	
	public static int NUM_PRODUCTOS = 200;
	public final String RUTA_FICHERO = "G:\\ficheros\\productos.txt";

	public Almacen() {
		this.Localidad = "Generica";
		this.codPostal = 00000;
		this.productos = this.generarProductos(this.NUM_PRODUCTOS);
	}

	public Almacen(Producto[] productos, String localidad, int codPostal) {
		super();
		this.productos = productos;
		Localidad = localidad;
		this.codPostal = codpostal;
	}

	public int salvarProductos() {
		try {

			// FileWriter es similar a File, permite escribir al final del fichero sin
			// borrar
			FileWriter fw = new FileWriter(this.RUTA_FICHERO, true);

			// Printwriter es el objeto que permite escribir sobre el fichero de texto
			PrintWriter out = new PrintWriter(fw);
			out.println();

			// Recorremos el bucle de productos
			for (int i = 0; i < this.productos.length; i++) {

				if (productos[i] != null) {

					String linea = "";
					linea = linea.concat(productos[i].getNombre());
					linea = linea.concat(" ");
					linea = linea.concat(productos[i].getDescripcion());
					linea = linea.concat(" ");
					// Necesitamos convertir la cantidad de int a String ya que concat sÃ³lo admite
					// String
					linea = linea.concat(Integer.toString(productos[i].getCantidad()));
					linea = linea.concat(" ");
					linea = linea.concat(Double.toString(productos[i].getPrecio()));
					linea = linea.concat(" ");
					linea = linea.concat(Integer.toString(productos[i].getCategoria().id));

					// Si estamos leyendo el Ãºltimo producto del array no pasamos escribimos linea
					// en blanco
					if (i != this.productos.length - 1)
						out.println(linea);
					else
						out.print(linea);
				}

			}
			// Cerramos el flujo de datos
			fw.close();
			return 0;
		} catch (IOException ex) {
			ex.printStackTrace();
			return -1;
		}

	}

	public int cargarProductos() {

		try {

			// Abrimos el fichero con file
			File arch = new File(this.RUTA_FICHERO);
			// Utilizamos FileReader y BufferedReader para poder leer linea a linea en modo
			// texto
			FileReader fr = new FileReader(arch);
			BufferedReader br = new BufferedReader(fr);

			for (int i = 0; i < Almacen.NUM_PRODUCTOS; i++) {

				// leemos una linea del fichero
				String linea = br.readLine();

				// Para cada linea tenemos que extraer todos los campos del producto
				// Utilizamos un StringTokenizer para separarlos
				StringTokenizer tokens = new StringTokenizer(linea);

				// Creamos un producto para cargar los datos de la linea del fichero
				Producto prod = new Producto();

				// El primero es el nombre
				prod.setNombre(tokens.nextToken());

				// El segundo token es la descripcion
				prod.setDescripcion(tokens.nextToken());

				// El Tercer token es la cantidad
				prod.setCantidad(Integer.valueOf(tokens.nextToken()));

				// El Tercer token es el precio
				prod.setPrecio(Double.valueOf(tokens.nextToken()));

				// Para la categoria creamos un objeto de tipo categoria y le asignamos el id
				// leyendolo del fichero
				Categoria cat = new Categoria();
				cat.id = Integer.valueOf(tokens.nextToken());
				prod.setCategoria(cat);

				// Guardamos el producto en el array de productos del almacen
				this.productos[i] = prod;

			}

			// for (int i = 0; i < 10; i++)
			// System.out.println(this.productos[i].toString());

			br.close();
			return 0;

		} catch (IOException ex) {
			ex.printStackTrace();
			return -1;
		}

	}

	/**
	 * La funciÃ³n general un numero de productos aleatorios y los devuelve en un
	 * array de Producto
	 *
	 * @param cantidad Cantidad de productos a generar
	 * @return Producto[]
	 */
	public Producto[] generarProductos(int cantidad) {

		Producto prodAleatorios[] = new Producto[cantidad];
		Producto temporal;

		for (int i = 0; i < cantidad; i++) {

			temporal = new Producto();
			prodAleatorios[i] = temporal;

		}

		return prodAleatorios;

	}

	@Override
	public String toString() {
		return "Almacen [productos=" + Arrays.toString(productos) + ", Localidad=" + Localidad + ", codPostal="
				+ codPostal + "]";
	}

	/**
	 * Funcion que devuelve la suma de los precios de todos los Ã§ productos que se
	 * les pasen
	 */
	public double calcularPrecios(Producto prod[]) {

		double precioTotal = 0.0;

		// Si el array esta vacio usamos el array de productos del almacen
		if (prod.length == 0) {
			prod = this.productos;
		}

		// Recorremos todos los productos del array y sumamos
		// al precio total su precio por la cantidad de productos
		for (int i = 0; i < prod.length; i++) {
			precioTotal += prod[i].getPrecio() * prod[i].getCantidad();
		}

		// Devolvemos la suma total de precios
		return precioTotal;

	}
	/*
	 * Crear el método  void estadísticas() en la clase Almacen de PcTrunk. Este método convertirá el array de
	 *  productos en un ArrayList y mostrará por pantalla las siguientes estadísticas. El bucle se debe recorrer
	 *   sólo una vez y se debe de utilizar un iterator.

Precio Medio, máximo y mínimo, sacando los nombres de los productos para el máximo y mínimo
Suponiendo que sólo hay 3 categorías de productos (Accesorios, Pantallas y Pcs) Mostrar el porcentaje de productos de cada categoría.

	 */

	public void estadisticas(Producto[] productos)
	{
		double precioMedio = 0, precioMaximo = 0, precioMinimo = 0, precio, precio2, precioMas = 0;
		String nombreMaximo, nombreMinimo;

		Categoria categoriaDif;
		String nombreCate;
		double porCatePorProduc = 0;

		ArrayList<String> Categorias = new ArrayList<String>();
		ArrayList<Producto> ListaProductos = new ArrayList<Producto>();

		for(int contador = 0; contador < productos.length; contador++)
		{
			precioMas = precioMas + productos[contador].getPrecio();

			precio = productos[contador].getPrecio();
			precio2 = precio;
			if(contador == 0)
			{
				precioMedio = precio;
				precioMaximo = precio;
				precioMinimo = precio;
				nombreMaximo = productos[0].getNombre();
				nombreMinimo = productos[0].getNombre();
			}
			else
			{
				// Precio Maximo
				if(precio < productos[contador].getPrecio())
				{
					precio = productos[contador].getPrecio();
					precioMaximo = productos[contador].getPrecio();
					nombreMaximo = productos[contador].getNombre();
				}

				// Precio Minimo
				if(precio2 > productos[contador].getPrecio())
				{
					precio2 = productos[contador].getPrecio();
					precioMinimo = productos[contador].getPrecio();
					nombreMinimo = productos[contador].getNombre();
				}


			}

			categoriaDif = productos[contador].getCategoria();
			nombreCate = categoriaDif.getNombre();

			if(!Categorias.contains(nombreCate))
					Categorias.add(nombreCate);

		}

		porCatePorProduc = (productos.length / Categorias.size()) * 100;
		precioMedio = (precioMas / productos.length);



		// convertimos el array en Arraylist
		for(int contador = 0; contador < productos.length; contador++)
		{
			ListaProductos.add(productos[contador]);
		}




	}

	/*
	 * Crear el método int eliminarProducto(int posicion) que elimina un producto situado en esa posición,
	 *  se convertirá a arraylist y se utilizará remove para eliminar la posición. Se tiene que controlar
	 *  la excepción que lanza remove y mostrar un mensaje en caso de que sea lanzada.
	 */

	public int eliminarProducto(int posicion)
	{
		ArrayList<Producto> ListaProductos = new ArrayList<Producto>();

		for(int contador = 0; contador < productos.length; contador++)
		{
			ListaProductos.add(productos[contador]);
		}

		ListaProductos.remove(posicion);
		System.out.println("Producto eliminado");

		// falta controlar la excepcion que no se hacerla :(

        return 0;
	}

	/*
	 * Crear el método int buscar(Producto prod) que devuelve la posición del producto si
	 *  el producto está en el Almacén y -1 en caso contrario. Utilizar un Vector
	 */

	public Producto[] getProductos() {
		return productos;
	}

	public void setProductos(Producto[] productos) {
		this.productos = productos;
	}


		// No se como buscar el producto en el almacen
	public int buscar(Almacen alm, Producto productos)
	{
		for(int contador = 0; contador < alm.productos.length; contador++)
		{

		}

		return 0;

	}

	/*
	 * Crear el método Producto[] ordenar(), que devuelve el array ordenado por el nombre del producto.
	 *  No funciona directamente con Collection.sort(..), primero hay que investigar el apartado 11.1 de la teoría.
	 */

	public void ordenar(Producto[] productos)
	{
		ArrayList<Producto> Ordenado = new ArrayList<Producto>();


		for(int contador = 0; contador < productos.length; contador++)
		{
			Ordenado.add(productos[contador]);
		}


	}


	/*
	 *
	 * Vector es una matriz dinámica segura para subprocesos proporcionada por Java en los primeros días;
	 *  ArrayList también es una matriz dinámica, pero no segura para subprocesos; LinkedList es diferente
	 *   de la anterior. LinkedList se almacena usando una lista doblemente vinculada y no es segura para subprocesos.
	 *
	 *
	 */


}
