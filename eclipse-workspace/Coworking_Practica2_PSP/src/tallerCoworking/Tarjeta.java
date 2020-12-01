package tallerCoworking;
/**
 * Clase implementada con monitor para asegurar exlusi�n mutua al recurso Tarjeta.
 * @author: Carlos Jim�nez
 * @version: 01/12/2020/C
 *
 */
public class Tarjeta {
	/**
	 * Atributos
	 * id: Numero identificador de la tarjeta
	 * libre: boolean que indica si la tarjeta est� ocupada
	 */
	private int id;
	private boolean libre = true;
	
	public Tarjeta(int id) {
		this.id = id;
	}
	
	/**
	 * M�todo implementado con monitor para asegurar exlusi�n mutua al recurso Tarjeta.
	 * Mientras la tarjeta est� siendo utilizada el siguiente trabajador deber� esperar.
	 * @param i: Trabajador que utiliza la tarjeta.
	 */
	public synchronized void cogeTarjeta (int i) throws InterruptedException  {
		while(!libre)
			wait();
		System.out.println("Trabajador " +(i+1)+ " coge la tarjeta " +(id+1));
		libre=false;
	}
	
	/**
	 * M�todo implementado con monitor para asegurar exlusi�n mutua al recurso Tarjeta.
	 * Una vez la tarjeta sea liberada se le notificar� al resto de trabajadores y podr�n acceder a ella.
	 * @param i: Trabajador que libera el ordenador.
	 */
	public synchronized void sueltaTarjeta(int i) {
		libre=true;
		System.out.println("Trabajador " +(i+1)+ " suelta la tarjeta " +(id+1));
		notifyAll();
	}

}
