package personajes;

import java.util.ArrayList;
import hechizo.Hechizo;

public class Mago extends Personaje{
	
	private ArrayList<Hechizo>hechizos = new ArrayList<>();

	private SubClaseMago subClase;
	
	public Mago(String nombre, SubClaseMago subClase) {
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
	
	public SubClaseMago obtenerSubclase() {
		return subClase;
	}
	
	@Override
	public String toString() {
		return "[Mago] " + nombre + " | SubClase: " + subClase + " | Puntos de Salud " + puntosDeSalud + " | Nivel de Magia: " + nivelDeMagia;
	}
}
