package com.itt.arte;
/*Aqui implementamos nuestra interface Sala que sera una coleccion de métodos abstractos 
 * los cuales seran implementados en las clases que escojamos, en este caso la clase Teatro.
 * Un interface se diferencia basicamente a una clase abstracta en que nos permite un metodo 
 * de encapsulacion sin tener que recurrir a la herencia.
 */
public interface Sala {
	String verProgramacion();
	String verLocalidades();
	String verLocalidadesOcupadas();
	String venderLocalidades(int fila,int butaca,Espectador e);
	String cancelarLocalidades(int fila, int butaca);
	String consultarLocalidad(int fila, int butaca);
	double calcularRecaudacion();
	

}
