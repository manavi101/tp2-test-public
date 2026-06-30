package hechizo;

import personajes.Personaje;

public class AvadaKedavra extends Hechizo{
	private static final int danioBase = 50;//???

	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		int danio = lanzador.potenciarDanioOscuro(danioBase);
		objetivo.recibirAtaque(danio);
		System.out.println(lanzador.obtenerNombre() + " lanzó Avada Kedavra a " + objetivo.obtenerNombre() + " (-" + danio + " HP) [le quedan " + objetivo.obtenerPuntosDeSalud() + " HP]");
	}

	@Override
	public String obtenerNombre() {
		return "Avada Kedabra";
	}

}
