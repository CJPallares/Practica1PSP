package tallerCoworking;

/**
 * Clase que implementa el recurso Sitio para asegurar el acceso solo a n-1 trabajadores, 4 en nuestro caso.
 * En este coworking siempre va a haber una persona pensando, no va a querer usar el ordenador porque está pensando nuevas ideas. Una vez pensadas querrá 
 * implementarlas en su ordenador, por lo que volverá a su sitio e intentará conseguir las dos tarjetas necesarias para poder usar el ordenador.
 * @author: Carlos Jiménez
 * @version: 01/12/2020/C
 */
public class Sitio {
	/**
	 * Atributos
	 * sLibre: boolean que indica si la tarjeta está ocupada
	 */
	private int sLibre=4;
	
	/**
	 * Método implementado con monitor para asegurar el acceso solo a n-1 trabajadores, 4 en nuestro caso.
	 * Mientras no haya sitio el trabajador deberá esperar.
	 * @param i: Trabajador que coge su sitio.
	 */
	public synchronized void cogeSitio(int i) throws InterruptedException{
		while(sLibre==0)
			wait();
		System.out.println("Trabajador " +(i+1)+ " quiere usar el ordenador");
		sLibre--;
	}
	
	/**
	 * Método implementado con monitor para asegurar el acceso solo a n-1 trabajadores, 4 en nuestro caso.
	 * Una vez el trabajador suelta las dos tarjetas y libera el ordenador se marcha de su sitio a pensar y se le notificará al resto de trabajadores.
	 * @param i: Trabajador que se retira a pensar.
	 */
	public synchronized void marchaPensar (int i) {
		sLibre++;
		System.out.println("Trabajador " +(i+1)+ " se retira a pensar");
		notifyAll();
	}

}
