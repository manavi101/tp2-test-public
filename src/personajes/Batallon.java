package personajes;

import java.util.LinkedList;
import java.util.List;

public class Batallon {
	
	private List<Personaje> personajes;
	
	public Batallon() {
		personajes = new LinkedList<Personaje>();
	}
	
	public boolean agregarPersonaje(Personaje personaje) {
		return personajes.add(personaje);
	}
	
	public boolean tienePersonajesSaludables() {
		for (Personaje personaje : personajes) {
			if(personaje.estaVivo()) {
				return true;
			}
		}
		
		return false;
	}
	
	public void atacar(Batallon objetivo) {
		
	}
	
	public void mostrarIntegrantes() {
		for(Personaje personaje : personajes) {
			System.out.println(personaje);
		}
	}
}
