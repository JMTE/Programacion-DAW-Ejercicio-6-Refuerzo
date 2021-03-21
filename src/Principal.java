import java.util.InputMismatchException;
import java.util.Scanner;
//Importamos nuestros paquetes que contienen las clases
import com.itt.arte.Espectador;
import com.itt.arte.Obra;
import com.itt.arte.Sala;
import com.itt.arte.Teatro;

/*La mayoria de este codigo se nos facilitaba para ir completando lo que fuera necesario
 * Yo he hecho algun cambio que comentaré detenidamente
 */
public class Principal {
	private static Scanner lector;
	private static Obra obra= new Obra("La cena de los idiotas","Comedia",95);
	private static Sala teatro=new Teatro("C/Sol, 45",300,2,obra,30);
	public static void main(String[] args) {
		
		lector =new Scanner(System.in);
		//El case y la eleccion de opcion los voy a hacer con entero y no con un char
		int opc;
		//Aqui comienzo un try para capturar las posibles excepciones al introducir parametros 
		try{
		do{
			//defino las variables fila, butaca, edad, nombre,telefono que despues necesitaremos
			int fila = 0,butaca = 0,edad=0;
			String nombre = null,telefono = null;
			
			opc=mostrarMenu();//llamamos al metodo menu que creamos mas abajo
			switch(opc){
			
			case 1:System.out.println(teatro.verProgramacion());/*En caso de introducir un 1 ,
			llamo al metodo verProgramacion mediante la referencia al objeto de la clase Teatro
			*/
			break;//Los break los utilizo para saltar y que no siga pidiendo todas las opciones del case
			case 2:System.out.println(teatro.verLocalidades());/*En caso de introducir un 2 ,
			llamo al metodo verLocalidades mediante la referencia al objeto de la clase Teatro
			*/
			break;
			case 3:System.out.println(teatro.verLocalidadesOcupadas());/*En caso de introducir un 3 ,
			llamo al metodo verLocalidades Ocupadas mediante la referencia al objeto de la clase Teatro
			*/
			break;
			case 4:/*En caso de introducir un 4 ,
				llamo al metodo venderLocalidades mediante la referencia al objeto de la clase Teatro
				este metodo necesita que se le pasen 3 parametros, por lo tanto hay que 
				definirlos
				*/
				
				do{/*Los bucles do-while en donde van filas y butacas, los hago para no 
				introducir un valor fuera del rango de nuestras localidades, si introduces
				un valor fuera de rango te pregunta de nuevo la fila o butaca*/
				
				System.out.println("¿En qué fila quieres sentarte (0-4)?");
				//A continuacion capturamos el valor introducido por consola mediante el metodo nextInt de la clase Scanner
				fila=lector.nextInt();
				
				}while (fila>4 || fila <0);
				//Con bucata lo mismo que con la fila
				do{
				System.out.println("¿Y en qué butaca (0-9)?");
				butaca=lector.nextInt();
				}while(butaca>9 || butaca<0);
				//Con nombre capturamos el nombre que introducimos en la consola
				System.out.println("Cómo se llama?");
				 nombre=lector.next();
				 //Con telefono igual
				System.out.println("¿Su teléfono?");
				telefono=lector.next();
				//Para los años, ponemos un valor maximo de 120 años, para que ningun gracioso
				//introduzca un valor de 1000 años por ejemplo o un valor negativo
				do{
				System.out.println("¿Cuántos años tiene?");
				edad=lector.nextInt();
				}while (edad>120 || edad<0);
				/*Cuando ya tenemos los atributos necesarios para construir un objeto espectador,
				 * hacemos esto, creamos una referencia a un objeto Espectador pasandole por parametros
				 * los necesarios y que hemos conseguido antes mediante las preguntas,nombre,telefono
				 * y edad.
				 * 
				 */
				//Espectador e=new Espectador(nombre,telefono,edad);
				/*Y a continuacion ya podemos llamar a nuestro metodo vender localidades, porque
				 * ya tenemos todos los parametros necesarios, fila, butaca y el objeto espectador
				 */
				System.out.println(teatro.venderLocalidades(fila, butaca, new Espectador(nombre,telefono,edad)));
				break;
			case 5:
				/*Este es el caso de escoger la opcion 5 en el menu, para llamar al metodo 
				 * cancelarLocalidad necesitamos pasar por parametro la fila y la butaca
				 * por lo tanto lo sacaremos de los valores que introduzcamos por consola en
				 * cada pregunta. De la misma manera que antes nos protegeremos de valores
				 * que no contiene nuestro array con los bucles do-while
				 */
				do{
				 System.out.println("¿Fila (0-4)?");
				 fila=lector.nextInt();
				}while (fila>4 || fila <0);
				do{
				 System.out.println("¿Butaca (0-9)?");
				 butaca=lector.nextInt();
				}while(butaca>9 || butaca<0);
				 System.out.println(teatro.cancelarLocalidades(fila, butaca));
				 break;
			case 6:
				/*Si escogemos la opcion 6, para llamar al metodo consultarLocalidad
				 * de la misma manera que la opcion anterior necesitamos definir primero los
				 * parametros necesarios para pasarlos en el llamamiento al metodo. Por lo tanto
				 * la descripcion del proceso es analogo al anterior.
				 */
				do{
					System.out.println("¿Fila (0-4)?");
					fila=lector.nextInt();
				}while (fila>4 || fila <0);
				do{
					System.out.println("¿Butaca (0-9)?");
				    butaca=lector.nextInt();
				}while(butaca>9 || butaca<0);
				 System.out.println(teatro.consultarLocalidad(fila, butaca));
				 break;
			case 7:
				/*Si escogemos la opcion 7, llamaremos al metodo calcularRecaudacion*/
				System.out.println("Recaudacion: "+ teatro.calcularRecaudacion());
				break;
			case 8:
				//Si escogemos la opcion 8, cerramos el programa
				System.out.println("Hasta pronto");
				opc=8;//ponemos opc=8 para salir del bucle do-while
				break;
			default:
				//Si escogemos cualquier otra opcion, decimos que es una opcion incorrecta y seguimos en el bucle
				System.out.println("Has introducido una opción incorrecta");
				break;
			}
		}while (opc!=8);
		lector.close();
	}catch (InputMismatchException e){/*Aqui es donde capturamos la excepcion de introducir 
	letras en vez de numeros, cuando esto ocurre, el programa se cae y nos informa del error*/
		System.out.println("Has introducido caracteres en vez de numeros\n FIN DEL PROGRAMA");
		
	}
	}	
	
	/*Este es el metodo de la creación del menu dado en el enunciado, yo he cambiado que en 
	 * vez de validar mediante una variable char, valide mediante un entero
	 */
	public static int mostrarMenu(){
		int opcion;
		System.out.println("TEATRO LA BOMBILLA DE DON BLAS");
		System.out.println("-----------------------------");
		System.out.println("1. Ver la programación actual");
		System.out.println("2. Mostrar todas las localidades");
		System.out.println ("3. Mostrar localidades ocupadas");
		System.out.println ("4. Vender localidad");
		System.out.println ("5. Cancelar localidad");
		System.out.println ("6. Consultar localidad");
		System.out.println ("7. Calcular recaudación");
		System.out.println ("8. Terminar programa");
		System.out.println ("------------------------------");
		System.out.println ("¿Qué opción deseas?");

          opcion = lector.nextInt();

          return opcion; 

       }


			
		

	

}
