package hechizo;

import personajes.Personaje;

public class ExpectoPatronum implements Hechizo {
	private static final int curacionBase = 20;
	
	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		int curacion = lanzador.potenciarCuracion(curacionBase);
		lanzador.curar(curacion);
		System.out.println(lanzador.obtenerNombre() + " se curó con Expecto Patronum (+" + curacion + " HP) [tiene ahora " + lanzador.obtenerPuntosDeSalud() + " HP]");
	}
	
	@Override
	public String obtenerNombre() {
		return "Expectro Patronum";
	}
}
