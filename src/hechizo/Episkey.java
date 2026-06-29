package hechizo;

import personajes.Personaje;

public class Episkey extends Hechizo{
	private int curacionTurno = 25;
	private int duracion = 5;
	
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
	public MomentoEfecto obtenerMomentoEfecto() {
		return MomentoEfecto.INICIO_TURNO;
	}

	@Override
	public String obtenerNombre() {
		return "Episkey";
	}

	@Override
	public void aplicarEfecto(Personaje personaje) {
		if(!personaje.estaVivo()) {
			turnosRestantes = 0;
			return;
		}
		
		personaje.curar(curacionTurno);
		turnosRestantes--;
		
		System.out.println(personaje.obtenerNombre() + " recupera vida por Episkey (+" + curacionTurno + " HP [Tiene " + personaje.obtenerPuntosDeSalud() + " HP]");
		
	}
	
	public boolean finalizo() {
		return turnosRestantes <= 0;
	}
	
	@Override
	public void potenciarHechizo(Hechizo nuevoHechizo) {
		curacionTurno += curacionTurno;
		turnosRestantes += 2;
		
		System.out.println("Episkey se fortaleció: ahora cura " + curacionTurno + " HP por turno");
	}
	
}
