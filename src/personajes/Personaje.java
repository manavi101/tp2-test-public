package personajes;

public abstract class Personaje {
	
	protected String nombre;
	protected int puntosDeSalud;
	protected int nivelDeMagia;
	
	public Personaje(String nombre, int puntosDeSalud, int nivelDeMagia) {
		this.nombre = nombre;
		this.puntosDeSalud = puntosDeSalud;
		this.nivelDeMagia = nivelDeMagia;
	}
	
	public abstract void atacar(Personaje objetivo);
	public abstract void recibirAtaque();
	
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
	
}
