package hechizo;

import personajes.Personaje;

public class Expelliarmus implements Hechizo{
	private static final int danioBase = 20; //?

	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		int danio = lanzador.potenciarDanioOscuro(danioBase);
        objetivo.recibirAtaque(danio);
        System.out.println(lanzador.obtenerNombre() + " lanzó Expelliarmus a " + objetivo.obtenerNombre() + " (-" + danio + " HP) [le quedan " + objetivo.obtenerPuntosDeSalud() + " HP]");
    }

	@Override
	public String obtenerNombre() {
		return "Expeliarmus";
	}
}
