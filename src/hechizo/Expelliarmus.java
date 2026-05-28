package hechizo;

import personajes.Personaje;

public class Expelliarmus implements Hechizo{

	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		System.out.println(lanzador.obtenerNombre() + " lanzo Expelliarmus contra " + objetivo.obtenerNombre());
	}

	@Override
	public String obtenerNombre() {
		return "Expeliarmus";
	}
}
