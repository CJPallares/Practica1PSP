package tallerCoworking;
/**
 * Clase que contiene el método run necesario para realizar la ejecución multihilo.
 * @author: Carlos Jiménez
 * @version: 01/12/2020/C
 *
 */
public class Trabajador extends Thread {
	private int id;
	private Tarjeta izda; 
	private Tarjeta dcha;
	private Sitio s;
	private Ordenador o;
	
	public Trabajador(int id, Tarjeta izda, Tarjeta dcha, Sitio s, Ordenador o) {
		this.id = id;
		this.izda = izda;
		this.dcha = dcha;
		this.s = s;
		this.o = o;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				s.cogeSitio(id);
				izda.cogeTarjeta(id);
				dcha.cogeTarjeta(id);
				o.cogeOrdenador(id);
				//Utiliza el ordenador por el tiempo determinado.
				Thread.sleep(100);
				
				dcha.sueltaTarjeta(id);
				izda.sueltaTarjeta(id);
				//Una vez suelta ambas tarjetas deja el ordenador y se marcha a pensar.
				o.liberaOrdenador(id);
				s.marchaPensar(id);
			} catch (InterruptedException e) {
				 Thread.currentThread().interrupt();
				 System.exit(-1);
			}
			
		}
		
	}
}
