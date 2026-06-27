package batalla;

import personajeFactory.MagoFactory;
import personajeFactory.MortifagoFactory;
import personajeFactory.Reclutador;
import personajes.Batallon;

import java.util.Random;


public class BatallaMagosVsMortifagos {

	  public static void main(String[] args) {

	    Batallon batallonMagos = new Batallon();

	    Batallon batallonMortifagos = new Batallon();
	    
	    Reclutador reclutadorMagos = new Reclutador(new MagoFactory());
	    
	    Reclutador reclutadorMortifagos = new Reclutador(new MortifagoFactory());


	    for (int i = 0; i < 3; i++) {

	      batallonMagos.agregarPersonaje(reclutadorMagos.reclutarPersonaje());

	      batallonMortifagos.agregarPersonaje(reclutadorMortifagos.reclutarPersonaje());

	    }


	    Random rand = new Random();

	    while (batallonMagos.tienePersonajesSaludables() && batallonMortifagos.tienePersonajesSaludables()) {

	      // los ataques pueden tener salidas por pantalla para mostrar lo que sucede

	      if (rand.nextBoolean()) {

	        batallonMagos.atacar(batallonMortifagos);

	        if (batallonMortifagos.tienePersonajesSaludables()) {

	          batallonMortifagos.atacar(batallonMagos);

	        }

	      } else {

	        batallonMortifagos.atacar(batallonMagos);

	        if (batallonMagos.tienePersonajesSaludables()) {

	          batallonMagos.atacar(batallonMortifagos);

	        }

	      }


	      System.out.println("----------------------------");

	    }


	    if (batallonMagos.tienePersonajesSaludables()) {

	      System.out.println("¡Los magos han ganado la batalla!");

	    } else {

	      System.out.println("¡Los mortífagos han ganado la batalla!");

	    }

	  }

	}