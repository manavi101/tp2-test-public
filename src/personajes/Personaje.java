package personajes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import hechizo.Hechizo;

public abstract class Personaje {
	protected static final Random random = new Random();
	protected String nombre;
	protected int puntosDeSalud;
	protected int nivelDeMagia;
	protected List<Hechizo> hechizos = new ArrayList<>();
	protected boolean escudoActivo = false;
	
	public String atacar(Personaje objetivo, Set<String> hechizosUsados) {
		List<Hechizo> disponible = new ArrayList<>();
		for(Hechizo hechizo : hechizos) {
			if(!hechizosUsados.contains(hechizo.obtenerNombre())) {
				disponible.add(hechizo);
			}
		}
		
		if(disponible.isEmpty()) {
			return null;
		}
		
		Hechizo elegido = disponible.get(random.nextInt(disponible.size()));
		
		elegido.ejecutar(this, objetivo);
		
		return elegido.obtenerNombre();
	}
	
	public Personaje(String nombre, int puntosDeSalud, int nivelDeMagia) {
		this.nombre = nombre;
		this.puntosDeSalud = puntosDeSalud;
		this.nivelDeMagia = nivelDeMagia;
	}
	
	public int potenciarDanioOscuro(int danioBase) {
		return danioBase + nivelDeMagia;
	}
	
	public int potenciarCuracion(int vidaBase) {
		return vidaBase + nivelDeMagia;
	}
	
	public void recibirAtaque(int danioRecibido) {
		if(escudoActivo) {
			danioRecibido = danioRecibido/2;
			escudoActivo = false;
		}
		puntosDeSalud = Math.max(0, puntosDeSalud - danioRecibido);
	}
	
	@Override
	public String toString() {
		return nombre + " | Puntos de Salud: " + puntosDeSalud + " | Nivel de Magia: " + nivelDeMagia;
	}
	
	public String obtenerNombre() {
		return nombre;
	}
	
	public int obtenerNivelDeMagia() {
		return nivelDeMagia;
	}
	
	public int obtenerPuntosDeSalud() {
		return puntosDeSalud;
	}
	
	public void modificarPuntosDeSalud(int nuevaSalud) {
		puntosDeSalud = nuevaSalud;
	}
	
	public boolean estaVivo() {
		return puntosDeSalud > 0;
	}
	
	public void curar(int vidaCurada) {
		puntosDeSalud += vidaCurada;
	}
	
	public void activarEscudo() {
		escudoActivo = true;
	}
	
	public void agregarHechizo(Hechizo hechizo) {
		hechizos.add(hechizo);
	}
}
