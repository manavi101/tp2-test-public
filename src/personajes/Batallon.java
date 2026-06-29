package personajes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import hechizo.MomentoEfecto;

public class Batallon {
	
	protected static final Random random = new Random();
	private Map<Personaje, List<String>> hechizosLanzados = new HashMap<>();
	private List<Personaje> personajes;
	
	public Batallon() {
		personajes = new LinkedList<Personaje>();
	}
	
	public boolean agregarPersonaje(Personaje personaje) {
		return personajes.add(personaje);
	}
	
	public boolean tienePersonajesSaludables() {
		return !personajesVivos().isEmpty();
	}

	public List<Personaje> personajesVivos() {
		List<Personaje> vivos = new ArrayList<>();
		for (Personaje personaje : personajes) {
			if(personaje.estaVivo()) {
				vivos.add(personaje);
			}
		}
		return vivos;
	}
	
	public void atacar(Batallon objetivo) {
		Set<String> hechizosUsadosEnTurno = new HashSet<>();
		
		for(Personaje atacante : personajesVivos()) {
			List<Personaje> enemigosVivos = objetivo.personajesVivos();
			if(enemigosVivos.isEmpty()) { break; }
			
			Personaje victima = enemigosVivos.get(random.nextInt(enemigosVivos.size()));
			String hechizoLanzado = atacante.atacar(victima, hechizosUsadosEnTurno);
			
			if(hechizoLanzado != null) {
				hechizosUsadosEnTurno.add(hechizoLanzado);
				registrarHechizo(atacante, hechizoLanzado);
			}

			if(!victima.estaVivo()) {
				System.out.println("  >> " + victima.obtenerNombre() + " ha caído");
			}
		}
	}
	
	public void aplicarEfectos(MomentoEfecto momento) {
		for(Personaje personaje : personajesVivos()) {
			personaje.aplicarEfectos(momento);
			
			if(!personaje.estaVivo()) {
				System.out.println("  >> " + personaje.obtenerNombre() + " ha caído por un efecto");
			}
		}
	}
	
	public void activarEfectoParaSiguienteRonda() {
		for(Personaje personaje: personajesVivos()) {
			personaje.activarEfectosParaSiguienteRonda();
		}
	}
	
	private void registrarHechizo(Personaje personaje, String hechizo) {
	    if (!hechizosLanzados.containsKey(personaje)) {
	        hechizosLanzados.put(personaje, new ArrayList<>());
	    }
	    hechizosLanzados.get(personaje).add(hechizo);
	}
	
	public void mostrarIntegrantes() {
		for(Personaje personaje : personajes) {
			System.out.println(personaje);
		}
	}
}
