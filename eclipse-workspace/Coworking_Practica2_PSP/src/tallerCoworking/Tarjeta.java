package tallerCoworking;
/**
 * Clase implementada con monitor para asegurar exlusión mutua al recurso Tarjeta.
 * @author: Carlos Jiménez
 * @version: 01/12/2020/C
 *
 */
public class Tarjeta {
	/**
	 * Atributos
	 * id: Numero identificador de la tarjeta
	 * libre: boolean que indica si la tarjeta está ocupada
	 */
	private int id;
	private boolean libre = true;
	
	public Tarjeta(int id) {
		this.id = id;
	}
	
	/**
	 * Método implementado con monitor para asegurar exlusión mutua al recurso Tarjeta.
	 * Mientras la tarjeta esté siendo utilizada el siguiente trabajador deberá esperar.
	 * @param i: Trabajador que utiliza la tarjeta.
	 */
	public synchronized void cogeTarjeta (int i) throws InterruptedException  {
		while(!libre)
			wait();
		System.out.println("Trabajador " +(i+1)+ " coge la tarjeta " +(id+1));
		libre=false;
	}
	
	/**
	 * Método implementado con monitor para asegurar exlusión mutua al recurso Tarjeta.
	 * Una vez la tarjeta sea liberada se le notificará al resto de trabajadores y podrán acceder a ella.
	 * @param i: Trabajador que libera el ordenador.
	 */
	public synchronized void sueltaTarjeta(int i) {
		libre=true;
		System.out.println("Trabajador " +(i+1)+ " suelta la tarjeta " +(id+1));
		notifyAll();
	}

}
