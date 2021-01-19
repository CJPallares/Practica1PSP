package buzon;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws IOException {
		try {
			final int ServerPort = 1237;
			Scanner sc = new Scanner(System.in);
			
			// Consiguiendo localhost ip
			InetAddress ip = InetAddress.getByName("localhost");
			
			// Creando socket cliente
			System.out.println("Estableciendo la conexi�n");
			Socket s = new Socket(ip, ServerPort);
			
			// Obteniendo input y output streams
			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			while (true) {
				do {
					String recibido = dis.readUTF();
					System.out.println(recibido);
				} while (dis.available() > 0);
				
				// Lee el mensaje a entregar
				String mensajeCliente = sc.nextLine();
				// Escribe en el output stream, que ser� mandado a la clase manejadora de clientes: GestionCliente.
				dos.writeUTF(mensajeCliente);
				dos.flush();
				if (mensajeCliente.equals("3")) {
					System.out.println("Cerrando conexi�n actual : " + s);
					s.close();
					System.out.println("Conexi�n cerrada");
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
