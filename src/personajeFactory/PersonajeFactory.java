package personajeFactory;

import java.util.ArrayList;
import java.util.Random;

import personajes.Personaje;

public abstract class PersonajeFactory implements PersonajeFactoryInterface {
	
	protected ArrayList<String> nombres;
	protected ArrayList<String> nombresDisponibles;
	protected Random rand;
	
	public abstract Personaje crearPersonaje();
	
	
	public PersonajeFactory() {
		this.rand = new Random();
	}
	
	protected String obtenerNombre() {
		
		if(nombresDisponibles.isEmpty()) {
			nombresDisponibles = new ArrayList<>(nombres);
		}
		
		int indice = rand.nextInt(nombresDisponibles.size());
		
		return nombresDisponibles.remove(indice);
	}	
}
