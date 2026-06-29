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
	protected int puntosDeSaludMaximos;
	protected int nivelDeMagia;
	protected List<Hechizo> hechizos = new ArrayList<>();
	protected boolean escudoActivo = false;
	protected List<Hechizo> efectosActivos = new ArrayList<>();
	
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
		puntosDeSaludMaximos = puntosDeSalud;
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
	
	public void agregarEfectoActivo(Hechizo hechizo) {
		for(Hechizo efectoActual : efectosActivos) {
			if(efectoActual.esMismoEfecto(hechizo)) {
				efectoActual.potenciarHechizo(hechizo);
				return;
			}
		}
		
		efectosActivos.add(hechizo);
	}
	
	public void aplicarEfectosFinDeTurno() {
		List<Hechizo> efectosTerminados = new ArrayList<>();
		
		for(Hechizo efecto : efectosActivos) {
			efecto.aplicarFinDeTurno(this);
			
			if(efecto.finalizo()) {
				efectosTerminados.add(efecto);
			}
		}
		
		efectosActivos.removeAll(efectosTerminados);
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
		puntosDeSalud = Math.min(puntosDeSalud += vidaCurada, puntosDeSaludMaximos);
	}
	
	public void activarEscudo() {
		escudoActivo = true;
	}
	
	public void agregarHechizo(Hechizo hechizo) {
		hechizos.add(hechizo);
	}
}
