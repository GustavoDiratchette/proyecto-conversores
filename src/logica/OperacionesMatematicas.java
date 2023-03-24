package logica;

public class OperacionesMatematicas {

	static int cantidad = 0;
	static double conversion = 0;
	static String monedaOrigen = "Peso Argentino";
	static String monedaDestino = "Peso Argentino";
	
	static double conversionTemp = 0;
	static String temperaturaOrigen = "CELSIUS";
	static String temperaturaDestino = "CELSIUS";

	

	public static String aMoneda(double cantidad, String monedas) {

		return "$ " + Math.round(cantidad * 100.00) / 100.00 + " " + monedas;
	}

	// Conversion MONEDAS________________________________________________________________________________________

	public static String convertir(int cantidad, String monedaOrigen, String monedaDestino) {

		switch (monedaOrigen) {
		case "Peso Argentino":
			if (monedaDestino.equals("Dólar")) {
				conversion = cantidad * 0.0050;
			} else if (monedaDestino.equals("Euro")) {
				conversion = cantidad * 0.0047;
			} else if (monedaDestino.equals("Libra Esterlina")) {
				conversion = cantidad * 0.0042;
			} else if (monedaDestino.equals("Yen Japonés")) {
				conversion = cantidad * 0.69;
			} else if (monedaDestino.equals("Won sul-coreano")) {
				conversion = cantidad * 6.53;
			} else {
				conversion = cantidad;
			}
			break;

		case "Dólar":
			if (monedaDestino.equals("Peso Argentino")) {
				conversion = cantidad * 198.27;
			} else if (monedaDestino.equals("Euro")) {
				conversion = cantidad * 0.94;
			} else if (monedaDestino.equals("Libra Esterlina")) {
				conversion = cantidad * 0.83;
			} else if (monedaDestino.equals("Yen Japonés")) {
				conversion = cantidad * 135.98;
			} else if (monedaDestino.equals("Won sul-coreano")) {
				conversion = cantidad * 1295.73;
			} else {
				conversion = cantidad;
			}
			break;

		case "Euro":
			if (monedaDestino.equals("Peso Argentino")) {
				conversion = cantidad * 210.60;
			} else if (monedaDestino.equals("Dólar")) {
				conversion = cantidad * 1.06;
			} else if (monedaDestino.equals("Libra Esterlina")) {
				conversion = cantidad * 0.88;
			} else if (monedaDestino.equals("Yen Japonés")) {
				conversion = cantidad * 144.38;
			} else if (monedaDestino.equals("Won sul-coreano")) {
				conversion = cantidad * 1375.68;
			} else {
				conversion = cantidad;
			}
			break;

		case "Libra Esterlina":
			if (monedaDestino.equals("Peso Argentino")) {
				conversion = cantidad * 238.42;
			} else if (monedaDestino.equals("Dólar")) {
				conversion = cantidad * 1.20;
			} else if (monedaDestino.equals("Euro")) {
				conversion = cantidad * 1.13;
			} else if (monedaDestino.equals("Yen Japonés")) {
				conversion = cantidad * 163.48;
			} else if (monedaDestino.equals("Won sul-coreano")) {
				conversion = cantidad * 1558.12;
			} else {
				conversion = cantidad;
			}
			break;

		case "Yen Japonés":
			if (monedaDestino.equals("Peso Argentino")) {
				conversion = cantidad * 1.46;
			} else if (monedaDestino.equals("Dólar")) {
				conversion = cantidad * 0.0074;
			} else if (monedaDestino.equals("Euro")) {
				conversion = cantidad * 0.0069;
			} else if (monedaDestino.equals("Libra Esterlina")) {
				conversion = cantidad * 0.0061;
			} else if (monedaDestino.equals("Won sul-coreano")) {
				conversion = cantidad * 9.53;
			} else {
				conversion = cantidad;
			}
			break;

		case "Won sul-coreano":
			if (monedaDestino.equals("Peso Argentino")) {
				conversion = cantidad * 0.15;
			} else if (monedaDestino.equals("Dólar")) {
				conversion = cantidad * 0.00077;
			} else if (monedaDestino.equals("Euro")) {
				conversion = cantidad * 0.00073;
			} else if (monedaDestino.equals("Libra Esterlina")) {
				conversion = cantidad * 0.00064;
			} else if (monedaDestino.equals("Yen Japonés")) {
				conversion = cantidad * 0.10;
			} else {
				conversion = cantidad;
			}
			break;
			
		}
		String resultado= ((aMoneda(cantidad, monedaOrigen)) + " -> " + aMoneda(conversion, monedaDestino));
		
		
		return resultado;
		
	}
	

	// fin metodo convertir_________________________________________________________
	
	
	
	// Conversion TEMPERATURAS________________________________________________________________________________________

		public static String[] convertirTemp(int cantidad, String temperaturaOrigen, String temperaturaDestino) {
			String unidO="°C";
			String unidD="°C";
			String resultadoTemp[]=new String [2];
			switch (temperaturaOrigen) {
			case "CELSIUS":
				unidO="°C";
				if (temperaturaDestino.equals("KELVIN")) {
					conversionTemp = cantidad + 273.15;
					unidD="K";
				} else if (temperaturaDestino.equals("FAHRENHEIT")) {
					conversionTemp = cantidad * 1.8+32;
					unidD="°F";
				
				} else {
					conversionTemp = cantidad;
					unidD="°C";
				}
				break;

			case "KELVIN":
				unidO="K";
				if (temperaturaDestino.equals("CELSIUS")) {
					conversionTemp = cantidad - 273.15;
					unidD="°C";
				} else if (temperaturaDestino.equals("FAHRENHEIT")) {
					conversionTemp = (cantidad-273.15) * 1.8+32;
					unidD="°F";
				} else {
					conversionTemp = cantidad;
					unidD="K";
				}
				break;
			case "FAHRENHEIT":
				unidO="°F";
				if (temperaturaDestino.equals("CELSIUS")) {
					conversionTemp = (cantidad - 32) / 1.8;
					unidD="°C";
				} else if (temperaturaDestino.equals("KELVIN")) {
					conversionTemp = (cantidad-32) / 1.8 + 273.15;
					unidD="K";
				} else {
					conversionTemp = cantidad;
					unidD="°F";
				}
				break;
			
				
			}
			
			String resultadoTD=(double)Math.round(conversionTemp*100.00)/100.00 + unidD;
			System.out.println(conversionTemp);
			resultadoTemp[0]=unidO;
			resultadoTemp[1]=resultadoTD;
			
			return resultadoTemp;
			
		}
		
		
		
		// fin metodo convertir_________________________________________________________


	public static double sumar(double num1, double num2) {

		double suma;
		suma = num1 + num2;
		return suma;
	}

	public static double restar(double num1, double num2) {

		double resta;
		resta = num1 - num2;
		return resta;
	}

	public static double multiplicar(double num1, double num2) {

		double mulplicacion;
		mulplicacion = num1 * num2;
		return mulplicacion;
	}

	public static String dividir(double num1, double num2) {
		double div = 0;
		if (num2 != 0) {
			div = num1 / num2;
			return "La division es: " + div;
		} else {
			return "No se puede dividir por cero";
		}
		
	}
}
