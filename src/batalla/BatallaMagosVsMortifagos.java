package batalla;

import personajeFactory.Reclutador;
import personajes.Batallon;

public class BatallaMagosVsMortifagos {
	public static void main(String[] args) {
		Batallon batallonMagos = new Batallon();
		Batallon batallonMortifagos = new Batallon();
		
		for(int i = 0; i < 3; i++) {
			batallonMagos.agregarPersonaje(Reclutador.crearMago());
			batallonMortifagos.agregarPersonaje(Reclutador.crearMortifago());
		}
		
		System.out.println("----- Batallon Magos -----");
		batallonMagos.mostrarIntegrantes();
		
		System.out.println("----- Batallon Mortifagos -----");
		batallonMortifagos.mostrarIntegrantes();
	
	}
}
