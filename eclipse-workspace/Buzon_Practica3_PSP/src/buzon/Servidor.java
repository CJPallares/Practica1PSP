package buzon;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Servidor {

	public static void main(String[] args) {
		try {
			HashMap<String, ArrayList<String>> buzon = new HashMap<>();

			System.out.println("Creando el socket servidor");
			// El servidor está escuchando en el puerto 1234
			ServerSocket ss = new ServerSocket();
			
			InetSocketAddress addr = new InetSocketAddress("localhost", 1237);
			ss.bind(addr);
			
			

			// ejecutando un bucle infinito para recibir peticiones de clientes
			while (true) {
				Socket s = null;

				try {
					// socket que recibirá peticiones de nuevos clientes que entren
					s = ss.accept();
					System.out.println("Un nuevo cliente se ha conectado: " + s);

					// obteniendo input y output streams
					DataInputStream dis = new DataInputStream(s.getInputStream());
					DataOutputStream dos = new DataOutputStream(s.getOutputStream());
					System.out.println("Creando nuevo hilo para el cliente actual");
					// crea un nuevo Hilo con este objeto
					Thread t = new GestionCliente(s, dis, dos, buzon);
					// se llama al método start() del hilo
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
