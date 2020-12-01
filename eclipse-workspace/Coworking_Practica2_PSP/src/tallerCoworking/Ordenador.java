package tallerCoworking;
/**
 * Clase implementada con monitor para asegurar exlusi�n mutua al recurso Ordenador.
 * @author: Carlos Jim�nez
 * @version: 01/12/2020/C
 *
 */
public class Ordenador {
		private boolean libre = true;
		
		public Ordenador() {
			this.libre= true;
		}
		/**
		 * M�todo implementado con monitor para asegurar exlusi�n mutua al recurso Ordenador.
		 * Mientras el ordenador est� siendo utilizado el siguiente trabajador deber� esperar.
		 * @param i: Trabajador que utiliza el ordenador.
		 */
		public synchronized void cogeOrdenador (int i) throws InterruptedException  {
			while(!libre)
				wait();
			System.out.println("***** TRABAJADOR " +(i+1)+ " USA EL ORDENADOR ***** ");
			libre=false;
		}
		
		/**
		 * M�todo implementado con monitor para asegurar exlusi�n mutua al recurso Ordenador.
		 * Cuando el ordenador sea liberado se le notificar� al resto de trabajadores y podr�n acceder a �l.
		 * @param i: Trabajador que libera el ordenador.
		 */
		public synchronized void liberaOrdenador(int i) {
			libre=true;
			System.out.println("##### TRABAJADOR " +(i+1)+ " LIBERA EL ORDENADOR ##### ");
			notifyAll();
		}
	
}
