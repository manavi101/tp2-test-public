package batalla;

import personajeFactory.MagoFactory;
import personajeFactory.MortifagoFactory;
import java.util.Scanner;

public class BatallaParametrosConsola {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Batalla batalla = new Batalla(new MagoFactory(), new MortifagoFactory());
		
		System.out.println("Cuantos magos quiere en la pelea?");
		int aux = sc.nextInt();
		
		batalla.agregarPersonaje1(aux);
		
		System.out.println("Cuantos mortifagos quiere en la pelea?");
		aux = sc.nextInt();
		
		batalla.agregarPersonaje2(aux);
		
		batalla.realizarBatalla();
	
		sc.close();
	}

}