package hechizo;

import personajes.Personaje;

public class Sectumsempra extends Hechizo{

	private int danioTurno = 35;
	private int duracion = 3;
	
	private int turnosRestantes = duracion;
	
	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		
		objetivo.agregarEfectoActivo(new Sectumsempra());
		
		System.out.println(lanzador.obtenerNombre() + "lanzo Sectumsempra sobre " + objetivo.obtenerNombre());
		
	}
	
	@Override
	public boolean esEfectoPorTurno() {
		return true;
	}
	
	@Override
	public String obtenerNombre() {
		return "Sectumsempra";
	}

	@Override
	public void aplicarFinDeTurno(Personaje personaje) {
		personaje.recibirAtaque(danioTurno);
		turnosRestantes--;
		
		System.out.println(personaje.obtenerNombre() + " Se desangra (-" + danioTurno + " HP [le quedaan " + personaje.obtenerPuntosDeSalud() + " HP]");
	}
	
	@Override
	public boolean finalizo() {
		return turnosRestantes <= 0;
	}
	
	@Override
	public void potenciarHechizo(Hechizo nuevoHechizo) {
		danioTurno += danioTurno;
		turnosRestantes += 2;
		
		System.out.println("Sectumsempra se intensificó: ahora causa " + danioTurno + "HP por turno");
	}

}
