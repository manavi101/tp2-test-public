package hechizo;

import personajes.Personaje;

public abstract class Hechizo{
	
	protected boolean activoDesdeSiguienteRonda = false;
	
	public abstract void ejecutar(Personaje lanzador, Personaje objetivo);
	
	public abstract String obtenerNombre();
	
	public void aplicarEfecto(Personaje personaje) {
		
	}
	
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
	
	public MomentoEfecto obtenerMomentoEfecto() {
		return null;
	}

	public void activarParaLaSigueinteRonda() {
		activoDesdeSiguienteRonda = true;
	}
	
	
	public boolean estaActivo() {
		return activoDesdeSiguienteRonda;
	}
}
