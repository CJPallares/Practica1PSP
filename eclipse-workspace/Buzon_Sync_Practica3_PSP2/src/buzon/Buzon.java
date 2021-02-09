package buzon;
/**
 * Clase que implementa el recurso compartido buz�n, que ser� una secci�n cr�tica implement�ndola con monitores
 * a trav�s de sus m�todos sincronizados.
 * @author: Carlos Jim�nez
 * @version: 9/02/2021/B
 *
 */
import java.util.HashMap;

public class Buzon {
	HashMap<String, String> buzon;

	public Buzon() {
		buzon = new HashMap<>();
	}

	public synchronized String leerMensaje(String usuario) {
		return buzon.get(usuario);

	}

	public synchronized void borrarMensaje(String usuario) {
		buzon.put(usuario, "");
	}

	public synchronized void enviarMensaje(String destinatario, String mensaje) {
		buzon.put(destinatario, mensaje);
	}

	public synchronized boolean usuarioEncontrado(String usuario) {
		boolean enc = true;
		if (!buzon.containsKey(usuario)) {
			enc = false;
		}
		return enc;
	}
}
