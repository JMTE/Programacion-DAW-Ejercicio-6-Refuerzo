package com.itt.arte;
/*Aqui implementamos la clase Obra la cual nos especifica los atributos de la obra que 
 * se proyectará en nuestro teatro, la obra será una clase agregada a nuestra clase Teatro.
 */
public class Obra {
	//Encapsulamos los atributos
	private String titulo;
	private String genero;
	private int minutosDuracion;
	//Definimos el constructor con el cual llamaremos al objeto de la clase Obra
	public Obra(String titulo,String genero, int min){
		this.titulo=titulo;
		this.genero=genero;
		this.minutosDuracion=min;
		
	}
	
	/*Definimos todos los metodos SETTER Y GETTER de nuestra clase, aunque no utilizaremos
	 * todos en nuestro ejemplo, por si es necesario en el futuro acceder a algun atributo 
	 * o cambiarlo.
	 */
	
	public void cambia_Titulo(String titulo){
		this.titulo=titulo;
	}
	
	public String dame_Titulo(){
		return this.titulo;
		
	}
	public void cambia_Genero(String genero){
		this.genero=genero;
	}
	public String dame_Genero(){
		return this.genero;
		
	}
	public void cambia_Minutos(int minutos){
		this.minutosDuracion=minutos;
	}
	public int dame_Minutos(){
		return this.minutosDuracion;
		
	}
	//Implementamos el metodo toString que nos ofrecerá la informacion de nuestra obra cuando lo llamemos
	public String toString(){
		return this.dame_Titulo()+ ", Género: "+this.dame_Genero()+", Duración: "+this.dame_Minutos();
	}
}
