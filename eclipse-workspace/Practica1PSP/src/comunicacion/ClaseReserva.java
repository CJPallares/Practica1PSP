package comunicacion;

import java.util.Scanner;

// Clase hija que representa la reserva de un establecimiento de aguas termales, con opciones añadidas que podrá elegir el cliente.
public class ClaseReserva {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String opc = "";
		while (!opc.equalsIgnoreCase("Salir")) {
			menu();
			opc = sc.next();
			switch (opc.toLowerCase()) {

			case "reservar":
				reservar();
				break;

			case "consultar":
				muestraReserva();
				break;

			case "salir":
				System.out.println("¡Gracias! Vuelva cuando quiera.");
				break;

			default:
				System.out.println("No entiendo el mensaje");
				break;

			}
		}
	}

	public static void muestraReserva() {
		String opc;
		System.out.println("Introduce código de reserva:");
		Scanner tec = new Scanner(System.in);
		opc = tec.nextLine();
		System.out.println("Código de reserva " + opc + " confirmado");

	}

	public static void reservar() {
		boolean enc = false;

		while (!enc) {
			System.out.println("¿Cuántas horas quiere reservar en nuestro establecimiento, UNA o DOS?");
			Scanner tec1 = new Scanner(System.in);
			String opc1 = tec1.nextLine();

			if (opc1.equalsIgnoreCase("UNA") || opc1.equalsIgnoreCase("DOS")) {
				System.out.println("Ha elegido " + opc1 + " hora");

				System.out.println("Tras su circuito termal debe elegir entre MASAJE o SAUNA.");
				Scanner tec2 = new Scanner(System.in);
				String opc2 = tec2.nextLine();
				if (opc2.equalsIgnoreCase("masaje") || opc2.equalsIgnoreCase("sauna")) {
					System.out.println("Ha elegido " + opc2 + " ¡Buena elección!");
					System.out.println("****Reserva Confirmada****");
					enc = true;
					if (!enc)
						System.out.println("Introduce una de las opciones válidas");
				}
			}

		}
	}

	public static void menu() {
		System.out.println("************SPA Luminux****************");
		System.out.println("Reserve con nosotros el exclusivo circuito termal.");
		System.out.println("**********Elija una opción**********");
		System.out.println("*Reservar");
		System.out.println("*Consultar");
		System.out.println("*Salir");
		System.out.println("****************************");
	}

}
