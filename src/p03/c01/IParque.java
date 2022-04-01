package src.p03.c01;

public interface IParque {
	
	public abstract void entrarAlParque(String puerta) throws InterruptedException;

	// TODO hecho
	public abstract void salirDelParque(String puerta) throws InterruptedException;
}
