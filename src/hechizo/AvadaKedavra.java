package hechizo;

import personajes.Personaje;

public class AvadaKedavra implements Hechizo{
	private static final int danioBase = 20;//???

	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		int danio = lanzador.potenciarDanioOscuro(danioBase);
		objetivo.recibirAtaque(danio);
		System.out.println(lanzador.obtenerNombre() + " lanzó Avada Kedavra a " + objetivo.obtenerNombre() + " (-" + danio + " HP)");
	}

	@Override
	public String obtenerNombre() {
		return "Avada Kedabra";
	}

}
