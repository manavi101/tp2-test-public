package personajes;

import java.util.ArrayList;
import hechizo.Hechizo;

public class Mortifago extends Personaje{
	
	private ArrayList<Hechizo>hechizos = new ArrayList<>();

	private SubClaseMortifago subClase;
	
	public Mortifago(String nombre, SubClaseMortifago subClase) {
		super(nombre, subClase.obtenerPuntosDeSalud(), subClase.obtenerNivelDeMagia());
		
		this.subClase = subClase;
	}
	
	public void agregarHechizo(Hechizo hechizo) {
		hechizos.add(hechizo);
	}
	
	@Override
	public void atacar(Personaje objetivo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recibirAtaque() {
		// TODO Auto-generated method stub
		
	}
	
	public SubClaseMortifago obtenerSubclase() {
		return subClase;
	}
	
	@Override
	public String toString() {
		return "[Mortifago] " + nombre + " | SubClase: " + subClase + " | Puntos de Salud " + puntosDeSalud + " | Nivel de Magia: " + nivelDeMagia;
	}
}
