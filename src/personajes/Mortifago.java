package personajes;

public class Mortifago extends Personaje{

	private SubClaseMortifago subClase;
	
	public Mortifago(String nombre, SubClaseMortifago subClase) {
		super(nombre, subClase.obtenerPuntosDeSalud(), subClase.obtenerNivelDeMagia());
		
		this.subClase = subClase;
	}
	
	@Override
	public int potenciarDanioOscuro(int vidaBase) {
		return super.potenciarDanioOscuro(vidaBase) + 20;
	}
	
	public SubClaseMortifago obtenerSubclase() {
		return subClase;
	}
	
	@Override
	public String toString() {
		return "[Mortifago] " + nombre + " | SubClase: " + subClase + " | Puntos de Salud " + puntosDeSalud + " | Nivel de Magia: " + nivelDeMagia;
	}
}
