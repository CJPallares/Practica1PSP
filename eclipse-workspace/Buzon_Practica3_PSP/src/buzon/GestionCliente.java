package buzon;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Map;

public class GestionCliente extends Thread {
	private final DataInputStream dis;
	private final DataOutputStream dos;
	private final Socket s;
	private String usuario;
	Map<String, ArrayList<String>> buzon;

	// Constructor
	public GestionCliente(Socket s, DataInputStream dis, DataOutputStream dos, Map<String, ArrayList<String>> buzon) {
		this.s = s;
		this.dis = dis;
		this.dos = dos;
		this.buzon = buzon;
	}

	@Override
	public void run() {
		boolean salir = false;
		String recibeDeCliente;
		String aDevolverCliente;
		ArrayList<String> arrMensaje = null;
		try {
			dos.writeUTF("Bienvenido, ¿cuál es tu nombre?");
			this.usuario = this.dis.readUTF();
			dos.writeUTF("Soy " + this.usuario + "\n");
			dos.flush();
			
			

			while (!salir) {
				String opciones = "Elija una de estas opciones: \n 1.Consultar mensajes \n 2.Escribir mensaje \n 3.Salir ";
				dos.writeUTF(opciones);
				recibeDeCliente = dis.readUTF();

				switch (recibeDeCliente) {

				case "1":
					arrMensaje = buzon.get(usuario);
					if (arrMensaje == null) {
						aDevolverCliente = "No se encontraron mensajes \n";
						dos.writeUTF(aDevolverCliente);
					} else {
						for (int i = 0; i < arrMensaje.size(); i++) {
							dos.writeUTF(arrMensaje.get(i));
							dos.flush();
						}
						buzon.remove(usuario);
					}
					break;

				case "2":
					aDevolverCliente = "¿A qué cliente desea mandar el mensaje?";
					dos.writeUTF(aDevolverCliente);
					String destinatario = dis.readUTF();

					aDevolverCliente = "Escriba el mensaje que desea enviar.";
					dos.writeUTF(aDevolverCliente);
					String mensaje = dis.readUTF();

					mensaje += " | Remitente: " + usuario;

					arrMensaje.add(mensaje);
					System.out.println(mensaje);
					buzon.put(destinatario, arrMensaje);
					aDevolverCliente = "Mensaje enviado \n";
					dos.writeUTF(aDevolverCliente);
					break;

				case "3":
					System.out.println("Cerrando la conexion.");
					this.s.close();
					System.out.println("Conexion cerrada.");
					salir = true;
					break;

				default:
					aDevolverCliente = "Escoja una de las opciones indicadas.";
					dos.writeUTF(aDevolverCliente);
					break;
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			// Cerrando recursos
			this.dis.close();
			this.dos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
