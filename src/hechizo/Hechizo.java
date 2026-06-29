package hechizo;

import personajes.Personaje;

public abstract class Hechizo {
	public abstract void ejecutar(Personaje lanzador, Personaje objetivo);
	
	public abstract String obtenerNombre();
	
	public abstract void aplicarFinDeTurno(Personaje personaje);
	
	public boolean esEfectoPorTurno() {
		return false;
	}
	
	public boolean finalizo() {
		return true;
	}
	
	public boolean esMismoEfecto(Hechizo nuevoHechizo) {
		return this.obtenerNombre().equals(nuevoHechizo.obtenerNombre());
	}
	
	public void potenciarHechizo(Hechizo nuevoHechizo) {
		
	}
}
