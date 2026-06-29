package hechizo;

import personajes.Personaje;

public class Episkey extends Hechizo{
	private static final int curacionTurno = 25;
	private static final int duracion = 5;
	
	private int turnosRestantes = duracion;

	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		lanzador.agregarEfectoActivo(new Episkey());
		
		System.out.println(lanzador.obtenerNombre() + " lanzo Episkey y comenzo a curarse");
		
	}
	
	@Override
	public boolean esEfectoPorTurno() {
		return true;
	}

	@Override
	public String obtenerNombre() {
		return "Episkey";
	}

	@Override
	public void aplicarFinDeTurno(Personaje personaje) {
		personaje.curar(curacionTurno);
		turnosRestantes--;
		
		System.out.println(personaje.obtenerNombre() + " recupera vida por Episkey (+" + curacionTurno + " HP [Tiene " + personaje.obtenerPuntosDeSalud() + " HP]");
		
	}
	
	public boolean finalizo() {
		return turnosRestantes <= 0;
	}

}
