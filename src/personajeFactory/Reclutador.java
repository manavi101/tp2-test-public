package personajeFactory;

import personajes.Personaje;

public class Reclutador {
	private static PersonajeFactory magoFactory = new MagoFactory();
	
	private static PersonajeFactory mortifagoFactory = new MortifagoFactory();
	
	public static Personaje crearMago() {
		return magoFactory.crearPersonaje();
	}
	
	public static Personaje crearMortifago() {
		return mortifagoFactory.crearPersonaje();
	}
}
