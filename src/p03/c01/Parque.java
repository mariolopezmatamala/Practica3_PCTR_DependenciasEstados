package src.p03.c01;

import java.awt.ContainerOrderFocusTraversalPolicy;
import java.util.Enumeration;
import java.util.Hashtable;

public class Parque implements IParque {
	
	//TODO hecho
	private static final int PERSONASMAXIMAS = 50;
	private int contadorPersonasTotales;
	private Hashtable<String, Integer> contadoresPersonasPuerta;
	private boolean estaVacio;
	private boolean estaLLeno;
	


	public Parque() { // TODO
		contadorPersonasTotales = 0;
		contadoresPersonasPuerta = new Hashtable<String, Integer>();
		// TODO hecho
		estaVacio = true;
		estaLLeno = false;
	}

	@Override
	public synchronized void entrarAlParque(String puerta){		// TODO hecho
		// Si no hay entradas por esa puerta, inicializamos
		if (contadoresPersonasPuerta.get(puerta) == null) {
			contadoresPersonasPuerta.put(puerta, 0);
		}
		
		// TODO falta un try catch o algo asi
		try {
			comprobarAntesDeEntrar();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		// Aumentamos el contador total y el individual
		contadorPersonasTotales++;
		contadoresPersonasPuerta.put(puerta, contadoresPersonasPuerta.get(puerta) + 1);

		// Imprimimos el estado del parque
		imprimirInfo(puerta, "Entrada");
		
		// TODO hecho
		estaVacio = false;
		
		// TODO hecho
		notifyAll();  
		return;

	}

	//
	// TODO Método salirDelParque
	//
	@Override
	public synchronized void salirDelParque(String puerta){		// TODO hecho
		
		// Si no hay entradas por esa puerta, inicializamos
		if (contadoresPersonasPuerta.get(puerta) == null){
			contadoresPersonasPuerta.put(puerta, 0);
		}
		
		// TODO falta un try catch o algo asi
		try {
			comprobarAntesDeSalir();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
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


	protected void comprobarAntesDeEntrar() throws InterruptedException {	// TODO hecho
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


	protected void comprobarAntesDeSalir() throws InterruptedException {	// TODO hecho
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
