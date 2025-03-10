package src.p03.c01;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ActividadSalidaPuerta implements Runnable{
	// TODO hecho
	private static final int NUMSALIDAS = 20;
	private IParque parque;
	private String puerta;
	
	
	public ActividadSalidaPuerta(String puerta, IParque parque) {
		this.parque = parque;
		this.puerta = puerta;
	}

	
	@Override
	public void run() {
		
		for (int i = 0; i < NUMSALIDAS; i ++) {
			try {
				parque.salirDelParque(puerta);
				TimeUnit.MILLISECONDS.sleep(new Random().nextInt(5)*1000);
			} catch (InterruptedException e) {
				Logger.getGlobal().log(Level.INFO, "Salida interrumpida");
				Logger.getGlobal().log(Level.INFO, e.toString());
				return;
			}
		}
		
	}
	
	
}
