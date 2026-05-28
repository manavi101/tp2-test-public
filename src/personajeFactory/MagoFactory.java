package personajeFactory;

import java.util.ArrayList;
import java.util.Random;

import personajes.Mago;
import personajes.SubClaseMago;

public class MagoFactory extends PersonajeFactory{
	
	private ArrayList<String> nombres;
	private ArrayList<String> nombresDisponibles;
	private Random rand;
	
	public MagoFactory() {
		
		nombres = new ArrayList<>();
		
		rand = new Random();
		
		nombres.add("Harry");
		nombres.add("Hermionie");
		nombres.add("Ron");
		nombres.add("Dumbledore");
		nombres.add("Lupin");
		
		nombresDisponibles = new ArrayList<>(nombres);
	}
	
	@Override
	public Mago crearPersonaje() {
		SubClaseMago[] subClases = SubClaseMago.values();
		
		SubClaseMago subClaseRandom = subClases[rand.nextInt(subClases.length)];
		
		return new Mago(obtenerNombre(), subClaseRandom);
	}
	
	public String obtenerNombre() {
		
		if(nombresDisponibles.isEmpty()) {
			nombresDisponibles = new ArrayList<>(nombres);
		}
		
		int indice = rand.nextInt(nombresDisponibles.size());
		
		return nombresDisponibles.remove(indice);
	}

}
