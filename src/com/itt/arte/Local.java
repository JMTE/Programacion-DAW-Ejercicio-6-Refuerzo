package com.itt.arte;
/*Aqui implementamos la clase Local que será clase padre de Teatro, es decir, la clase
 * Teatro va a heredar de esta clase sus metodos y atributos si fuera necesario.
 */
public class Local {
	//Encapsulamos los atributos
	private String domicilio;
	private int metros;
	private int accesos;
	//Implementamos el constructor que recibe 3 parametros al invocarlo
	public Local(String dom, int m,int acc){
		this.domicilio=dom;
		this.metros=m;
		this.accesos=acc;
		
				
	}
	/*Definimos todos los metodos SETTER Y GETTER de nuestra clase, aunque no utilizaremos
	 * todos en nuestro ejemplo, por si es necesario en el futuro acceder a algun atributo 
	 * o cambiarlo.
	 */
	public void cambia_Domicilio(String domicilio){
		this.domicilio=domicilio;
	}
	
	public String dame_Domicilio(){
		return this.domicilio;
		
	}
	public void cambia_Metros(int metros){
		this.metros=metros;
	}
	public int dame_Metros(){
		return this.metros;
		
	}
	public void cambia_Accesos(int accesos){
		this.accesos=accesos;
	}
	public int dame_Accesos(){
		return this.accesos;
		
	}
	
	/*Aqui implementamos el metodo toString que nos facilita la informacion de los atributos
	 * de la clase Local
	 */
	
	public String toString(){
		return "En "+this.dame_Domicilio()+", local de "+this.dame_Metros()+" m2,"+
	" con  "+this.dame_Accesos()+ " accesos";
	}
}
