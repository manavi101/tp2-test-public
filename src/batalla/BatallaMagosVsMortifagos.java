package batalla;

import personajeFactory.MagoFactory;
import personajeFactory.MortifagoFactory;
import personajeFactory.Reclutador;
import personajes.Batallon;

import java.util.Random;

import hechizo.MomentoEfecto;


public class BatallaMagosVsMortifagos {

	  public static void main(String[] args) {
		

		Batalla batalla = new Batalla(new MagoFactory(), new MortifagoFactory());

		// Agregar magos al batallón 1
		batalla.agregarMagos(5);

		// Agregar mortífagos al batallón 2
		batalla.agregarMortifagos(5);

		// Realizar la batalla
		batalla.realizarBatalla();

	  }

	}