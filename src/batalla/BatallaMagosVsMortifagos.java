package batalla;

import personajeFactory.MagoFactory;
import personajeFactory.MortifagoFactory;


public class BatallaMagosVsMortifagos {

	  public static void main(String[] args) {
		

		Batalla batalla = new Batalla(new MagoFactory(), new MortifagoFactory());

		batalla.agregarPersonaje1(5);

		batalla.agregarPersonaje2(3);

		batalla.realizarBatalla();

	  }

	}