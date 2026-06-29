package batalla;

import personajeFactory.MagoFactory;
import personajeFactory.MortifagoFactory;
import personajeFactory.Reclutador;
import personajes.Batallon;

import java.util.Random;

import hechizo.MomentoEfecto;


public class BatallaMagosVsMortifagos {

	  public static void main(String[] args) {
		
		int turno = 1;
		
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
	    	
	    	System.out.println("----------------------------");
	    	System.out.println(" Inicio de turno: " + turno);
	    	System.out.println("----------------------------");
	    	
	    	batallonMagos.aplicarEfectos(MomentoEfecto.INICIO_TURNO);
	    	batallonMortifagos.aplicarEfectos(MomentoEfecto.INICIO_TURNO);
	    	
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
	      
	      batallonMagos.aplicarEfectos(MomentoEfecto.FIN_TURNO);
	      batallonMortifagos.aplicarEfectos(MomentoEfecto.FIN_TURNO);
	      
	      batallonMagos.activarEfectoParaSiguienteRonda();
	      batallonMortifagos.activarEfectoParaSiguienteRonda();
	      
	      System.out.println();
	      System.out.println("----------------------------");
	      System.out.println(" Fin de turno " + turno);
	      System.out.println("----------------------------");
	      System.out.println();
	      
	      turno++;
	    }


	    if (batallonMagos.tienePersonajesSaludables()) {

	      System.out.println("¡Los magos han ganado la batalla!");

	    } else {

	      System.out.println("¡Los mortífagos han ganado la batalla!");

	    }

	  }

	}