	paquete  pctrunk1 ;

	import  java.io.BufferedReader ;
	import  java.io.File ;
	import  java.io.FileReader ;
	import  java.io.FileWriter ;
	import  java.io.IOException ;
	import  java.io.PrintWriter ;
	import  java.util.ArrayList ;
	import  java.util.Arrays ;
	import  java.util.Iterator ;
	import  java.util.Scanner ;
	import  java.util.StringTokenizer ;

	 Almacén de clase  pública {

		Producto productos [];
		String  Localidad ;
		int codPostal;


		//MODIFICADO POR ADRIAN JOYAAAA 
		//g
		//TRABAJO DE DANIEL BENITezd
		//:DD
		// ESTA ES LA TERCERA VERSION DEL CODIGO PARA EL APARTADO 4 DEL EJERCICIO
		
		public  final  String  RUTA_FICHERO  =  " G: \\ ficheros \\ productos.txt " ;

		 Almacén público () {
			esto . Localidad  =  " Genérica " ;
			esto . codPostal =  00000 ;
			esto . productos =  esto . generarProductos ( este . NUM_PRODUCTOS );
		}

		public  Almacen ( Producto [] productos , String  localidad , int  codPostal ) {
			super ();
			esto . productos = productos;
			Localidad  = localidad;
			esto . codPostal = codpostal;
		}

		public  int  salvarProductos () {
			prueba {

				// FileWriter es similar a File, permite escribir al final del fichero sin
				// borrar
				FileWriter fw =  new  FileWriter ( esto . RUTA_FICHERO , verdadero );

				// Printwriter es el objeto que permite escribir sobre el fichero de texto
				PrintWriter out =  nuevo  PrintWriter (fw);
				fuera . println ();

				// Recorremos el bucle de productos
				for ( int i =  0 ; i <  this . productos . length; i ++ ) {

					if (productos [i] ! =  null ) {

						String linea =  " " ;
						linea = linea . concat (productos [i] . getNombre ());
						linea = linea . concat ( "  " );
						linea = linea . concat (productos [i] . getDescripcion ());
						linea = linea . concat ( "  " );
						// Necesitamos convertir la cantidad de int a String ya que concat solo admite
						// Cadena
						linea = linea . concat ( Integer . toString (productos [i] . getCantidad ()));
						linea = linea . concat ( "  " );
						linea = linea . concat ( Double . toString (productos [i] . getPrecio ()));
						linea = linea . concat ( "  " );
						linea = linea . concat ( Integer . toString (productos [i] . getCategoria () . id));

						// Si estamos leyendo el Ãºltimo producto del array no pasamos escribimos linea
						// en blanco
						if (i ! =  this . productos . length -  1 )
							fuera . println (linea);
						demás
							fuera . imprimir (linea);
					}

				}
				// Cerramos el flujo de datos
				fw . cerca();
				return  0 ;
			} captura ( IOException ex) {
				ej . printStackTrace ();
				retorno  - 1 ;
			}

		}

		public  int  cargarProductos () {

			prueba {

				// Abrimos el fichero con file
				Archivo arch =  nuevo  Archivo ( este . RUTA_FICHERO );
				// Utilizamos FileReader y BufferedReader para poder leer linea a linea en modo
				// texto
				FileReader fr =  nuevo  FileReader (arch);
				BufferedReader br =  new  BufferedReader (fr);

				para ( int i =  0 ; i <  Almacen . NUM_PRODUCTOS ; i ++ ) {

					// leemos una linea del fichero
					Cadena linea = br . readLine ();

					// Para cada linea tenemos que extraer todos los campos del producto
					// Utilizamos un StringTokenizer para separarlos
					StringTokenizer tokens =  nuevo  StringTokenizer (linea);

					// Creamos un producto para cargar los datos de la linea del fichero
					Producto prod =  nuevo  Producto ();

					// El primero es el nombre
					prod . setNombre (tokens . nextToken ());

					// El segundo token es la descripcion
					prod . setDescripcion (tokens . nextToken ());

					// El Tercer token es la cantidad
					prod . setCantidad ( Integer . valueOf (tokens . nextToken ()));

					// El Tercer token es el precio
					prod . setPrecio ( Double . valueOf (tokens . nextToken ()));

					// Para la categoria creamos un objeto de tipo categoria y le asignamos el id
					// leyendolo del fichero
					Categoria gato =  nueva  Categoria ();
					cat . id =  Entero . valueOf (tokens . nextToken ());
					prod . setCategoria (gato);

					// Guardamos el producto en el array de productos del almacen
					esto . productos [i] = prod;

				}

				// para (int i = 0; i <10; i ++)
				// System.out.println (this.productos [i] .toString ());

				br . cerca();
				return  0 ;

			} captura ( IOException ex) {
				ej . printStackTrace ();
				retorno  - 1 ;
			}

		}

		/ **
		 * La función general un número de productos aleatorios y los devuelve en un
		 * matriz de Producto
		 *
		 * @param cantidad Cantidad de productos a generar
		 * @return Producto []
		 * /
		public  Producto [] generarProductos ( int  cantidad ) {

			Producto prodAleatorios [] =  nuevo  Producto [cantidad];
			Producto temporal;

			para ( int i =  0 ; i < cantidad; i ++ ) {

				temporal =  nuevo  Producto ();
				prodAleatorios [i] = temporal;

			}

			return prodAleatorios;

		}

		@Anular
		public  String  toString () {
			return  " Almacen [productos = "  +  Arrays . toString (productos) +  " , Localidad = "  +  Localidad  +  " , codPostal = "
					+ codPostal +  " ] " ;
		}

		/ **
		 * Funcion que devuelve la suma de los precios de todos los Ã§ productos que se
		 * les pasen
		 * /
		public  double  calcularPrecios ( Producto  prod []) {

			doble precioTotal =  0.0 ;

			// Si el array esta vacio usamos el array de productos del almacen
			if (prod . length ==  0 ) {
				prod =  esto . productos;
			}

			// Recorremos todos los productos del array y sumamos
			// al precio total su precio por la cantidad de productos
			for ( int i =  0 ; i < prod . length; i ++ ) {
				precioTotal + = prod [i] . getPrecio () * prod [i] . getCantidad ();
			}

			// Devolvemos la suma total de precios
			return precioTotal;

		}
		/ *
		 * Crear el método void estadísticas () en la clase Almacen de PcTrunk. Este método convertirá el array de
		 * productos en un ArrayList y mostrar por pantalla las siguientes estadísticas. El bucle se debe recorrer
		 * sólo una vez y se debe utilizar un iterador.
	Precio Medio, máximo y mínimo, sacando los nombres de los productos para el máximo y mínimo
	Suponiendo que sólo hay 3 categorías de productos (Accesorios, Pantallas y Pcs) Mostrar el porcentaje de productos de cada categoría.
		 * /

		público  vacío  estadisticas ( Producto [] productos )
		{
			doble precioMedio =  0 , precioMaximo =  0 , precioMinimo =  0 , precio, precio2, precioMas =  0 ;
			String nombreMaximo, nombreMinimo;

			Categoria categoriaDif;
			String nombreCate;
			doble porCatePorProduc =  0 ;

			ArrayList < String >  Categorias  =  new  ArrayList < String > ();
			ArrayList < Producto >  ListaProductos  =  new  ArrayList < Producto > ();

			para ( int contador =  0 ; contador < productos . length; contador ++ )
			{
				precioMas = precioMas + productos [contador] . getPrecio ();

				precio = productos [contador] . getPrecio ();
				precio2 = precio;
				si (contador ==  0 )
				{
					precioMedio = precio;
					precioMaximo = precio;
					precioMinimo = precio;
					nombreMaximo = productos [ 0 ] . getNombre ();
					nombreMinimo = productos [ 0 ] . getNombre ();
				}
				demás
				{
					// Precio Maximo
					if (precio < productos [contador] . getPrecio ())
					{
						precio = productos [contador] . getPrecio ();
						precioMaximo = productos [contador] . getPrecio ();
						nombreMaximo = productos [contador] . getNombre ();
					}

					// Precio Minimo
					if (precio2 > productos [contador] . getPrecio ())
					{
						precio2 = productos [contador] . getPrecio ();
						precioMinimo = productos [contador] . getPrecio ();
						nombreMinimo = productos [contador] . getNombre ();
					}


				}

				categoriaDif = productos [contador] . getCategoria ();
				nombreCate = categoriaDif . getNombre ();

				if ( ! Categorias . contiene (nombreCate))
						Categorias . agregar (nombreCate);

			}

			porCatePorProduc = (productos . largo /  Categorias . tamaño ()) *  100 ;
			precioMedio = (precioMas / productos . longitud);



			// convertimos el array en Arraylist
			para ( int contador =  0 ; contador < productos . length; contador ++ )
			{
				ListaProductos . agregar (productos [contador]);
			}




		}

		/ *
		 * Crear el método int eliminarProducto (int posicion) que elimina un producto situado en esa posición,
		 * se convertirá a arraylist y se utilizará remove para eliminar la posición. Se tiene que controlar
		 * la excepción que lanza eliminar y mostrar un mensaje en caso de que sea lanzada.
		 * /

		public  int  eliminarProducto ( int  posicion )
		{
			ArrayList < Producto >  ListaProductos  =  new  ArrayList < Producto > ();

			para ( int contador =  0 ; contador < productos . length; contador ++ )
			{
				ListaProductos . agregar (productos [contador]);
			}

			ListaProductos . eliminar (posicionar);
			Sistema . fuera . println ( " Producto eliminado " );

			// falta controlar la excepcion que no se hacerla :(

	        return  0 ;
		}

		/ *
		 * Crear el método int buscar (Producto prod) que devuelve la posición del producto si
		 * el producto está en el Almacén y -1 en caso contrario. Utilizar un Vector
		 * /

		 Producto público [] getProductos () {
			devolver productos;
		}

		public  void  setProductos ( Producto [] productos ) {
			esto . productos = productos;
		}


			// No se como buscar el producto en el almacen
		public  int  buscar ( Almacen  alm , Producto  productos )
		{
			para ( int contador =  0 ; contador < alm . productos . length; contador ++ )
			{

			}

			return  0 ;

		}

		/ *
		 * Crear el método Producto [] ordenar (), que devuelve el arreglo ordenado por el nombre del producto.
		 * No funciona directamente con Collection.sort (..), primero hay que investigar el apartado 11.1 de la teoría.
		 * /

		public  void  ordenar ( Producto [] productos )
		{
			ArrayList < Producto >  Ordenado  =  new  ArrayList < Producto > ();


			para ( int contador =  0 ; contador < productos . length; contador ++ )
			{
				Ordenado . agregar (productos [contador]);
			}


		}


		/ *
		 *
		 * Vector es una matriz dinámica segura para subprocesos proporcionados por Java en los primeros días;
		 * ArrayList también es una matriz dinámica, pero no segura para subprocesos; LinkedList es diferente
		 * de la anterior. LinkedList se almacena usando una lista doblemente vinculada y no es segura para subprocesos.
		 *
		 *
		 * /
			

		/ * AÑADIMOS LA NUEVA FUNCIÓN AL CÓDIGO PARA EL APARTADO 7 * /
		
		int edad;
		{
		Escáner teclado =  nuevo  escáner ( System . In );

		Sistema . fuera . print ( " Escribe tu edad: " );
		edad = teclado . nextInt ();

		if (edad > =  18 ) {
			Sistema . fuera . println ( " Eres mayor de edad " );
		}

		teclado . cerca();

	}

	}

	
}
