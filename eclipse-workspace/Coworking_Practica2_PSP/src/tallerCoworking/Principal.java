package tallerCoworking;
/**
 * Clase principal que contiene el main y ejecuta la solución planteada.
 * @author: Carlos Jiménez
 * @version: 01/12/2020/C
 *
 */
public class Principal {

	public static void main(String[] args) {
		Sitio s = new Sitio();
		Ordenador o = new Ordenador();
		Tarjeta[] tarjetas = new Tarjeta[5];
		Trabajador[] trabajadores = new Trabajador[5];
		
		for (int i = 0; i < tarjetas.length; i++) {
			tarjetas[i] = new Tarjeta(i);	
		}
				
		for (int i = 0; i < trabajadores.length; i++) {
			trabajadores[i] = new Trabajador(i, tarjetas[i], tarjetas[(i+1)%5], s, o);
		}
		
		for (int i = 0; i < trabajadores.length; i++) {
			trabajadores[i].start();
		}
	}

}
