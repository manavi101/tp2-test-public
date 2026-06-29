package hechizo;

import personajes.Personaje;

public class Protego extends Hechizo{

	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		lanzador.activarEscudo();
		System.out.println(lanzador.obtenerNombre() + " lanzo Protego");
	}

	@Override
	public String obtenerNombre() {
		return "Protego";
	}

	@Override
	public void aplicarFinDeTurno(Personaje personaje) {
		
	}

}
