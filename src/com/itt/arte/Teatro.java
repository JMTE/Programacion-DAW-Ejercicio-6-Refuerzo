package com.itt.arte;

/*Aqui implementaremos la clase clave, donde estará lo mas importante de nuestro programa.
 * Esta clase hereda de la clase Local y por lo tanto hereda todas sus propiedades que 
 * definen el local
 * Implementa a la interfaz Sala, por lo tanto está obligada a implementar todos sus 
 * metodos abstractos.
 * Esta clase es el contenedor de la clase Espectador,es decir, hay una interrelacion de
 * composicion.
 * La clase Teatro agrega a un objeto de la clase Obra, que nos servirá para saber que obra
 * se esta proyectando en este momento.
 * Para definir la herencia se utiliza el extends
 * Para decir que implementa una interfaz se utiliza la palabra clave implements
 *
 */

public class Teatro extends Local implements Sala{
	//encapsulamos los atributos
	private double precio;
	private Obra obra;
	/*Declaramos un array de objetos Espectador de dos dimensiones para "emular" lo que seria
	 * el aforo de nuestro teatro, distribuido en filas y butacas, este aforo sera de 50
	 * personas distribuido en 5 filas y 10 butacas cada fila
	 */
	private Espectador[][]localidades=new Espectador[5][10];
	/*Implementamos el constructor de la clase que recibe por parametros los heredados de la
	 * clase Local, un objeto Obra y un atributo propio de la clase que es el precio de la obra
	 */
	public Teatro(String dom,int m,int acc,Obra obra,double pre){
		super(dom,  m,  acc);
		this.obra=obra;
		this.precio=pre;
		
		
	}
	/*Definimos los metodos SETTER y GETTER de esta clase, porque igual al teatro le interesa
	 * en algun momento cambiar la obra que se proyecta o incluso cambiar el precio de la misma
	 */
	public void cambia_Obra(Obra obra){
		this.obra=obra;
	}
	public Obra dame_Obra(){
		return this.obra;
	}
	public void cambia_Precio(double precio){
		this.precio=precio;
	}
	public double dame_Precio(){
		return this.precio;
	}
	
	/*Aqui empezamos a implementar los metodos de la interfaz Sala
	 * Para ver el primer punto que nos piden, utilizamos un metodo que devuelva
	 * un String con los datos de la obra que le pasamos por parametro mas los datos del
	 * local que los heredamos de la clase local con la palabra reservada super mas los 
	 * datos del atributo precio para saber el precio de la obra en general
	 * */
	public String verProgramacion() {
		
		return "Hoy representamos "+this.obra.toString()+"\n"+super.toString()+"\nPrecio: "+this.precio ;
	}
	
	
	/*A continuacion se nos pide ver lo que podria definirse como un mapa de las localidades
	 * Tendremos que poner en texto la posicion de cada butaca y a que fila representa
	 * Además en este mapa deberemos de mostrar si alguna localidad esta ocupada o libre 
	 * con un texto.
	 * La mejor forma de hacerlo es recorriendo un array e ir sumando cada posicion a una
	 * cadena de texto. Para añadir la palabra libre o ocupado segun la localidad tenga 
	 * un objeto espectador o no, ejecutaremos un bucle if que nos dira si esa posicion del 
	 * array contiene un objeto espectador o esta vacio, de esta manera agregaremos el texto 
	 * libre o ocupado.
	 */

	public String verLocalidades() {
		//Declaramos el String vacio que es el que nos dira si la palabra a incluir es Libre o Ocupado
		String vacio = null;
		//Declaramos el String texto que es donde concatenaremos nuestro String total
		String texto="";
		//Recorremos el array Localidades de dos dimensiones que contiene objetos espectadores
		for (int i=0;i<localidades.length;i++){
			
			for (int j=0;j<localidades[i].length;j++){
				//En cada posicion del array incluimos el texto con su posicion y el punto
				texto=texto.concat(i+"."+j);
				//Aqui es donde miramos con este bucle if si la posicion del array esta ocupada o no
				if (localidades[i][j]==null){
					vacio="Libre     ";
					
					
				}else vacio="Ocupado   ";
				/*Y a continuacion a esa posicion del array le concatenamos el texto que
				 * llevamos arrastrado mas la nueva posicion y el nuevo valor de vacio
				 */
				texto=texto.concat(" "+vacio);
			}
			//cuando cambiamos de fila(j=9), introducimos un salto de linea para mejor vision del mapa
			texto=texto.concat("\n");
			
		}
		//Cuando acaba de recorrer el array retornamos nuestro texto
		return texto;
	}
	
	/*Para el siguiente punto se hace de una manera similar al anterior, recorremos nuestro
	 * array de localidades de dos dimensiones con un bucle for y donde se encuentre una 
	 * posicion que no este vacia, introducimos en una variable texto el texto que ya arrastramos
	 * mas un nuevo texto que será el resultado de la posicion actual de array mas un llamamiento
	 * al metodo toString para ver los datos de los atributos de nuestro objeto Espectador 
	 * perteneciente a esa posicion del array.
	 */
	public String verLocalidadesOcupadas() {
		String texto = "";
		for (int i=0;i<localidades.length;i++){
			for (int j=0;j<localidades[i].length;j++){
				if (localidades[i][j]!=null){
					texto=texto.concat(i+"."+j+" "+localidades[i][j].toString()+"\n");
				}			
				}
			/*Si al finalizar de recorrer el array, no hay ninguna posicion ocupada,
			 * le decimos que devuelva un texto de que aun no se vendieron localidades
			 */
		}
		if (texto.equals("")){
			texto="Aun no hay localidades vendidas";
		}
		
		return texto;
	}
/*En el siguiente punto, se trata de implementar el metodo de vender una localidad,
 Este metodo que devolverá un String recibe por parametro dos enteros(fila y butaca)
 y un objeto Espectador. 
 */
	public String venderLocalidades(int fila, int butaca, Espectador e) {
		String texto = null;
		/*Este metodo se implementa facil, con un bucle if, comprobamos si la posicion
		 * del array que nos da fila,butaca, esta libre, si esto es asi, asignamos
		 * esa posicion del array a nuestro objeto espectador pasado por parametro, 
		 * quedando ahi grabado.
		 * Si no es asi, es decir, la posicion del array ya contiene otro espectador,
		 * informamos de que esa localidad esta ocupada y que compren otra.
		 */
				if (localidades[fila][butaca]==null){
					
					localidades[fila][butaca]=e;//aqui asignamos la posicion del array al objeto espectador
					/*A continuacion en el String texto introducimos la cadena compuesta por
					 * la fila y butaca mas el nombre de nuestro espectador que sacamos con el 
					 * getter de la clase espectador mas el precio segun rango de edad que calculamos
					 * con el metodo precioEspectador(Está implementado al final de la clase) y que le pasamos por parametro nuestro espectador
					 * para que este sepa la edad
					 */
					texto="Se ha vendido la localidad "+fila+"."+butaca+" a "+e.dame_Nombre().toUpperCase()+" por " +this.damePrecioEspectador(localidades[fila][butaca])+ " euros";
				}else if (localidades[fila][butaca]!=null){
					texto="Has escogido una localidad ocupada, vuelve a comprar otra";
					
				}
			
		
		
		//retornamos el texto compuesto que hemos hecho antes
		return texto;
		
		
	}
	
	/*En el siguiente punto tenemos que implementar el metodo con el que conseguimos
	 * cancelar una localidad y por lo tanto dejar esa posicion del array vacia
	 * como al metodo le pasamos por parametro la fila y butaca de la localidad que queremos
	 * vaciar o cancelar, solo hay que comprobar si esa localidad esta ocupada y si es asi
	 * ponerla a null o si esta vacia, decir que en esa localidad no hay nadie.
	 */

	public String cancelarLocalidades(int fila, int butaca) {
		String texto="";
		/*Aqui comprobamos si esa posicion del array esta ocupada y si es asi, 
		 * completamos el String texto con el nombre de la persona que ocupaba esa posicion
		 * del array mediante la llamada al metodo dame nombre del objeto espectador
		 * y a continuacion ponemos esa posicion del array a null.
		 */
		if (localidades[fila][butaca]!=null){
			texto=localidades[fila][butaca].dame_Nombre().toUpperCase()+" ha cancelado su reserva";
			localidades[fila][butaca]=null;
		//Si en esa posicion de array no hay objeto espectador, el texto será que no hay nadie ahi.	
		}else texto="No hay una localidad vendida en esa butaca";
		return texto;
	}

	/*El siguiente punto de consultar una localidad, es muy parecido al anterior metodo
	 * por parametro recibimos la fila y butaca de la cual queremos consultar el espectador
	 * que tenemos ahi guardado en el array.
	 * por lo tanto despues comprobamos con el bucle if si esa posicion esta ocupada y si es
	 * asi, devolvemos una cadena de texto con el nombre de esa persona mas el precio que paga
	 * esa persona por la entrada(Este valor lo calculamos con el metodo calculaPrecioEspectador
	 * que implemento al final de esta clase)
	 */
	public String consultarLocalidad(int fila, int butaca) {
		String texto="";
		if (localidades[fila][butaca]!=null){
			texto="Localidad ocupada por "+localidades[fila][butaca].toString()+", Precio: "+this.damePrecioEspectador(localidades[fila][butaca]);
			//localidades[fila][butaca]=null;
			
		}else texto="No hay una localidad vendida en esa butaca";
		return texto;
	}
	/*En este metodo tenemos que calcular la recaudacion total del teatro por la obra,
	 * por lo tanto hay que recorrer nuestras 50 posiciones del array y ver en donde la posicion
	 * este ocupada por un espectador, que precio ha pagado este segun su rango de edad(para esto
	 * utilizamos el metodo precioEspectador que implementamos al final de esta clase).
	 * Despues iremos sumando cada cifra al sumatorio para tener el valor final al acabar de
	 * recorrer el array .
	 */
	public double calcularRecaudacion() {
		double recaudacion=0;
		for (int i=0;i<localidades.length;i++){
			for (int j=0;j<localidades[i].length;j++){
				if (localidades[i][j]!=null){
				recaudacion=recaudacion+this.damePrecioEspectador(localidades[i][j]);
				}
			}
		}
		return recaudacion;
	}
	
	/*Con el metodo implementado a continuacion, calculamos el precio que va a pagar cada espectador
	 * segun su rango de edad. Para ello recibe por parametro el espectador sobre el cual
	 * calcularemos su rango de edad. Con unos bucles if anidados obtendremos el valor precio
	 * nuevo segun el rango de edad al que pertenezca. Será ese nuevo valor el que devolverá
	 * nuestro metodo
	 */
	
	public double damePrecioEspectador(Espectador e){
		double precio = 0;
		if (e.rango_Edad().equals("INFANTIL")){
			precio=this.precio*0.50;
		}else if(e.rango_Edad().equals("MENOR")){
				precio=this.precio*0.8;
				
		}else if (e.rango_Edad().equals("MAYOR")){
				precio=this.precio;
				
		}else if (e.rango_Edad().equals("JUBILADO")){
			precio=this.precio*0.34;
		}
		return precio;
	}

}
