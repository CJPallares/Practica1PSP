package tallerCoworking;
/**
 * Clase implementada con monitor para asegurar exlusión mutua al recurso Ordenador.
 * @author: Carlos Jiménez
 * @version: 01/12/2020/C
 *
 */
public class Ordenador {
		private boolean libre = true;
		
		public Ordenador() {
			this.libre= true;
		}
		/**
		 * Método implementado con monitor para asegurar exlusión mutua al recurso Ordenador.
		 * Mientras el ordenador esté siendo utilizado el siguiente trabajador deberá esperar.
		 * @param i: Trabajador que utiliza el ordenador.
		 */
		public synchronized void cogeOrdenador (int i) throws InterruptedException  {
			while(!libre)
				wait();
			System.out.println("***** TRABAJADOR " +(i+1)+ " USA EL ORDENADOR ***** ");
			libre=false;
		}
		
		/**
		 * Método implementado con monitor para asegurar exlusión mutua al recurso Ordenador.
		 * Cuando el ordenador sea liberado se le notificará al resto de trabajadores y podrán acceder a él.
		 * @param i: Trabajador que libera el ordenador.
		 */
		public synchronized void liberaOrdenador(int i) {
			libre=true;
			System.out.println("##### TRABAJADOR " +(i+1)+ " LIBERA EL ORDENADOR ##### ");
			notifyAll();
		}
	
}
