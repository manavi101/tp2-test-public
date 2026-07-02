package personajes;

public class Mago extends Personaje{

	private SubClaseMago subClase;
	
	public Mago(String nombre, SubClaseMago subClase) {
		super(nombre, subClase.obtenerPuntosDeSalud(), subClase.obtenerNivelDeMagia());
		
		this.subClase = subClase;
	}
	
	public SubClaseMago obtenerSubclase() {
		return subClase;
	}
	
	@Override
	public int potenciarCuracion(int vidaBase) {
		return super.potenciarCuracion(vidaBase) + 10;
	}
	
	@Override
	public String toString() {
		return "[Mago] " + nombre + " | SubClase: " + subClase + " | Puntos de Salud " + puntosDeSalud + " | Nivel de Magia: " + nivelDeMagia;
	}

	@Override
	public String obtenerTipo() {
		return "Mago";
	}
}
