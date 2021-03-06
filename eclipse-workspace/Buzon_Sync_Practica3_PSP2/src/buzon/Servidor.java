package buzon;
/**
 * Clase Servidor que hace uso de un bucle infinito para mantenerse aceptando peticiones entrantes. 
 * Cuando una petici�n de un cliente llega, el servidor le asigna al cliente un nuevo hilo para manejar la parte
 * de la comunicaci�n. Invoca el m�todo start
 * @author: Carlos Jim�nez
 * @version: 19/01/2021/D
 *
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		try {
			Buzon buzon = new Buzon();
			System.out.println("Creando el socket servidor");
			// El servidor est� escuchando en el puerto 1234
			ServerSocket ss = new ServerSocket();
			
			InetSocketAddress addr = new InetSocketAddress("localhost", 1237);
			ss.bind(addr);
			
			

			// ejecutando un bucle infinito para recibir peticiones de clientes
			while (true) {
				Socket s = null;

				try {
					// socket que recibir� peticiones de nuevos clientes que entren
					s = ss.accept();
					System.out.println("Un nuevo cliente se ha conectado: " + s);

					// obteniendo input y output streams
					DataInputStream dis = new DataInputStream(s.getInputStream());
					DataOutputStream dos = new DataOutputStream(s.getOutputStream());
					System.out.println("Creando nuevo hilo para el cliente actual");
					// crea un nuevo Hilo con este objeto
					Thread t = new GestionCliente(s, dis, dos, buzon);
					// se llama al m�todo start() del hilo
					t.start();
					System.out.println("Nuevo Hilo creado");
				} catch (Exception e) {
					s.close();
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
