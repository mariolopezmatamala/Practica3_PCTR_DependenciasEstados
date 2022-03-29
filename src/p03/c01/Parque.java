package src.p03.c01;

import java.awt.ContainerOrderFocusTraversalPolicy;
import java.util.Enumeration;
import java.util.Hashtable;

public class Parque implements IParque {

	private static final int PERSONASMAXIMAS = 50;
	private int contadorPersonasTotales;
	private Hashtable<String, Integer> contadoresPersonasPuerta;
<<<<<<< HEAD
	
	private boolean estaVacio;
	private boolean estaLLeno;
	
	
	public Parque() {	// TODO
=======

	public Parque() { // TODO
>>>>>>> branch 'main' of https://github.com/mariolopezmatamala/Practica3_PCTR_DependenciasEstados
		contadorPersonasTotales = 0;
		contadoresPersonasPuerta = new Hashtable<String, Integer>();
		// TODO
		estaVacio = true;
		estaLLeno = false;
	}

	@Override
<<<<<<< HEAD
	public synchronized void entrarAlParque(String puerta){		// TODO hecho
		
=======
	public void entrarAlParque(String puerta) { // TODO

>>>>>>> branch 'main' of https://github.com/mariolopezmatamala/Practica3_PCTR_DependenciasEstados
		// Si no hay entradas por esa puerta, inicializamos
		if (contadoresPersonasPuerta.get(puerta) == null) {
			contadoresPersonasPuerta.put(puerta, 0);
		}
<<<<<<< HEAD
		
		// TODO falta un try catch o algo asi
		comprobarAntesDeEntrar();
		
=======

		// TODO

>>>>>>> branch 'main' of https://github.com/mariolopezmatamala/Practica3_PCTR_DependenciasEstados
		// Aumentamos el contador total y el individual
		contadorPersonasTotales++;
		contadoresPersonasPuerta.put(puerta, contadoresPersonasPuerta.get(puerta) + 1);

		// Imprimimos el estado del parque
		imprimirInfo(puerta, "Entrada");
<<<<<<< HEAD
		
		// TODO hecho
		estaVacio = false;
		
		// TODO hecho
		notifyAll();  
		return;
=======

		// TODO

		// TODO
 
>>>>>>> branch 'main' of https://github.com/mariolopezmatamala/Practica3_PCTR_DependenciasEstados
	}

	//
	// TODO Método salirDelParque
	//
<<<<<<< HEAD
	@Override
	public synchronized void salirDelParque(String puerta){		// TODO hecho
		
		// Si no hay entradas por esa puerta, inicializamos
		if (contadoresPersonasPuerta.get(puerta) == null){
			contadoresPersonasPuerta.put(puerta, 0);
		}
		
		// TODO falta un try catch o algo asi
		comprobarAntesDeSalir();
		
		// Aumentamos el contador total y el individual
		contadorPersonasTotales++;		
		contadoresPersonasPuerta.put(puerta, contadoresPersonasPuerta.get(puerta)-1);
		
		// Imprimimos el estado del parque
		imprimirInfo(puerta, "Salida");
		
		// TODO hecho
		estaLLeno = false;
		
		// TODO hecho
		notifyAll();
		return;
	}
	
	private void imprimirInfo (String puerta, String movimiento){
=======

	private void imprimirInfo(String puerta, String movimiento) {
>>>>>>> branch 'main' of https://github.com/mariolopezmatamala/Practica3_PCTR_DependenciasEstados
		System.out.println(movimiento + " por puerta " + puerta);
		System.out.println("--> Personas en el parque " + contadorPersonasTotales); // + " tiempo medio de estancia: " +
																					// tmedio);

		// Iteramos por todas las puertas e imprimimos sus entradas
		for (String p : contadoresPersonasPuerta.keySet()) {
			System.out.println("----> Por puerta " + p + " " + contadoresPersonasPuerta.get(p));
		}
		System.out.println(" ");
	}

	private int sumarContadoresPuerta() {
		int sumaContadoresPuerta = 0;
		Enumeration<Integer> iterPuertas = contadoresPersonasPuerta.elements();
		while (iterPuertas.hasMoreElements()) {
			sumaContadoresPuerta += iterPuertas.nextElement();
		}
		return sumaContadoresPuerta;
	}

	protected void checkInvariante() {
		assert sumarContadoresPuerta() == contadorPersonasTotales
				: "INV: La suma de contadores de las puertas debe ser igual al valor del contador del parte";
		assert contadorPersonasTotales < PERSONASMAXIMAS
				: "El numero de personas en el parque no puede exceder el numero de personas maximas";
		assert contadorPersonasTotales > 0
				: "INV: El numero de personas totales en el parque tiene que ser mayor que cero";
		

	}

<<<<<<< HEAD
	protected void comprobarAntesDeEntrar() throws InterruptedException {	// TODO hecho
=======
	protected void comprobarAntesDeEntrar() { // TODO
>>>>>>> branch 'main' of https://github.com/mariolopezmatamala/Practica3_PCTR_DependenciasEstados
		//
		// TODO hecho
		//
		if(contadorPersonasTotales == 50) {
			estaLLeno = true;
		}
		
		while(estaLLeno) {
			wait();
		}
	}

<<<<<<< HEAD
	protected void comprobarAntesDeSalir() throws InterruptedException {	// TODO hecho
=======
	protected void comprobarAntesDeSalir() { // TODO
>>>>>>> branch 'main' of https://github.com/mariolopezmatamala/Practica3_PCTR_DependenciasEstados
		//
		// TODO hecho
		//
		if(contadorPersonasTotales == 0) {
			estaVacio = true;
		}
		
		while(estaVacio) {
			wait();
		}
	}

}
