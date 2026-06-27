package hechizo;

import personajes.Personaje;

public class Expelliarmus implements Hechizo{
	private static final int danioBase = 50; //?

	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
        objetivo.recibirAtaque(danioBase);
        System.out.println(lanzador.obtenerNombre() + " lanzó Expelliarmus a " + objetivo.obtenerNombre());
    }

	@Override
	public String obtenerNombre() {
		return "Expeliarmus";
	}
}
