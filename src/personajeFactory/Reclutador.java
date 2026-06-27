package personajeFactory;

import personajes.Personaje;

public class Reclutador {
	private PersonajeFactoryInterface personajeFactory;
	
	public Reclutador(PersonajeFactoryInterface personajeFactory) {
		this.personajeFactory = personajeFactory;
	}
	
	public Personaje reclutarPersonaje() {
		return personajeFactory.crearPersonaje();
	}
}

//Magos factory con mortifagos factory 