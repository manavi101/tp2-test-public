package hechizo;

import personajes.Personaje;

public class Protego implements Hechizo{

	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		System.out.println(lanzador.obtenerNombre() + " lanzo Protego");
	}

	@Override
	public String obtenerNombre() {
		return "Protego";
	}

}
