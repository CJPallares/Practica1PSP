package buzon;
/**
 * Clase GestionCliente que maneja a cada cliente que se conecta con un socket específico para cada uno,
 * de ahí la potencia del multicliente en la implementación que nos permite Java de forma sencilla mediante Threads.
 * Contiene el método run() necesario para realizar la ejecución multihilo.
 * @author: Carlos Jiménez
 * @version: 19/01/2021/D
 *
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class GestionCliente extends Thread {
	private final DataInputStream dis;
	private final DataOutputStream dos;
	private final Socket s;
	private Buzon buzon;

	// Constructor
	public GestionCliente(Socket s, DataInputStream dis, DataOutputStream dos, Buzon buzon) {
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
		String usuario;

		try {
			// envía mensaje al cliente
			dos.writeUTF("Bienvenido, ¿cuál es tu nombre?");
			// lee lo que le responde el cliente
			usuario = this.dis.readUTF();
			dos.writeUTF("Usuario llamado " + usuario + "\n");
			dos.flush();

			while (!salir) {
				String opciones = "Elija una de estas opciones: \n 1.Consultar mensajes \n 2.Escribir mensaje \n 3.Salir ";
				dos.writeUTF(opciones);
				recibeDeCliente = dis.readUTF();

				switch (recibeDeCliente) {

				case "1":
					if ((!buzon.usuarioEncontrado(usuario)) || (buzon.leerMensaje(usuario) == "")) {
						aDevolverCliente = "No se encontraron mensajes \n";
						dos.writeUTF(aDevolverCliente);
						
					} else {
						dos.writeUTF(buzon.leerMensaje(usuario));
						dos.flush();
						//borramos el campo valor(mensaje) ya que el usuario ya ha recibido sus mensajes y no hay persistencia de datos en nuestro programa
						buzon.borrarMensaje(usuario);
					}
					break;

				case "2":
					aDevolverCliente = "¿A qué cliente desea mandar el mensaje?";
					dos.writeUTF(aDevolverCliente);
					String destinatario = dis.readUTF();

					aDevolverCliente = "Escriba el mensaje que desea enviar.";
					dos.writeUTF(aDevolverCliente);
					// leemos el input enviado por el cliente
					String mensaje = dis.readUTF();

					mensaje += " | Remitente: " + usuario;
					buzon.enviarMensaje(destinatario, mensaje);
					
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
