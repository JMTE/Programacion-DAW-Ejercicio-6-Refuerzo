package com.itt.arte;
/*Aqui implementamos la clase Espectador, que será la clase donde reunimos todo lo relacionado
 * con los espectadores del teatro. Esta clase sera componente de la clase Teatro. Es decir
 * Teatro sera componedor de la clase Espectador.
 */
public class Espectador {
	//Encapsulamos los atributos como siempre
private String nombre;
private String tlf;
private int edad;
//Implementamos el constructor de la clase que recibe 3 atributos
public Espectador(String nom,String tlf, int ed){
	this.nombre=nom;
	this.tlf=tlf;
	this.edad=ed;
}
/*Definimos todos los metodos SETTER Y GETTER de nuestra clase, aunque no utilizaremos
 * todos en nuestro ejemplo, por si es necesario en el futuro acceder a algun atributo 
 * o cambiarlo.
 */
public void cambia_Nombre(String nombre){
	this.nombre=nombre;
}
public String dame_Nombre(){
	return this.nombre;
	
}
public void cambia_Telefono(String telefono){
	this.tlf=telefono;
}
public String dame_telefono(){
	return this.tlf;
	
}
public void cambia_Edad(int edad){
	this.edad=edad;
	
}
public int dame_Edad(){
	return this.edad;
	
}
/*Aqui implementamos el metodo rango de edad. Este metodo segun la edad que le introduzcamos
 * en el constructor, nos calculará a que franja pertenece. Para ello utilizamos un sencillo
 * bucle if anidado. Este metodo nos devolverá el rango cuando lo necesitemos.
 */
public String rango_Edad(){
	String rango;
	if (this.edad>=0 && this.edad<=12){
		rango="INFANTIL";
		}else if (this.edad>=13&&this.edad<=17 ){
			rango="MENOR";
			
		}else if (this.edad>=18 && this.edad<=64){
			rango="MAYOR";
			
		}else rango="JUBILADO";
	return rango;
}
/*Aqui definimos el metodo toString que nos facilitara la informacion de los atributos de 
 * la clase, pero en vez de edad, informaremos del rango correspondiente calculado en el 
 * metodo que implementamos anteriormente
 */
public String toString(){
	return this.nombre.toUpperCase()+", tlf: "+this.tlf+", Tipo: "+this.rango_Edad();
}
}
